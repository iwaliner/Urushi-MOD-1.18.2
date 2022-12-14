package com.iwaliner.urushi;

import com.iwaliner.urushi.blockentity.screen.DoubledWoodenCabinetryScreen;
import com.iwaliner.urushi.blockentity.screen.FryerScreen;
import com.iwaliner.urushi.entiity.food.model.*;
import com.iwaliner.urushi.entiity.food.renderer.*;
import com.iwaliner.urushi.entiity.model.CushionModel;
import com.iwaliner.urushi.entiity.renderer.CushionRenderer;
import com.iwaliner.urushi.entiity.renderer.GhostRenderer;
import com.iwaliner.urushi.json.*;
import com.iwaliner.urushi.particle.TestParticle;
import com.iwaliner.urushi.util.ElementUtils;
import com.iwaliner.urushi.util.ToggleKeyMappingPlus;
import com.iwaliner.urushi.util.UrushiUtils;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.ToggleKeyMapping;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.loading.FMLPaths;

import javax.annotation.Nullable;
import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.io.File;

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

    public static final KeyMapping connectionKey = new ToggleKeyMappingPlus("Apart Block Connections", InputConstants.KEY_C, "Urushi");


    /**???????????????????????????????????????*/
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

    /**??????????????????????????????????????????*/
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

    /*???????????????????????????????????????*/
    @SubscribeEvent
    public static void registerParticlesEvent(ParticleFactoryRegisterEvent event) {
        //Minecraft.getInstance().particleEngine.register(ParticleRegister.Test.get(),TestParticle.Provider::new);
    }

    @Nullable
    @SubscribeEvent
    public static void RegisterRendererEvent(FMLClientSetupEvent event) {

        /**??????????????????????????????*/
        ClientRegistry.registerKeyBinding(connectionKey);

        /**??????????????????????????????*/
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

       /**???????????????GUI?????????*/
        MenuScreens.register(MenuRegister.FryerMenu.get(), FryerScreen::new);
        MenuScreens.register(MenuRegister.DoubledWoodenCabinetryMenu.get(), DoubledWoodenCabinetryScreen::new);






        /**json????????????????????????????????????????????????????????????????????????*/
        if(ModCoreUrushi.isDebug) {
        FMLPaths.GAMEDIR.get();
        ModCoreUrushi.assetsDirectory = new File(FMLPaths.GAMEDIR.get().getParent().toString() + "/src/main/resources/assets/urushi/");
        ModCoreUrushi.assetsInBuildDirectory = new File(FMLPaths.GAMEDIR.get().getParent().toString() + "/build/resources/main/assets/urushi/");
        ModCoreUrushi.dataDirectory = new File(FMLPaths.GAMEDIR.get().getParent().toString() + "/src/main/resources/data/");
        ModCoreUrushi.dataInBuildDirectory = new File(FMLPaths.GAMEDIR.get().getParent().toString() + "/build/resources/main/data/");




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


            SlabBlockJsonMaker.INSTANCE.registerSlabBlockModel(ItemAndBlockRegister.yomi_stone_slab.get(),"half_slab_yomi_stone",ItemAndBlockRegister.yomi_stone.get(),"upper_slab_yomi_stone","yomi_stone");
            SlabBlockJsonMaker.INSTANCE.registerSlabBlockModel(ItemAndBlockRegister.cobbled_yomi_stone_slab.get(),"half_slab_cobbled_yomi_stone",ItemAndBlockRegister.cobbled_yomi_stone.get(),"upper_slab_cobbled_yomi_stone","yomi_stone_cobbled");
            SlabBlockJsonMaker.INSTANCE.registerSlabBlockModel(ItemAndBlockRegister.large_yomi_stone_brick_slab.get(),"half_slab_large_yomi_stone_brick",ItemAndBlockRegister.large_yomi_stone_bricks.get(),"upper_slab_large_yomi_stone_brick","yomi_stone_bricks");
            SlabBlockJsonMaker.INSTANCE.registerSlabBlockModel(ItemAndBlockRegister.small_yomi_stone_brick_slab.get(),"half_slab_small_yomi_stone_brick",ItemAndBlockRegister.small_yomi_stone_bricks.get(),"upper_slab_small_yomi_stone_brick","yomi_stone_small_bricks");
            SlabBlockJsonMaker.INSTANCE.registerSlabBlockModel(ItemAndBlockRegister.jadeite_slab.get(),"half_slab_jadeite",ItemAndBlockRegister.jadeite_block.get(),"upper_slab_jadeite","jadeite_block_polished");
            SlabBlockJsonMaker.INSTANCE.registerSlabBlockModel(ItemAndBlockRegister.jadeite_brick_slab.get(),"half_slab_jadeite_brick",ItemAndBlockRegister.jadeite_brick.get(),"upper_slab_jadeite_brick","jadeite_block_brick");
            SlabBlockJsonMaker.INSTANCE.registerSlabBlockModel(ItemAndBlockRegister.smooth_jadeite_slab.get(),"half_slab_smooth_jadeite",ItemAndBlockRegister.smooth_jadeite_block.get(),"upper_slab_smooth_jadeite","jadeite_block_smooth");

            StairBlockJsonMaker.INSTANCE.registerStairsBlockModel("yomi_stone","yomi_stone");
            StairBlockJsonMaker.INSTANCE.registerStairsBlockModel("cobbled_yomi_stone","yomi_stone_cobbled");
            StairBlockJsonMaker.INSTANCE.registerStairsBlockModel("polished_yomi_stone","yomi_stone_polished");
            StairBlockJsonMaker.INSTANCE.registerStairsBlockModel("large_yomi_stone_brick","yomi_stone_bricks");
            StairBlockJsonMaker.INSTANCE.registerStairsBlockModel("small_yomi_stone_brick","yomi_stone_small_bricks");
            StairBlockJsonMaker.INSTANCE.registerStairsBlockModel("jadeite","jadeite_block_polished");
            StairBlockJsonMaker.INSTANCE.registerStairsBlockModel("jadeite_brick","jadeite_block_brick");
            StairBlockJsonMaker.INSTANCE.registerStairsBlockModel("smooth_jadeite","jadeite_block_smooth");

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



        }
    }
}