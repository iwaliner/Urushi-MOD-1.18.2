package com.iwaliner.urushi;


import com.iwaliner.urushi.blockentity.renderer.SanboRenderer;
import com.iwaliner.urushi.blockentity.renderer.ShichirinRenderer;
import com.iwaliner.urushi.blockentity.screen.DoubledWoodenCabinetryScreen;
import com.iwaliner.urushi.blockentity.screen.FryerScreen;
import com.iwaliner.urushi.entiity.food.model.*;
import com.iwaliner.urushi.entiity.food.renderer.*;
import com.iwaliner.urushi.entiity.model.CushionModel;
import com.iwaliner.urushi.entiity.renderer.CushionRenderer;
import com.iwaliner.urushi.entiity.renderer.GhostRenderer;
import com.iwaliner.urushi.json.*;
import com.iwaliner.urushi.particle.*;
import com.iwaliner.urushi.util.ElementUtils;
import com.iwaliner.urushi.util.ToggleKeyMappingPlus;
import com.iwaliner.urushi.util.UrushiUtils;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.client.event.*;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.loading.FMLPaths;

import javax.annotation.Nullable;
import java.io.File;
import java.util.Map;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = ModCoreUrushi.ModID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetUp {
    public static final ModelLayerLocation RICE = new ModelLayerLocation(new ResourceLocation(ModCoreUrushi.ModID, "rice_food"), "rice_food");
    public static final ModelLayerLocation KARAAGE = new ModelLayerLocation(new ResourceLocation(ModCoreUrushi.ModID, "karaage_food"), "karaage_food");
    public static final ModelLayerLocation TOFU = new ModelLayerLocation(new ResourceLocation(ModCoreUrushi.ModID, "tofu_food"), "tofu_food");
    public static final ModelLayerLocation ABURAAGE = new ModelLayerLocation(new ResourceLocation(ModCoreUrushi.ModID, "aburaage_food"), "aburaage_food");
    public static final ModelLayerLocation DANGO = new ModelLayerLocation(new ResourceLocation(ModCoreUrushi.ModID, "dango_food"), "dango_food");
    public static final ModelLayerLocation RICE_CAKE = new ModelLayerLocation(new ResourceLocation(ModCoreUrushi.ModID, "rice_cake_food"), "rice_cake_food");
    public static final ModelLayerLocation ROASTED_RICE_CAKE = new ModelLayerLocation(new ResourceLocation(ModCoreUrushi.ModID, "roasted_rice_cake_food"), "roasted_rice_cake_food");
    public static final ModelLayerLocation CUSHION = new ModelLayerLocation(new ResourceLocation(ModCoreUrushi.ModID, "cushion"), "cushion");


    public static final KeyMapping connectionKey = new ToggleKeyMappingPlus("Apart Block Connections (single play only)", InputConstants.KEY_C, "Urushi");


    /**エンティティの見た目を登録*/
    @SubscribeEvent
    public static void RegisterEntityRendererEvent(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityRegister.RiceFoodEntity.get(), RiceFoodRenderer::new);
        event.registerEntityRenderer(EntityRegister.TKGFoodEntity.get(), TKGFoodRenderer::new);
        event.registerEntityRenderer(EntityRegister.SekihanFoodEntity.get(), SekihanFoodRenderer::new);
        event.registerEntityRenderer(EntityRegister.GyudonFoodEntity.get(), GyudonFoodRenderer::new);
        event.registerEntityRenderer(EntityRegister.ButadonFoodEntity.get(), ButadonFoodRenderer::new);
        event.registerEntityRenderer(EntityRegister.KitsuneUdonFoodEntity.get(), KitsuneUdonFoodRenderer::new);
        event.registerEntityRenderer(EntityRegister.KaraageFoodEntity.get(), KaraageFoodRenderer::new);
        event.registerEntityRenderer(EntityRegister.TofuFoodEntity.get(), TofuFoodRenderer::new);
        event.registerEntityRenderer(EntityRegister.AburaageFoodEntity.get(), AburaageFoodRenderer::new);
        event.registerEntityRenderer(EntityRegister.KusaDangoFoodEntity.get(), KusaDangoFoodRenderer::new);
        event.registerEntityRenderer(EntityRegister.ColorDangoFoodEntity.get(), ColorDangoFoodRenderer::new);
        event.registerEntityRenderer(EntityRegister.MitarashiDangoFoodEntity.get(), MitarashiDangoFoodRenderer::new);
        event.registerEntityRenderer(EntityRegister.RiceCakeFoodEntity.get(), RiceCakeFoodRenderer::new);
        event.registerEntityRenderer(EntityRegister.RoastedRiceCakeFoodEntity.get(), RoastedRiceCakeFoodRenderer::new);
        event.registerEntityRenderer(EntityRegister.KitsunebiEntity.get(),  (p_174088_) -> {
            return new ThrownItemRenderer<>(p_174088_, 1.0F, true);
        });
        event.registerEntityRenderer(EntityRegister.Ghost.get(), GhostRenderer::new);
        event.registerEntityRenderer(EntityRegister.Cushion.get(), CushionRenderer::new);

    }

    /**エンティティのレイヤーを指定*/
    @SubscribeEvent
    public static void registerLayerEvent(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(RICE, RiceFoodModel::createBodyLayer);
        event.registerLayerDefinition(KARAAGE, KaraageFoodModel::createBodyLayer);
        event.registerLayerDefinition(TOFU, TofuFoodModel::createBodyLayer);
        event.registerLayerDefinition(ABURAAGE, AburaageFoodModel::createBodyLayer);
        event.registerLayerDefinition(DANGO, DangoFoodModel::createBodyLayer);
        event.registerLayerDefinition(RICE_CAKE, RiceCakeFoodModel::createBodyLayer);
        event.registerLayerDefinition(ROASTED_RICE_CAKE, RoastedRiceCakeFoodModel::createBodyLayer);
        event.registerLayerDefinition(CUSHION, CushionModel::createBodyLayer);
    }

    /**パーティクルの見た目を指定*/
    @SubscribeEvent
    public static void registerParticlesEvent(ParticleFactoryRegisterEvent event) {
        Minecraft.getInstance().particleEngine.register(ParticleRegister.FireElement.get(), ElementParticle.Provider::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegister.WoodElement.get(), ElementParticle.Provider::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegister.EarthElement.get(), ElementParticle.Provider::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegister.MetalElement.get(), ElementParticle.Provider::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegister.WaterElement.get(), ElementParticle.Provider::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegister.FallingRedLeaves.get(), FallingRedLeavesParticle.Provider::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegister.FallingOrangeLeaves.get(), FallingOrangeLeavesParticle.Provider::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegister.FallingYellowLeaves.get(), FallingYellowLeavesParticle.Provider::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegister.FallingSakuraLeaves.get(), FallingSakuraLeavesParticle.Provider::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegister.WoodElementMedium.get(), MediumParticle.Provider::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegister.FireElementMedium.get(), MediumParticle.Provider::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegister.EarthElementMedium.get(), MediumParticle.Provider::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegister.MetalElementMedium.get(), MediumParticle.Provider::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegister.WaterElementMedium.get(), MediumParticle.Provider::new);
    }




    @Nullable
    @SubscribeEvent
    public static void RegisterRendererEvent(FMLClientSetupEvent event) {

        /**キーボード操作を登録*/
        ClientRegistry.registerKeyBinding(connectionKey);

        /**アイテムの状態を登録*/
        event.enqueueWork(() -> {
            ItemProperties.register(ItemAndBlockRegister.normal_katana_tier_1.get(), new ResourceLocation(ModCoreUrushi.ModID, "ishurting"), (itemStack, clientWorld, livingEntity,i) -> (livingEntity instanceof Player &&livingEntity.swinging&&livingEntity.getMainHandItem()==itemStack)?1:0);
            ItemProperties.register(ItemAndBlockRegister.normal_katana_tier_2.get(), new ResourceLocation(ModCoreUrushi.ModID, "ishurting"), (itemStack, clientWorld, livingEntity,i) -> (livingEntity instanceof Player &&livingEntity.swinging&&livingEntity.getMainHandItem()==itemStack)?1:0);
            ItemProperties.register(ItemAndBlockRegister.normal_katana_tier_3.get(), new ResourceLocation(ModCoreUrushi.ModID, "ishurting"), (itemStack, clientWorld, livingEntity,i) -> (livingEntity instanceof Player &&livingEntity.swinging&&livingEntity.getMainHandItem()==itemStack)?1:0);
            ItemProperties.register(ItemAndBlockRegister.normal_katana_tier_4.get(), new ResourceLocation(ModCoreUrushi.ModID, "ishurting"), (itemStack, clientWorld, livingEntity,i) -> (livingEntity instanceof Player &&livingEntity.swinging&&livingEntity.getMainHandItem()==itemStack)?1:0);
            ItemProperties.register(ItemAndBlockRegister.normal_katana_tier_5.get(), new ResourceLocation(ModCoreUrushi.ModID, "ishurting"), (itemStack, clientWorld, livingEntity,i) -> (livingEntity instanceof Player &&livingEntity.swinging&&livingEntity.getMainHandItem()==itemStack)?1:0);
            ItemProperties.register(ItemAndBlockRegister.normal_katana_tier_6.get(), new ResourceLocation(ModCoreUrushi.ModID, "ishurting"), (itemStack, clientWorld, livingEntity,i) -> (livingEntity instanceof Player &&livingEntity.swinging&&livingEntity.getMainHandItem()==itemStack)?1:0);
            ItemProperties.register(ItemAndBlockRegister.normal_katana_tier_7.get(), new ResourceLocation(ModCoreUrushi.ModID, "ishurting"), (itemStack, clientWorld, livingEntity,i) -> (livingEntity instanceof Player &&livingEntity.swinging&&livingEntity.getMainHandItem()==itemStack)?1:0);
            ItemProperties.register(ItemAndBlockRegister.normal_katana_tier_8.get(), new ResourceLocation(ModCoreUrushi.ModID, "ishurting"), (itemStack, clientWorld, livingEntity,i) -> (livingEntity instanceof Player &&livingEntity.swinging&&livingEntity.getMainHandItem()==itemStack)?1:0);
            ItemProperties.register(ItemAndBlockRegister.normal_katana_tier_9.get(), new ResourceLocation(ModCoreUrushi.ModID, "ishurting"), (itemStack, clientWorld, livingEntity,i) -> (livingEntity instanceof Player &&livingEntity.swinging&&livingEntity.getMainHandItem()==itemStack)?1:0);
            ItemProperties.register(ItemAndBlockRegister.normal_katana_tier_10.get(), new ResourceLocation(ModCoreUrushi.ModID, "ishurting"), (itemStack, clientWorld, livingEntity,i) -> (livingEntity instanceof Player &&livingEntity.swinging&&livingEntity.getMainHandItem()==itemStack)?1:0);

            ItemProperties.register(ItemAndBlockRegister.wood_element_magatama.get(), new ResourceLocation(ModCoreUrushi.ModID, "stored_amount"), (itemStack, clientWorld, livingEntity,i) -> (int)Mth.floor((float) ElementUtils.getStoredReiryokuAmount(itemStack)/400) );
            ItemProperties.register(ItemAndBlockRegister.fire_element_magatama.get(), new ResourceLocation(ModCoreUrushi.ModID, "stored_amount"), (itemStack, clientWorld, livingEntity,i) -> (int)Mth.floor((float) ElementUtils.getStoredReiryokuAmount(itemStack)/400) );
            ItemProperties.register(ItemAndBlockRegister.earth_element_magatama.get(), new ResourceLocation(ModCoreUrushi.ModID, "stored_amount"), (itemStack, clientWorld, livingEntity,i) -> (int)Mth.floor((float) ElementUtils.getStoredReiryokuAmount(itemStack)/400) );
            ItemProperties.register(ItemAndBlockRegister.metal_element_magatama.get(), new ResourceLocation(ModCoreUrushi.ModID, "stored_amount"), (itemStack, clientWorld, livingEntity,i) -> (int)Mth.floor((float) ElementUtils.getStoredReiryokuAmount(itemStack)/400) );
            ItemProperties.register(ItemAndBlockRegister.water_element_magatama.get(), new ResourceLocation(ModCoreUrushi.ModID, "stored_amount"), (itemStack, clientWorld, livingEntity,i) -> (int)Mth.floor((float) ElementUtils.getStoredReiryokuAmount(itemStack)/400) );

            ItemProperties.register(Item.byBlock(ItemAndBlockRegister.japanese_timber_bamboo.get()), new ResourceLocation(ModCoreUrushi.ModID, "event"), (itemStack, clientWorld, livingEntity,i) -> UrushiUtils.isShogatsu()? 1 : 0);

        });

       /**コンテナにGUIを登録*/
        MenuScreens.register(MenuRegister.FryerMenu.get(), FryerScreen::new);
        MenuScreens.register(MenuRegister.DoubledWoodenCabinetryMenu.get(), DoubledWoodenCabinetryScreen::new);

       /**見た目が特殊なBlockEntityの見た目を登録*/
        BlockEntityRenderers.register(BlockEntityRegister.Sanbo.get(), SanboRenderer::new);
        BlockEntityRenderers.register(BlockEntityRegister.Shichirin.get(), ShichirinRenderer::new);


        /**jsonファイルを自動生成するために開発環境のパスを登録*/
        if(ModCoreUrushi.isDebug) {
        FMLPaths.GAMEDIR.get();
        ModCoreUrushi.assetsDirectory = new File(FMLPaths.GAMEDIR.get().getParent().toString() + "/src/main/resources/assets/urushi/");
        ModCoreUrushi.assetsInBuildDirectory = new File(FMLPaths.GAMEDIR.get().getParent().toString() + "/build/resources/main/assets/urushi/");
        ModCoreUrushi.dataDirectory = new File(FMLPaths.GAMEDIR.get().getParent().toString() + "/src/main/resources/data/");
        ModCoreUrushi.dataInBuildDirectory = new File(FMLPaths.GAMEDIR.get().getParent().toString() + "/build/resources/main/data/");



            ModCoreUrushi.underDevelopmentList.add(Item.byBlock(ItemAndBlockRegister.goldfish_bowl.get()));
            ModCoreUrushi.underDevelopmentList.add(Item.byBlock(ItemAndBlockRegister.normal_iron_ingot_0.get()));
            ModCoreUrushi.underDevelopmentList.add(Item.byBlock(ItemAndBlockRegister.normal_iron_ingot_1.get()));
            ModCoreUrushi.underDevelopmentList.add(Item.byBlock(ItemAndBlockRegister.normal_iron_ingot_2.get()));
            ModCoreUrushi.underDevelopmentList.add(Item.byBlock(ItemAndBlockRegister.normal_iron_ingot_3.get()));
            ModCoreUrushi.underDevelopmentList.add(Item.byBlock(ItemAndBlockRegister.normal_iron_ingot_4.get()));
            ModCoreUrushi.underDevelopmentList.add(Item.byBlock(ItemAndBlockRegister.normal_iron_ingot_5.get()));
            ModCoreUrushi.underDevelopmentList.add(Item.byBlock(ItemAndBlockRegister.normal_iron_ingot_6.get()));
            ModCoreUrushi.underDevelopmentList.add(Item.byBlock(ItemAndBlockRegister.normal_iron_ingot_7.get()));
            ModCoreUrushi.underDevelopmentList.add(Item.byBlock(ItemAndBlockRegister.normal_iron_ingot_8.get()));
            ModCoreUrushi.underDevelopmentList.add(Item.byBlock(ItemAndBlockRegister.normal_iron_ingot_9.get()));
            ModCoreUrushi.underDevelopmentList.add(ItemAndBlockRegister.normal_hot_katana_blade_tier_1.get());
            ModCoreUrushi.underDevelopmentList.add(ItemAndBlockRegister.normal_hot_katana_blade_tier_2.get());
            ModCoreUrushi.underDevelopmentList.add(ItemAndBlockRegister.normal_hot_katana_blade_tier_3.get());
            ModCoreUrushi.underDevelopmentList.add(ItemAndBlockRegister.normal_hot_katana_blade_tier_4.get());
            ModCoreUrushi.underDevelopmentList.add(ItemAndBlockRegister.normal_hot_katana_blade_tier_5.get());
            ModCoreUrushi.underDevelopmentList.add(ItemAndBlockRegister.normal_hot_katana_blade_tier_6.get());
            ModCoreUrushi.underDevelopmentList.add(ItemAndBlockRegister.normal_hot_katana_blade_tier_7.get());
            ModCoreUrushi.underDevelopmentList.add(ItemAndBlockRegister.normal_hot_katana_blade_tier_8.get());
            ModCoreUrushi.underDevelopmentList.add(ItemAndBlockRegister.normal_hot_katana_blade_tier_9.get());
            ModCoreUrushi.underDevelopmentList.add(ItemAndBlockRegister.normal_hot_katana_blade_tier_10.get());
            ModCoreUrushi.underDevelopmentList.add(ItemAndBlockRegister.normal_katana_blade_tier_1.get());
            ModCoreUrushi.underDevelopmentList.add(ItemAndBlockRegister.normal_katana_blade_tier_2.get());
            ModCoreUrushi.underDevelopmentList.add(ItemAndBlockRegister.normal_katana_blade_tier_3.get());
            ModCoreUrushi.underDevelopmentList.add(ItemAndBlockRegister.normal_katana_blade_tier_4.get());
            ModCoreUrushi.underDevelopmentList.add(ItemAndBlockRegister.normal_katana_blade_tier_5.get());
            ModCoreUrushi.underDevelopmentList.add(ItemAndBlockRegister.normal_katana_blade_tier_6.get());
            ModCoreUrushi.underDevelopmentList.add(ItemAndBlockRegister.normal_katana_blade_tier_7.get());
            ModCoreUrushi.underDevelopmentList.add(ItemAndBlockRegister.normal_katana_blade_tier_8.get());
            ModCoreUrushi.underDevelopmentList.add(ItemAndBlockRegister.normal_katana_blade_tier_9.get());
            ModCoreUrushi.underDevelopmentList.add(ItemAndBlockRegister.normal_katana_blade_tier_10.get());
            ModCoreUrushi.underDevelopmentList.add(ItemAndBlockRegister.normal_katana_tier_1.get());
            ModCoreUrushi.underDevelopmentList.add(ItemAndBlockRegister.normal_katana_tier_2.get());
            ModCoreUrushi.underDevelopmentList.add(ItemAndBlockRegister.normal_katana_tier_3.get());
            ModCoreUrushi.underDevelopmentList.add(ItemAndBlockRegister.normal_katana_tier_4.get());
            ModCoreUrushi.underDevelopmentList.add(ItemAndBlockRegister.normal_katana_tier_5.get());
            ModCoreUrushi.underDevelopmentList.add(ItemAndBlockRegister.normal_katana_tier_6.get());
            ModCoreUrushi.underDevelopmentList.add(ItemAndBlockRegister.normal_katana_tier_7.get());
            ModCoreUrushi.underDevelopmentList.add(ItemAndBlockRegister.normal_katana_tier_8.get());
            ModCoreUrushi.underDevelopmentList.add(ItemAndBlockRegister.normal_katana_tier_9.get());
            ModCoreUrushi.underDevelopmentList.add(ItemAndBlockRegister.normal_katana_tier_10.get());
            ModCoreUrushi.underDevelopmentList.add(ItemAndBlockRegister.hammer.get());
            ModCoreUrushi.underDevelopmentList.add(ItemAndBlockRegister.enhanced_jadeite.get());
             ModCoreUrushi.underDevelopmentList.add(Item.byBlock(ItemAndBlockRegister.sanbo_tier2.get()));
            ModCoreUrushi.underDevelopmentList.add(Item.byBlock(ItemAndBlockRegister.sanbo_tier3.get()));
            ModCoreUrushi.underDevelopmentList.add(Item.byBlock(ItemAndBlockRegister.senryoubako.get()));










            MineableTagGenerator.INSTANCE.registerPickaxeMineableTag(ModCoreUrushi.pickaxeList);
            MineableTagGenerator.INSTANCE.registerAxeMineableTag(ModCoreUrushi.axeList);
            MineableTagGenerator.INSTANCE.registerShovelMineableTag(ModCoreUrushi.shovelList);
            MineableTagGenerator.INSTANCE.registerHoeMineableTag(ModCoreUrushi.hoeList);
            RequiredToolMaterialTagGenerator.INSTANCE.registerWoodenToolTag(ModCoreUrushi.woodenToolList);
            RequiredToolMaterialTagGenerator.INSTANCE.registerStoneToolTag(ModCoreUrushi.stoneToolList);
            RequiredToolMaterialTagGenerator.INSTANCE.registerIronToolTag(ModCoreUrushi.ironToolList);
            RequiredToolMaterialTagGenerator.INSTANCE.registerGoldenToolTag(ModCoreUrushi.goldenToolList);
            RequiredToolMaterialTagGenerator.INSTANCE.registerDiamondToolTag(ModCoreUrushi.diamondToolList);
            RequiredToolMaterialTagGenerator.INSTANCE.registerNetheriteToolTag(ModCoreUrushi.netheriteToolList);
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.oak_fushiranma.get()),"fushiranma_oak");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.spruce_fushiranma.get()),"fushiranma_spruce");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.birch_fushiranma.get()),"fushiranma_birch");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.jungle_fushiranma.get()),"fushiranma_jungle");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.acacia_fushiranma.get()),"fushiranma_acacia");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.dark_oak_fushiranma.get()),"fushiranma_dark_oak");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.japanese_apricot_fushiranma.get()),"fushiranma_japanese_apricot");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.sakura_fushiranma.get()),"fushiranma_sakura");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.cypress_fushiranma.get()),"fushiranma_cypress");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.red_urushi_fushiranma.get()),"fushiranma_red_urushi");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.black_urushi_fushiranma.get()),"fushiranma_black_urushi");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.polished_yomi_stone.get()),"polished_yomi_stone");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.fallen_red_leaves.get()),"fallen_red_leaves");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.fallen_orange_leaves.get()),"fallen_orange_leaves");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.fallen_yellow_leaves.get()),"fallen_yellow_leaves");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.fallen_sakura_leaves.get()),"fallen_sakura_leaves");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.fallen_japanese_apricot_leaves.get()),"fallen_japanese_apricot_leaves");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.ghost_dirt.get()),"ghost_dirt");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.ghost_stone.get()),"ghost_stone");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.jadeite_block.get()),"jadeite_block");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.smooth_jadeite_block.get()),"smooth_jadeite_block");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.jadeite_brick.get()),"jadeite_brick");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.jadeite_pillar.get()),"jadeite_pillar");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.petrified_log_with_water_amber.get()),"petrified_log_with_water_amber");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.petrified_log_with_metal_amber.get()),"petrified_log_with_metal_amber");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.petrified_log_with_fire_amber.get()),"petrified_log_with_fire_amber");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.petrified_log_with_wood_amber.get()),"petrified_log_with_wood_amber");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.oak_framed_wattle_and_daub.get()),"framed_wattle_and_daub/wattle_and_daub_oak_0");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.spruce_framed_wattle_and_daub.get()),"framed_wattle_and_daub/wattle_and_daub_spruce_0");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.birch_framed_wattle_and_daub.get()),"framed_wattle_and_daub/wattle_and_daub_birch_0");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.jungle_framed_wattle_and_daub.get()),"framed_wattle_and_daub/wattle_and_daub_jungle_0");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.acacia_framed_wattle_and_daub.get()),"framed_wattle_and_daub/wattle_and_daub_acacia_0");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.dark_oak_framed_wattle_and_daub.get()),"framed_wattle_and_daub/wattle_and_daub_dark_oak_0");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.japanese_apricot_framed_wattle_and_daub.get()),"framed_wattle_and_daub/wattle_and_daub_apricot_0");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.sakura_framed_wattle_and_daub.get()),"framed_wattle_and_daub/wattle_and_daub_sakura_0");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.cypress_framed_wattle_and_daub.get()),"framed_wattle_and_daub/wattle_and_daub_cypress_0");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.japanese_cedar_framed_wattle_and_daub.get()),"framed_wattle_and_daub/wattle_and_daub_cedar_0");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.red_urushi_framed_wattle_and_daub.get()),"framed_wattle_and_daub/wattle_and_daub_red_0");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.black_urushi_framed_wattle_and_daub.get()),"framed_wattle_and_daub/wattle_and_daub_black_0");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.oak_framed_sand_coast.get()),"framed_sand_coast/sand_coast_oak_0");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.spruce_framed_sand_coast.get()),"framed_sand_coast/sand_coast_spruce_0");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.birch_framed_sand_coast.get()),"framed_sand_coast/sand_coast_birch_0");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.jungle_framed_sand_coast.get()),"framed_sand_coast/sand_coast_jungle_0");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.acacia_framed_sand_coast.get()),"framed_sand_coast/sand_coast_acacia_0");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.dark_oak_framed_sand_coast.get()),"framed_sand_coast/sand_coast_dark_oak_0");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.japanese_apricot_framed_sand_coast.get()),"framed_sand_coast/sand_coast_apricot_0");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.sakura_framed_sand_coast.get()),"framed_sand_coast/sand_coast_sakura_0");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.cypress_framed_sand_coast.get()),"framed_sand_coast/sand_coast_cypress_0");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.japanese_cedar_framed_sand_coast.get()),"framed_sand_coast/sand_coast_cedar_0");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.red_urushi_framed_sand_coast.get()),"framed_sand_coast/sand_coast_red_0");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.black_urushi_framed_sand_coast.get()),"framed_sand_coast/sand_coast_black_0");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(ItemAndBlockRegister.invisible_button_item.get(),"invisible_button_inventory");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(ItemAndBlockRegister.invisible_pressure_plate_item.get(),"invisible_pressure_plate");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.kakuriyo_dirt.get()),"kakuriyo_dirt");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.oak_shitamiita.get()),"oak_shitamiita");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.spruce_shitamiita.get()),"spruce_shitamiita");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.birch_shitamiita.get()),"birch_shitamiita");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.jungle_shitamiita.get()),"jungle_shitamiita");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.acacia_shitamiita.get()),"acacia_shitamiita");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.dark_oak_shitamiita.get()),"dark_oak_shitamiita");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.japanese_apricot_shitamiita.get()),"japanese_apricot_shitamiita");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.sakura_shitamiita.get()),"sakura_shitamiita");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.cypress_shitamiita.get()),"cypress_shitamiita");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.japanese_cedar_shitamiita.get()),"japanese_cedar_shitamiita");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.red_urushi_shitamiita.get()),"red_urushi_shitamiita");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.black_urushi_shitamiita.get()),"black_urushi_shitamiita");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.oak_shitamiita_slab.get()),"half_slab_oak_shitamiita");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.spruce_shitamiita_slab.get()),"half_slab_spruce_shitamiita");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.birch_shitamiita_slab.get()),"half_slab_birch_shitamiita");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.jungle_shitamiita_slab.get()),"half_slab_jungle_shitamiita");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.acacia_shitamiita_slab.get()),"half_slab_acacia_shitamiita");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.dark_oak_shitamiita_slab.get()),"half_slab_dark_oak_shitamiita");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.japanese_apricot_shitamiita_slab.get()),"half_slab_japanese_apricot_shitamiita");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.sakura_shitamiita_slab.get()),"half_slab_sakura_shitamiita");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.cypress_shitamiita_slab.get()),"half_slab_cypress_shitamiita");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.japanese_cedar_shitamiita_slab.get()),"half_slab_japanese_cedar_shitamiita");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.red_urushi_shitamiita_slab.get()),"half_slab_red_urushi_shitamiita");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.black_urushi_shitamiita_slab.get()),"half_slab_black_urushi_shitamiita");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.long_chochin.get()),"long_chochin");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.izakaya_long_chochin.get()),"izakaya_long_chochin");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.eigyouchu_long_chochin.get()),"eigyouchu_long_chochin");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.ramen_long_chochin.get()),"ramen_long_chochin");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.oden_long_chochin.get()),"oden_long_chochin");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.shokujidokoro_long_chochin.get()),"shokujidokoro_long_chochin");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.shichirin.get()),"shichirin_filled");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.unfired_shichirin.get()),"shichirin_unfired");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.unfinished_shichirin.get()),"shichirin_unfinished");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.wood_element_tank_tier1.get()),"wood_element_tank_tier1");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.fire_element_tank_tier1.get()),"fire_element_tank_tier1");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.earth_element_tank_tier1.get()),"earth_element_tank_tier1");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.metal_element_tank_tier1.get()),"metal_element_tank_tier1");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.water_element_tank_tier1.get()),"water_element_tank_tier1");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.white_stained_wooden_cabinetry_slab.get()),"white_stained_wooden_cabinetry_under_slab");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.orange_stained_wooden_cabinetry_slab.get()),"orange_stained_wooden_cabinetry_under_slab");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.magenta_stained_wooden_cabinetry_slab.get()),"magenta_stained_wooden_cabinetry_under_slab");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.light_blue_stained_wooden_cabinetry_slab.get()),"light_blue_stained_wooden_cabinetry_under_slab");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.yellow_stained_wooden_cabinetry_slab.get()),"yellow_stained_wooden_cabinetry_under_slab");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.lime_stained_wooden_cabinetry_slab.get()),"lime_stained_wooden_cabinetry_under_slab");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.pink_stained_wooden_cabinetry_slab.get()),"pink_stained_wooden_cabinetry_under_slab");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.gray_stained_wooden_cabinetry_slab.get()),"gray_stained_wooden_cabinetry_under_slab");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.light_gray_stained_wooden_cabinetry_slab.get()),"light_gray_stained_wooden_cabinetry_under_slab");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.cyan_stained_wooden_cabinetry_slab.get()),"cyan_stained_wooden_cabinetry_under_slab");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.purple_stained_wooden_cabinetry_slab.get()),"purple_stained_wooden_cabinetry_under_slab");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.blue_stained_wooden_cabinetry_slab.get()),"blue_stained_wooden_cabinetry_under_slab");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.brown_stained_wooden_cabinetry_slab.get()),"brown_stained_wooden_cabinetry_under_slab");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.green_stained_wooden_cabinetry_slab.get()),"green_stained_wooden_cabinetry_under_slab");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.red_stained_wooden_cabinetry_slab.get()),"red_stained_wooden_cabinetry_under_slab");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.black_stained_wooden_cabinetry_slab.get()),"black_stained_wooden_cabinetry_under_slab");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.white_stained_wooden_cabinetry.get()),"white_stained_wooden_cabinetry");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.orange_stained_wooden_cabinetry.get()),"orange_stained_wooden_cabinetry");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.magenta_stained_wooden_cabinetry.get()),"magenta_stained_wooden_cabinetry");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.light_blue_stained_wooden_cabinetry.get()),"light_blue_stained_wooden_cabinetry");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.yellow_stained_wooden_cabinetry.get()),"yellow_stained_wooden_cabinetry");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.lime_stained_wooden_cabinetry.get()),"lime_stained_wooden_cabinetry");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.pink_stained_wooden_cabinetry.get()),"pink_stained_wooden_cabinetry");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.gray_stained_wooden_cabinetry.get()),"gray_stained_wooden_cabinetry");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.light_gray_stained_wooden_cabinetry.get()),"light_gray_stained_wooden_cabinetry");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.cyan_stained_wooden_cabinetry.get()),"cyan_stained_wooden_cabinetry");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.purple_stained_wooden_cabinetry.get()),"purple_stained_wooden_cabinetry");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.blue_stained_wooden_cabinetry.get()),"blue_stained_wooden_cabinetry");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.brown_stained_wooden_cabinetry.get()),"brown_stained_wooden_cabinetry");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.green_stained_wooden_cabinetry.get()),"green_stained_wooden_cabinetry");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.red_stained_wooden_cabinetry.get()),"red_stained_wooden_cabinetry");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.black_stained_wooden_cabinetry.get()),"black_stained_wooden_cabinetry");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.doubled_white_stained_wooden_cabinetry.get()),"white_stained_wooden_cabinetry_doubled");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.doubled_orange_stained_wooden_cabinetry.get()),"orange_stained_wooden_cabinetry_doubled");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.doubled_magenta_stained_wooden_cabinetry.get()),"magenta_stained_wooden_cabinetry_doubled");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.doubled_light_blue_stained_wooden_cabinetry.get()),"light_blue_stained_wooden_cabinetry_doubled");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.doubled_yellow_stained_wooden_cabinetry.get()),"yellow_stained_wooden_cabinetry_doubled");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.doubled_lime_stained_wooden_cabinetry.get()),"lime_stained_wooden_cabinetry_doubled");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.doubled_pink_stained_wooden_cabinetry.get()),"pink_stained_wooden_cabinetry_doubled");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.doubled_gray_stained_wooden_cabinetry.get()),"gray_stained_wooden_cabinetry_doubled");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.doubled_light_gray_stained_wooden_cabinetry.get()),"light_gray_stained_wooden_cabinetry_doubled");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.doubled_cyan_stained_wooden_cabinetry.get()),"cyan_stained_wooden_cabinetry_doubled");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.doubled_purple_stained_wooden_cabinetry.get()),"purple_stained_wooden_cabinetry_doubled");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.doubled_blue_stained_wooden_cabinetry.get()),"blue_stained_wooden_cabinetry_doubled");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.doubled_brown_stained_wooden_cabinetry.get()),"brown_stained_wooden_cabinetry_doubled");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.doubled_green_stained_wooden_cabinetry.get()),"green_stained_wooden_cabinetry_doubled");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.doubled_red_stained_wooden_cabinetry.get()),"red_stained_wooden_cabinetry_doubled");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.doubled_black_stained_wooden_cabinetry.get()),"black_stained_wooden_cabinetry_doubled");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.wood_element_crafting_table_tier1.get()),"wood_element_crafting_table_tier1_lit");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.fire_element_crafting_table_tier1.get()),"fire_element_crafting_table_tier1_lit");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.earth_element_crafting_table_tier1.get()),"earth_element_crafting_table_tier1_lit");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.metal_element_crafting_table_tier1.get()),"metal_element_crafting_table_tier1_lit");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.water_element_crafting_table_tier1.get()),"water_element_crafting_table_tier1_lit");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.wood_element_sacred_rock.get()),"wood_element_sacred_rock");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.fire_element_sacred_rock.get()),"fire_element_sacred_rock");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.earth_element_sacred_rock.get()),"earth_element_sacred_rock");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.metal_element_sacred_rock.get()),"metal_element_sacred_rock");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.water_element_sacred_rock.get()),"water_element_sacred_rock");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.wood_element_emitter_tier1.get()),"wood_element_emitter_tier1");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.fire_element_emitter_tier1.get()),"fire_element_emitter_tier1");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.earth_element_emitter_tier1.get()),"earth_element_emitter_tier1");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.metal_element_emitter_tier1.get()),"metal_element_emitter_tier1");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.water_element_emitter_tier1.get()),"water_element_emitter_tier1");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.mirror_tier1.get()),"mirror_tier1_n");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.orange_plaster.get()),"orange_plaster");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.magenta_plaster.get()),"magenta_plaster");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.light_blue_plaster.get()),"light_blue_plaster");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.yellow_plaster.get()),"yellow_plaster");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.lime_plaster.get()),"lime_plaster");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.pink_plaster.get()),"pink_plaster");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.light_gray_plaster.get()),"light_gray_plaster");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.gray_plaster.get()),"gray_plaster");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.cyan_plaster.get()),"cyan_plaster");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.purple_plaster.get()),"purple_plaster");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.blue_plaster.get()),"blue_plaster");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.brown_plaster.get()),"brown_plaster");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.green_plaster.get()),"green_plaster");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.red_plaster.get()),"red_plaster");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.black_plaster.get()),"black_plaster");
           NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.ghost_plaster.get()),"ghost_plaster");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.ghost_sand_coast.get()),"ghost_sand_coast");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.ghost_wattle_and_daub.get()),"ghost_wattle_and_daub");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.ghost_concrete.get()),"ghost_concrete");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.copper_giboshi.get()),"giboshi_copper");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.lantern_plant_block.get()),"lantern_plant_block");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.ishigaki_block.get()),"ishigaki_block");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.concrete_slab_wall.get()),"concrete_slab_wall_normal");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.ajisai.get()),"ajisai");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.sazare_ishi.get()),"sazare_ishi");
            NormalBlockItemJsonMaker.INSTANCE.registerBlockModel(Item.byBlock(ItemAndBlockRegister.rock.get()),"rock");






            CubeAllBlockJsonMaker.INSTANCE.registerBlockModel(ItemAndBlockRegister.yomi_stone.get(),"yomi_stone");
            CubeAllBlockJsonMaker.INSTANCE.registerBlockModel(ItemAndBlockRegister.yomi_copper_ore.get(),"copper_ore_yomi");
            CubeAllBlockJsonMaker.INSTANCE.registerBlockModel(ItemAndBlockRegister.yomi_iron_ore.get(),"iron_ore_yomi");
            CubeAllBlockJsonMaker.INSTANCE.registerBlockModel(ItemAndBlockRegister.yomi_gold_ore.get(),"gold_ore_yomi");
            CubeAllBlockJsonMaker.INSTANCE.registerBlockModel(ItemAndBlockRegister.cobbled_yomi_stone.get(),"yomi_stone_cobbled");
            CubeAllBlockJsonMaker.INSTANCE.registerBlockModel(ItemAndBlockRegister.polished_yomi_stone.get(),"yomi_stone_polished");
            CubeAllBlockJsonMaker.INSTANCE.registerBlockModel(ItemAndBlockRegister.black_kakuriyo_portal_frame.get(),"kakuriyo_portal_frame_black");
            CubeAllBlockJsonMaker.INSTANCE.registerBlockModel(ItemAndBlockRegister.jadeite_block.get(),"jadeite_block_polished");
            CubeAllBlockJsonMaker.INSTANCE.registerBlockModel(ItemAndBlockRegister.smooth_jadeite_block.get(),"jadeite_block_smooth");
            CubeAllBlockJsonMaker.INSTANCE.registerBlockModel(ItemAndBlockRegister.jadeite_brick.get(),"jadeite_block_brick");
            CubeAllBlockJsonMaker.INSTANCE.registerBlockModel(ItemAndBlockRegister.petrified_planks.get(),"petrified_planks");
            CubeAllBlockJsonMaker.INSTANCE.registerBlockModel(ItemAndBlockRegister.kakuriyo_dirt.get(),"kakuriyo_dirt");
            CubeAllBlockJsonMaker.INSTANCE.registerBlockModel(ItemAndBlockRegister.orange_plaster.get(),"plaster_orange");
            CubeAllBlockJsonMaker.INSTANCE.registerBlockModel(ItemAndBlockRegister.magenta_plaster.get(),"plaster_magenta");
            CubeAllBlockJsonMaker.INSTANCE.registerBlockModel(ItemAndBlockRegister.light_blue_plaster.get(),"plaster_light_blue");
            CubeAllBlockJsonMaker.INSTANCE.registerBlockModel(ItemAndBlockRegister.yellow_plaster.get(),"plaster_yellow");
            CubeAllBlockJsonMaker.INSTANCE.registerBlockModel(ItemAndBlockRegister.lime_plaster.get(),"plaster_lime");
            CubeAllBlockJsonMaker.INSTANCE.registerBlockModel(ItemAndBlockRegister.pink_plaster.get(),"plaster_pink");
            CubeAllBlockJsonMaker.INSTANCE.registerBlockModel(ItemAndBlockRegister.light_gray_plaster.get(),"plaster_light_gray");
            CubeAllBlockJsonMaker.INSTANCE.registerBlockModel(ItemAndBlockRegister.gray_plaster.get(),"plaster_gray");
            CubeAllBlockJsonMaker.INSTANCE.registerBlockModel(ItemAndBlockRegister.cyan_plaster.get(),"plaster_cyan");
            CubeAllBlockJsonMaker.INSTANCE.registerBlockModel(ItemAndBlockRegister.purple_plaster.get(),"plaster_purple");
            CubeAllBlockJsonMaker.INSTANCE.registerBlockModel(ItemAndBlockRegister.blue_plaster.get(),"plaster_blue");
            CubeAllBlockJsonMaker.INSTANCE.registerBlockModel(ItemAndBlockRegister.brown_plaster.get(),"plaster_brown");
            CubeAllBlockJsonMaker.INSTANCE.registerBlockModel(ItemAndBlockRegister.green_plaster.get(),"plaster_green");
            CubeAllBlockJsonMaker.INSTANCE.registerBlockModel(ItemAndBlockRegister.red_plaster.get(),"plaster_red");
            CubeAllBlockJsonMaker.INSTANCE.registerBlockModel(ItemAndBlockRegister.black_plaster.get(),"plaster_black");
            CubeAllBlockJsonMaker.INSTANCE.registerBlockModel(ItemAndBlockRegister.lantern_plant_block.get(),"lantern_plant_block");



            SlabBlockJsonMaker.INSTANCE.registerSlabBlockModel(ItemAndBlockRegister.yomi_stone_slab.get(),"half_slab_yomi_stone",ItemAndBlockRegister.yomi_stone.get(),"upper_slab_yomi_stone","yomi_stone");
            SlabBlockJsonMaker.INSTANCE.registerSlabBlockModel(ItemAndBlockRegister.cobbled_yomi_stone_slab.get(),"half_slab_cobbled_yomi_stone",ItemAndBlockRegister.cobbled_yomi_stone.get(),"upper_slab_cobbled_yomi_stone","yomi_stone_cobbled");
            SlabBlockJsonMaker.INSTANCE.registerSlabBlockModel(ItemAndBlockRegister.large_yomi_stone_brick_slab.get(),"half_slab_large_yomi_stone_brick",ItemAndBlockRegister.large_yomi_stone_bricks.get(),"upper_slab_large_yomi_stone_brick","yomi_stone_bricks");
            SlabBlockJsonMaker.INSTANCE.registerSlabBlockModel(ItemAndBlockRegister.small_yomi_stone_brick_slab.get(),"half_slab_small_yomi_stone_brick",ItemAndBlockRegister.small_yomi_stone_bricks.get(),"upper_slab_small_yomi_stone_brick","yomi_stone_small_bricks");
            SlabBlockJsonMaker.INSTANCE.registerSlabBlockModel(ItemAndBlockRegister.jadeite_slab.get(),"half_slab_jadeite",ItemAndBlockRegister.jadeite_block.get(),"upper_slab_jadeite","jadeite_block_polished");
            SlabBlockJsonMaker.INSTANCE.registerSlabBlockModel(ItemAndBlockRegister.jadeite_brick_slab.get(),"half_slab_jadeite_brick",ItemAndBlockRegister.jadeite_brick.get(),"upper_slab_jadeite_brick","jadeite_block_brick");
            SlabBlockJsonMaker.INSTANCE.registerSlabBlockModel(ItemAndBlockRegister.smooth_jadeite_slab.get(),"half_slab_smooth_jadeite",ItemAndBlockRegister.smooth_jadeite_block.get(),"upper_slab_smooth_jadeite","jadeite_block_smooth");
            SlabBlockJsonMaker.INSTANCE.registerSlabBlockModel(ItemAndBlockRegister.orange_plaster_slab.get(),"half_slab_orange_plaster",ItemAndBlockRegister.orange_plaster.get(),"upper_slab_orange_plaster","plaster_orange");
            SlabBlockJsonMaker.INSTANCE.registerSlabBlockModel(ItemAndBlockRegister.magenta_plaster_slab.get(),"half_slab_magenta_plaster",ItemAndBlockRegister.magenta_plaster.get(),"upper_slab_magenta_plaster","plaster_magenta");
            SlabBlockJsonMaker.INSTANCE.registerSlabBlockModel(ItemAndBlockRegister.light_blue_plaster_slab.get(),"half_slab_light_blue_plaster",ItemAndBlockRegister.light_blue_plaster.get(),"upper_slab_light_blue_plaster","plaster_light_blue");
            SlabBlockJsonMaker.INSTANCE.registerSlabBlockModel(ItemAndBlockRegister.yellow_plaster_slab.get(),"half_slab_yellow_plaster",ItemAndBlockRegister.yellow_plaster.get(),"upper_slab_yellow_plaster","plaster_yellow");
            SlabBlockJsonMaker.INSTANCE.registerSlabBlockModel(ItemAndBlockRegister.lime_plaster_slab.get(),"half_slab_lime_plaster",ItemAndBlockRegister.lime_plaster.get(),"upper_slab_lime_plaster","plaster_lime");
            SlabBlockJsonMaker.INSTANCE.registerSlabBlockModel(ItemAndBlockRegister.pink_plaster_slab.get(),"half_slab_pink_plaster",ItemAndBlockRegister.pink_plaster.get(),"upper_slab_pink_plaster","plaster_pink");
            SlabBlockJsonMaker.INSTANCE.registerSlabBlockModel(ItemAndBlockRegister.light_gray_plaster_slab.get(),"half_slab_light_gray_plaster",ItemAndBlockRegister.light_gray_plaster.get(),"upper_slab_light_gray_plaster","plaster_light_gray");
            SlabBlockJsonMaker.INSTANCE.registerSlabBlockModel(ItemAndBlockRegister.gray_plaster_slab.get(),"half_slab_gray_plaster",ItemAndBlockRegister.gray_plaster.get(),"upper_slab_gray_plaster","plaster_gray");
            SlabBlockJsonMaker.INSTANCE.registerSlabBlockModel(ItemAndBlockRegister.cyan_plaster_slab.get(),"half_slab_cyan_plaster",ItemAndBlockRegister.cyan_plaster.get(),"upper_slab_cyan_plaster","plaster_cyan");
            SlabBlockJsonMaker.INSTANCE.registerSlabBlockModel(ItemAndBlockRegister.purple_plaster_slab.get(),"half_slab_purple_plaster",ItemAndBlockRegister.purple_plaster.get(),"upper_slab_purple_plaster","plaster_purple");
            SlabBlockJsonMaker.INSTANCE.registerSlabBlockModel(ItemAndBlockRegister.blue_plaster_slab.get(),"half_slab_blue_plaster",ItemAndBlockRegister.blue_plaster.get(),"upper_slab_blue_plaster","plaster_blue");
            SlabBlockJsonMaker.INSTANCE.registerSlabBlockModel(ItemAndBlockRegister.brown_plaster_slab.get(),"half_slab_brown_plaster",ItemAndBlockRegister.brown_plaster.get(),"upper_slab_brown_plaster","plaster_brown");
            SlabBlockJsonMaker.INSTANCE.registerSlabBlockModel(ItemAndBlockRegister.green_plaster_slab.get(),"half_slab_green_plaster",ItemAndBlockRegister.green_plaster.get(),"upper_slab_green_plaster","plaster_green");
            SlabBlockJsonMaker.INSTANCE.registerSlabBlockModel(ItemAndBlockRegister.red_plaster_slab.get(),"half_slab_red_plaster",ItemAndBlockRegister.red_plaster.get(),"upper_slab_red_plaster","plaster_red");
            SlabBlockJsonMaker.INSTANCE.registerSlabBlockModel(ItemAndBlockRegister.black_plaster_slab.get(),"half_slab_black_plaster",ItemAndBlockRegister.black_plaster.get(),"upper_slab_black_plaster","plaster_black");


            StairBlockJsonMaker.INSTANCE.registerStairsBlockModel("yomi_stone","yomi_stone");
            StairBlockJsonMaker.INSTANCE.registerStairsBlockModel("cobbled_yomi_stone","yomi_stone_cobbled");
            StairBlockJsonMaker.INSTANCE.registerStairsBlockModel("polished_yomi_stone","yomi_stone_polished");
            StairBlockJsonMaker.INSTANCE.registerStairsBlockModel("large_yomi_stone_brick","yomi_stone_bricks");
            StairBlockJsonMaker.INSTANCE.registerStairsBlockModel("small_yomi_stone_brick","yomi_stone_small_bricks");
            StairBlockJsonMaker.INSTANCE.registerStairsBlockModel("jadeite","jadeite_block_polished");
            StairBlockJsonMaker.INSTANCE.registerStairsBlockModel("jadeite_brick","jadeite_block_brick");
            StairBlockJsonMaker.INSTANCE.registerStairsBlockModel("smooth_jadeite","jadeite_block_smooth");
            StairBlockJsonMaker.INSTANCE.registerStairsBlockModel("orange_plaster","plaster_orange");
            StairBlockJsonMaker.INSTANCE.registerStairsBlockModel("magenta_plaster","plaster_magenta");
            StairBlockJsonMaker.INSTANCE.registerStairsBlockModel("light_blue_plaster","plaster_light_blue");
            StairBlockJsonMaker.INSTANCE.registerStairsBlockModel("yellow_plaster","plaster_yellow");
            StairBlockJsonMaker.INSTANCE.registerStairsBlockModel("lime_plaster","plaster_lime");
            StairBlockJsonMaker.INSTANCE.registerStairsBlockModel("pink_plaster","plaster_pink");
            StairBlockJsonMaker.INSTANCE.registerStairsBlockModel("light_gray_plaster","plaster_light_gray");
            StairBlockJsonMaker.INSTANCE.registerStairsBlockModel("gray_plaster","plaster_gray");
            StairBlockJsonMaker.INSTANCE.registerStairsBlockModel("cyan_plaster","plaster_cyan");
            StairBlockJsonMaker.INSTANCE.registerStairsBlockModel("purple_plaster","plaster_purple");
            StairBlockJsonMaker.INSTANCE.registerStairsBlockModel("blue_plaster","plaster_blue");
            StairBlockJsonMaker.INSTANCE.registerStairsBlockModel("brown_plaster","plaster_brown");
            StairBlockJsonMaker.INSTANCE.registerStairsBlockModel("green_plaster","plaster_green");
            StairBlockJsonMaker.INSTANCE.registerStairsBlockModel("red_plaster","plaster_red");
            StairBlockJsonMaker.INSTANCE.registerStairsBlockModel("black_plaster","plaster_black");


            GeneratedItemJsonMaker.INSTANCE.registerItemModel(ItemAndBlockRegister.jadeite.get(),"jadeite");
            GeneratedItemJsonMaker.INSTANCE.registerItemModel(ItemAndBlockRegister.yomotsuhegui_fruit.get(),"yomotsuhegui");
            GeneratedItemJsonMaker.INSTANCE.registerItemModel(ItemAndBlockRegister.ghost_core.get(),"ghost_core");
            GeneratedItemJsonMaker.INSTANCE.registerItemModel(ItemAndBlockRegister.wood_amber.get(),"amber_wood");
            GeneratedItemJsonMaker.INSTANCE.registerItemModel(ItemAndBlockRegister.fire_amber.get(),"amber_fire");
            GeneratedItemJsonMaker.INSTANCE.registerItemModel(ItemAndBlockRegister.earth_amber.get(),"amber_earth");
            GeneratedItemJsonMaker.INSTANCE.registerItemModel(ItemAndBlockRegister.metal_amber.get(),"amber_metal");
            GeneratedItemJsonMaker.INSTANCE.registerItemModel(ItemAndBlockRegister.water_amber.get(),"amber_water");
            GeneratedItemJsonMaker.INSTANCE.registerItemModel(ItemAndBlockRegister.wood_element_magatama.get(),"magatama_wood");
            GeneratedItemJsonMaker.INSTANCE.registerItemModel(ItemAndBlockRegister.fire_element_magatama.get(),"magatama_fire");
            GeneratedItemJsonMaker.INSTANCE.registerItemModel(ItemAndBlockRegister.earth_element_magatama.get(),"magatama_earth");
            GeneratedItemJsonMaker.INSTANCE.registerItemModel(ItemAndBlockRegister.metal_element_magatama.get(),"magatama_metal");
            GeneratedItemJsonMaker.INSTANCE.registerItemModel(ItemAndBlockRegister.water_element_magatama.get(),"magatama_water");
            GeneratedItemJsonMaker.INSTANCE.registerItemModel(ItemAndBlockRegister.roasted_shiitake.get(),"shiitake_roasted");
            GeneratedItemJsonMaker.INSTANCE.registerItemModel(ItemAndBlockRegister.shiitake_goggles.get(),"shiitake_goggles");
            GeneratedItemJsonMaker.INSTANCE.registerItemModel(ItemAndBlockRegister.so.get(),"so");
            GeneratedItemJsonMaker.INSTANCE.registerItemModel(ItemAndBlockRegister.cheese_gyudon.get(),"rice_beef_cheese");
            GeneratedItemJsonMaker.INSTANCE.registerItemModel(ItemAndBlockRegister.cheese_gyudon_with_onsen_egg.get(),"rice_beef_cheese_onsen_egg");
            GeneratedItemJsonMaker.INSTANCE.registerItemModel(ItemAndBlockRegister.wood_element_paper.get(),"paper_wood");
            GeneratedItemJsonMaker.INSTANCE.registerItemModel(ItemAndBlockRegister.fire_element_paper.get(),"paper_fire");
            GeneratedItemJsonMaker.INSTANCE.registerItemModel(ItemAndBlockRegister.earth_element_paper.get(),"paper_earth");
            GeneratedItemJsonMaker.INSTANCE.registerItemModel(ItemAndBlockRegister.metal_element_paper.get(),"paper_metal");
            GeneratedItemJsonMaker.INSTANCE.registerItemModel(ItemAndBlockRegister.water_element_paper.get(),"paper_water");



        }
    }
}