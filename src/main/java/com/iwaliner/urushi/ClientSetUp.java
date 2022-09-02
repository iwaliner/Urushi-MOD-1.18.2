package com.iwaliner.urushi;

import com.iwaliner.urushi.json.MineableTagGenerator;
import com.iwaliner.urushi.json.RequiredToolMaterialTagGenerator;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
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

    @Nullable

    @SubscribeEvent
    public static void RegisterRendererEvent(FMLClientSetupEvent event) {

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