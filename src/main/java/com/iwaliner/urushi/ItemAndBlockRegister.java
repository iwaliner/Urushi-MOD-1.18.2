package com.iwaliner.urushi;

import com.iwaliner.urushi.block.*;
import com.iwaliner.urushi.item.*;
import com.iwaliner.urushi.world.tree.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.*;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Objects;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = ModCoreUrushi.ModID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ItemAndBlockRegister {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModCoreUrushi.ModID);
    public static final DeferredRegister<Block> BLOCKS= DeferredRegister.create(ForgeRegistries.BLOCKS, ModCoreUrushi.ModID);
    public static final RegistryObject<Block> sikkui =B("plaster","p",0,() -> {return new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> sikkui_slab =B("plaster_slab","p",0,() -> {return new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> sikkui_stairs =B("plaster_stairs","p",0,() -> {return new StairBlock(ItemAndBlockRegister.sikkui.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> sikkui_bars =B("plaster_bars","p",0,() -> {return new BarsBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> oak_framed_sikkui =B("oak_framed_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> spruce_framed_sikkui =B("spruce_framed_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> birch_framed_sikkui =B("birch_framed_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> jungle_framed_sikkui =B("jungle_framed_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> acacia_framed_sikkui =B("acacia_framed_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> dark_oak_framed_sikkui =B("dark_oak_framed_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> japanese_apricot_framed_plaster =B("japanese_apricot_framed_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> sakura_framed_plaster =B("sakura_framed_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> cypress_framed_plaster =B("cypress_framed_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> red_framed_plaster =B("red_framed_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> black_framed_plaster =B("black_framed_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> namako =B("namako","p",0,() -> {return new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final RegistryObject<Item> raw_ibushi_kawara =I("raw_ibushi_kawara");
    public static final RegistryObject<Item> ibushi_kawara =I("ibushi_kawara");
    public static final RegistryObject<Block> ibushi_kawara_block =B("ibushi_kawara_block","p",0,() -> {return new HorizonalRotateBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> ibushi_kawara_slab =B("ibushi_kawara_slab","p",0,() -> {return new HorizonalRotateSlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> ibushi_kawara_stairs =B("ibushi_kawara_stairs","p",0,() -> {return new StairBlock(ibushi_kawara_block.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> ibushi_kawara_wall =B("ibushi_kawara_wall","p",0,() -> {return new WallBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> ibushi_kawara_roof_45 =B("ibushi_kawara_roof_45","p",0,() -> {return new Roof45Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F).noCollission());});
    public static final RegistryObject<Block> ibushi_kawara_roof_225 =B("ibushi_kawara_roof_225","p",0,() -> {return new Roof225Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F).noCollission());});
    public static final RegistryObject<Item> copper_kawara =I("copper_kawara");
    public static final RegistryObject<Block> copper_kawara_block =B("copper_kawara_block","p",0,() -> {return new HorizonalRotateBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.DIRT).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> copper_kawara_slab =B("copper_kawara_slab","p",0,() -> {return new HorizonalRotateSlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.DIRT).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> copper_kawara_stairs =B("copper_kawara_stairs","p",0,() -> {return new StairBlock(copper_kawara_block.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.STONE, MaterialColor.DIRT).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> copper_kawara_wall =B("copper_kawara_wall","p",0,() -> {return new WallBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.DIRT).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> copper_kawara_roof_45 =B("copper_kawara_roof_45","p",0,() -> {return new Roof45Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.DIRT).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F).noCollission());});
    public static final RegistryObject<Block> copper_kawara_roof_225 =B("copper_kawara_roof_225","p",0,() -> {return new Roof225Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.DIRT).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F).noCollission());});
    public static final RegistryObject<Item> cupric_oxide_kawara =I("cupric_oxide_kawara");
    public static final RegistryObject<Block> cupric_oxide_kawara_block =B("cupric_oxide_kawara_block","p",0,() -> {return new HorizonalRotateBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.EMERALD).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> cupric_oxide_kawara_slab =B("cupric_oxide_kawara_slab","p",0,() -> {return new HorizonalRotateSlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.EMERALD).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> cupric_oxide_kawara_stairs =B("cupric_oxide_kawara_stairs","p",0,() -> {return new StairBlock(cupric_oxide_kawara_block.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.STONE, MaterialColor.EMERALD).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> cupric_oxide_kawara_wall =B("cupric_oxide_kawara_wall","p",0,() -> {return new WallBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.EMERALD).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> cupric_oxide_kawara_roof_45 =B("cupric_oxide_kawara_roof_45","p",0,() -> {return new Roof45Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.EMERALD).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F).noCollission());});
    public static final RegistryObject<Block> cupric_oxide_kawara_roof_225 =B("cupric_oxide_kawara_roof_225","p",0,() -> {return new Roof225Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.EMERALD).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F).noCollission());});
    public static final RegistryObject<Block> wattle_and_daub =B("wattle_and_daub","s",-1,() -> {return new Block(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.DIRT).strength(0.5F, 2.0F).sound(SoundType.GRASS));});
    public static final RegistryObject<Block> wattle_and_daub_slab =B("wattle_and_daub_slab","s",-1,() -> {return new SlabBlock(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.DIRT).strength(0.5F, 2.0F).sound(SoundType.GRASS));});
    public static final RegistryObject<Block> wattle_and_daub_stairs =B("wattle_and_daub_stairs","s",-1,() -> {return new StairBlock(wattle_and_daub.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.DIRT).strength(0.5F, 2.0F).sound(SoundType.GRASS));});
    public static final RegistryObject<Block> sand_coast =B("sand_coast","s",-1,() -> {return new Block(BlockBehaviour.Properties.of(Material.SAND, MaterialColor.SAND).strength(0.5F, 3.0F).sound(SoundType.SAND));});
    public static final RegistryObject<Block> thatched_block =B("thatched_block","h",-1,() -> {return new Block(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.TERRACOTTA_YELLOW).strength(0.2F, 3.0F).sound(SoundType.GRASS));});
    public static final RegistryObject<Block> thatched_slab =B("thatched_slab","h",-1,() -> {return new SlabBlock(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.TERRACOTTA_YELLOW).strength(0.2F, 3.0F).sound(SoundType.GRASS));});
    public static final RegistryObject<Block> thatched_stairs =B("thatched_stairs","h",-1,() -> {return new StairBlock(thatched_block.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.TERRACOTTA_YELLOW).strength(0.2F, 3.0F).sound(SoundType.GRASS));});
    public static final RegistryObject<Block> thatched_roof_45 =B("thatched_roof_45","h",-1,() -> {return new Roof45Block(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.TERRACOTTA_YELLOW).strength(0.2F, 3.0F).sound(SoundType.GRASS));});
    public static final RegistryObject<Block> thatched_roof_225 =B("thatched_roof_225","h",-1,() -> {return new Roof225Block(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.TERRACOTTA_YELLOW).strength(0.2F, 3.0F).sound(SoundType.GRASS));});
    public static final RegistryObject<Block> hiwadabuki_block =B("hiwadabuki_block","h",-1,() -> {return new Block(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.TERRACOTTA_BLACK).strength(0.2F, 3.0F).sound(SoundType.GRASS));});
    public static final RegistryObject<Block> hiwadabuki_slab =B("hiwadabuki_slab","h",-1,() -> {return new SlabBlock(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.TERRACOTTA_BLACK).strength(0.2F, 3.0F).sound(SoundType.GRASS));});
    public static final RegistryObject<Block> hiwadabuki_stairs =B("hiwadabuki_stairs","h",-1,() -> {return new StairBlock(thatched_block.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.TERRACOTTA_BLACK).strength(0.2F, 3.0F).sound(SoundType.GRASS));});
    public static final RegistryObject<Block> hiwadabuki_roof_45 =B("hiwadabuki_roof_45","h",-1,() -> {return new Roof45Block(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.TERRACOTTA_BLACK).strength(0.2F, 3.0F).sound(SoundType.GRASS));});
    public static final RegistryObject<Block> hiwadabuki_roof_225 =B("hiwadabuki_roof_225","h",-1,() -> {return new Roof225Block(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.TERRACOTTA_BLACK).strength(0.2F, 3.0F).sound(SoundType.GRASS));});
    public static final RegistryObject<Block> green_tatami =B("green_tatami","h",-1,() -> {return new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.GRASS).strength(0.2F, 10.0F).sound(SoundType.GRASS));});
    public static final RegistryObject<Block> green_tatami_carpet =B("green_tatami_carpet","h",-1,() -> {return new TatamiCarpetBlock(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.GRASS).strength(0.2F, 10.0F).sound(SoundType.GRASS).noCollission());});
    public static final RegistryObject<Block> brown_tatami =B("brown_tatami","h",-1,() -> {return new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.GRASS).strength(0.2F, 10.0F).sound(SoundType.GRASS));});
    public static final RegistryObject<Block> brown_tatami_carpet =B("brown_tatami_carpet","h",-1,() -> {return new TatamiCarpetBlock(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.GRASS).strength(0.2F, 10.0F).sound(SoundType.GRASS).noOcclusion());});
    public static final RegistryObject<Block> goldfish_bowl =B("goldfish_bowl","p",-1,() -> {return new Block(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.WATER).strength(0.2F, 10.0F).sound(SoundType.GLASS).noOcclusion());});
    public static final RegistryObject<Block> rough_stone =B("rough_stone","p",0,() -> {return new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> rough_stone_slab =B("rough_stone_slab","p",0,() -> {return new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> rough_stone_stairs =B("rough_stone_stairs","p",0,() -> {return new StairBlock(rough_stone.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> rough_stone_wall =B("rough_stone_wall","p",0,() -> {return new WallBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> concrete =B("concrete","p",0,() -> {return new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> concrete_slab =B("concrete_slab","p",0,() -> {return new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> concrete_stairs =B("concrete_stairs","p",0,() -> {return new StairBlock(concrete.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> dirty_concrete =B("dirty_concrete","p",0,() -> {return new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> dirty_concrete_slab =B("dirty_concrete_slab","p",0,() -> {return new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> dirty_concrete_stairs =B("dirty_concrete_stairs","p",0,() -> {return new StairBlock(dirty_concrete.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> lidless_groove =B("lidless_groove","p",0,() -> {return new GrooveBlock(false,BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> groove =B("groove","p",0,() -> {return new GrooveBlock(true,BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> mesh_groove =B("mesh_groove","p",0,() -> {return new GrooveBlock(true,BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> connectable_glass =B("connectable_glass","p",-1,() -> {return new ConnectableGlassBlock(BlockBehaviour.Properties.of(Material.GLASS).sound(SoundType.GLASS).strength(0.2F, 3.0F).noOcclusion().isValidSpawn(ItemAndBlockRegister::never).isRedstoneConductor(ItemAndBlockRegister::never).isSuffocating(ItemAndBlockRegister::never).isViewBlocking(ItemAndBlockRegister::never));});
    public static final RegistryObject<Block> connectable_glass_pane =B("connectable_glass_pane","p",-1,() -> {return new ConnectableGlassPaneBlock(BlockBehaviour.Properties.of(Material.GLASS).sound(SoundType.GLASS).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> metal_framed_glass =B("metal_framed_glass","p",-1,() -> {return new ConnectableGlassBlock(BlockBehaviour.Properties.of(Material.GLASS).sound(SoundType.GLASS).strength(0.2F, 3.0F).noOcclusion().isValidSpawn(ItemAndBlockRegister::never).isRedstoneConductor(ItemAndBlockRegister::never).isSuffocating(ItemAndBlockRegister::never).isViewBlocking(ItemAndBlockRegister::never));});
    public static final RegistryObject<Block> metal_framed_glass_pane =B("metal_framed_glass_pane","p",-1,() -> {return new ConnectableGlassPaneBlock(BlockBehaviour.Properties.of(Material.GLASS).sound(SoundType.GLASS).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> smooth_oak_planks =B("smooth_oak_planks","a",-1,() -> {return new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_oak_slab =B("smooth_oak_slab","a",-1,() -> {return new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_oak_stairs =B("smooth_oak_stairs","a",-1,() -> {return new StairBlock(smooth_oak_planks.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> oak_parapet =B("oak_parapet","a",-1,() -> {return new ParapetBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> oak_bars =B("oak_bars","a",-1,() -> {return new BarsBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> oak_fushiranma =B("oak_fushiranma","a",-1,() -> {return new FushiranmaBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_spruce_planks =B("smooth_spruce_planks","a",-1,() -> {return new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.PODZOL).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_spruce_slab =B("smooth_spruce_slab","a",-1,() -> {return new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.PODZOL).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_spruce_stairs =B("smooth_spruce_stairs","a",-1,() -> {return new StairBlock(smooth_spruce_planks.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.PODZOL).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> spruce_parapet =B("spruce_parapet","a",-1,() -> {return new ParapetBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.PODZOL).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> spruce_bars =B("spruce_bars","a",-1,() -> {return new BarsBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.PODZOL).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> spruce_fushiranma =B("spruce_fushiranma","a",-1,() -> {return new FushiranmaBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.PODZOL).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_birch_planks =B("smooth_birch_planks","a",-1,() -> {return new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_birch_slab =B("smooth_birch_slab","a",-1,() -> {return new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_birch_stairs =B("smooth_birch_stairs","a",-1,() -> {return new StairBlock(smooth_birch_planks.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> birch_parapet =B("birch_parapet","a",-1,() -> {return new ParapetBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> birch_bars =B("birch_bars","a",-1,() -> {return new BarsBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> birch_fushiranma =B("birch_fushiranma","a",-1,() -> {return new FushiranmaBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_jungle_planks =B("smooth_jungle_planks","a",-1,() -> {return new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.DIRT).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_jungle_slab =B("smooth_jungle_slab","a",-1,() -> {return new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.DIRT).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_jungle_stairs =B("smooth_jungle_stairs","a",-1,() -> {return new StairBlock(smooth_jungle_planks.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.DIRT).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> jungle_parapet =B("jungle_parapet","a",-1,() -> {return new ParapetBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.DIRT).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> jungle_bars =B("jungle_bars","a",-1,() -> {return new BarsBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.DIRT).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> jungle_fushiranma =B("jungle_fushiranma","a",-1,() -> {return new FushiranmaBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.DIRT).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_acacia_planks =B("smooth_acacia_planks","a",-1,() -> {return new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_acacia_slab =B("smooth_acacia_slab","a",-1,() -> {return new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_acacia_stairs =B("smooth_acacia_stairs","a",-1,() -> {return new StairBlock(smooth_acacia_planks.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> acacia_parapet =B("acacia_parapet","a",-1,() -> {return new ParapetBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> acacia_bars =B("acacia_bars","a",-1,() -> {return new BarsBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> acacia_fushiranma =B("acacia_fushiranma","a",-1,() -> {return new FushiranmaBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_dark_oak_planks =B("smooth_dark_oak_planks","a",-1,() -> {return new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_dark_oak_slab =B("smooth_dark_oak_slab","a",-1,() -> {return new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_dark_oak_stairs =B("smooth_dark_oak_stairs","a",-1,() -> {return new StairBlock(smooth_dark_oak_planks.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> dark_oak_parapet =B("dark_oak_parapet","a",-1,() -> {return new ParapetBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> dark_oak_bars =B("dark_oak_bars","a",-1,() -> {return new BarsBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> dark_oak_fushiranma =B("dark_oak_fushiranma","a",-1,() -> {return new FushiranmaBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> green_bars =B("green_bars","a",-1,() -> {return new BarsBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_GREEN).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Item> japanese_apricot_bark =I("japanese_apricot_bark");
    public static final RegistryObject<Block> japanese_apricot_sapling =B("japanese_apricot_sapling","a",-1,() -> {return new SaplingBlock(new ApricotTreeGrower(),BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.COLOR_PINK).sound(SoundType.GRASS).noCollission().instabreak().randomTicks());});
    public static final RegistryObject<Block> japanese_apricot_leaves =B("japanese_apricot_leaves","h",-1,() -> {return cutouteaves(MaterialColor.COLOR_PINK,SoundType.AZALEA_LEAVES);});
    public static final RegistryObject<Block> glowing_japanese_apricot_sapling =B("glowing_japanese_apricot_sapling","a",-1,() -> {return new GlowingSaplingBlock(new GlowingApricotTreeGrower(),BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.COLOR_PINK).sound(SoundType.GRASS).noCollission().instabreak().randomTicks().lightLevel((p_235470_0_) -> {return 15;}));});
    public static final RegistryObject<Block> glowing_japanese_apricot_leaves =B("glowing_japanese_apricot_leaves","h",-1,() -> {return glowingleaves(MaterialColor.COLOR_PINK,SoundType.AZALEA_LEAVES);});
    public static final RegistryObject<Block> stripped_japanese_apricot_log =B("stripped_japanese_apricot_log","a",-1,() -> {return log(MaterialColor.WOOD, MaterialColor.TERRACOTTA_PINK);});
    public static final RegistryObject<Block> japanese_apricot_log =B("japanese_apricot_log","a",-1,() -> {return strippablelog(stripped_japanese_apricot_log.get(),0,MaterialColor.WOOD, MaterialColor.TERRACOTTA_PINK);});
    public static final RegistryObject<Block> stripped_japanese_apricot_wood =B("stripped_japanese_apricot_wood","a",-1,() -> {return new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_PINK).sound(SoundType.WOOD).strength(2.0F, 10.0F));});
    public static final RegistryObject<Block> japanese_apricot_wood =B("japanese_apricot_wood","a",-1,() -> {return new StrippableLogBlock(stripped_japanese_apricot_wood.get(),0,BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_PINK).sound(SoundType.WOOD).strength(2.0F, 10.0F));});
    public static final RegistryObject<Block> japanese_apricot_planks =B("japanese_apricot_planks","a",-1,() -> {return new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_PINK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> japanese_apricot_slab =B("japanese_apricot_slab","a",-1,() -> {return new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_PINK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> japanese_apricot_stairs =B("japanese_apricot_stairs","a",-1,() -> {return new StairBlock(japanese_apricot_planks.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_PINK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> japanese_apricot_fence =B("japanese_apricot_fence","a",-1,() -> {return new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_PINK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> japanese_apricot_fence_gate =B("japanese_apricot_fence_gate","a",-1,() -> {return new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_PINK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> japanese_apricot_door =B("japanese_apricot_door","a",-1,() -> {return new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_PINK).sound(SoundType.WOOD).strength(1.0F, 10.0F).noOcclusion());});
    public static final RegistryObject<Block> japanese_apricot_trapdoor =B("japanese_apricot_trapdoor","a",-1,() -> {return new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_PINK).sound(SoundType.WOOD).strength(1.0F, 10.0F).noOcclusion().isValidSpawn(ItemAndBlockRegister::never));});
    public static final RegistryObject<Block> japanese_apricot_pressure_plate =B("japanese_apricot_pressure_plate","a",-1,() -> {return new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_PINK).sound(SoundType.WOOD).strength(0.5F, 10.0F).noCollission());});
    public static final RegistryObject<Block> japanese_apricot_button =B("japanese_apricot_button","a",-1,() -> {return new WoodButtonBlock(BlockBehaviour.Properties.of(Material.DECORATION, MaterialColor.TERRACOTTA_PINK).sound(SoundType.WOOD).strength(0.5F, 10.0F).noCollission());});
    public static final RegistryObject<Block> smooth_japanese_apricot_planks =B("smooth_japanese_apricot_planks","a",-1,() -> {return new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_PINK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_japanese_apricot_slab =B("smooth_japanese_apricot_slab","a",-1,() -> {return new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_PINK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_japanese_apricot_stairs =B("smooth_japanese_apricot_stairs","a",-1,() -> {return new StairBlock(smooth_japanese_apricot_planks.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_PINK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> japanese_apricot_parapet =B("japanese_apricot_parapet","a",-1,() -> {return new ParapetBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_PINK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> japanese_apricot_fushiranma =B("japanese_apricot_fushiranma","a",-1,() -> {return new FushiranmaBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_PINK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Item> sakura_bark =I("sakura_bark");
    public static final RegistryObject<Block> sakura_sapling =B("sakura_sapling","a",-1,() -> {return new SaplingBlock(new SakuraTreeGrower(),BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.TERRACOTTA_WHITE).sound(SoundType.GRASS).noCollission().instabreak().randomTicks());});
    public static final RegistryObject<Block> big_sakura_sapling =B("big_sakura_sapling","a",-1,() -> {return new SaplingBlock(new FancySakuraTreeGrower(),BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.TERRACOTTA_WHITE).sound(SoundType.GRASS).noCollission().instabreak().randomTicks());});
    public static final RegistryObject<Block> sakura_leaves =B("sakura_leaves","h",-1,() -> {return cutouteaves(MaterialColor.TERRACOTTA_WHITE,SoundType.AZALEA_LEAVES);});
    public static final RegistryObject<Block> glowing_sakura_sapling =B("glowing_sakura_sapling","a",-1,() -> {return new GlowingSaplingBlock(new GlowingSakuraTreeGrower(),BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.TERRACOTTA_WHITE).sound(SoundType.GRASS).noCollission().instabreak().randomTicks().lightLevel((p_235470_0_) -> {return 15;}));});
    public static final RegistryObject<Block> glowing_big_sakura_sapling =B("glowing_big_sakura_sapling","a",-1,() -> {return new GlowingSaplingBlock(new GlowingFancySakuraTreeGrower(),BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.TERRACOTTA_WHITE).sound(SoundType.GRASS).noCollission().instabreak().randomTicks().lightLevel((p_235470_0_) -> {return 15;}));});
    public static final RegistryObject<Block> glowing_sakura_leaves =B("glowing_sakura_leaves","h",-1,() -> {return glowingleaves(MaterialColor.TERRACOTTA_WHITE,SoundType.AZALEA_LEAVES);});
    public static final RegistryObject<Block> stripped_sakura_log =B("stripped_sakura_log","a",-1,() -> {return log(MaterialColor.WOOD, MaterialColor.COLOR_ORANGE);});
    public static final RegistryObject<Block> sakura_log =B("sakura_log","a",-1,() -> {return strippablelog(stripped_sakura_log.get(),1,MaterialColor.WOOD, MaterialColor.COLOR_ORANGE);});
    public static final RegistryObject<Block> stripped_sakura_wood =B("stripped_sakura_wood","a",-1,() -> {return new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(2.0F, 10.0F));});
    public static final RegistryObject<Block> sakura_wood =B("sakura_wood","a",-1,() -> {return new StrippableLogBlock(stripped_sakura_wood.get(),1,BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(2.0F, 10.0F));});
    public static final RegistryObject<Block> sakura_planks =B("sakura_planks","a",-1,() -> {return new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> sakura_slab =B("sakura_slab","a",-1,() -> {return new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> sakura_stairs =B("sakura_stairs","a",-1,() -> {return new StairBlock(sakura_planks.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> sakura_fence =B("sakura_fence","a",-1,() -> {return new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> sakura_fence_gate =B("sakura_fence_gate","a",-1,() -> {return new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> sakura_door =B("sakura_door","a",-1,() -> {return new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F).noOcclusion());});
    public static final RegistryObject<Block> sakura_trapdoor =B("sakura_trapdoor","a",-1,() -> {return new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F).noOcclusion().isValidSpawn(ItemAndBlockRegister::never));});
    public static final RegistryObject<Block> sakura_pressure_plate =B("sakura_pressure_plate","a",-1,() -> {return new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(0.5F, 10.0F).noCollission());});
    public static final RegistryObject<Block> sakura_button =B("sakura_button","a",-1,() -> {return new WoodButtonBlock(BlockBehaviour.Properties.of(Material.DECORATION, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(0.5F, 10.0F).noCollission());});
    public static final RegistryObject<Block> smooth_sakura_planks =B("smooth_sakura_planks","a",-1,() -> {return new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_sakura_slab =B("smooth_sakura_slab","a",-1,() -> {return new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_sakura_stairs =B("smooth_sakura_stairs","a",-1,() -> {return new StairBlock(smooth_sakura_planks.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> sakura_parapet =B("sakura_parapet","a",-1,() -> {return new ParapetBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> sakura_fushiranma =B("sakura_fushiranma","a",-1,() -> {return new FushiranmaBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Item> cypress_bark =I("cypress_bark");
    public static final RegistryObject<Block> cypress_sapling =B("cypress_sapling","a",-1,() -> {return new SaplingBlock(new CypressTreeGrower(),BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.GRASS).sound(SoundType.GRASS).noCollission().instabreak().randomTicks());});
    public static final RegistryObject<Block> cypress_leaves =B("cypress_leaves","h",-1,() -> {return leaves(MaterialColor.GRASS,SoundType.AZALEA_LEAVES);});
    public static final RegistryObject<Block> stripped_cypress_log =B("stripped_cypress_log","a",-1,() -> {return log(MaterialColor.WOOD, MaterialColor.SAND);});
    public static final RegistryObject<Block> cypress_log =B("cypress_log","a",-1,() -> {return strippablelog(stripped_cypress_log.get(),2,MaterialColor.WOOD, MaterialColor.SAND);});
    public static final RegistryObject<Block> stripped_cypress_wood =B("stripped_cypress_wood","a",-1,() -> {return new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).sound(SoundType.WOOD).strength(2.0F, 10.0F));});
    public static final RegistryObject<Block> cypress_wood =B("cypress_wood","a",-1,() -> {return new StrippableLogBlock(stripped_cypress_wood.get(),2,BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).sound(SoundType.WOOD).strength(2.0F, 10.0F));});
    public static final RegistryObject<Block> cypress_planks =B("cypress_planks","a",-1,() -> {return new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> cypress_slab =B("cypress_slab","a",-1,() -> {return new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> cypress_stairs =B("cypress_stairs","a",-1,() -> {return new StairBlock(cypress_planks.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> cypress_fence =B("cypress_fence","a",-1,() -> {return new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> cypress_fence_gate =B("cypress_fence_gate","a",-1,() -> {return new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> cypress_door =B("cypress_door","a",-1,() -> {return new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F).noOcclusion());});
    public static final RegistryObject<Block> cypress_trapdoor =B("cypress_trapdoor","a",-1,() -> {return new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F).noOcclusion().isValidSpawn(ItemAndBlockRegister::never));});
    public static final RegistryObject<Block> cypress_pressure_plate =B("cypress_pressure_plate","a",-1,() -> {return new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).sound(SoundType.WOOD).strength(0.5F, 10.0F).noCollission());});
    public static final RegistryObject<Block> cypress_button =B("cypress_button","a",-1,() -> {return new WoodButtonBlock(BlockBehaviour.Properties.of(Material.DECORATION, MaterialColor.SAND).sound(SoundType.WOOD).strength(0.5F, 10.0F).noCollission());});
    public static final RegistryObject<Block> smooth_cypress_planks =B("smooth_cypress_planks","a",-1,() -> {return new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_cypress_slab =B("smooth_cypress_slab","a",-1,() -> {return new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_cypress_stairs =B("smooth_cypress_stairs","a",-1,() -> {return new StairBlock(smooth_cypress_planks.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> cypress_parapet =B("cypress_parapet","a",-1,() -> {return new ParapetBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> cypress_fushiranma =B("cypress_fushiranma","a",-1,() -> {return new FushiranmaBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> lacquer_sapling =B("lacquer_sapling","a",-1,() -> {return new SaplingBlock(new LacquerTreeGrower(),BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.GRASS).sound(SoundType.GRASS).noCollission().instabreak().randomTicks());});
    public static final RegistryObject<Block> lacquer_leaves =B("lacquer_leaves","h",-1,() -> {return leaves(MaterialColor.GRASS,SoundType.AZALEA_LEAVES);});
    public static final RegistryObject<Block> lacquer_log =B("lacquer_log","a",-1,() -> {return chiselablelog(MaterialColor.WOOD, MaterialColor.WOOD);});
    public static final RegistryObject<Block> chiseled_lacquer_log =B("chiseled_lacquer_log","a",-1,() -> {return new ChiseledLacquerLogBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).strength(1.0F, 10.0F).randomTicks());});
    public static final RegistryObject<Item> tiny_red_dye =I("tiny_red_dye");
    public static final RegistryObject<Item> tiny_black_dye =I("tiny_black_dye");
    public static final RegistryObject<Item> raw_urushi_ball =ITEMS.register("raw_urushi_ball", () -> {return new ToolchipItem("rawurushi",(new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> red_urushi_ball =ITEMS.register("red_urushi_ball", () -> {return new Item((new Item.Properties()).tab(ModCoreUrushi.UrushiTab).craftRemainder(Items.BOWL));});
    public static final RegistryObject<Item> black_urushi_ball =ITEMS.register("black_urushi_ball", () -> {return new Item((new Item.Properties()).tab(ModCoreUrushi.UrushiTab).craftRemainder(Items.BOWL));});
    public static final RegistryObject<Block> red_urushi_planks =B("red_urushi_planks","a",-1,() -> {return new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> red_urushi_slab =B("red_urushi_slab","a",-1,() -> {return new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> red_urushi_stairs =B("red_urushi_stairs","a",-1,() -> {return new StairBlock(red_urushi_planks.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> red_urushi_fence =B("red_urushi_fence","a",-1,() -> {return new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> red_urushi_fence_gate =B("red_urushi_fence_gate","a",-1,() -> {return new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> red_urushi_door =B("red_urushi_door","a",-1,() -> {return new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).sound(SoundType.WOOD).strength(1.0F, 10.0F).noOcclusion());});
    public static final RegistryObject<Block> red_urushi_trapdoor =B("red_urushi_trapdoor","a",-1,() -> {return new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).sound(SoundType.WOOD).strength(1.0F, 10.0F).noOcclusion().isValidSpawn(ItemAndBlockRegister::never));});
    public static final RegistryObject<Block> red_urushi_pressure_plate =B("red_urushi_pressure_plate","a",-1,() -> {return new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).sound(SoundType.WOOD).strength(0.5F, 10.0F).noCollission());});
    public static final RegistryObject<Block> red_urushi_button =B("red_urushi_button","a",-1,() -> {return new WoodButtonBlock(BlockBehaviour.Properties.of(Material.DECORATION, MaterialColor.COLOR_RED).sound(SoundType.WOOD).strength(0.5F, 10.0F).noCollission());});
    public static final RegistryObject<Block> smooth_red_urushi_planks =B("smooth_red_urushi_planks","a",-1,() -> {return new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_red_urushi_slab =B("smooth_red_urushi_slab","a",-1,() -> {return new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_red_urushi_stairs =B("smooth_red_urushi_stairs","a",-1,() -> {return new StairBlock(smooth_red_urushi_planks.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> red_urushi_parapet =B("red_urushi_parapet","a",-1,() -> {return new ParapetBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> red_urushi_fushiranma =B("red_urushi_fushiranma","a",-1,() -> {return new FushiranmaBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> black_urushi_planks =B("black_urushi_planks","a",-1,() -> {return new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BLACK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> black_urushi_slab =B("black_urushi_slab","a",-1,() -> {return new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BLACK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> black_urushi_stairs =B("black_urushi_stairs","a",-1,() -> {return new StairBlock(black_urushi_planks.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BLACK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> black_urushi_fence =B("black_urushi_fence","a",-1,() -> {return new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BLACK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> black_urushi_fence_gate =B("black_urushi_fence_gate","a",-1,() -> {return new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BLACK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> black_urushi_door =B("black_urushi_door","a",-1,() -> {return new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BLACK).sound(SoundType.WOOD).strength(1.0F, 10.0F).noOcclusion());});
    public static final RegistryObject<Block> black_urushi_trapdoor =B("black_urushi_trapdoor","a",-1,() -> {return new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BLACK).sound(SoundType.WOOD).strength(1.0F, 10.0F).noOcclusion().isValidSpawn(ItemAndBlockRegister::never));});
    public static final RegistryObject<Block> black_urushi_pressure_plate =B("black_urushi_pressure_plate","a",-1,() -> {return new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BLACK).sound(SoundType.WOOD).strength(0.5F, 10.0F).noCollission());});
    public static final RegistryObject<Block> black_urushi_button =B("black_urushi_button","a",-1,() -> {return new WoodButtonBlock(BlockBehaviour.Properties.of(Material.DECORATION, MaterialColor.COLOR_BLACK).sound(SoundType.WOOD).strength(0.5F, 10.0F).noCollission());});
    public static final RegistryObject<Block> smooth_black_urushi_planks =B("smooth_black_urushi_planks","a",-1,() -> {return new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BLACK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_black_urushi_slab =B("smooth_black_urushi_slab","a",-1,() -> {return new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BLACK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_black_urushi_stairs =B("smooth_black_urushi_stairs","a",-1,() -> {return new StairBlock(smooth_black_urushi_planks.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BLACK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> black_urushi_parapet =B("black_urushi_parapet","a",-1,() -> {return new ParapetBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BLACK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> black_urushi_fushiranma =B("black_urushi_fushiranma","a",-1,() -> {return new FushiranmaBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BLACK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> wooden_cabinetry_slab =B("wooden_cabinetry_slab","a",-1,() -> {return new WoodenCabinetrySlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_BLACK).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final RegistryObject<Block> wooden_cabinetry =B("wooden_cabinetry","a",-1,() -> {return new WoodenCabinetryBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_BLACK).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final RegistryObject<Block> andon =B("andon","a",-1,() -> {return new AndonBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.PODZOL).sound(SoundType.WOOD).strength(0.2F, 10.0F).noOcclusion().lightLevel((p_235470_0_) -> {return 15;}));});
    public static final RegistryObject<Block> ariake_andon =B("ariake_andon","a",-1,() -> {return new AriakeAndonBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.PODZOL).sound(SoundType.WOOD).strength(0.2F, 10.0F).noOcclusion().lightLevel((p_235470_0_) -> {return 13;}));});
    public static final RegistryObject<Block> kasuga_lantern =B("kasuga_lantern","a",-1,() -> {return new KasugaLanternBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.PODZOL).sound(SoundType.WOOD).strength(0.2F, 10.0F).noOcclusion().lightLevel((p_235470_0_) -> {return 15;}));});
    public static final RegistryObject<Block> iron_giboshi =B("iron_giboshi","p",2,() -> {return new GiboshiBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_BLACK).sound(SoundType.METAL).strength(0.5F, 30.0F).noOcclusion().requiresCorrectToolForDrops());});
    public static final RegistryObject<Block> gold_giboshi =B("gold_giboshi","p",2,() -> {return new GiboshiBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.GOLD).sound(SoundType.METAL).strength(0.5F, 30.0F).noOcclusion().requiresCorrectToolForDrops());});
    public static final RegistryObject<Block> blank_fusuma =B("blank_fusuma","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SNOW).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> blue_seigaiha_fusuma =B("blue_seigaiha_fusuma","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SNOW).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> blue_sayagata_fusuma =B("blue_sayagata_fusuma","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SNOW).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> blank_antique_fusuma =B("blank_antique_fusuma","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SNOW).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> sliding_glass_door =B("sliding_glass_door","p",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of(Material.GLASS).sound(SoundType.GLASS).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> oak_shoji_pane =B("oak_shoji_pane","a",-1,() -> {return new IronBarsBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> spruce_shoji_pane =B("spruce_shoji_pane","a",-1,() -> {return new IronBarsBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.PODZOL).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> birch_shoji_pane =B("birch_shoji_pane","a",-1,() -> {return new IronBarsBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> jungle_shoji_pane =B("jungle_shoji_pane","a",-1,() -> {return new IronBarsBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.DIRT).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> acacia_shoji_pane =B("acacia_shoji_pane","a",-1,() -> {return new IronBarsBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> dark_oak_shoji_pane =B("dark_oak_shoji_pane","a",-1,() -> {return new IronBarsBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> japanese_apricot_shoji_pane =B("japanese_apricot_shoji_pane","a",-1,() -> {return new IronBarsBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_ORANGE).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> sakura_shoji_pane =B("sakura_shoji_pane","a",-1,() -> {return new IronBarsBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> cypress_shoji_pane =B("cypress_shoji_pane","a",-1,() -> {return new IronBarsBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> red_urushi_shoji_pane =B("red_urushi_shoji_pane","a",-1,() -> {return new IronBarsBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> black_urushi_shoji_pane =B("black_urushi_shoji_pane","a",-1,() -> {return new IronBarsBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BLACK).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> oak_shoji =B("oak_shoji","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> spruce_shoji =B("spruce_shoji","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.PODZOL).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> birch_shoji =B("birch_shoji","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> jungle_shoji =B("jungle_shoji","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.DIRT).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> acacia_shoji =B("acacia_shoji","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> dark_oak_shoji =B("dark_oak_shoji","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> japanese_apricot_shoji =B("japanese_apricot_shoji","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_ORANGE).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> sakura_shoji =B("sakura_shoji","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> cypress_shoji =B("cypress_shoji","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> red_urushi_shoji =B("red_urushi_shoji","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> black_urushi_shoji =B("black_urushi_shoji","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BLACK).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> deep_blue_noren =B("deep_blue_noren","a",-1,() -> {return new NorenBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_BLUE).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> red_noren =B("red_noren","a",-1,() -> {return new NorenBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> cyan_noren =B("cyan_noren","a",-1,() -> {return new NorenBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_CYAN).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> magenta_noren =B("magenta_noren","a",-1,() -> {return new NorenBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_MAGENTA).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> men_onsen_noren =B("men_onsen_noren","a",-1,() -> {return new WideNorenBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_BLUE).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> women_onsen_noren =B("women_onsen_noren","a",-1,() -> {return new WideNorenBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> sushi_noren =B("sushi_noren","a",-1,() -> {return new WideNorenBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_BLUE).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> kakejiku_14 =B("kakejiku_14","a",-1,() -> {return new KakejikuBlock(null,BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_GREEN).sound(SoundType.WOOD).instabreak().noCollission());});
    public static final RegistryObject<Block> kakejiku_13 =B("kakejiku_13","a",-1,() -> {return new KakejikuBlock(kakejiku_14.get(),BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_GREEN).sound(SoundType.WOOD).instabreak().noCollission());});
    public static final RegistryObject<Block> kakejiku_12 =B("kakejiku_12","a",-1,() -> {return new KakejikuBlock(kakejiku_13.get(),BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_GREEN).sound(SoundType.WOOD).instabreak().noCollission());});
    public static final RegistryObject<Block> kakejiku_11 =B("kakejiku_11","a",-1,() -> {return new KakejikuBlock(kakejiku_12.get(),BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_GREEN).sound(SoundType.WOOD).instabreak().noCollission());});
    public static final RegistryObject<Block> kakejiku_10 =B("kakejiku_10","a",-1,() -> {return new KakejikuBlock(kakejiku_11.get(),BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_GREEN).sound(SoundType.WOOD).instabreak().noCollission());});
    public static final RegistryObject<Block> kakejiku_9 =B("kakejiku_9","a",-1,() -> {return new KakejikuBlock(kakejiku_10.get(),BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_GREEN).sound(SoundType.WOOD).instabreak().noCollission());});
    public static final RegistryObject<Block> kakejiku_8 =B("kakejiku_8","a",-1,() -> {return new KakejikuBlock(kakejiku_9.get(),BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_GREEN).sound(SoundType.WOOD).instabreak().noCollission());});
    public static final RegistryObject<Block> kakejiku_7 =B("kakejiku_7","a",-1,() -> {return new KakejikuBlock(kakejiku_8.get(),BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_GREEN).sound(SoundType.WOOD).instabreak().noCollission());});
    public static final RegistryObject<Block> kakejiku_6 =B("kakejiku_6","a",-1,() -> {return new KakejikuBlock(kakejiku_7.get(),BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_GREEN).sound(SoundType.WOOD).instabreak().noCollission());});
    public static final RegistryObject<Block> kakejiku_5 =B("kakejiku_5","a",-1,() -> {return new KakejikuBlock(kakejiku_6.get(),BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_GREEN).sound(SoundType.WOOD).instabreak().noCollission());});
    public static final RegistryObject<Block> kakejiku_4 =B("kakejiku_4","a",-1,() -> {return new KakejikuBlock(kakejiku_5.get(),BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_GREEN).sound(SoundType.WOOD).instabreak().noCollission());});
    public static final RegistryObject<Block> kakejiku_3 =B("kakejiku_3","a",-1,() -> {return new KakejikuBlock(kakejiku_4.get(),BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_GREEN).sound(SoundType.WOOD).instabreak().noCollission());});
    public static final RegistryObject<Block> kakejiku_2 =B("kakejiku_2","a",-1,() -> {return new KakejikuBlock(kakejiku_3.get(),BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_GREEN).sound(SoundType.WOOD).instabreak().noCollission());});
    public static final RegistryObject<Block> kakejiku_1 =B("kakejiku_1","a",-1,() -> {return new KakejikuBlock(kakejiku_2.get(),BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_GREEN).sound(SoundType.WOOD).instabreak().noCollission());});
    public static final RegistryObject<Block> white_futon =B("white_futon","n",-1,() -> {return new FutonBlock(DyeColor.WHITE,BlockBehaviour.Properties.of(Material.WOOL, MaterialColor.WOOL).sound(SoundType.WOOL).strength(0.3F, 10.0F));});
    public static final RegistryObject<Block> orange_futon =B("orange_futon","n",-1,() -> {return new FutonBlock(DyeColor.ORANGE,BlockBehaviour.Properties.of(Material.WOOL, MaterialColor.WOOL).sound(SoundType.WOOL).strength(0.3F, 10.0F));});
    public static final RegistryObject<Block> magenta_futon =B("magenta_futon","n",-1,() -> {return new FutonBlock(DyeColor.MAGENTA,BlockBehaviour.Properties.of(Material.WOOL, MaterialColor.WOOL).sound(SoundType.WOOL).strength(0.3F, 10.0F));});
    public static final RegistryObject<Block> light_blue_futon =B("light_blue_futon","n",-1,() -> {return new FutonBlock(DyeColor.LIGHT_BLUE,BlockBehaviour.Properties.of(Material.WOOL, MaterialColor.WOOL).sound(SoundType.WOOL).strength(0.3F, 10.0F));});
    public static final RegistryObject<Block> yellow_futon =B("yellow_futon","n",-1,() -> {return new FutonBlock(DyeColor.YELLOW,BlockBehaviour.Properties.of(Material.WOOL, MaterialColor.WOOL).sound(SoundType.WOOL).strength(0.3F, 10.0F));});
    public static final RegistryObject<Block> lime_futon =B("lime_futon","n",-1,() -> {return new FutonBlock(DyeColor.LIME,BlockBehaviour.Properties.of(Material.WOOL, MaterialColor.WOOL).sound(SoundType.WOOL).strength(0.3F, 10.0F));});
    public static final RegistryObject<Block> pink_futon =B("pink_futon","n",-1,() -> {return new FutonBlock(DyeColor.PINK,BlockBehaviour.Properties.of(Material.WOOL, MaterialColor.WOOL).sound(SoundType.WOOL).strength(0.3F, 10.0F));});
    public static final RegistryObject<Block> gray_futon =B("gray_futon","n",-1,() -> {return new FutonBlock(DyeColor.GRAY,BlockBehaviour.Properties.of(Material.WOOL, MaterialColor.WOOL).sound(SoundType.WOOL).strength(0.3F, 10.0F));});
    public static final RegistryObject<Block> light_gray_futon =B("light_gray_futon","n",-1,() -> {return new FutonBlock(DyeColor.LIGHT_GRAY,BlockBehaviour.Properties.of(Material.WOOL, MaterialColor.WOOL).sound(SoundType.WOOL).strength(0.3F, 10.0F));});
    public static final RegistryObject<Block> cyan_futon =B("cyan_futon","n",-1,() -> {return new FutonBlock(DyeColor.CYAN,BlockBehaviour.Properties.of(Material.WOOL, MaterialColor.WOOL).sound(SoundType.WOOL).strength(0.3F, 10.0F));});
    public static final RegistryObject<Block> purple_futon =B("purple_futon","n",-1,() -> {return new FutonBlock(DyeColor.PURPLE,BlockBehaviour.Properties.of(Material.WOOL, MaterialColor.WOOL).sound(SoundType.WOOL).strength(0.3F, 10.0F));});
    public static final RegistryObject<Block> blue_futon =B("blue_futon","n",-1,() -> {return new FutonBlock(DyeColor.BLUE,BlockBehaviour.Properties.of(Material.WOOL, MaterialColor.WOOL).sound(SoundType.WOOL).strength(0.3F, 10.0F));});
    public static final RegistryObject<Block> brown_futon =B("brown_futon","n",-1,() -> {return new FutonBlock(DyeColor.BROWN,BlockBehaviour.Properties.of(Material.WOOL, MaterialColor.WOOL).sound(SoundType.WOOL).strength(0.3F, 10.0F));});
    public static final RegistryObject<Block> green_futon =B("green_futon","n",-1,() -> {return new FutonBlock(DyeColor.GREEN,BlockBehaviour.Properties.of(Material.WOOL, MaterialColor.WOOL).sound(SoundType.WOOL).strength(0.3F, 10.0F));});
    public static final RegistryObject<Block> red_futon =B("red_futon","n",-1,() -> {return new FutonBlock(DyeColor.RED,BlockBehaviour.Properties.of(Material.WOOL, MaterialColor.WOOL).sound(SoundType.WOOL).strength(0.3F, 10.0F));});
    public static final RegistryObject<Block> black_futon =B("black_futon","n",-1,() -> {return new FutonBlock(DyeColor.BLACK,BlockBehaviour.Properties.of(Material.WOOL, MaterialColor.WOOL).sound(SoundType.WOOL).strength(0.3F, 10.0F));});
    public static final RegistryObject<Block> japanese_timber_bamboo =B("japanese_timber_bamboo","a",-1,() -> {return new JapaneseTimberBambooBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.GRASS).sound(SoundType.BAMBOO).strength(0.5F, 10.0F).noOcclusion().randomTicks().dynamicShape());});
    public static final RegistryObject<Block> bamboo_block =B("bamboo_block","a",-1,() -> {return new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.BAMBOO).strength(0.5F, 10.0F));});
    public static final RegistryObject<Block> bamboo_slab =B("bamboo_slab","a",-1,() -> {return new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.BAMBOO).strength(0.5F, 10.0F));});
    public static final RegistryObject<Block> bamboo_stairs =B("bamboo_stairs","a",-1,() -> {return new StairBlock(bamboo_block.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.BAMBOO).strength(0.5F, 10.0F));});
    public static final RegistryObject<Block> bamboo_wall =B("bamboo_wall","a",-1,() -> {return new IronBarsBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.BAMBOO).strength(0.5F, 10.0F).noOcclusion());});
    public static final RegistryObject<Item> bamboo_charcoal =I("bamboo_charcoal");
    public static final RegistryObject<Block> bamboo_charcoal_block =B("bamboo_charcoal_block","a",-1,() -> {return new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BLACK).sound(SoundType.BAMBOO).strength(0.5F, 10.0F));});
    public static final RegistryObject<Block> tawara =B("tawara","h",-1,() -> {return new HorizonalRotateBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.TERRACOTTA_YELLOW).strength(0.2F, 3.0F).sound(SoundType.GRASS));});
    public static final RegistryObject<Block> paddy_field =B("paddy_field","s",-1,() -> {return new FarmBlock(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.WATER).strength(0.6F, 3.0F).sound(SoundType.GRAVEL).isViewBlocking(ItemAndBlockRegister::always).isSuffocating(ItemAndBlockRegister::always));});
    public static final RegistryObject<Block> senbakoki =B("senbakoki","a",-1,() -> {return new SenbakokiBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(0.6F, 10.0F).sound(SoundType.WOOD));});
    public static final RegistryObject<Block> dirt_furnace =B("dirt_furnace","s",-1,() -> {return new DirtFurnaceBlock(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.DIRT).strength(1F, 10.0F).sound(SoundType.GRAVEL));});
    public static final RegistryObject<Block> rice_cauldron =B("rice_cauldron","p",-1,() -> {return new RiceCauldronBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_BLACK).strength(1F, 10.0F).sound(SoundType.METAL).requiresCorrectToolForDrops());});
    public static final RegistryObject<Block> rice_crop =B("rice_crop","h",-1,() -> {return new RiceCropBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.GRASS).sound(SoundType.GRASS).randomTicks().noCollission().instabreak());});
    public static final RegistryObject<Block> azuki_crop =B("azuki_crop","h",-1,() -> {return new UrushiCropBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.GRASS).sound(SoundType.GRASS).randomTicks().noCollission().instabreak());});
    public static final RegistryObject<Block> soy_crop =B("soy_crop","h",-1,() -> {return new UrushiCropBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.GRASS).sound(SoundType.GRASS).randomTicks().noCollission().instabreak());});
    public static final RegistryObject<Item> raw_rice =ITEMS.register("raw_rice", () -> {return new ToolchipItem("rawrice",(new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> rice =ITEMS.register("rice", () -> {return new PlaceableFoodItem(()->EntityRegister.RiceFoodEntity.get(),(new Item.Properties()).food(FoodUrushi.Rice).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> tkg =ITEMS.register("tkg", () -> {return new PlaceableFoodItem(()->EntityRegister.TKGFoodEntity.get(),(new Item.Properties()).food(FoodUrushi.TKG).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> sekihan =ITEMS.register("sekihan", () -> {return new PlaceableFoodItem(()->EntityRegister.SekihanFoodEntity.get(),(new Item.Properties()).food(FoodUrushi.Sekihan).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> gyudon =ITEMS.register("gyudon", () -> {return new PlaceableFoodItem(()->EntityRegister.GyudonFoodEntity.get(),(new Item.Properties()).food(FoodUrushi.Gyudon).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> butadon =ITEMS.register("butadon", () -> {return new PlaceableFoodItem(()->EntityRegister.ButadonFoodEntity.get(),(new Item.Properties()).food(FoodUrushi.Butadon).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> karaage =ITEMS.register("karaage", () -> {return new PlaceableFoodItem(()->EntityRegister.KaraageFoodEntity.get(),(new Item.Properties()).food(FoodUrushi.Karaage).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> tofu =ITEMS.register("tofu", () -> {return new PlaceableFoodItem(()->EntityRegister.TofuFoodEntity.get(),(new Item.Properties()).food(FoodUrushi.Tofu).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> aburaage =ITEMS.register("abura_age", () -> {return new PlaceableFoodItem(()->EntityRegister.AburaageFoodEntity.get(),(new Item.Properties()).food(FoodUrushi.Aburaage).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> noodle_knife =ITEMS.register("noodle_knife", () -> {return new NoodleKnifeItem((new Item.Properties()).tab(ModCoreUrushi.UrushiTab).durability(1024));});
    public static final RegistryObject<Block> dough =B("dough","n",-1,() -> {return new DoughBlock(BlockBehaviour.Properties.of(Material.CLAY, MaterialColor.WOOL).instabreak().sound(SoundType.WOOD));});
    public static final RegistryObject<Block> udon =B("udon","n",-1,() -> {return new UdonBlock(BlockBehaviour.Properties.of(Material.CLAY, MaterialColor.WOOL).instabreak().sound(SoundType.WOOD));});
    public static final RegistryObject<Item> kitsune_udon =ITEMS.register("kitsune_udon", () -> {return new PlaceableFoodItem(()->EntityRegister.KitsuneUdonFoodEntity.get(),(new Item.Properties()).food(FoodUrushi.KitsuneUdon).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Block> salt_and_sand =B("salt_and_sand","s",-1,() -> {return new SaltAndSandBlock(BlockBehaviour.Properties.of(Material.SAND, MaterialColor.SAND).strength(1F, 10F).sound(SoundType.SAND));});
    public static final RegistryObject<Item> salt =ITEMS.register("salt", () -> {return new ToolchipItem("salt",(new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> kanten_powder =I("kanten_powder");
    public static final RegistryObject<Item> wood_chip =I("wood_chip");
    public static final RegistryObject<Block> ironsand_ore =B("ironsand_ore","s",1,() -> {return new FallingBlock(BlockBehaviour.Properties.of(Material.SAND, MaterialColor.SAND).strength(1F, 10.0F).sound(SoundType.SAND));});
    public static final RegistryObject<Item> ironsand =I("ironsand");
    public static final RegistryObject<Item> hammer =ITEMS.register("hammer", () -> {return new HammerItem((new Item.Properties()).tab(ModCoreUrushi.UrushiTab).durability(1024));});
    public static final RegistryObject<Block> normal_iron_ingot_9 =BIron("normal_iron_ingot_9",() -> {return new IronIngotBlock(null,BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_YELLOW).instabreak().sound(SoundType.ANVIL));});
    public static final RegistryObject<Block> normal_iron_ingot_8 =BIron("normal_iron_ingot_8",() -> {return new IronIngotBlock(normal_iron_ingot_9.get(),BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_YELLOW).instabreak().sound(SoundType.ANVIL));});
    public static final RegistryObject<Block> normal_iron_ingot_7 =BIron("normal_iron_ingot_7",() -> {return new IronIngotBlock(normal_iron_ingot_8.get(),BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_YELLOW).instabreak().sound(SoundType.ANVIL));});
    public static final RegistryObject<Block> normal_iron_ingot_6 =BIron("normal_iron_ingot_6",() -> {return new IronIngotBlock(normal_iron_ingot_7.get(),BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_YELLOW).instabreak().sound(SoundType.ANVIL));});
    public static final RegistryObject<Block> normal_iron_ingot_5 =BIron("normal_iron_ingot_5",() -> {return new IronIngotBlock(normal_iron_ingot_6.get(),BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_YELLOW).instabreak().sound(SoundType.ANVIL));});
    public static final RegistryObject<Block> normal_iron_ingot_4 =BIron("normal_iron_ingot_4",() -> {return new IronIngotBlock(normal_iron_ingot_5.get(),BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_YELLOW).instabreak().sound(SoundType.ANVIL));});
    public static final RegistryObject<Block> normal_iron_ingot_3 =BIron("normal_iron_ingot_3",() -> {return new IronIngotBlock(normal_iron_ingot_4.get(),BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_YELLOW).instabreak().sound(SoundType.ANVIL));});
    public static final RegistryObject<Block> normal_iron_ingot_2 =BIron("normal_iron_ingot_2",() -> {return new IronIngotBlock(normal_iron_ingot_3.get(),BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_YELLOW).instabreak().sound(SoundType.ANVIL));});
    public static final RegistryObject<Block> normal_iron_ingot_1 =BIron("normal_iron_ingot_1",() -> {return new IronIngotBlock(normal_iron_ingot_2.get(),BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_YELLOW).instabreak().sound(SoundType.ANVIL));});
    public static final RegistryObject<Block> normal_iron_ingot_0 =BIron("normal_iron_ingot_0",() -> {return new IronIngotBlock(normal_iron_ingot_1.get(),BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_YELLOW).instabreak().sound(SoundType.ANVIL));});
    public static final RegistryObject<Item> normal_katana_blade_tier_10 =I("normal_katana_blade_tier_10");
    public static final RegistryObject<Item> normal_katana_blade_tier_9 =I("normal_katana_blade_tier_9");
    public static final RegistryObject<Item> normal_katana_blade_tier_8 =I("normal_katana_blade_tier_8");
    public static final RegistryObject<Item> normal_katana_blade_tier_7 =I("normal_katana_blade_tier_7");
    public static final RegistryObject<Item> normal_katana_blade_tier_6 =I("normal_katana_blade_tier_6");
    public static final RegistryObject<Item> normal_katana_blade_tier_5 =I("normal_katana_blade_tier_5");
    public static final RegistryObject<Item> normal_katana_blade_tier_4 =I("normal_katana_blade_tier_4");
    public static final RegistryObject<Item> normal_katana_blade_tier_3 =I("normal_katana_blade_tier_3");
    public static final RegistryObject<Item> normal_katana_blade_tier_2 =I("normal_katana_blade_tier_2");
    public static final RegistryObject<Item> normal_katana_blade_tier_1 =I("normal_katana_blade_tier_1");
    public static final RegistryObject<Item> normal_hot_katana_blade_tier_10 =ITEMS.register("normal_hot_katana_blade_tier_10", () -> {return new HotKatanaBladeItem(normal_katana_blade_tier_10.get(),(new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> normal_hot_katana_blade_tier_9 =ITEMS.register("normal_hot_katana_blade_tier_9", () -> {return new HotKatanaBladeItem(normal_katana_blade_tier_9.get(),(new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> normal_hot_katana_blade_tier_8 =ITEMS.register("normal_hot_katana_blade_tier_8", () -> {return new HotKatanaBladeItem(normal_katana_blade_tier_8.get(),(new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> normal_hot_katana_blade_tier_7 =ITEMS.register("normal_hot_katana_blade_tier_7", () -> {return new HotKatanaBladeItem(normal_katana_blade_tier_7.get(),(new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> normal_hot_katana_blade_tier_6 =ITEMS.register("normal_hot_katana_blade_tier_6", () -> {return new HotKatanaBladeItem(normal_katana_blade_tier_6.get(),(new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> normal_hot_katana_blade_tier_5 =ITEMS.register("normal_hot_katana_blade_tier_5", () -> {return new HotKatanaBladeItem(normal_katana_blade_tier_5.get(),(new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> normal_hot_katana_blade_tier_4 =ITEMS.register("normal_hot_katana_blade_tier_4", () -> {return new HotKatanaBladeItem(normal_katana_blade_tier_4.get(),(new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> normal_hot_katana_blade_tier_3 =ITEMS.register("normal_hot_katana_blade_tier_3", () -> {return new HotKatanaBladeItem(normal_katana_blade_tier_3.get(),(new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> normal_hot_katana_blade_tier_2 =ITEMS.register("normal_hot_katana_blade_tier_2", () -> {return new HotKatanaBladeItem(normal_katana_blade_tier_2.get(),(new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> normal_hot_katana_blade_tier_1 =ITEMS.register("normal_hot_katana_blade_tier_1", () -> {return new HotKatanaBladeItem(normal_katana_blade_tier_1.get(),(new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> normal_katana_tier_10 =ITEMS.register("normal_katana_tier_10", () -> {return new NormalKatanaItem(Tiers.IRON,18,-2.9F,(new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> normal_katana_tier_9 =ITEMS.register("normal_katana_tier_9", () -> {return new NormalKatanaItem(Tiers.IRON,16,-2.9F,(new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> normal_katana_tier_8 =ITEMS.register("normal_katana_tier_8", () -> {return new NormalKatanaItem(Tiers.IRON,14,-2.9F,(new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> normal_katana_tier_7 =ITEMS.register("normal_katana_tier_7", () -> {return new NormalKatanaItem(Tiers.IRON,12,-2.9F,(new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> normal_katana_tier_6 =ITEMS.register("normal_katana_tier_6", () -> {return new NormalKatanaItem(Tiers.IRON,10,-2.9F,(new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> normal_katana_tier_5 =ITEMS.register("normal_katana_tier_5", () -> {return new NormalKatanaItem(Tiers.IRON,8,-2.9F,(new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> normal_katana_tier_4 =ITEMS.register("normal_katana_tier_4", () -> {return new NormalKatanaItem(Tiers.IRON,6,-2.9F,(new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> normal_katana_tier_3 =ITEMS.register("normal_katana_tier_3", () -> {return new NormalKatanaItem(Tiers.IRON,4,-2.9F,(new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> normal_katana_tier_2 =ITEMS.register("normal_katana_tier_2", () -> {return new NormalKatanaItem(Tiers.IRON,2,-2.9F,(new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> normal_katana_tier_1 =ITEMS.register("normal_katana_tier_1", () -> {return new NormalKatanaItem(Tiers.IRON,0,-2.9F,(new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Block> rope =B("rope","a",-1,() -> {return new RopeBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.LADDER).strength(0.1F, 10.0F));});
    public static final RegistryObject<Item> climbing_rope =ITEMS.register("climbing_rope", () -> {return new ClimbingRopesItem((new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> open_wagasa =ITEMS.register("open_wagasa", () -> {return new WagasaItem(true,(new Item.Properties()).tab(ModCoreUrushi.UrushiTab).stacksTo(1));});
    public static final RegistryObject<Item> close_wagasa =ITEMS.register("close_wagasa", () -> {return new WagasaItem(false,(new Item.Properties()).stacksTo(1));});
    public static final RegistryObject<LiquidBlock> HotSpringBlock =BLOCKS.register("hot_spring_water",() -> {return new HotSpringWaterBlock(()->FluidRegister.HotSpringStill.get(),BlockBehaviour.Properties.of(Material.WATER, MaterialColor.WATER).noDrops().strength(1000F).noCollission());});
    public static final RegistryObject<Item> hot_spring_bucket =ITEMS.register("hot_spring_water_bucket", () -> {return new BucketItem(FluidRegister.HotSpringStill,(new Item.Properties()).tab(ModCoreUrushi.UrushiTab).stacksTo(1));});
    //public static final RegistryObject<Block> hot_spring_source =B("hot_spring_source","p",0,() -> {return new HotSpringSourceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F).randomTicks());});
    public static final RegistryObject<Item> vegetable_oil =I("vegetable_oil");
    public static final RegistryObject<Block> oil_extractor =B("oil_extractor","a",-1,() -> {return new OilExtractorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.LADDER).strength(1F, 3.0F));});
    public static final RegistryObject<Block> fryer =B("fryer","p",0,() -> {return new FryerBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.WOOL).sound(SoundType.METAL).strength(1F, 10.0F).requiresCorrectToolForDrops().dynamicShape());});


    private static boolean never(BlockState state, BlockGetter blockGetter, BlockPos blockPos) {
        return false;
    }

    private static boolean never(BlockState state, BlockGetter blockGetter, BlockPos blockPos, EntityType<?> entityType) {
   return false;
    }
    private static boolean always(BlockState p_50775_, BlockGetter p_50776_, BlockPos p_50777_) {
        return true;
    }

    private static RotatedPillarBlock log(MaterialColor p_50789_, MaterialColor p_50790_) {
        return new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, (p_152624_) -> {
            return p_152624_.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? p_50789_ : p_50790_;
        }).strength(2.0F).sound(SoundType.WOOD));
    }
    private static RotatedPillarBlock chiselablelog(MaterialColor p_50789_, MaterialColor p_50790_) {
        return new LacquerLogBlock(BlockBehaviour.Properties.of(Material.WOOD, (p_152624_) -> {
            return p_152624_.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? p_50789_ : p_50790_;
        }).strength(2.0F).sound(SoundType.WOOD));
    }
    private static RotatedPillarBlock strippablelog(Block block,int i,MaterialColor p_50789_, MaterialColor p_50790_) {
        return new StrippableLogBlock(block,i,BlockBehaviour.Properties.of(Material.WOOD, (p_152624_) -> {
            return p_152624_.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? p_50789_ : p_50790_;
        }).strength(2.0F).sound(SoundType.WOOD));
    }
    private static LeavesBlock leaves(MaterialColor color,SoundType p_152615_) {
        return new LeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES,color).strength(0.2F).randomTicks().sound(p_152615_).noOcclusion().isValidSpawn(ItemAndBlockRegister::never).isSuffocating(ItemAndBlockRegister::never).isViewBlocking(ItemAndBlockRegister::never));
    }
    private static CutoutLeavesBlock cutouteaves(MaterialColor color,SoundType p_152615_) {
        return new CutoutLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES,color).strength(0.2F).randomTicks().sound(p_152615_).noOcclusion().isValidSpawn(ItemAndBlockRegister::never).isSuffocating(ItemAndBlockRegister::never).isViewBlocking(ItemAndBlockRegister::never));
    }
    private static CutoutLeavesBlock glowingleaves(MaterialColor color,SoundType p_152615_) {
        return new CutoutLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES,color).strength(0.2F).randomTicks().sound(p_152615_).noOcclusion().isValidSpawn(ItemAndBlockRegister::never).isSuffocating(ItemAndBlockRegister::never).isViewBlocking(ItemAndBlockRegister::never).lightLevel((p_235470_0_) -> {return 15;}));
    }
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
        BLOCKS.register(eventBus);
    }
    private static <T extends Item> RegistryObject<T> I(String name) {
        RegistryObject<Item> object = ITEMS.register(name, ()-> {
            return new Item((new Item.Properties()).tab(ModCoreUrushi.UrushiTab));
        });
        return (RegistryObject<T>) object;
    }
    private static <T extends Block> RegistryObject<T> B(String name,String tool,int l, Supplier<T > sup) {
        RegistryObject<T> object = BLOCKS.register(name, sup);
        ITEMS.register(name,() -> {return new BlockItem( Objects.requireNonNull(object.get()), (new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
if(ModCoreUrushi.isDebug) {
    if (tool == "p") {
        ModCoreUrushi.pickaxeList.add(ModCoreUrushi.ModID + ":" + name);
    } else if (tool == "a") {
        ModCoreUrushi.axeList.add(ModCoreUrushi.ModID + ":" + name);
    } else if (tool == "s") {
        ModCoreUrushi.shovelList.add(ModCoreUrushi.ModID + ":" + name);
    } else if (tool == "h") {
        ModCoreUrushi.hoeList.add(ModCoreUrushi.ModID + ":" + name);
    }

    if (l == 0) {
        ModCoreUrushi.woodenToolList.add("urushi:" + name);
    } else if (l == 1) {
        ModCoreUrushi.stoneToolList.add("urushi:" + name);
    } else if (l == 2) {
        ModCoreUrushi.ironToolList.add("urushi:" + name);
    } else if (l == 3) {
        ModCoreUrushi.goldenToolList.add("urushi:" + name);
    } else if (l == 4) {
        ModCoreUrushi.diamondToolList.add("urushi:" + name);
    } else if (l == 5) {
        ModCoreUrushi.netheriteToolList.add("urushi:" + name);
    }
}
        return object;
    }

    private static <T extends Block> RegistryObject<T> BIron(String name, Supplier<T > sup) {
        RegistryObject<T> object = BLOCKS.register(name, sup);
        ITEMS.register(name,() -> {return new IronIngotItem( Objects.requireNonNull(object.get()), (new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
        if(ModCoreUrushi.isDebug) {
            ModCoreUrushi.pickaxeList.add(ModCoreUrushi.ModID + ":" + name);
        }
        return object;
    }


}
