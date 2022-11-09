package com.iwaliner.urushi;

import baguchan.tofucraft.client.TofuModelLayers;
import baguchan.tofucraft.client.model.TofuSpiderModel;
import baguchan.tofucraft.client.model.TofunianModel;
import com.iwaliner.urushi.blockentity.screen.DoubledWoodenCabinetryScreen;
import com.iwaliner.urushi.blockentity.screen.FryerScreen;
import com.iwaliner.urushi.entiity.food.model.*;
import com.iwaliner.urushi.entiity.food.renderer.*;
import com.iwaliner.urushi.entiity.renderer.GhostRenderer;
import com.iwaliner.urushi.json.*;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.loading.FMLPaths;

import javax.annotation.Nullable;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
    }

    @Nullable

    @SubscribeEvent
    public static void RegisterRendererEvent(FMLClientSetupEvent event) {


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

        });

       /**コンテナにGUIを登録*/
        MenuScreens.register(MenuRegister.FryerMenu.get(), FryerScreen::new);
        MenuScreens.register(MenuRegister.DoubledWoodenCabinetryMenu.get(), DoubledWoodenCabinetryScreen::new);






        /**jsonファイルを自動生成するために開発環境のパスを登録*/
        if(ModCoreUrushi.isDebug) {
        FMLPaths.GAMEDIR.get();
        ModCoreUrushi.assetsDirectory = new File(FMLPaths.GAMEDIR.get().getParent().toString() + "/src/main/resources/assets/urushi/");
        ModCoreUrushi.assetsInBuildDirectory = new File(FMLPaths.GAMEDIR.get().getParent().toString() + "/build/resources/main/assets/urushi/");
        ModCoreUrushi.dataDirectory = new File(FMLPaths.GAMEDIR.get().getParent().toString() + "/src/main/resources/data/");
        ModCoreUrushi.dataInBuildDirectory = new File(FMLPaths.GAMEDIR.get().getParent().toString() + "/build/resources/main/data/");
          //  ModCoreUrushi.dataDirectory = new File(FMLPaths.GAMEDIR.get().getParent().toString() + "/src/generated/resources/data/");
          //  ModCoreUrushi.dataInBuildDirectory = new File(FMLPaths.GAMEDIR.get().getParent().toString() + "/build/resources/main/data/");




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

            CubeAllBlockJsonMaker.INSTANCE.registerBlockModel(ItemAndBlockRegister.yomi_stone.get(),"yomi_stone");
            CubeAllBlockJsonMaker.INSTANCE.registerBlockModel(ItemAndBlockRegister.yomi_copper_ore.get(),"copper_ore_yomi");
            CubeAllBlockJsonMaker.INSTANCE.registerBlockModel(ItemAndBlockRegister.yomi_iron_ore.get(),"iron_ore_yomi");
            CubeAllBlockJsonMaker.INSTANCE.registerBlockModel(ItemAndBlockRegister.yomi_gold_ore.get(),"gold_ore_yomi");
            CubeAllBlockJsonMaker.INSTANCE.registerBlockModel(ItemAndBlockRegister.cobbled_yomi_stone.get(),"yomi_stone_cobbled");
            CubeAllBlockJsonMaker.INSTANCE.registerBlockModel(ItemAndBlockRegister.polished_yomi_stone.get(),"yomi_stone_polished");
            CubeAllBlockJsonMaker.INSTANCE.registerBlockModel(ItemAndBlockRegister.black_kakuriyo_portal_frame.get(),"kakuriyo_portal_frame_black");

            SlabBlockJsonMaker.INSTANCE.registerSlabBlockModel(ItemAndBlockRegister.yomi_stone_slab.get(),"half_slab_yomi_stone",ItemAndBlockRegister.yomi_stone.get(),"upper_slab_yomi_stone","yomi_stone");
            SlabBlockJsonMaker.INSTANCE.registerSlabBlockModel(ItemAndBlockRegister.cobbled_yomi_stone_slab.get(),"half_slab_cobbled_yomi_stone",ItemAndBlockRegister.cobbled_yomi_stone.get(),"upper_slab_cobbled_yomi_stone","yomi_stone_cobbled");
            SlabBlockJsonMaker.INSTANCE.registerSlabBlockModel(ItemAndBlockRegister.large_yomi_stone_brick_slab.get(),"half_slab_large_yomi_stone_brick",ItemAndBlockRegister.large_yomi_stone_bricks.get(),"upper_slab_large_yomi_stone_brick","yomi_stone_bricks");
            SlabBlockJsonMaker.INSTANCE.registerSlabBlockModel(ItemAndBlockRegister.small_yomi_stone_brick_slab.get(),"half_slab_small_yomi_stone_brick",ItemAndBlockRegister.small_yomi_stone_bricks.get(),"upper_slab_small_yomi_stone_brick","yomi_stone_small_bricks");

            StairBlockJsonMaker.INSTANCE.registerStairsBlockModel("yomi_stone","yomi_stone");
            StairBlockJsonMaker.INSTANCE.registerStairsBlockModel("cobbled_yomi_stone","yomi_stone_cobbled");
            StairBlockJsonMaker.INSTANCE.registerStairsBlockModel("polished_yomi_stone","yomi_stone_polished");
            StairBlockJsonMaker.INSTANCE.registerStairsBlockModel("large_yomi_stone_brick","yomi_stone_bricks");
            StairBlockJsonMaker.INSTANCE.registerStairsBlockModel("small_yomi_stone_brick","yomi_stone_small_bricks");


            GeneratedItemJsonMaker.INSTANCE.registerItemModel(ItemAndBlockRegister.jadeite.get(),"jadeite");
            GeneratedItemJsonMaker.INSTANCE.registerItemModel(ItemAndBlockRegister.yomotsuhegui_fruit.get(),"yomotsuhegui");
            GeneratedItemJsonMaker.INSTANCE.registerItemModel(ItemAndBlockRegister.ghost_core.get(),"ghost_core");



        }
    }
}