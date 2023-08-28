package com.iwaliner.urushi;

import com.iwaliner.urushi.entiity.GhostEntity;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;


@Mod.EventBusSubscriber(modid = ModCoreUrushi.ModID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonSetUp {
    @SubscribeEvent
    public static void RegisterRendererEvent(final FMLCommonSetupEvent event) {
        SpawnPlacements.register(EntityRegister.Ghost.get(),SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
        SpawnPlacements.register(EntityRegister.RedOni.get(),SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
    }
}
