package com.iwaliner.urushi.world.feature;

import com.google.common.collect.ImmutableList;
import com.iwaliner.urushi.FeatureRegister;
import com.iwaliner.urushi.ItemAndBlockRegister;
import com.iwaliner.urushi.block.LanternPlantBlock;
import com.iwaliner.urushi.block.WallShiitakeBlock;
import net.minecraft.core.*;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.util.valueproviders.WeightedListInt;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CaveVines;
import net.minecraft.world.level.block.CaveVinesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.*;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.MegaPineFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.SpruceFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RandomizedIntStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.AlterGroundDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.GiantTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;
import java.util.OptionalInt;

public class FeatureGenerator {
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> RED = FeatureUtils.register("red", Feature.TREE, createBirchTypeTree(Blocks.OAK_LOG,ItemAndBlockRegister.red_leaves.get()).build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> ORANGE = FeatureUtils.register("orange", Feature.TREE, createBirchTypeTree(Blocks.OAK_LOG,ItemAndBlockRegister.orange_leaves.get()).build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> YELLOW = FeatureUtils.register("yellow", Feature.TREE, createBirchTypeTree(Blocks.OAK_LOG,ItemAndBlockRegister.yellow_leaves.get()).build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> APRICOT = FeatureUtils.register("japanese_apricot", Feature.TREE, createBirchTypeTree(ItemAndBlockRegister.japanese_apricot_log.get(),ItemAndBlockRegister.japanese_apricot_leaves.get()).build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> GLOWING_APRICOT = FeatureUtils.register("glowing_japanese_apricot", Feature.TREE, createBirchTypeTree(ItemAndBlockRegister.japanese_apricot_log.get(),ItemAndBlockRegister.glowing_japanese_apricot_leaves.get()).build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> SAKURA = FeatureUtils.register("sakura", Feature.TREE, createBirchTypeTree(ItemAndBlockRegister.sakura_log.get(),ItemAndBlockRegister.sakura_leaves.get()).build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> GLOWING_SAKURA = FeatureUtils.register("glowing_sakura", Feature.TREE, createBirchTypeTree(ItemAndBlockRegister.sakura_log.get(),ItemAndBlockRegister.glowing_sakura_leaves.get()).build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> FANCY_SAKURA = FeatureUtils.register("fancy_sakura", Feature.TREE, createFancySakura().build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> GLOWING_FANCY_SAKURA = FeatureUtils.register("glowing_fancy_sakura", Feature.TREE, createGlowingFancySakura().build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> CYPRESS = FeatureUtils.register("cypress", Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ItemAndBlockRegister.cypress_log.get()), new StraightTrunkPlacer(5, 2, 1), BlockStateProvider.simple(ItemAndBlockRegister.cypress_leaves.get()), new SpruceFoliagePlacer(UniformInt.of(2, 3), UniformInt.of(0, 2), UniformInt.of(1, 2)), new TwoLayersFeatureSize(2, 0, 2))).ignoreVines().build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> MEGA_CYPRESS = FeatureUtils.register("mega_cypress", Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ItemAndBlockRegister.cypress_log.get()), new GiantTrunkPlacer(13, 2, 14), BlockStateProvider.simple(ItemAndBlockRegister.cypress_leaves.get()), new MegaPineFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), UniformInt.of(13, 17)), new TwoLayersFeatureSize(1, 1, 2))).decorators(ImmutableList.of(new AlterGroundDecorator(BlockStateProvider.simple(Blocks.ROOTED_DIRT)))).build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> CEDAR = FeatureUtils.register("cedar", Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ItemAndBlockRegister.japanese_cedar_log.get()), new StraightTrunkPlacer(5, 2, 1), BlockStateProvider.simple(ItemAndBlockRegister.japanese_cedar_leaves.get()), new SpruceFoliagePlacer(UniformInt.of(2, 3), UniformInt.of(0, 2), UniformInt.of(1, 2)), new TwoLayersFeatureSize(2, 0, 2))).ignoreVines().build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> MEGA_CEDAR = FeatureUtils.register("mega_cedar", Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ItemAndBlockRegister.japanese_cedar_log.get()), new GiantTrunkPlacer(13, 2, 14), BlockStateProvider.simple(ItemAndBlockRegister.japanese_cedar_leaves.get()), new MegaPineFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), UniformInt.of(13, 17)), new TwoLayersFeatureSize(1, 1, 2))).build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> LACQUER = FeatureUtils.register("lacquer", Feature.TREE, createBirchTypeTree(ItemAndBlockRegister.lacquer_log.get(),ItemAndBlockRegister.lacquer_leaves.get()).build());
   public static final Holder<ConfiguredFeature<LakeFeature.Configuration, ?>> HOT_SPRING = FeatureUtils.register("hot_spring", Feature.LAKE, (new LakeFeature.Configuration(BlockStateProvider.simple(ItemAndBlockRegister.HotSpringBlock.get()),BlockStateProvider.simple(Blocks.TUFF))));
   public static final Holder<ConfiguredFeature<JapaneseTimberBambooFeature.Configuration, ?>> BAMBOO = FeatureUtils.register("japanese_timber_bamboo", FeatureRegister.Bamboo.get(), (new JapaneseTimberBambooFeature.Configuration(BlockStateProvider.simple(ItemAndBlockRegister.japanese_timber_bamboo.get()))));
    public static final Holder<ConfiguredFeature<KakuriyoPortalFeature.Configuration, ?>> KAKURIYO_PORTAL = FeatureUtils.register("kakuriyo_portal", FeatureRegister.KakuriyoPortal.get(), (new KakuriyoPortalFeature.Configuration(BlockStateProvider.simple(ItemAndBlockRegister.ghost_red_kakuriyo_portal_frame.get()))));
    private static final WeightedStateProvider YOMI_VINES_BODY_PROVIDER = new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(ItemAndBlockRegister.yomi_vines_plant.get().defaultBlockState(), 4).add(ItemAndBlockRegister.yomi_vines_plant.get().defaultBlockState().setValue(CaveVines.BERRIES, Boolean.valueOf(true)), 1));

    private static final RandomizedIntStateProvider YOMI_VINES_HEAD_PROVIDER = new RandomizedIntStateProvider(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(ItemAndBlockRegister.yomi_vines.get().defaultBlockState(), 4).add(ItemAndBlockRegister.yomi_vines.get().defaultBlockState().setValue(CaveVines.BERRIES, Boolean.valueOf(true)), 1)), CaveVinesBlock.AGE, UniformInt.of(23, 25));

     public static final Holder<ConfiguredFeature<BlockColumnConfiguration, ?>> YOMI_VINES = FeatureUtils.register("yomi_vines", Feature.BLOCK_COLUMN, new BlockColumnConfiguration(List.of(BlockColumnConfiguration.layer(new WeightedListInt(SimpleWeightedRandomList.<IntProvider>builder().add(UniformInt.of(800, 1000), 2).add(UniformInt.of(1, 2), 3).add(UniformInt.of(1, 6), 30).build()), YOMI_VINES_BODY_PROVIDER), BlockColumnConfiguration.layer(ConstantInt.of(1), YOMI_VINES_HEAD_PROVIDER)), Direction.DOWN, BlockPredicate.ONLY_IN_AIR_PREDICATE, true));
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> KAKURIYO_MEGA_CEDAR = FeatureUtils.register("kakuriyo_mega_cedar", Feature.TREE, (new KakuriyoTreeConfigration.KakuriyoTreeConfigurationBuilder(BlockStateProvider.simple(ItemAndBlockRegister.japanese_cedar_log.get()), new GiantTrunkPlacer(13, 2, 14), BlockStateProvider.simple(ItemAndBlockRegister.japanese_cedar_leaves.get()), new MegaPineFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), UniformInt.of(13, 17)), new TwoLayersFeatureSize(1, 1, 2))).build());


    public static final Holder<PlacedFeature> APRICOT_CHECKED = PlacementUtils.register("apricot_check", APRICOT, PlacementUtils.filteredByBlockSurvival(ItemAndBlockRegister.japanese_apricot_sapling.get()));
    public static final Holder<PlacedFeature> SAKURA_CHECKED = PlacementUtils.register("sakura_check", SAKURA, PlacementUtils.filteredByBlockSurvival(ItemAndBlockRegister.sakura_sapling.get()));
    public static final Holder<PlacedFeature> CYPRESS_CHECKED = PlacementUtils.register("cypress_check", CYPRESS, PlacementUtils.filteredByBlockSurvival(ItemAndBlockRegister.cypress_sapling.get()));
    public static final Holder<PlacedFeature> CEDAR_CHECKED = PlacementUtils.register("cedar_check", CEDAR, PlacementUtils.filteredByBlockSurvival(ItemAndBlockRegister.japanese_cedar_sapling.get()));
    public static final Holder<PlacedFeature> LACQUER_CHECKED = PlacementUtils.register("lacquer_check", LACQUER, PlacementUtils.filteredByBlockSurvival(ItemAndBlockRegister.lacquer_sapling.get()));
    public static final Holder<PlacedFeature> RED_CHECKED = PlacementUtils.register("red_check", RED, PlacementUtils.filteredByBlockSurvival(ItemAndBlockRegister.red_sapling.get()));
    public static final Holder<PlacedFeature> ORANGE_CHECKED = PlacementUtils.register("orange_check", ORANGE, PlacementUtils.filteredByBlockSurvival(ItemAndBlockRegister.orange_sapling.get()));
    public static final Holder<PlacedFeature> YELLOW_CHECKED = PlacementUtils.register("yellow_check", YELLOW, PlacementUtils.filteredByBlockSurvival(ItemAndBlockRegister.yellow_sapling.get()));
    public static final Holder<PlacedFeature> BAMBOO_CHECKED = PlacementUtils.register("japanese_timber_bamboo_check", BAMBOO, PlacementUtils.filteredByBlockSurvival(ItemAndBlockRegister.japanese_timber_bamboo.get()));
    public static final Holder<PlacedFeature> MEGA_CEDAR_CHECKED = PlacementUtils.register("mega_cedar_check", MEGA_CEDAR, PlacementUtils.filteredByBlockSurvival(ItemAndBlockRegister.japanese_cedar_sapling.get()));

    public static final Holder<PlacedFeature> HOT_SPRING_CHECKED = PlacementUtils.register("hot_spring_check", HOT_SPRING, PlacementUtils.filteredByBlockSurvival(ItemAndBlockRegister.HotSpringBlock.get()));
    public static final Holder<PlacedFeature> FANCY_SAKURA_CHECKED = PlacementUtils.register("fancy_sakura_check", FANCY_SAKURA, PlacementUtils.filteredByBlockSurvival(ItemAndBlockRegister.big_sakura_sapling.get()));
    public static final Holder<PlacedFeature> YOMI_VINES_CHECKED = PlacementUtils.register("yomi_vines_check", YOMI_VINES, PlacementUtils.filteredByBlockSurvival(ItemAndBlockRegister.yomi_vines.get()));
    public static final Holder<PlacedFeature> KAKURIYO_PORTAL_CHECKED = PlacementUtils.register("kakuriyo_portal_check", KAKURIYO_PORTAL, PlacementUtils.filteredByBlockSurvival(ItemAndBlockRegister.lantern_plant.get()));
    public static final Holder<PlacedFeature> KAKURIYO_MEGA_CEDAR_CHECKED = PlacementUtils.register("kakuriyo_mega_cedar_check", KAKURIYO_MEGA_CEDAR, PlacementUtils.filteredByBlockSurvival(ItemAndBlockRegister.japanese_cedar_sapling.get()));

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> APRICOT_SPAWN = FeatureUtils.register("apricot_spawn", Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(APRICOT_CHECKED, 0.2F)),APRICOT_CHECKED));
    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> SAKURA_SPAWN = FeatureUtils.register("sakura_spawn", Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(SAKURA_CHECKED, 0.2F)),SAKURA_CHECKED));
    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> CYPRESS_SPAWN = FeatureUtils.register("cypress_spawn", Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(CYPRESS_CHECKED, 0.2F)),CYPRESS_CHECKED));
    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> CEDAR_SPAWN = FeatureUtils.register("cedar_spawn", Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(CEDAR_CHECKED, 0.2F)),CEDAR_CHECKED));
    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> LACQUER_SPAWN = FeatureUtils.register("lacquer_spawn", Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(LACQUER_CHECKED, 0.2F)),LACQUER_CHECKED));
    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> MEGA_CEDAR_SPAWN = FeatureUtils.register("mega_cedar_spawn", Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(MEGA_CEDAR_CHECKED, 0.2F)),MEGA_CEDAR_CHECKED));
    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> RED_SPAWN = FeatureUtils.register("red_spawn", Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(RED_CHECKED, 0.2F)),RED_CHECKED));
    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> ORANGE_SPAWN = FeatureUtils.register("orange_spawn", Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(ORANGE_CHECKED, 0.2F)),ORANGE_CHECKED));
    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> YELLOW_SPAWN = FeatureUtils.register("yellow_spawn", Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(YELLOW_CHECKED, 0.2F)),YELLOW_CHECKED));
    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> BAMBOO_SPAWN = FeatureUtils.register("japanese_timber_bamboo_spawn", Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(BAMBOO_CHECKED, 0.2F)),BAMBOO_CHECKED));

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> HOT_SPRING_SPAWN = FeatureUtils.register("hot_spring_spawn", Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(HOT_SPRING_CHECKED, 0.2F)),HOT_SPRING_CHECKED));

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> FANCY_SAKURA_SPAWN = FeatureUtils.register("fancy_sakura_spawn", Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(FANCY_SAKURA_CHECKED, 0.2F)),FANCY_SAKURA_CHECKED));
    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> KAKURIYO_MEGA_CEDAR_SPAWN = FeatureUtils.register("kakuriyo_mega_cedar_spawn", Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(KAKURIYO_MEGA_CEDAR_CHECKED, 0.2F)),KAKURIYO_MEGA_CEDAR_CHECKED));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> SHIITAKE = FeatureUtils.register("shiitake_spawn", Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(ItemAndBlockRegister.shiitake.get()), 300));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> WALL_SHIITAKE_N = FeatureUtils.register("wall_shiitake_spawn_n", Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(ItemAndBlockRegister.wall_shiitake.get().defaultBlockState().setValue(WallShiitakeBlock.FACING,Direction.NORTH)), 1000));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> WALL_SHIITAKE_S = FeatureUtils.register("wall_shiitake_spawn_s", Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(ItemAndBlockRegister.wall_shiitake.get().defaultBlockState().setValue(WallShiitakeBlock.FACING,Direction.SOUTH)), 1000));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> WALL_SHIITAKE_E = FeatureUtils.register("wall_shiitake_spawn_e", Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(ItemAndBlockRegister.wall_shiitake.get().defaultBlockState().setValue(WallShiitakeBlock.FACING,Direction.EAST)), 1000));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> WALL_SHIITAKE_W = FeatureUtils.register("wall_shiitake_spawn_w", Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(ItemAndBlockRegister.wall_shiitake.get().defaultBlockState().setValue(WallShiitakeBlock.FACING,Direction.WEST)), 1000));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> EULALIA = FeatureUtils.register("eulalia_spawn", Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(ItemAndBlockRegister.eulalia.get()), 60));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> TALL_EULALIA = FeatureUtils.register("tall_eulalia_spawn", Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(ItemAndBlockRegister.double_eulalia.get()), 60));
    public static final Holder<ConfiguredFeature<SimpleRandomFeatureConfiguration, ?>> LYCORIS_FLOWERS = FeatureUtils.register("lycoris_spawn", Feature.SIMPLE_RANDOM_SELECTOR, new SimpleRandomFeatureConfiguration(HolderSet.direct( PlacementUtils.inlinePlaced(Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ItemAndBlockRegister.lycoris.get())))))));
    public static final Holder<ConfiguredFeature<SimpleRandomFeatureConfiguration, ?>> QUARTZ_CLUSTER = FeatureUtils.register("quartz_cluster", Feature.SIMPLE_RANDOM_SELECTOR, new SimpleRandomFeatureConfiguration(HolderSet.direct( PlacementUtils.inlinePlaced(Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ItemAndBlockRegister.quartz_cluster.get())))))));
    public static final Holder<ConfiguredFeature<SimpleRandomFeatureConfiguration, ?>> LANTERN_PLANT= FeatureUtils.register("lantern_plant", Feature.SIMPLE_RANDOM_SELECTOR, new SimpleRandomFeatureConfiguration(HolderSet.direct( PlacementUtils.inlinePlaced(Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ItemAndBlockRegister.lantern_plant.get().defaultBlockState().setValue(LanternPlantBlock.AGE,Integer.valueOf(1)))))))));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> FALLEN_SAKUEA_LEAVES = FeatureUtils.register("fallen_sakura_leaves_spawn", Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(ItemAndBlockRegister.fallen_sakura_leaves.get()), 20));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> FALLEN_RED_LEAVES = FeatureUtils.register("fallen_red_leaves_spawn", Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(ItemAndBlockRegister.fallen_red_leaves.get()), 30));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> FALLEN_ORANGE_LEAVES = FeatureUtils.register("fallen_orange_leaves_spawn", Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(ItemAndBlockRegister.fallen_orange_leaves.get()), 30));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> FALLEN_YELLOW_LEAVES = FeatureUtils.register("fallen_yellow_leaves_spawn", Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(ItemAndBlockRegister.fallen_yellow_leaves.get()), 30));
    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> YOMI_VINES_SPAWN = FeatureUtils.register("yomi_vines_spawn", Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(YOMI_VINES_CHECKED, 0.2F)),YOMI_VINES_CHECKED));
    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> KAKURIYO_PORTAL_SPAWN = FeatureUtils.register("kakuriyo_portal_spawn", Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(KAKURIYO_PORTAL_CHECKED, 0.2F)),KAKURIYO_PORTAL_CHECKED));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> WOOD_ELEMENT_SACRED_ROCK = FeatureUtils.register("wood_element_sacred_rock", Feature.RANDOM_PATCH, new RandomPatchConfiguration(1, 40, 10, PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ItemAndBlockRegister.wood_element_sacred_rock.get())), BlockPredicate.allOf(BlockPredicate.replaceable(), BlockPredicate.matchesBlock(ItemAndBlockRegister.kakuriyo_grass_block.get(), new BlockPos(0, -1, 0))))));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> FIRE_ELEMENT_SACRED_ROCK = FeatureUtils.register("fire_element_sacred_rock", Feature.RANDOM_PATCH, new RandomPatchConfiguration(1, 40, 10, PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ItemAndBlockRegister.fire_element_sacred_rock.get())), BlockPredicate.allOf(BlockPredicate.replaceable(), BlockPredicate.matchesBlock(ItemAndBlockRegister.kakuriyo_grass_block.get(), new BlockPos(0, -1, 0))))));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> EARTH_ELEMENT_SACRED_ROCK = FeatureUtils.register("earth_element_sacred_rock", Feature.RANDOM_PATCH, new RandomPatchConfiguration(1, 40, 10, PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ItemAndBlockRegister.earth_element_sacred_rock.get())), BlockPredicate.allOf(BlockPredicate.replaceable(), BlockPredicate.matchesBlock(ItemAndBlockRegister.kakuriyo_grass_block.get(), new BlockPos(0, -1, 0))))));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> METAL_ELEMENT_SACRED_ROCK = FeatureUtils.register("metal_element_sacred_rock", Feature.RANDOM_PATCH, new RandomPatchConfiguration(1, 40, 10, PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ItemAndBlockRegister.metal_element_sacred_rock.get())), BlockPredicate.allOf(BlockPredicate.replaceable(), BlockPredicate.matchesBlock(ItemAndBlockRegister.kakuriyo_grass_block.get(), new BlockPos(0, -1, 0))))));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> WATER_ELEMENT_SACRED_ROCK = FeatureUtils.register("water_element_sacred_rock", Feature.RANDOM_PATCH, new RandomPatchConfiguration(1, 40, 10, PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ItemAndBlockRegister.water_element_sacred_rock.get())), BlockPredicate.allOf(BlockPredicate.replaceable(), BlockPredicate.matchesBlock(ItemAndBlockRegister.kakuriyo_grass_block.get(), new BlockPos(0, -1, 0))))));
    private static TreeConfiguration.TreeConfigurationBuilder createStraightBlobTree(Block p_195147_, Block p_195148_, int p_195149_, int p_195150_, int p_195151_, int p_195152_) {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(p_195147_), new StraightTrunkPlacer(p_195149_, p_195150_, p_195151_), BlockStateProvider.simple(p_195148_), new BlobFoliagePlacer(ConstantInt.of(p_195152_), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1));
    }
    private static TreeConfiguration.TreeConfigurationBuilder createFancySakura() {
        return (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ItemAndBlockRegister.sakura_log.get()), new FancyTrunkPlacer(3, 11, 0), BlockStateProvider.simple(ItemAndBlockRegister.sakura_leaves.get()), new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder createGlowingFancySakura() {
        return (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ItemAndBlockRegister.sakura_log.get()), new FancyTrunkPlacer(3, 11, 0), BlockStateProvider.simple(ItemAndBlockRegister.glowing_sakura_leaves.get()), new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))).ignoreVines();
    }
    private static TreeConfiguration.TreeConfigurationBuilder createBirchTypeTree(Block log,Block leaves) {
        return createStraightBlobTree(log,leaves, 5, 2, 0, 2).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder createBamboo() {
        return createStraightBlobTree(ItemAndBlockRegister.japanese_timber_bamboo.get(),Blocks.AIR, 5, 2, 2, 2).ignoreVines();
    }

    private static RandomPatchConfiguration grassPatch(BlockStateProvider p_195203_, int p_195204_) {
        return FeatureUtils.simpleRandomPatchConfiguration(p_195204_, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(p_195203_)));
    }
    public static void register() {
    }
}
