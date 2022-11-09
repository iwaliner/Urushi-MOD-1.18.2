package com.iwaliner.urushi;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

public class DimensionRegister {
    public static final ResourceKey<DimensionType> KakuriyoType=ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY,new ResourceLocation(ModCoreUrushi.ModID,"kakuriyo"));
    public static final ResourceKey<Level> KakuriyoKey=ResourceKey.create(Registry.DIMENSION_REGISTRY,new ResourceLocation(ModCoreUrushi.ModID,"kakuriyo"));

    public static void register(){

    }
}
