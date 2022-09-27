package com.iwaliner.urushi;


import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.biome.OverworldBiomes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

public class BiomeRegister {
    public static final DeferredRegister<Biome> BIOMES;
    public static final ResourceKey<Biome> SakuraForest;

    public BiomeRegister() {
    }
    public static void register(IEventBus eventBus) {
        BIOMES.register(eventBus);
    }
    private static ResourceKey<Biome> register(String p_48229_) {
        BIOMES.register(p_48229_, OverworldBiomes::theVoid);
        return ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ModCoreUrushi.ModID, p_48229_));
    }
    static {
        BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, ModCoreUrushi.ModID);
        SakuraForest = register("sakura_forest");
    }

}
