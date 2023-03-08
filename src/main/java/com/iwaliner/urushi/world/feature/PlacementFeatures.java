package com.iwaliner.urushi.world.feature;

import com.google.common.collect.ImmutableList;
import com.iwaliner.urushi.ItemAndBlockRegister;
import com.iwaliner.urushi.ModCoreUrushi;
import com.iwaliner.urushi.TagUrushi;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.tags.TagKey;
import net.minecraft.util.valueproviders.ClampedInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.common.Tags;

import java.util.List;

public class PlacementFeatures {
    //countExtra(chunk amount,chance,extraSpawn)
    public static final Holder<PlacedFeature> APRICOT_PLACE = PlacementUtils.register("apricot_place", FeatureGenerator.APRICOT_SPAWN, VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.1F, 1)));
    public static final Holder<PlacedFeature> SAKURA_PLACE = PlacementUtils.register("sakura_place", FeatureGenerator.SAKURA_SPAWN, VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.1F, 1)));
    public static final Holder<PlacedFeature> CYPRESS_PLACE = PlacementUtils.register("cypress_place", FeatureGenerator.CYPRESS_SPAWN, VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.1F, 1)));
    public static final Holder<PlacedFeature> CEDAR_PLACE = PlacementUtils.register("cedar_place", FeatureGenerator.CEDAR_SPAWN, VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.1F, 1)));
    public static final Holder<PlacedFeature> LACQUER_PLACE = PlacementUtils.register("lacquer_place", FeatureGenerator.LACQUER_SPAWN, VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.1F, 1)));
    public static final Holder<PlacedFeature> BAMBOO_PLACE = PlacementUtils.register("japanese_timber_bamboo_place", FeatureGenerator.BAMBOO_SPAWN, VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.1F, 1)));
    public static final Holder<PlacedFeature> AUTUMN_HILLS_RED_PLACE = PlacementUtils.register("autumn_hills_red", FeatureGenerator.RED_SPAWN, VegetationPlacements.treePlacement(PlacementUtils.countExtra(4, 0.1F, 1)));
    public static final Holder<PlacedFeature> AUTUMN_HILLS_ORANGE_PLACE = PlacementUtils.register("autumn_hills_orange", FeatureGenerator.ORANGE_SPAWN, VegetationPlacements.treePlacement(PlacementUtils.countExtra(4, 0.1F, 1)));
    public static final Holder<PlacedFeature> AUTUMN_HILLS_YELLOW_PLACE = PlacementUtils.register("autumn_hills_yellow", FeatureGenerator.YELLOW_SPAWN, VegetationPlacements.treePlacement(PlacementUtils.countExtra(4, 0.1F, 1)));
    public static final Holder<PlacedFeature> HOT_SPRING_PLACE = PlacementUtils.register("hot_spring_place", FeatureGenerator.HOT_SPRING_SPAWN, InSquarePlacement.spread(),HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(100),VerticalAnchor.aboveBottom(350)),BiomeFilter.biome());

    public static final Holder<PlacedFeature> SAKURA_FOREST_SAKURA_PLACE = PlacementUtils.register("sakura_forest_sakura", FeatureGenerator.FANCY_SAKURA_SPAWN, VegetationPlacements.treePlacement(PlacementUtils.countExtra(5, 0.1F, 1)));
    public static final Holder<PlacedFeature> CEDAR_FOREST_CEDAR_PLACE = PlacementUtils.register("cedar_forest_japanese_cedar", FeatureGenerator.MEGA_CEDAR_SPAWN, VegetationPlacements.treePlacement(PlacementUtils.countExtra(8, 0.2F, 1)));
    public static final Holder<PlacedFeature> KAKURIYO_CEDAR_FOREST_CEDAR_PLACE = PlacementUtils.register("kakuriyo_cedar_forest_japanese_cedar", FeatureGenerator.KAKURIYO_MEGA_CEDAR_SPAWN, VegetationPlacements.treePlacement(PlacementUtils.countExtra(8, 0.2F, 1)));
    public static final Holder<PlacedFeature> SHIITKE = PlacementUtils.register("shiitake", FeatureGenerator.SHIITAKE,NoiseThresholdCountPlacement.of(-0.8D, 1, 5), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> WALL_SHIITKE_N = PlacementUtils.register("wall_shiitake_n", FeatureGenerator.WALL_SHIITAKE_N,NoiseThresholdCountPlacement.of(-0.8D, 1, 4), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> WALL_SHIITKE_S = PlacementUtils.register("wall_shiitake_s", FeatureGenerator.WALL_SHIITAKE_S,NoiseThresholdCountPlacement.of(-0.8D, 1, 4), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> WALL_SHIITKE_E = PlacementUtils.register("wall_shiitake_e", FeatureGenerator.WALL_SHIITAKE_E,NoiseThresholdCountPlacement.of(-0.8D, 1, 4), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> WALL_SHIITKE_W = PlacementUtils.register("wall_shiitake_w", FeatureGenerator.WALL_SHIITAKE_W,NoiseThresholdCountPlacement.of(-0.8D, 1, 4), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> TALL_EULALIA = PlacementUtils.register("tall_eulalia", FeatureGenerator.TALL_EULALIA,NoiseThresholdCountPlacement.of(-0.8D, 5, 10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> EULALIA = PlacementUtils.register("eulalia", FeatureGenerator.EULALIA,NoiseThresholdCountPlacement.of(-0.8D, 5, 10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> LYCORIS_FLOWERS = PlacementUtils.register("lycoris_flowers", FeatureGenerator.LYCORIS_FLOWERS, RarityFilter.onAverageOnceEvery(30), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, CountPlacement.of(ClampedInt.of(UniformInt.of(-2, 6), 0, 15)), BiomeFilter.biome());
    public static final Holder<PlacedFeature> BAMBOO_FOREST_BAMBOO_PLACE = PlacementUtils.register("bamboo_forest_bamboo", FeatureGenerator.BAMBOO_SPAWN, VegetationPlacements.treePlacement(PlacementUtils.countExtra(120, 0.1F, 1)));
    public static final Holder<PlacedFeature> FALLEN_SAKURA_LEAVES = PlacementUtils.register("fallen_sakura_leaves", FeatureGenerator.FALLEN_SAKUEA_LEAVES,NoiseThresholdCountPlacement.of(-0.8D, 5, 8), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> FALLEN_RED_LEAVES = PlacementUtils.register("fallen_red_leaves", FeatureGenerator.FALLEN_RED_LEAVES,NoiseThresholdCountPlacement.of(-0.8D, 5, 10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> FALLEN_ORANGE_LEAVES = PlacementUtils.register("fallen_orange_leaves", FeatureGenerator.FALLEN_ORANGE_LEAVES,NoiseThresholdCountPlacement.of(-0.8D, 5, 10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> FALLEN_YELLOW_LEAVES = PlacementUtils.register("fallen_yellow_leaves", FeatureGenerator.FALLEN_YELLOW_LEAVES,NoiseThresholdCountPlacement.of(-0.8D, 5, 10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> KAKURIYO_PORTAL = PlacementUtils.register("kakuriyo_portal", FeatureGenerator.KAKURIYO_PORTAL_SPAWN, VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.1F, 1)));
    public static final Holder<PlacedFeature> WOOD_ELEMENT_SACRED_ROCK = PlacementUtils.register("wood_element_sacred_rock", FeatureGenerator.WOOD_ELEMENT_SACRED_ROCK,NoiseThresholdCountPlacement.of(0.45D, 0, 1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> FIRE_ELEMENT_SACRED_ROCK = PlacementUtils.register("fire_element_sacred_rock", FeatureGenerator.FIRE_ELEMENT_SACRED_ROCK,NoiseThresholdCountPlacement.of(0.45D, 0, 1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> EARTH_ELEMENT_SACRED_ROCK = PlacementUtils.register("earth_element_sacred_rock", FeatureGenerator.EARTH_ELEMENT_SACRED_ROCK,NoiseThresholdCountPlacement.of(0.45D, 0, 1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> METAL_ELEMENT_SACRED_ROCK = PlacementUtils.register("metal_element_sacred_rock", FeatureGenerator.METAL_ELEMENT_SACRED_ROCK,NoiseThresholdCountPlacement.of(0.45D, 0, 1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> WATER_ELEMENT_SACRED_ROCK = PlacementUtils.register("water_element_sacred_rock", FeatureGenerator.WATER_ELEMENT_SACRED_ROCK,NoiseThresholdCountPlacement.of(0.45D, 0, 1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());




    public static final RuleTest NATURAL_SAND = new TagMatchTest(BlockTags.SAND);
    public static final RuleTest NATURAL_YOMI_STONE = new TagMatchTest(TagUrushi.YOMI_STONE);
    public static final List<OreConfiguration.TargetBlockState> ORE_IRONSAND_TARGET_LIST = List.of(OreConfiguration.target(NATURAL_SAND, ItemAndBlockRegister.ironsand_ore.get().defaultBlockState()));
    public static final List<OreConfiguration.TargetBlockState> ORE_JADEITE_TARGET_LIST = List.of(OreConfiguration.target(NATURAL_YOMI_STONE, ItemAndBlockRegister.jadeite_ore.get().defaultBlockState()));
    public static final List<OreConfiguration.TargetBlockState> ORE_YOMI_IRON_TARGET_LIST = List.of(OreConfiguration.target(NATURAL_YOMI_STONE, ItemAndBlockRegister.yomi_iron_ore.get().defaultBlockState()));
    public static final List<OreConfiguration.TargetBlockState> ORE_YOMI_GOLD_TARGET_LIST = List.of(OreConfiguration.target(NATURAL_YOMI_STONE, ItemAndBlockRegister.yomi_gold_ore.get().defaultBlockState()));
    public static final List<OreConfiguration.TargetBlockState> ORE_YOMI_COPPER_TARGET_LIST = List.of(OreConfiguration.target(NATURAL_YOMI_STONE, ItemAndBlockRegister.yomi_copper_ore.get().defaultBlockState()));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_IRONSAND = FeatureUtils.register("ore_ironsand", Feature.ORE, new OreConfiguration(ORE_IRONSAND_TARGET_LIST, 9));
    public static final Holder<PlacedFeature> ORE_IRONSAND_PLACE = PlacementUtils.register("ore_ironsand_place",ORE_IRONSAND,List.of(CountPlacement.of(7), InSquarePlacement.spread(), HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-40),VerticalAnchor.aboveBottom(200)), BiomeFilter.biome()));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_JADEITE = FeatureUtils.register("ore_jadeite", Feature.ORE, new OreConfiguration(ORE_JADEITE_TARGET_LIST, 9));
    public static final Holder<PlacedFeature> ORE_JADEITE_PLACE = PlacementUtils.register("ore_jadeited_place",ORE_JADEITE,List.of(CountPlacement.of(10), InSquarePlacement.spread(), HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(0),VerticalAnchor.aboveBottom(120)), BiomeFilter.biome()));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_IRON = FeatureUtils.register("ore_yomi_iron", Feature.ORE, new OreConfiguration(ORE_YOMI_IRON_TARGET_LIST, 9));
    public static final Holder<PlacedFeature> ORE_IRON_PLACE = PlacementUtils.register("ore_yomi_iron_place",ORE_IRON,List.of(CountPlacement.of(15), InSquarePlacement.spread(), HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(0),VerticalAnchor.aboveBottom(120)), BiomeFilter.biome()));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_GOLD = FeatureUtils.register("ore_yomi_gold", Feature.ORE, new OreConfiguration(ORE_YOMI_GOLD_TARGET_LIST, 9));
    public static final Holder<PlacedFeature> ORE_GOLD_PLACE = PlacementUtils.register("ore_yomi_gold_place",ORE_GOLD,List.of(CountPlacement.of(15), InSquarePlacement.spread(), HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(0),VerticalAnchor.aboveBottom(100)), BiomeFilter.biome()));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_COPPER = FeatureUtils.register("ore_yomi_copper", Feature.ORE, new OreConfiguration(ORE_YOMI_COPPER_TARGET_LIST, 9));
    public static final Holder<PlacedFeature> ORE_COPPER_PLACE = PlacementUtils.register("ore_yomi_copper_place",ORE_COPPER,List.of(CountPlacement.of(10), InSquarePlacement.spread(), HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(0),VerticalAnchor.aboveBottom(120)), BiomeFilter.biome()));
    //public static final Holder<PlacedFeature> YOMI_VINE_PLACE = PlacementUtils.register("yomi_vine", FeatureGenerator.YOMI_VINES, List.of(CountPlacement.of(80), InSquarePlacement.spread()));
    public static final Holder<PlacedFeature> QUARTZ_CLUSTER = PlacementUtils.register("quartz_cluster", FeatureGenerator.QUARTZ_CLUSTER, List.of(HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(5), VerticalAnchor.aboveBottom(60)), CountPlacement.of(ClampedInt.of(UniformInt.of(-1, 6), 3, 20)), BiomeFilter.biome()));
    public static final Holder<PlacedFeature> LANTERN_PLANT = PlacementUtils.register("lantern_plant", FeatureGenerator.LANTERN_PLANT, List.of(HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(5), VerticalAnchor.aboveBottom(60)), CountPlacement.of(ClampedInt.of(UniformInt.of(-1, 8), 1, 4)), BiomeFilter.biome()));
    public static final Holder<PlacedFeature> YOMI_VINE_PLACE = PlacementUtils.register("yomi_vine", FeatureGenerator.YOMI_VINES_SPAWN,NoiseThresholdCountPlacement.of(-0.8D, 10, 20), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome());




}
