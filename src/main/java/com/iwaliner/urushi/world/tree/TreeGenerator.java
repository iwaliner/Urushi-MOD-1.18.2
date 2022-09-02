package com.iwaliner.urushi.world.tree;

import com.google.common.collect.ImmutableList;
import com.iwaliner.urushi.ItemAndBlockRegister;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.TreePlacements;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.MegaPineFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.SpruceFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.AlterGroundDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.GiantTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;
import java.util.OptionalInt;

public class TreeGenerator {
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> APRICOT = FeatureUtils.register("japanese_apricot", Feature.TREE, createApricot().build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> GLOWING_APRICOT = FeatureUtils.register("glowing_japanese_apricot", Feature.TREE, createGlowingApricot().build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> SAKURA = FeatureUtils.register("sakura", Feature.TREE, createSakura().build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> GLOWING_SAKURA = FeatureUtils.register("glowing_sakura", Feature.TREE, createGlowingSakura().build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> FANCY_SAKURA = FeatureUtils.register("fancy_sakura", Feature.TREE, createFancySakura().build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> GLOWING_FANCY_SAKURA = FeatureUtils.register("glowing_fancy_sakura", Feature.TREE, createGlowingFancySakura().build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> CYPRESS = FeatureUtils.register("cypress", Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ItemAndBlockRegister.cypress_log.get()), new StraightTrunkPlacer(5, 2, 1), BlockStateProvider.simple(ItemAndBlockRegister.cypress_leaves.get()), new SpruceFoliagePlacer(UniformInt.of(2, 3), UniformInt.of(0, 2), UniformInt.of(1, 2)), new TwoLayersFeatureSize(2, 0, 2))).ignoreVines().build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> MEGA_CYPRESS = FeatureUtils.register("mega_cypress", Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ItemAndBlockRegister.cypress_log.get()), new GiantTrunkPlacer(13, 2, 14), BlockStateProvider.simple(ItemAndBlockRegister.cypress_leaves.get()), new MegaPineFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), UniformInt.of(13, 17)), new TwoLayersFeatureSize(1, 1, 2))).decorators(ImmutableList.of(new AlterGroundDecorator(BlockStateProvider.simple(Blocks.ROOTED_DIRT)))).build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> LACQUER = FeatureUtils.register("lacquer", Feature.TREE, createLacquer().build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> BAMBOO = FeatureUtils.register("japanese_timber_bamboo", Feature.TREE, createBamboo().build());


    public static final Holder<PlacedFeature> APRICOT_CHECKED = PlacementUtils.register("apricot_check", APRICOT, PlacementUtils.filteredByBlockSurvival(ItemAndBlockRegister.japanese_apricot_sapling.get()));
    public static final Holder<PlacedFeature> SAKURA_CHECKED = PlacementUtils.register("sakura_check", SAKURA, PlacementUtils.filteredByBlockSurvival(ItemAndBlockRegister.sakura_sapling.get()));
    public static final Holder<PlacedFeature> CYPRESS_CHECKED = PlacementUtils.register("cypress_check", CYPRESS, PlacementUtils.filteredByBlockSurvival(ItemAndBlockRegister.cypress_sapling.get()));
    public static final Holder<PlacedFeature> LACQUER_CHECKED = PlacementUtils.register("lacquer_check", LACQUER, PlacementUtils.filteredByBlockSurvival(ItemAndBlockRegister.lacquer_sapling.get()));
    public static final Holder<PlacedFeature> BAMBOO_CHECKED = PlacementUtils.register("japanese_timber_bamboo_check", BAMBOO, PlacementUtils.filteredByBlockSurvival(ItemAndBlockRegister.japanese_timber_bamboo.get()));


    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> APRICOT_SPAWN = FeatureUtils.register("apricot_spawn", Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(APRICOT_CHECKED, 0.2F)),APRICOT_CHECKED));
    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> SAKURA_SPAWN = FeatureUtils.register("sakura_spawn", Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(SAKURA_CHECKED, 0.2F)),SAKURA_CHECKED));
    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> CYPRESS_SPAWN = FeatureUtils.register("cypress_spawn", Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(CYPRESS_CHECKED, 0.2F)),CYPRESS_CHECKED));
    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> LACQUER_SPAWN = FeatureUtils.register("lacquer_spawn", Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(LACQUER_CHECKED, 0.2F)),LACQUER_CHECKED));
    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> BAMBOO_SPAWN = FeatureUtils.register("japanese_timber_bamboo_spawn", Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(BAMBOO_CHECKED, 0.2F)),BAMBOO_CHECKED));


    private static TreeConfiguration.TreeConfigurationBuilder createStraightBlobTree(Block p_195147_, Block p_195148_, int p_195149_, int p_195150_, int p_195151_, int p_195152_) {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(p_195147_), new StraightTrunkPlacer(p_195149_, p_195150_, p_195151_), BlockStateProvider.simple(p_195148_), new BlobFoliagePlacer(ConstantInt.of(p_195152_), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1));
    }
    private static TreeConfiguration.TreeConfigurationBuilder createApricot() {
        return createStraightBlobTree(ItemAndBlockRegister.japanese_apricot_log.get(),ItemAndBlockRegister.japanese_apricot_leaves.get(), 5, 2, 0, 2).ignoreVines();
    }
    private static TreeConfiguration.TreeConfigurationBuilder createGlowingApricot() {
        return createStraightBlobTree(ItemAndBlockRegister.japanese_apricot_log.get(),ItemAndBlockRegister.glowing_japanese_apricot_leaves.get(), 5, 2, 0, 2).ignoreVines();
    }
    private static TreeConfiguration.TreeConfigurationBuilder createSakura() {
        return createStraightBlobTree(ItemAndBlockRegister.sakura_log.get(),ItemAndBlockRegister.sakura_leaves.get(), 5, 2, 0, 2).ignoreVines();
    }
    private static TreeConfiguration.TreeConfigurationBuilder createGlowingSakura() {
        return createStraightBlobTree(ItemAndBlockRegister.sakura_log.get(),ItemAndBlockRegister.glowing_sakura_leaves.get(), 5, 2, 0, 2).ignoreVines();
    }
    private static TreeConfiguration.TreeConfigurationBuilder createFancySakura() {
        return (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ItemAndBlockRegister.sakura_log.get()), new FancyTrunkPlacer(3, 11, 0), BlockStateProvider.simple(ItemAndBlockRegister.sakura_leaves.get()), new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))).ignoreVines();
    }
    private static TreeConfiguration.TreeConfigurationBuilder createGlowingFancySakura() {
        return (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ItemAndBlockRegister.sakura_log.get()), new FancyTrunkPlacer(3, 11, 0), BlockStateProvider.simple(ItemAndBlockRegister.glowing_sakura_leaves.get()), new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))).ignoreVines();
    }
    private static TreeConfiguration.TreeConfigurationBuilder createLacquer() {
        return createStraightBlobTree(ItemAndBlockRegister.lacquer_log.get(),ItemAndBlockRegister.lacquer_leaves.get(), 5, 2, 0, 2).ignoreVines();
    }
    private static TreeConfiguration.TreeConfigurationBuilder createBamboo() {
        return createStraightBlobTree(ItemAndBlockRegister.japanese_timber_bamboo.get(),Blocks.AIR, 5, 2, 0, 2).ignoreVines();
    }
}
