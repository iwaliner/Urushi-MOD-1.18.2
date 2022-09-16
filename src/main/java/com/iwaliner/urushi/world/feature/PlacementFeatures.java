package com.iwaliner.urushi.world.feature;

import com.google.common.collect.ImmutableList;
import com.iwaliner.urushi.ItemAndBlockRegister;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.tags.BlockTags;
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
    public static final Holder<PlacedFeature> LACQUER_PLACE = PlacementUtils.register("lacquer_place", FeatureGenerator.LACQUER_SPAWN, VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.1F, 1)));
    public static final Holder<PlacedFeature> BAMBOO_PLACE = PlacementUtils.register("japanese_timber_bamboo_place", FeatureGenerator.BAMBOO_SPAWN, VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.1F, 1)));
    public static final Holder<PlacedFeature> HOT_SPRING_PLACE = PlacementUtils.register("hot_spring_place", FeatureGenerator.HOT_SPRING_SPAWN, InSquarePlacement.spread(),HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(100),VerticalAnchor.aboveBottom(350)),BiomeFilter.biome());






   public static final RuleTest NATURAL_SAND = new TagMatchTest(BlockTags.SAND);
    public static final List<OreConfiguration.TargetBlockState> ORE_IRONSAND_TARGET_LIST = List.of(OreConfiguration.target(NATURAL_SAND, ItemAndBlockRegister.ironsand_ore.get().defaultBlockState()));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_IRONSAND = FeatureUtils.register("ore_ironsand", Feature.ORE, new OreConfiguration(ORE_IRONSAND_TARGET_LIST, 9));
    public static final Holder<PlacedFeature> ORE_IRONSAND_PLACE = PlacementUtils.register("ore_ironsand_place",ORE_IRONSAND,List.of(CountPlacement.of(7), InSquarePlacement.spread(), HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-40),VerticalAnchor.aboveBottom(200)), BiomeFilter.biome()));


    private static ImmutableList.Builder<PlacementModifier> APlacement(PlacementModifier p_195485_) {
        return ImmutableList.<PlacementModifier>builder().add(p_195485_).add(InSquarePlacement.spread()).add(PlacementUtils.HEIGHTMAP_WORLD_SURFACE).add(BiomeFilter.biome());
    }

}