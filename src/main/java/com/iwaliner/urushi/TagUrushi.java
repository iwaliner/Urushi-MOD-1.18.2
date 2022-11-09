package com.iwaliner.urushi;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class TagUrushi {
    public static final TagKey<Block> YOMI_STONE =TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(ModCoreUrushi.ModID,"yomi_stone"));
    public static final TagKey<Block> QUARTZ_CLUSTER_PLACEABLE =TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(ModCoreUrushi.ModID,"quartz_cluster_placeable"));
    public static final TagKey<Block> SHIITAKE_GROW_BLOCK =TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(ModCoreUrushi.ModID,"shiitake_placeable"));
    public static final TagKey<Block> SHIITAKE_WALL_GROW_BLOCK =TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(ModCoreUrushi.ModID,"shiitake_wall_placeable"));
    public static final TagKey<Block> GRASS_BLOCK_WITH_FALLEN_LEAVES_INGREDIENT =TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(ModCoreUrushi.ModID,"grass_block_with_fallen_leaves_ingredient"));
    public static final TagKey<Block> JAPANESE_TIMBER_BAMBOO_PLACEABLE =TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(ModCoreUrushi.ModID,"japanese_timber_bamboo_placeable"));
    public static final TagKey<Item> OIL_EXTRACTOR_INSERTALE =TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(ModCoreUrushi.ModID,"oil_extractor_insertable"));

}
