package com.iwaliner.urushi;

import baguchan.tofucraft.client.TofuModelLayers;
import baguchan.tofucraft.client.model.TofuSpiderModel;
import baguchan.tofucraft.client.model.TofunianModel;
import com.iwaliner.urushi.entiity.food.model.RiceFoodModel;
import com.iwaliner.urushi.entiity.food.renderer.*;
import com.iwaliner.urushi.json.MineableTagGenerator;
import com.iwaliner.urushi.json.RequiredToolMaterialTagGenerator;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
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
    public static final ModelLayerLocation TKG = new ModelLayerLocation(new ResourceLocation(ModCoreUrushi.ModID, "tlg_food"), "tlg_food");
    public static final ModelLayerLocation Sekihan = new ModelLayerLocation(new ResourceLocation(ModCoreUrushi.ModID, "sekihan_food"), "sekihan_food");
    public static final ModelLayerLocation Gyudon = new ModelLayerLocation(new ResourceLocation(ModCoreUrushi.ModID, "gyudon_food"), "gyudon_food");
    public static final ModelLayerLocation Butadon = new ModelLayerLocation(new ResourceLocation(ModCoreUrushi.ModID, "butadon_food"), "butadon_food");


    /**エンティティの見た目を登録*/
    @SubscribeEvent
    public static void RegisterEntityRendererEvent(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityRegister.RiceFoodEntity.get(), RiceFoodRenderer::new);
        event.registerEntityRenderer(EntityRegister.TKGFoodEntity.get(), TKGFoodRenderer::new);
        event.registerEntityRenderer(EntityRegister.SekihanFoodEntity.get(), SekihanFoodRenderer::new);
        event.registerEntityRenderer(EntityRegister.GyudonFoodEntity.get(), GyudonFoodRenderer::new);
        event.registerEntityRenderer(EntityRegister.ButadonFoodEntity.get(), ButadonFoodRenderer::new);
    }
    @SubscribeEvent
    public static void registerLayerEvent(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(RICE, RiceFoodModel::createBodyLayer);
         event.registerLayerDefinition(TKG, RiceFoodModel::createBodyLayer);
        event.registerLayerDefinition(Sekihan, RiceFoodModel::createBodyLayer);
        event.registerLayerDefinition(Gyudon, RiceFoodModel::createBodyLayer);
        event.registerLayerDefinition(Butadon, RiceFoodModel::createBodyLayer);
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




    /**jsonファイルを自動生成するために開発環境のパスを登録*/
        if(ModCoreUrushi.password==88659) {
        FMLPaths.GAMEDIR.get();
        //ModCore_Urushi.assetsDirectory = new File(FMLPaths.GAMEDIR.get().getParent().toString() + "/src/main/resources/assets/urushi/");
        //ModCore_Urushi.assetsInBuildDirectory = new File(FMLPaths.GAMEDIR.get().getParent().toString() + "/build/resources/main/assets/urushi/");
        //ModCoreUrushi.dataDirectory = new File(FMLPaths.GAMEDIR.get().getParent().toString() + "/src/main/resources/data/");
       // ModCoreUrushi.dataInBuildDirectory = new File(FMLPaths.GAMEDIR.get().getParent().toString() + "/build/resources/main/data/");
            ModCoreUrushi.dataDirectory = new File(FMLPaths.GAMEDIR.get().getParent().toString() + "/src/generated/resources/data/");
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
    }
    }
}