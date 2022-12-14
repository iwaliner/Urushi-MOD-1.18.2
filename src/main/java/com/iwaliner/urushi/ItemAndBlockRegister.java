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
    public static final RegistryObject<Block> japanese_cedar_framed_plaster =B("japanese_cedar_framed_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).sound(SoundType.STONE).strength(1.0F, 10.0F));});
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
    public static final RegistryObject<Block> copper_kawara_block =B("copper_kawara_block","p",0,() -> {return new HorizonalRotateBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.DIRT).sound(SoundType.COPPER).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> copper_kawara_slab =B("copper_kawara_slab","p",0,() -> {return new HorizonalRotateSlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.DIRT).sound(SoundType.COPPER).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> copper_kawara_stairs =B("copper_kawara_stairs","p",0,() -> {return new StairBlock(copper_kawara_block.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.STONE, MaterialColor.DIRT).sound(SoundType.COPPER).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> copper_kawara_wall =B("copper_kawara_wall","p",0,() -> {return new WallBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.DIRT).sound(SoundType.COPPER).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> copper_kawara_roof_45 =B("copper_kawara_roof_45","p",0,() -> {return new Roof45Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.DIRT).sound(SoundType.COPPER).requiresCorrectToolForDrops().strength(1.0F, 10.0F).noCollission());});
    public static final RegistryObject<Block> copper_kawara_roof_225 =B("copper_kawara_roof_225","p",0,() -> {return new Roof225Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.DIRT).sound(SoundType.COPPER).requiresCorrectToolForDrops().strength(1.0F, 10.0F).noCollission());});
    public static final RegistryObject<Item> cupric_oxide_kawara =I("cupric_oxide_kawara");
    public static final RegistryObject<Block> cupric_oxide_kawara_block =B("cupric_oxide_kawara_block","p",0,() -> {return new HorizonalRotateBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.EMERALD).sound(SoundType.COPPER).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> cupric_oxide_kawara_slab =B("cupric_oxide_kawara_slab","p",0,() -> {return new HorizonalRotateSlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.EMERALD).sound(SoundType.COPPER).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> cupric_oxide_kawara_stairs =B("cupric_oxide_kawara_stairs","p",0,() -> {return new StairBlock(cupric_oxide_kawara_block.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.STONE, MaterialColor.EMERALD).sound(SoundType.COPPER).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> cupric_oxide_kawara_wall =B("cupric_oxide_kawara_wall","p",0,() -> {return new WallBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.EMERALD).sound(SoundType.COPPER).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> cupric_oxide_kawara_roof_45 =B("cupric_oxide_kawara_roof_45","p",0,() -> {return new Roof45Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.EMERALD).sound(SoundType.COPPER).requiresCorrectToolForDrops().strength(1.0F, 10.0F).noCollission());});
    public static final RegistryObject<Block> cupric_oxide_kawara_roof_225 =B("cupric_oxide_kawara_roof_225","p",0,() -> {return new Roof225Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.EMERALD).sound(SoundType.COPPER).requiresCorrectToolForDrops().strength(1.0F, 10.0F).noCollission());});
    public static final RegistryObject<Block> wattle_and_daub =B("wattle_and_daub","s",-1,() -> {return new Block(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.DIRT).strength(0.5F, 2.0F).sound(SoundType.GRASS));});
    public static final RegistryObject<Block> wattle_and_daub_slab =B("wattle_and_daub_slab","s",-1,() -> {return new SlabBlock(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.DIRT).strength(0.5F, 2.0F).sound(SoundType.GRASS));});
    public static final RegistryObject<Block> wattle_and_daub_stairs =B("wattle_and_daub_stairs","s",-1,() -> {return new StairBlock(wattle_and_daub.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.DIRT).strength(0.5F, 2.0F).sound(SoundType.GRASS));});
    public static final RegistryObject<Block> oak_framed_wattle_and_daub =B("oak_framed_wattle_and_daub","s",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.DIRT).sound(SoundType.GRASS).strength(0.5F, 2.0F));});
    public static final RegistryObject<Block> spruce_framed_wattle_and_daub =B("spruce_framed_wattle_and_daub","s",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.DIRT).sound(SoundType.GRASS).strength(0.5F, 2.0F));});
    public static final RegistryObject<Block> birch_framed_wattle_and_daub =B("birch_framed_wattle_and_daub","s",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.DIRT).sound(SoundType.GRASS).strength(0.5F, 2.0F));});
    public static final RegistryObject<Block> jungle_framed_wattle_and_daub =B("jungle_framed_wattle_and_daub","s",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.DIRT).sound(SoundType.GRASS).strength(0.5F, 2.0F));});
    public static final RegistryObject<Block> acacia_framed_wattle_and_daub =B("acacia_framed_wattle_and_daub","s",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.DIRT).sound(SoundType.GRASS).strength(0.5F, 2.0F));});
    public static final RegistryObject<Block> dark_oak_framed_wattle_and_daub =B("dark_oak_framed_wattle_and_daub","s",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.DIRT).sound(SoundType.GRASS).strength(0.5F, 2.0F));});
    public static final RegistryObject<Block> japanese_apricot_framed_wattle_and_daub =B("japanese_apricot_framed_wattle_and_daub","s",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.DIRT).sound(SoundType.GRASS).strength(0.5F, 2.0F));});
    public static final RegistryObject<Block> sakura_framed_wattle_and_daub =B("sakura_framed_wattle_and_daub","s",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.DIRT).sound(SoundType.GRASS).strength(0.5F, 2.0F));});
    public static final RegistryObject<Block> cypress_framed_wattle_and_daub =B("cypress_framed_wattle_and_daub","s",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.DIRT).sound(SoundType.GRASS).strength(0.5F, 2.0F));});
    public static final RegistryObject<Block> japanese_cedar_framed_wattle_and_daub =B("japanese_cedar_framed_wattle_and_daub","s",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.DIRT).sound(SoundType.GRASS).strength(0.5F, 2.0F));});
    public static final RegistryObject<Block> red_urushi_framed_wattle_and_daub =B("red_urushi_framed_wattle_and_daub","s",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.DIRT).sound(SoundType.GRASS).strength(0.5F, 2.0F));});
    public static final RegistryObject<Block> black_urushi_framed_wattle_and_daub =B("black_urushi_framed_wattle_and_daub","s",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.DIRT).sound(SoundType.GRASS).strength(0.5F, 2.0F));});
    public static final RegistryObject<Block> sand_coast =B("sand_coast","s",-1,() -> {return new Block(BlockBehaviour.Properties.of(Material.SAND, MaterialColor.SAND).strength(0.5F, 3.0F).sound(SoundType.SAND));});
    public static final RegistryObject<Block> oak_framed_sand_coast =B("oak_framed_sand_coast","s",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of(Material.SAND, MaterialColor.SAND).sound(SoundType.SAND).strength(0.5F, 2.0F));});
    public static final RegistryObject<Block> spruce_framed_sand_coast =B("spruce_framed_sand_coast","s",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of(Material.SAND, MaterialColor.SAND).sound(SoundType.SAND).strength(0.5F, 2.0F));});
    public static final RegistryObject<Block> birch_framed_sand_coast =B("birch_framed_sand_coast","s",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of(Material.SAND, MaterialColor.SAND).sound(SoundType.SAND).strength(0.5F, 2.0F));});
    public static final RegistryObject<Block> jungle_framed_sand_coast =B("jungle_framed_sand_coast","s",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of(Material.SAND, MaterialColor.SAND).sound(SoundType.SAND).strength(0.5F, 2.0F));});
    public static final RegistryObject<Block> acacia_framed_sand_coast =B("acacia_framed_sand_coast","s",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of(Material.SAND, MaterialColor.SAND).sound(SoundType.SAND).strength(0.5F, 2.0F));});
    public static final RegistryObject<Block> dark_oak_framed_sand_coast =B("dark_oak_framed_sand_coast","s",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of(Material.SAND, MaterialColor.SAND).sound(SoundType.SAND).strength(0.5F, 2.0F));});
    public static final RegistryObject<Block> japanese_apricot_framed_sand_coast =B("japanese_apricot_framed_sand_coast","s",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of(Material.SAND, MaterialColor.SAND).sound(SoundType.SAND).strength(0.5F, 2.0F));});
    public static final RegistryObject<Block> sakura_framed_sand_coast =B("sakura_framed_sand_coast","s",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of(Material.SAND, MaterialColor.SAND).sound(SoundType.SAND).strength(0.5F, 2.0F));});
    public static final RegistryObject<Block> cypress_framed_sand_coast =B("cypress_framed_sand_coast","s",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of(Material.SAND, MaterialColor.SAND).sound(SoundType.SAND).strength(0.5F, 2.0F));});
    public static final RegistryObject<Block> japanese_cedar_framed_sand_coast =B("japanese_cedar_framed_sand_coast","s",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of(Material.SAND, MaterialColor.SAND).sound(SoundType.SAND).strength(0.5F, 2.0F));});
    public static final RegistryObject<Block> red_urushi_framed_sand_coast =B("red_urushi_framed_sand_coast","s",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of(Material.SAND, MaterialColor.SAND).sound(SoundType.SAND).strength(0.5F, 2.0F));});
    public static final RegistryObject<Block> black_urushi_framed_sand_coast =B("black_urushi_framed_sand_coast","s",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of(Material.SAND, MaterialColor.SAND).sound(SoundType.SAND).strength(0.5F, 2.0F));});
    public static final RegistryObject<Block> thatched_block =B("thatched_block","h",-1,() -> {return new FlammableBlock(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.TERRACOTTA_YELLOW).strength(0.2F, 3.0F).sound(SoundType.GRASS));});
    public static final RegistryObject<Block> thatched_slab =B("thatched_slab","h",-1,() -> {return new FlammableSlabBlock(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.TERRACOTTA_YELLOW).strength(0.2F, 3.0F).sound(SoundType.GRASS));});
    public static final RegistryObject<Block> thatched_stairs =B("thatched_stairs","h",-1,() -> {return new FlammableStairBlock(thatched_block.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.TERRACOTTA_YELLOW).strength(0.2F, 3.0F).sound(SoundType.GRASS));});
    public static final RegistryObject<Block> thatched_roof_45 =B("thatched_roof_45","h",-1,() -> {return new FlammableRoof45Block(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.TERRACOTTA_YELLOW).strength(0.2F, 3.0F).sound(SoundType.GRASS));});
    public static final RegistryObject<Block> thatched_roof_225 =B("thatched_roof_225","h",-1,() -> {return new FlammableRoof225Block(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.TERRACOTTA_YELLOW).strength(0.2F, 3.0F).sound(SoundType.GRASS));});
    public static final RegistryObject<Block> hiwadabuki_block =B("hiwadabuki_block","h",-1,() -> {return new FlammableBlock(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.TERRACOTTA_BLACK).strength(0.2F, 3.0F).sound(SoundType.GRASS));});
    public static final RegistryObject<Block> hiwadabuki_slab =B("hiwadabuki_slab","h",-1,() -> {return new FlammableSlabBlock(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.TERRACOTTA_BLACK).strength(0.2F, 3.0F).sound(SoundType.GRASS));});
    public static final RegistryObject<Block> hiwadabuki_stairs =B("hiwadabuki_stairs","h",-1,() -> {return new FlammableStairBlock(thatched_block.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.TERRACOTTA_BLACK).strength(0.2F, 3.0F).sound(SoundType.GRASS));});
    public static final RegistryObject<Block> hiwadabuki_roof_45 =B("hiwadabuki_roof_45","h",-1,() -> {return new FlammableRoof45Block(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.TERRACOTTA_BLACK).strength(0.2F, 3.0F).sound(SoundType.GRASS));});
    public static final RegistryObject<Block> hiwadabuki_roof_225 =B("hiwadabuki_roof_225","h",-1,() -> {return new FlammableRoof225Block(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.TERRACOTTA_BLACK).strength(0.2F, 3.0F).sound(SoundType.GRASS));});
    public static final RegistryObject<Block> green_tatami =B("green_tatami","h",-1,() -> {return new FlammableRotatedPillarBlock(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.GRASS).strength(0.2F, 10.0F).sound(SoundType.GRASS));});
    public static final RegistryObject<Block> green_tatami_carpet =B("green_tatami_carpet","h",-1,() -> {return new FlammableTwoDirectionShapedBlock(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D,BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.GRASS).strength(0.2F, 10.0F).sound(SoundType.GRASS).noCollission());});
    public static final RegistryObject<Block> brown_tatami =B("brown_tatami","h",-1,() -> {return new FlammableRotatedPillarBlock(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.GRASS).strength(0.2F, 10.0F).sound(SoundType.GRASS));});
    public static final RegistryObject<Block> brown_tatami_carpet =B("brown_tatami_carpet","h",-1,() -> {return new FlammableTwoDirectionShapedBlock(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D,BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.GRASS).strength(0.2F, 10.0F).sound(SoundType.GRASS).noOcclusion());});
    public static final RegistryObject<Block> goldfish_bowl =B("goldfish_bowl","p",-1,() -> {return new Block(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.WATER).strength(0.2F, 10.0F).sound(SoundType.GLASS).noOcclusion());});
    public static final RegistryObject<Block> stone_trapdoor =B("stone_trapdoor","p",-1,() -> {return new TrapDoorBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).sound(SoundType.STONE).strength(1.0F, 10.0F).noOcclusion().isValidSpawn(ItemAndBlockRegister::never).requiresCorrectToolForDrops());});
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
    public static final RegistryObject<Block> smooth_oak_planks =BW("smooth_oak_planks","a",-1,() -> {return new FlammableBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_oak_slab =BW("smooth_oak_slab","a",-1,() -> {return new FlammableSlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_oak_stairs =BW("smooth_oak_stairs","a",-1,() -> {return new FlammableStairBlock(smooth_oak_planks.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> oak_parapet =BW("oak_parapet","a",-1,() -> {return new ParapetBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> oak_bars =BW("oak_bars","a",-1,() -> {return new BarsBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> oak_fushiranma =BW("oak_fushiranma","a",-1,() -> {return new FushiranmaBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_spruce_planks =BW("smooth_spruce_planks","a",-1,() -> {return new FlammableBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.PODZOL).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_spruce_slab =BW("smooth_spruce_slab","a",-1,() -> {return new FlammableSlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.PODZOL).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_spruce_stairs =BW("smooth_spruce_stairs","a",-1,() -> {return new FlammableStairBlock(smooth_spruce_planks.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.PODZOL).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> spruce_parapet =BW("spruce_parapet","a",-1,() -> {return new ParapetBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.PODZOL).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> spruce_bars =BW("spruce_bars","a",-1,() -> {return new BarsBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.PODZOL).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> spruce_fushiranma =BW("spruce_fushiranma","a",-1,() -> {return new FushiranmaBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.PODZOL).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_birch_planks =BW("smooth_birch_planks","a",-1,() -> {return new FlammableBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_birch_slab =BW("smooth_birch_slab","a",-1,() -> {return new FlammableSlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_birch_stairs =BW("smooth_birch_stairs","a",-1,() -> {return new FlammableStairBlock(smooth_birch_planks.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> birch_parapet =BW("birch_parapet","a",-1,() -> {return new ParapetBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> birch_bars =BW("birch_bars","a",-1,() -> {return new BarsBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> birch_fushiranma =BW("birch_fushiranma","a",-1,() -> {return new FushiranmaBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_jungle_planks =BW("smooth_jungle_planks","a",-1,() -> {return new FlammableBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.DIRT).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_jungle_slab =BW("smooth_jungle_slab","a",-1,() -> {return new FlammableSlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.DIRT).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_jungle_stairs =BW("smooth_jungle_stairs","a",-1,() -> {return new FlammableStairBlock(smooth_jungle_planks.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.DIRT).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> jungle_parapet =BW("jungle_parapet","a",-1,() -> {return new ParapetBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.DIRT).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> jungle_bars =BW("jungle_bars","a",-1,() -> {return new BarsBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.DIRT).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> jungle_fushiranma =BW("jungle_fushiranma","a",-1,() -> {return new FushiranmaBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.DIRT).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_acacia_planks =BW("smooth_acacia_planks","a",-1,() -> {return new FlammableBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_acacia_slab =BW("smooth_acacia_slab","a",-1,() -> {return new FlammableSlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_acacia_stairs =BW("smooth_acacia_stairs","a",-1,() -> {return new FlammableStairBlock(smooth_acacia_planks.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> acacia_parapet =BW("acacia_parapet","a",-1,() -> {return new ParapetBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> acacia_bars =BW("acacia_bars","a",-1,() -> {return new BarsBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> acacia_fushiranma =BW("acacia_fushiranma","a",-1,() -> {return new FushiranmaBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_dark_oak_planks =BW("smooth_dark_oak_planks","a",-1,() -> {return new FlammableBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_dark_oak_slab =BW("smooth_dark_oak_slab","a",-1,() -> {return new FlammableSlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_dark_oak_stairs =BW("smooth_dark_oak_stairs","a",-1,() -> {return new FlammableStairBlock(smooth_dark_oak_planks.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> dark_oak_parapet =BW("dark_oak_parapet","a",-1,() -> {return new ParapetBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> dark_oak_bars =BW("dark_oak_bars","a",-1,() -> {return new BarsBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> dark_oak_fushiranma =BW("dark_oak_fushiranma","a",-1,() -> {return new FushiranmaBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> green_bars =BW("green_bars","a",-1,() -> {return new BarsBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_GREEN).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> red_sapling =BW("red_sapling","a",-1,() -> {return new FlammableSaplingBlock(new RedTreeGrower(),BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.COLOR_RED).sound(SoundType.GRASS).noCollission().instabreak().randomTicks());});
    public static final RegistryObject<Block> red_leaves =BW("red_leaves","h",-1,() -> {return cutouteaves(MaterialColor.COLOR_RED,SoundType.AZALEA_LEAVES);});
    public static final RegistryObject<Block> fallen_red_leaves =BW("fallen_red_leaves","h",-1,() -> {return new FallenLeavesBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_RED).strength(0.2F, 10.0F).sound(SoundType.AZALEA_LEAVES).noCollission());});
    public static final RegistryObject<Block> grass_block_with_fallen_red_leaves =BW("grass_block_with_fallen_red_leaves","s",-1,() -> {return new GrassBlock(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.COLOR_RED).strength(0.6F, 10.0F).randomTicks().sound(SoundType.GRASS));});
    public static final RegistryObject<Block> kakuriyo_grass_block_with_fallen_red_leaves =BW("kakuriyo_grass_block_with_fallen_red_leaves","s",-1,() -> {return new KakuriyoGrassBlock(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.COLOR_RED).strength(0.6F, 10.0F).randomTicks().sound(SoundType.GRASS));});
    public static final RegistryObject<Block> orange_sapling =BW("orange_sapling","a",-1,() -> {return new FlammableSaplingBlock(new OrangeTreeGrower(),BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.COLOR_ORANGE).sound(SoundType.GRASS).noCollission().instabreak().randomTicks());});
    public static final RegistryObject<Block> orange_leaves =BW("orange_leaves","h",-1,() -> {return cutouteaves(MaterialColor.COLOR_ORANGE,SoundType.AZALEA_LEAVES);});
    public static final RegistryObject<Block> fallen_orange_leaves =BW("fallen_orange_leaves","h",-1,() -> {return new FallenLeavesBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_ORANGE).strength(0.2F, 10.0F).sound(SoundType.AZALEA_LEAVES).noCollission());});
    public static final RegistryObject<Block> grass_block_with_fallen_orange_leaves =BW("grass_block_with_fallen_orange_leaves","s",-1,() -> {return new GrassBlock(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.COLOR_ORANGE).strength(0.6F, 10.0F).randomTicks().sound(SoundType.GRASS));});
    public static final RegistryObject<Block> kakuriyo_grass_block_with_fallen_orange_leaves =BW("kakuriyo_grass_block_with_fallen_orange_leaves","s",-1,() -> {return new KakuriyoGrassBlock(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.COLOR_ORANGE).strength(0.6F, 10.0F).randomTicks().sound(SoundType.GRASS));});
    public static final RegistryObject<Block> yellow_sapling =BW("yellow_sapling","a",-1,() -> {return new FlammableSaplingBlock(new YellowTreeGrower(),BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.COLOR_YELLOW).sound(SoundType.GRASS).noCollission().instabreak().randomTicks());});
    public static final RegistryObject<Block> yellow_leaves =BW("yellow_leaves","h",-1,() -> {return cutouteaves(MaterialColor.COLOR_YELLOW,SoundType.AZALEA_LEAVES);});
    public static final RegistryObject<Block> fallen_yellow_leaves =BW("fallen_yellow_leaves","h",-1,() -> {return new FallenLeavesBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_YELLOW).strength(0.2F, 10.0F).sound(SoundType.AZALEA_LEAVES).noCollission());});
    public static final RegistryObject<Block> grass_block_with_fallen_yellow_leaves =BW("grass_block_with_fallen_yellow_leaves","s",-1,() -> {return new GrassBlock(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.COLOR_YELLOW).strength(0.6F, 10.0F).randomTicks().sound(SoundType.GRASS));});
    public static final RegistryObject<Block> kakuriyo_grass_block_with_fallen_yellow_leaves =BW("kakuriyo_grass_block_with_fallen_yellow_leaves","s",-1,() -> {return new KakuriyoGrassBlock(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.COLOR_YELLOW).strength(0.6F, 10.0F).randomTicks().sound(SoundType.GRASS));});
    public static final RegistryObject<Item> japanese_apricot_bark =IW("japanese_apricot_bark");
    public static final RegistryObject<Block> japanese_apricot_sapling =BW("japanese_apricot_sapling","a",-1,() -> {return new FlammableSaplingBlock(new ApricotTreeGrower(),BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.COLOR_PINK).sound(SoundType.GRASS).noCollission().instabreak().randomTicks());});
    public static final RegistryObject<Block> japanese_apricot_leaves =BW("japanese_apricot_leaves","h",-1,() -> {return cutouteaves(MaterialColor.COLOR_PINK,SoundType.AZALEA_LEAVES);});
    public static final RegistryObject<Block> fallen_japanese_apricot_leaves =BW("fallen_japanese_apricot_leaves","h",-1,() -> {return new FallenLeavesBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_PINK).strength(0.2F, 10.0F).sound(SoundType.AZALEA_LEAVES).noCollission());});
    public static final RegistryObject<Block> grass_block_with_fallen_japanese_apricot_leaves =BW("grass_block_with_fallen_japanese_apricot_leaves","s",-1,() -> {return new GrassBlock(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.COLOR_PINK).strength(0.6F, 10.0F).randomTicks().sound(SoundType.GRASS));});
    public static final RegistryObject<Block> kakuriyo_grass_block_with_fallen_japanese_apricot_leaves =BW("kakuriyo_grass_block_with_fallen_japanese_apricot_leaves","s",-1,() -> {return new KakuriyoGrassBlock(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.COLOR_PINK).strength(0.6F, 10.0F).randomTicks().sound(SoundType.GRASS));});
    public static final RegistryObject<Block> glowing_japanese_apricot_sapling =BW("glowing_japanese_apricot_sapling","a",-1,() -> {return new GlowingSaplingBlock(new GlowingApricotTreeGrower(),BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.COLOR_PINK).sound(SoundType.GRASS).noCollission().instabreak().randomTicks().lightLevel((p_235470_0_) -> {return 15;}));});
    public static final RegistryObject<Block> glowing_japanese_apricot_leaves =BW("glowing_japanese_apricot_leaves","h",-1,() -> {return glowingleaves(MaterialColor.COLOR_PINK,SoundType.AZALEA_LEAVES);});
    public static final RegistryObject<Block> stripped_japanese_apricot_log =BW("stripped_japanese_apricot_log","a",-1,() -> {return log(MaterialColor.WOOD, MaterialColor.TERRACOTTA_PINK);});
    public static final RegistryObject<Block> japanese_apricot_log =BW("japanese_apricot_log","a",-1,() -> {return strippablelog(stripped_japanese_apricot_log.get(),0,MaterialColor.WOOD, MaterialColor.TERRACOTTA_PINK);});
    public static final RegistryObject<Block> stripped_japanese_apricot_wood =BW("stripped_japanese_apricot_wood","a",-1,() -> {return new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_PINK).sound(SoundType.WOOD).strength(2.0F, 10.0F));});
    public static final RegistryObject<Block> japanese_apricot_wood =BW("japanese_apricot_wood","a",-1,() -> {return new StrippableLogBlock(stripped_japanese_apricot_wood.get(),0,BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_PINK).sound(SoundType.WOOD).strength(2.0F, 10.0F));});
    public static final RegistryObject<Block> japanese_apricot_planks =BW("japanese_apricot_planks","a",-1,() -> {return new FlammableBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_PINK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> japanese_apricot_slab =BW("japanese_apricot_slab","a",-1,() -> {return new FlammableSlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_PINK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> japanese_apricot_stairs =BW("japanese_apricot_stairs","a",-1,() -> {return new FlammableStairBlock(japanese_apricot_planks.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_PINK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> japanese_apricot_fence =BW("japanese_apricot_fence","a",-1,() -> {return new FlammableFenceBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_PINK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> japanese_apricot_fence_gate =BW("japanese_apricot_fence_gate","a",-1,() -> {return new FlammableFenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_PINK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> japanese_apricot_door =BW("japanese_apricot_door","a",-1,() -> {return new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_PINK).sound(SoundType.WOOD).strength(1.0F, 10.0F).noOcclusion());});
    public static final RegistryObject<Block> japanese_apricot_trapdoor =BW("japanese_apricot_trapdoor","a",-1,() -> {return new ConnectableTrapdoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_PINK).sound(SoundType.WOOD).strength(1.0F, 10.0F).noOcclusion().isValidSpawn(ItemAndBlockRegister::never));});
    public static final RegistryObject<Block> japanese_apricot_pressure_plate =BW("japanese_apricot_pressure_plate","a",-1,() -> {return new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_PINK).sound(SoundType.WOOD).strength(0.5F, 10.0F).noCollission());});
    public static final RegistryObject<Block> japanese_apricot_button =BW("japanese_apricot_button","a",-1,() -> {return new WoodButtonBlock(BlockBehaviour.Properties.of(Material.DECORATION, MaterialColor.TERRACOTTA_PINK).sound(SoundType.WOOD).strength(0.5F, 10.0F).noCollission());});
    public static final RegistryObject<Block> smooth_japanese_apricot_planks =BW("smooth_japanese_apricot_planks","a",-1,() -> {return new FlammableBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_PINK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_japanese_apricot_slab =BW("smooth_japanese_apricot_slab","a",-1,() -> {return new FlammableSlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_PINK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_japanese_apricot_stairs =BW("smooth_japanese_apricot_stairs","a",-1,() -> {return new FlammableStairBlock(smooth_japanese_apricot_planks.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_PINK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> japanese_apricot_parapet =BW("japanese_apricot_parapet","a",-1,() -> {return new ParapetBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_PINK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> japanese_apricot_fushiranma =BW("japanese_apricot_fushiranma","a",-1,() -> {return new FushiranmaBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_PINK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Item> sakura_bark =IW("sakura_bark");
    public static final RegistryObject<Block> sakura_sapling =BW("sakura_sapling","a",-1,() -> {return new FlammableSaplingBlock(new SakuraTreeGrower(),BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.TERRACOTTA_WHITE).sound(SoundType.GRASS).noCollission().instabreak().randomTicks());});
    public static final RegistryObject<Block> big_sakura_sapling =BW("big_sakura_sapling","a",-1,() -> {return new FlammableSaplingBlock(new FancySakuraTreeGrower(),BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.TERRACOTTA_WHITE).sound(SoundType.GRASS).noCollission().instabreak().randomTicks());});
    public static final RegistryObject<Block> sakura_leaves =BW("sakura_leaves","h",-1,() -> {return cutouteaves(MaterialColor.TERRACOTTA_WHITE,SoundType.AZALEA_LEAVES);});
    public static final RegistryObject<Block> fallen_sakura_leaves =BW("fallen_sakura_leaves","h",-1,() -> {return new FallenLeavesBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.TERRACOTTA_WHITE).strength(0.2F, 10.0F).sound(SoundType.AZALEA_LEAVES).noCollission());});
    public static final RegistryObject<Block> grass_block_with_fallen_sakura_leaves =BW("grass_block_with_fallen_sakura_leaves","s",-1,() -> {return new GrassBlock(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.TERRACOTTA_WHITE).strength(0.6F, 10.0F).randomTicks().sound(SoundType.GRASS));});
    public static final RegistryObject<Block> kakuriyo_grass_block_with_fallen_sakura_leaves =BW("kakuriyo_grass_block_with_fallen_sakura_leaves","s",-1,() -> {return new KakuriyoGrassBlock(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.TERRACOTTA_WHITE).strength(0.6F, 10.0F).randomTicks().sound(SoundType.GRASS));});
    public static final RegistryObject<Block> glowing_sakura_sapling =BW("glowing_sakura_sapling","a",-1,() -> {return new GlowingSaplingBlock(new GlowingSakuraTreeGrower(),BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.TERRACOTTA_WHITE).sound(SoundType.GRASS).noCollission().instabreak().randomTicks().lightLevel((p_235470_0_) -> {return 15;}));});
    public static final RegistryObject<Block> glowing_big_sakura_sapling =BW("glowing_big_sakura_sapling","a",-1,() -> {return new GlowingSaplingBlock(new GlowingFancySakuraTreeGrower(),BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.TERRACOTTA_WHITE).sound(SoundType.GRASS).noCollission().instabreak().randomTicks().lightLevel((p_235470_0_) -> {return 15;}));});
    public static final RegistryObject<Block> glowing_sakura_leaves =BW("glowing_sakura_leaves","h",-1,() -> {return glowingleaves(MaterialColor.TERRACOTTA_WHITE,SoundType.AZALEA_LEAVES);});
    public static final RegistryObject<Block> stripped_sakura_log =BW("stripped_sakura_log","a",-1,() -> {return log(MaterialColor.WOOD, MaterialColor.COLOR_ORANGE);});
    public static final RegistryObject<Block> sakura_log =BW("sakura_log","a",-1,() -> {return strippablelog(stripped_sakura_log.get(),1,MaterialColor.WOOD, MaterialColor.COLOR_ORANGE);});
    public static final RegistryObject<Block> stripped_sakura_wood =BW("stripped_sakura_wood","a",-1,() -> {return new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(2.0F, 10.0F));});
    public static final RegistryObject<Block> sakura_wood =BW("sakura_wood","a",-1,() -> {return new StrippableLogBlock(stripped_sakura_wood.get(),1,BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(2.0F, 10.0F));});
    public static final RegistryObject<Block> sakura_planks =BW("sakura_planks","a",-1,() -> {return new FlammableBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> sakura_slab =BW("sakura_slab","a",-1,() -> {return new FlammableSlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> sakura_stairs =BW("sakura_stairs","a",-1,() -> {return new FlammableStairBlock(sakura_planks.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> sakura_fence =BW("sakura_fence","a",-1,() -> {return new FlammableFenceBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> sakura_fence_gate =BW("sakura_fence_gate","a",-1,() -> {return new FlammableFenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> sakura_door =BW("sakura_door","a",-1,() -> {return new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F).noOcclusion());});
    public static final RegistryObject<Block> sakura_trapdoor =BW("sakura_trapdoor","a",-1,() -> {return new ConnectableTrapdoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F).noOcclusion().isValidSpawn(ItemAndBlockRegister::never));});
    public static final RegistryObject<Block> sakura_pressure_plate =BW("sakura_pressure_plate","a",-1,() -> {return new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(0.5F, 10.0F).noCollission());});
    public static final RegistryObject<Block> sakura_button =BW("sakura_button","a",-1,() -> {return new WoodButtonBlock(BlockBehaviour.Properties.of(Material.DECORATION, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(0.5F, 10.0F).noCollission());});
    public static final RegistryObject<Block> smooth_sakura_planks =BW("smooth_sakura_planks","a",-1,() -> {return new FlammableBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_sakura_slab =BW("smooth_sakura_slab","a",-1,() -> {return new FlammableSlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_sakura_stairs =BW("smooth_sakura_stairs","a",-1,() -> {return new FlammableStairBlock(smooth_sakura_planks.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> sakura_parapet =BW("sakura_parapet","a",-1,() -> {return new ParapetBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> sakura_fushiranma =BW("sakura_fushiranma","a",-1,() -> {return new FushiranmaBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Item> cypress_bark =IW("cypress_bark");
    public static final RegistryObject<Block> cypress_sapling =BW("cypress_sapling","a",-1,() -> {return new FlammableSaplingBlock(new CypressTreeGrower(),BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.GRASS).sound(SoundType.GRASS).noCollission().instabreak().randomTicks());});
    public static final RegistryObject<Block> cypress_leaves =BW("cypress_leaves","h",-1,() -> {return leaves(MaterialColor.GRASS,SoundType.AZALEA_LEAVES);});
    public static final RegistryObject<Block> stripped_cypress_log =BW("stripped_cypress_log","a",-1,() -> {return log(MaterialColor.WOOD, MaterialColor.SAND);});
    public static final RegistryObject<Block> cypress_log =BW("cypress_log","a",-1,() -> {return strippablelog(stripped_cypress_log.get(),2,MaterialColor.WOOD, MaterialColor.SAND);});
    public static final RegistryObject<Block> stripped_cypress_wood =BW("stripped_cypress_wood","a",-1,() -> {return new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).sound(SoundType.WOOD).strength(2.0F, 10.0F));});
    public static final RegistryObject<Block> cypress_wood =BW("cypress_wood","a",-1,() -> {return new StrippableLogBlock(stripped_cypress_wood.get(),2,BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).sound(SoundType.WOOD).strength(2.0F, 10.0F));});
    public static final RegistryObject<Block> cypress_planks =BW("cypress_planks","a",-1,() -> {return new FlammableBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> cypress_slab =BW("cypress_slab","a",-1,() -> {return new FlammableSlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> cypress_stairs =BW("cypress_stairs","a",-1,() -> {return new FlammableStairBlock(cypress_planks.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> cypress_fence =BW("cypress_fence","a",-1,() -> {return new FlammableFenceBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> cypress_fence_gate =BW("cypress_fence_gate","a",-1,() -> {return new FlammableFenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> cypress_door =BW("cypress_door","a",-1,() -> {return new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F).noOcclusion());});
    public static final RegistryObject<Block> cypress_trapdoor =BW("cypress_trapdoor","a",-1,() -> {return new ConnectableTrapdoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F).noOcclusion().isValidSpawn(ItemAndBlockRegister::never));});
    public static final RegistryObject<Block> cypress_pressure_plate =BW("cypress_pressure_plate","a",-1,() -> {return new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).sound(SoundType.WOOD).strength(0.5F, 10.0F).noCollission());});
    public static final RegistryObject<Block> cypress_button =BW("cypress_button","a",-1,() -> {return new WoodButtonBlock(BlockBehaviour.Properties.of(Material.DECORATION, MaterialColor.SAND).sound(SoundType.WOOD).strength(0.5F, 10.0F).noCollission());});
    public static final RegistryObject<Block> smooth_cypress_planks =BW("smooth_cypress_planks","a",-1,() -> {return new FlammableBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_cypress_slab =BW("smooth_cypress_slab","a",-1,() -> {return new FlammableSlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_cypress_stairs =BW("smooth_cypress_stairs","a",-1,() -> {return new FlammableStairBlock(smooth_cypress_planks.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> cypress_parapet =BW("cypress_parapet","a",-1,() -> {return new ParapetBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> cypress_fushiranma =BW("cypress_fushiranma","a",-1,() -> {return new FushiranmaBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Item> japanese_cedar_bark =IW("japanese_cedar_bark");
    public static final RegistryObject<Block> japanese_cedar_sapling =BW("japanese_cedar_sapling","a",-1,() -> {return new FlammableSaplingBlock(new CedarTreeGrower(),BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.COLOR_BROWN).sound(SoundType.GRASS).noCollission().instabreak().randomTicks());});
    public static final RegistryObject<Block> japanese_cedar_leaves =BW("japanese_cedar_leaves","h",-1,() -> {return leaves(MaterialColor.GRASS,SoundType.AZALEA_LEAVES);});
    public static final RegistryObject<Block> stripped_japanese_cedar_log =BW("stripped_japanese_cedar_log","a",-1,() -> {return log(MaterialColor.WOOD, MaterialColor.COLOR_BROWN);});
    public static final RegistryObject<Block> japanese_cedar_log =BW("japanese_cedar_log","a",-1,() -> {return strippablelog(stripped_japanese_cedar_log.get(),3,MaterialColor.WOOD, MaterialColor.COLOR_BROWN);});
    public static final RegistryObject<Block> stripped_japanese_cedar_wood =BW("stripped_japanese_cedar_wood","a",-1,() -> {return new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOD).strength(2.0F, 10.0F));});
    public static final RegistryObject<Block> japanese_cedar_wood =BW("japanese_cedar_wood","a",-1,() -> {return new StrippableLogBlock(stripped_japanese_cedar_wood.get(),3,BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOD).strength(2.0F, 10.0F));});
    public static final RegistryObject<Block> japanese_cedar_planks =BW("japanese_cedar_planks","a",-1,() -> {return new FlammableBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> japanese_cedar_slab =BW("japanese_cedar_slab","a",-1,() -> {return new FlammableSlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> japanese_cedar_stairs =BW("japanese_cedar_stairs","a",-1,() -> {return new FlammableStairBlock(cypress_planks.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> japanese_cedar_fence =BW("japanese_cedar_fence","a",-1,() -> {return new FlammableFenceBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> japanese_cedar_fence_gate =BW("japanese_cedar_fence_gate","a",-1,() -> {return new FlammableFenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> japanese_cedar_door =BW("japanese_cedar_door","a",-1,() -> {return new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F).noOcclusion());});
    public static final RegistryObject<Block> japanese_cedar_trapdoor =BW("japanese_cedar_trapdoor","a",-1,() -> {return new ConnectableTrapdoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F).noOcclusion().isValidSpawn(ItemAndBlockRegister::never));});
    public static final RegistryObject<Block> japanese_cedar_pressure_plate =BW("japanese_cedar_pressure_plate","a",-1,() -> {return new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOD).strength(0.5F, 10.0F).noCollission());});
    public static final RegistryObject<Block> japanese_cedar_button =BW("japanese_cedar_button","a",-1,() -> {return new WoodButtonBlock(BlockBehaviour.Properties.of(Material.DECORATION, MaterialColor.COLOR_BROWN).sound(SoundType.WOOD).strength(0.5F, 10.0F).noCollission());});
    public static final RegistryObject<Block> smooth_japanese_cedar_planks =BW("smooth_japanese_cedar_planks","a",-1,() -> {return new FlammableBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_japanese_cedar_slab =BW("smooth_japanese_cedar_slab","a",-1,() -> {return new FlammableSlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_japanese_cedar_stairs =BW("smooth_japanese_cedar_stairs","a",-1,() -> {return new FlammableStairBlock(smooth_cypress_planks.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> japanese_cedar_parapet =BW("japanese_cedar_parapet","a",-1,() -> {return new ParapetBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> japanese_cedar_fushiranma =BW("japanese_cedar_fushiranma","a",-1,() -> {return new FushiranmaBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> lacquer_sapling =BW("lacquer_sapling","a",-1,() -> {return new FlammableSaplingBlock(new LacquerTreeGrower(),BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.GRASS).sound(SoundType.GRASS).noCollission().instabreak().randomTicks());});
    public static final RegistryObject<Block> lacquer_leaves =BW("lacquer_leaves","h",-1,() -> {return leaves(MaterialColor.GRASS,SoundType.AZALEA_LEAVES);});
    public static final RegistryObject<Block> lacquer_log =BW("lacquer_log","a",-1,() -> {return chiselablelog(MaterialColor.WOOD, MaterialColor.WOOD);});
    public static final RegistryObject<Block> chiseled_lacquer_log =BW("chiseled_lacquer_log","a",-1,() -> {return new ChiseledLacquerLogBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).strength(1.0F, 10.0F).randomTicks());});
    public static final RegistryObject<Item> tiny_red_dye =I("tiny_red_dye");
    public static final RegistryObject<Item> tiny_black_dye =I("tiny_black_dye");
    public static final RegistryObject<Item> raw_urushi_ball =ITEMS.register("raw_urushi_ball", () -> {return new ToolchipItem("rawurushi",(new Item.Properties()).tab(ModCoreUrushi.UrushiWoodTab));});
    public static final RegistryObject<Item> red_urushi_ball =ITEMS.register("red_urushi_ball", () -> {return new Item((new Item.Properties()).tab(ModCoreUrushi.UrushiWoodTab).craftRemainder(Items.BOWL));});
    public static final RegistryObject<Item> black_urushi_ball =ITEMS.register("black_urushi_ball", () -> {return new Item((new Item.Properties()).tab(ModCoreUrushi.UrushiWoodTab).craftRemainder(Items.BOWL));});
    public static final RegistryObject<Block> red_urushi_planks =BW("red_urushi_planks","a",-1,() -> {return new FlammableBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> red_urushi_slab =BW("red_urushi_slab","a",-1,() -> {return new FlammableSlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> red_urushi_stairs =BW("red_urushi_stairs","a",-1,() -> {return new FlammableStairBlock(red_urushi_planks.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> red_urushi_fence =BW("red_urushi_fence","a",-1,() -> {return new FlammableFenceBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> red_urushi_fence_gate =BW("red_urushi_fence_gate","a",-1,() -> {return new FlammableFenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> red_urushi_door =BW("red_urushi_door","a",-1,() -> {return new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).sound(SoundType.WOOD).strength(1.0F, 10.0F).noOcclusion());});
    public static final RegistryObject<Block> red_urushi_trapdoor =BW("red_urushi_trapdoor","a",-1,() -> {return new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).sound(SoundType.WOOD).strength(1.0F, 10.0F).noOcclusion().isValidSpawn(ItemAndBlockRegister::never));});
    public static final RegistryObject<Block> red_urushi_pressure_plate =BW("red_urushi_pressure_plate","a",-1,() -> {return new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).sound(SoundType.WOOD).strength(0.5F, 10.0F).noCollission());});
    public static final RegistryObject<Block> red_urushi_button =BW("red_urushi_button","a",-1,() -> {return new WoodButtonBlock(BlockBehaviour.Properties.of(Material.DECORATION, MaterialColor.COLOR_RED).sound(SoundType.WOOD).strength(0.5F, 10.0F).noCollission());});
    public static final RegistryObject<Block> smooth_red_urushi_planks =BW("smooth_red_urushi_planks","a",-1,() -> {return new FlammableBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_red_urushi_slab =BW("smooth_red_urushi_slab","a",-1,() -> {return new FlammableSlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_red_urushi_stairs =BW("smooth_red_urushi_stairs","a",-1,() -> {return new FlammableStairBlock(smooth_red_urushi_planks.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> red_urushi_parapet =BW("red_urushi_parapet","a",-1,() -> {return new ParapetBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> red_urushi_fushiranma =BW("red_urushi_fushiranma","a",-1,() -> {return new FushiranmaBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> black_urushi_planks =BW("black_urushi_planks","a",-1,() -> {return new FlammableBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BLACK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> black_urushi_slab =BW("black_urushi_slab","a",-1,() -> {return new FlammableSlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BLACK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> black_urushi_stairs =BW("black_urushi_stairs","a",-1,() -> {return new FlammableStairBlock(black_urushi_planks.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BLACK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> black_urushi_fence =BW("black_urushi_fence","a",-1,() -> {return new FlammableFenceBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BLACK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> black_urushi_fence_gate =BW("black_urushi_fence_gate","a",-1,() -> {return new FlammableFenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BLACK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> black_urushi_door =BW("black_urushi_door","a",-1,() -> {return new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BLACK).sound(SoundType.WOOD).strength(1.0F, 10.0F).noOcclusion());});
    public static final RegistryObject<Block> black_urushi_trapdoor =BW("black_urushi_trapdoor","a",-1,() -> {return new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BLACK).sound(SoundType.WOOD).strength(1.0F, 10.0F).noOcclusion().isValidSpawn(ItemAndBlockRegister::never));});
    public static final RegistryObject<Block> black_urushi_pressure_plate =BW("black_urushi_pressure_plate","a",-1,() -> {return new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BLACK).sound(SoundType.WOOD).strength(0.5F, 10.0F).noCollission());});
    public static final RegistryObject<Block> black_urushi_button =BW("black_urushi_button","a",-1,() -> {return new WoodButtonBlock(BlockBehaviour.Properties.of(Material.DECORATION, MaterialColor.COLOR_BLACK).sound(SoundType.WOOD).strength(0.5F, 10.0F).noCollission());});
    public static final RegistryObject<Block> smooth_black_urushi_planks =BW("smooth_black_urushi_planks","a",-1,() -> {return new FlammableBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BLACK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_black_urushi_slab =BW("smooth_black_urushi_slab","a",-1,() -> {return new FlammableSlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BLACK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_black_urushi_stairs =BW("smooth_black_urushi_stairs","a",-1,() -> {return new FlammableStairBlock(smooth_black_urushi_planks.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BLACK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> black_urushi_parapet =BW("black_urushi_parapet","a",-1,() -> {return new ParapetBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BLACK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> black_urushi_fushiranma =BW("black_urushi_fushiranma","a",-1,() -> {return new FushiranmaBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BLACK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> wooden_cabinetry_slab =B("wooden_cabinetry_slab","a",-1,() -> {return new WoodenCabinetrySlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_BLACK).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final RegistryObject<Block> wooden_cabinetry =B("wooden_cabinetry","a",-1,() -> {return new WoodenCabinetryBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_BLACK).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final RegistryObject<Block> doubled_wooden_cabinetry =B("doubled_wooden_cabinetry","a",-1,() -> {return new DoubledWoodenCabinetryBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_BLACK).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final RegistryObject<Block> red_urushi_wooden_cabinetry_slab =B("red_urushi_wooden_cabinetry_slab","a",-1,() -> {return new WoodenCabinetrySlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final RegistryObject<Block> red_urushi_wooden_cabinetry =B("red_urushi_wooden_cabinetry","a",-1,() -> {return new WoodenCabinetryBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final RegistryObject<Block> doubled_red_urushi_wooden_cabinetry =B("doubled_red_urushi_wooden_cabinetry","a",-1,() -> {return new DoubledWoodenCabinetryBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final RegistryObject<Block> senryoubako =B("senryoubako","a",-1,() -> {return new SenryoubakoBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final RegistryObject<Block> kitsunebiBlock =BLOCKS.register("kitsunebi",() -> {return new BarrierBlock(BlockBehaviour.Properties.of(Material.GLASS).sound(SoundType.SOUL_SAND).instabreak().noCollission().noOcclusion().lightLevel((p_235470_0_) -> {return 15;}));});
    public static final RegistryObject<Item> kitsunebiItem =ITEMS.register("kitsunebi", () -> {return new KitsunebiItem((new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Block> fox_hopper =B("fox_hopper","a",-1,() -> {return new FoxHopperBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOL).strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> andon =B("andon","a",-1,() -> {return new AndonBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.PODZOL).sound(SoundType.WOOD).strength(0.2F, 10.0F).noOcclusion().lightLevel((p_235470_0_) -> {return 15;}));});
    public static final RegistryObject<Block> ariake_andon =B("ariake_andon","a",-1,() -> {return new AriakeAndonBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.PODZOL).sound(SoundType.WOOD).strength(0.2F, 10.0F).noOcclusion().lightLevel((p_235470_0_) -> {return 13;}));});
    public static final RegistryObject<Block> kasuga_lantern =B("kasuga_lantern","a",-1,() -> {return new KasugaLanternBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.PODZOL).sound(SoundType.WOOD).strength(0.2F, 10.0F).noOcclusion().lightLevel((p_235470_0_) -> {return 15;}));});
    public static final RegistryObject<Block> iron_giboshi =B("iron_giboshi","p",2,() -> {return new SimpleShapedBlock(Block.box(3.0D, 0.0D, 3.0D, 13.0D, 16.0D, 13.0D),BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_BLACK).sound(SoundType.METAL).strength(0.5F, 30.0F).noOcclusion().requiresCorrectToolForDrops());});
    public static final RegistryObject<Block> gold_giboshi =B("gold_giboshi","p",2,() -> {return new SimpleShapedBlock(Block.box(3.0D, 0.0D, 3.0D, 13.0D, 16.0D, 13.0D),BlockBehaviour.Properties.of(Material.METAL, MaterialColor.GOLD).sound(SoundType.METAL).strength(0.5F, 30.0F).noOcclusion().requiresCorrectToolForDrops());});
    public static final RegistryObject<Block> blank_fusuma =B("blank_fusuma","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SNOW).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> blue_seigaiha_fusuma =B("blue_seigaiha_fusuma","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SNOW).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> blue_sayagata_fusuma =B("blue_sayagata_fusuma","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SNOW).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> blank_antique_fusuma =B("blank_antique_fusuma","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SNOW).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> sliding_glass_door =B("sliding_glass_door","p",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of(Material.GLASS).sound(SoundType.GLASS).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> oak_shoji_pane =BW("oak_shoji_pane","a",-1,() -> {return new IronBarsBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> spruce_shoji_pane =BW("spruce_shoji_pane","a",-1,() -> {return new IronBarsBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.PODZOL).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> birch_shoji_pane =BW("birch_shoji_pane","a",-1,() -> {return new IronBarsBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> jungle_shoji_pane =BW("jungle_shoji_pane","a",-1,() -> {return new IronBarsBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.DIRT).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> acacia_shoji_pane =BW("acacia_shoji_pane","a",-1,() -> {return new IronBarsBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> dark_oak_shoji_pane =BW("dark_oak_shoji_pane","a",-1,() -> {return new IronBarsBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> japanese_apricot_shoji_pane =BW("japanese_apricot_shoji_pane","a",-1,() -> {return new IronBarsBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_ORANGE).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> sakura_shoji_pane =BW("sakura_shoji_pane","a",-1,() -> {return new IronBarsBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> cypress_shoji_pane =BW("cypress_shoji_pane","a",-1,() -> {return new IronBarsBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> japanese_cedar_shoji_pane =BW("japanese_cedar_shoji_pane","a",-1,() -> {return new IronBarsBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> red_urushi_shoji_pane =BW("red_urushi_shoji_pane","a",-1,() -> {return new IronBarsBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> black_urushi_shoji_pane =BW("black_urushi_shoji_pane","a",-1,() -> {return new IronBarsBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BLACK).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> oak_shoji =BW("oak_shoji","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> spruce_shoji =BW("spruce_shoji","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.PODZOL).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> birch_shoji =BW("birch_shoji","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> jungle_shoji =BW("jungle_shoji","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.DIRT).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> acacia_shoji =BW("acacia_shoji","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> dark_oak_shoji =BW("dark_oak_shoji","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> japanese_apricot_shoji =BW("japanese_apricot_shoji","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_ORANGE).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> sakura_shoji =BW("sakura_shoji","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> cypress_shoji =BW("cypress_shoji","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SAND).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> japanese_cedar_shoji =BW("japanese_cedar_shoji","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> red_urushi_shoji =BW("red_urushi_shoji","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final RegistryObject<Block> black_urushi_shoji =BW("black_urushi_shoji","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BLACK).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
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
    public static final RegistryObject<Item> white_cushion =ITEMS.register("white_cushion", () -> {return new CushionItem(DyeColor.WHITE,(new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> orange_cushion =ITEMS.register("orange_cushion", () -> {return new CushionItem(DyeColor.ORANGE,(new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> magenta_cushion =ITEMS.register("magenta_cushion", () -> {return new CushionItem(DyeColor.MAGENTA,(new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> light_blue_cushion =ITEMS.register("light_blue_cushion", () -> {return new CushionItem(DyeColor.LIGHT_BLUE,(new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> yellow_cushion =ITEMS.register("yellow_cushion", () -> {return new CushionItem(DyeColor.YELLOW,(new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> lime_cushion =ITEMS.register("lime_cushion", () -> {return new CushionItem(DyeColor.LIME,(new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> pink_cushion =ITEMS.register("pink_cushion", () -> {return new CushionItem(DyeColor.PINK,(new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> gray_cushion =ITEMS.register("gray_cushion", () -> {return new CushionItem(DyeColor.GRAY,(new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> light_gray_cushion =ITEMS.register("light_gray_cushion", () -> {return new CushionItem(DyeColor.LIGHT_GRAY,(new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> cyan_cushion =ITEMS.register("cyan_cushion", () -> {return new CushionItem(DyeColor.CYAN,(new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> purple_cushion =ITEMS.register("purple_cushion", () -> {return new CushionItem(DyeColor.PURPLE,(new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> blue_cushion =ITEMS.register("blue_cushion", () -> {return new CushionItem(DyeColor.BLUE,(new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> brown_cushion =ITEMS.register("brown_cushion", () -> {return new CushionItem(DyeColor.BROWN,(new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> green_cushion =ITEMS.register("green_cushion", () -> {return new CushionItem(DyeColor.GREEN,(new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> red_cushion =ITEMS.register("red_cushion", () -> {return new CushionItem(DyeColor.RED,(new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> black_cushion =ITEMS.register("black_cushion", () -> {return new CushionItem(DyeColor.BLACK,(new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
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
    public static final RegistryObject<Block> magma_slab =B("magma_slab","p",-1,() -> {return new MagmaSlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.NETHER).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(0.5F, 10.0F).lightLevel((p_235470_0_) -> {return 3;}).randomTicks().isValidSpawn((p_187421_, p_187422_, p_187423_, p_187424_) -> {return p_187424_.fireImmune();}).hasPostProcess(ItemAndBlockRegister::always).emissiveRendering(ItemAndBlockRegister::always));});
    public static final RegistryObject<Block> magma_stairs =B("magma_stairs","p",-1,() -> {return new MagmaStairBlock(Blocks.MAGMA_BLOCK.defaultBlockState(),BlockBehaviour.Properties.of(Material.STONE, MaterialColor.NETHER).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(0.5F, 10.0F).lightLevel((p_235470_0_) -> {return 3;}).randomTicks().isValidSpawn((p_187421_, p_187422_, p_187423_, p_187424_) -> {return p_187424_.fireImmune();}).hasPostProcess(ItemAndBlockRegister::always).emissiveRendering(ItemAndBlockRegister::always));});
    public static final RegistryObject<Block> japanese_timber_bamboo =B("japanese_timber_bamboo","a",-1,() -> {return new JapaneseTimberBambooBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.GRASS).sound(SoundType.BAMBOO).strength(0.5F, 10.0F).randomTicks().noCollission());});
    public static final RegistryObject<Block> bamboo_block =B("bamboo_block","a",-1,() -> {return new FlammableBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.BAMBOO).strength(0.5F, 10.0F));});
    public static final RegistryObject<Block> bamboo_slab =B("bamboo_slab","a",-1,() -> {return new FlammableSlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.BAMBOO).strength(0.5F, 10.0F));});
    public static final RegistryObject<Block> bamboo_stairs =B("bamboo_stairs","a",-1,() -> {return new FlammableStairBlock(bamboo_block.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.BAMBOO).strength(0.5F, 10.0F));});
    public static final RegistryObject<Block> bamboo_wall =B("bamboo_wall","a",-1,() -> {return new IronBarsBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.BAMBOO).strength(0.5F, 10.0F).noOcclusion());});
    public static final RegistryObject<Item> bamboo_charcoal =I("bamboo_charcoal");
    public static final RegistryObject<Block> bamboo_charcoal_block =B("bamboo_charcoal_block","a",-1,() -> {return new FlammableBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BLACK).sound(SoundType.BAMBOO).strength(0.5F, 10.0F));});
    public static final RegistryObject<Block> tawara =BF("tawara","h",-1,() -> {return new FlammableHorizonalRotateBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.TERRACOTTA_YELLOW).strength(0.2F, 3.0F).sound(SoundType.GRASS));});
    public static final RegistryObject<Block> paddy_field =BF("paddy_field","s",-1,() -> {return new FarmBlock(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.WATER).strength(0.6F, 3.0F).sound(SoundType.GRAVEL).isViewBlocking(ItemAndBlockRegister::always).isSuffocating(ItemAndBlockRegister::always));});
    public static final RegistryObject<Block> senbakoki =BF("senbakoki","a",-1,() -> {return new SenbakokiBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(0.6F, 10.0F).sound(SoundType.WOOD));});
    public static final RegistryObject<Block> dirt_furnace =BF("dirt_furnace","s",-1,() -> {return new DirtFurnaceBlock(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.DIRT).strength(1F, 10.0F).sound(SoundType.GRAVEL));});
    public static final RegistryObject<Block> rice_cauldron =BF("rice_cauldron","p",-1,() -> {return new RiceCauldronBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_BLACK).strength(1F, 10.0F).sound(SoundType.METAL).requiresCorrectToolForDrops());});
    public static final RegistryObject<Block> rice_crop =BF("rice_crop","h",-1,() -> {return new RiceCropBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.GRASS).sound(SoundType.GRASS).randomTicks().noCollission().instabreak());});
    public static final RegistryObject<Block> azuki_crop =BF("azuki_crop","h",-1,() -> {return new UrushiCropBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.GRASS).sound(SoundType.GRASS).randomTicks().noCollission().instabreak());});
    public static final RegistryObject<Block> soy_crop =BF("soy_crop","h",-1,() -> {return new UrushiCropBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.GRASS).sound(SoundType.GRASS).randomTicks().noCollission().instabreak());});
    public static final RegistryObject<Item> raw_rice =ITEMS.register("raw_rice", () -> {return new ToolchipItem("rawrice",(new Item.Properties()).tab(ModCoreUrushi.UrushiFoodTab));});
    public static final RegistryObject<Item> rice =ITEMS.register("rice", () -> {return new PlaceableFoodItem(()->EntityRegister.RiceFoodEntity.get(),(new Item.Properties()).food(FoodUrushi.Rice).tab(ModCoreUrushi.UrushiFoodTab));});
    public static final RegistryObject<Item> tkg =ITEMS.register("tkg", () -> {return new PlaceableFoodItem(()->EntityRegister.TKGFoodEntity.get(),(new Item.Properties()).food(FoodUrushi.TKG).tab(ModCoreUrushi.UrushiFoodTab));});
    public static final RegistryObject<Item> sekihan =ITEMS.register("sekihan", () -> {return new PlaceableFoodItem(()->EntityRegister.SekihanFoodEntity.get(),(new Item.Properties()).food(FoodUrushi.Sekihan).tab(ModCoreUrushi.UrushiFoodTab));});
    public static final RegistryObject<Item> gyudon =ITEMS.register("gyudon", () -> {return new PlaceableFoodItem(()->EntityRegister.GyudonFoodEntity.get(),(new Item.Properties()).food(FoodUrushi.Gyudon).tab(ModCoreUrushi.UrushiFoodTab));});
    public static final RegistryObject<Item> butadon =ITEMS.register("butadon", () -> {return new PlaceableFoodItem(()->EntityRegister.ButadonFoodEntity.get(),(new Item.Properties()).food(FoodUrushi.Butadon).tab(ModCoreUrushi.UrushiFoodTab));});
    public static final RegistryObject<Item> rice_cake =ITEMS.register("rice_cake", () -> {return new PlaceableFoodItem(()->EntityRegister.RiceCakeFoodEntity.get(),(new Item.Properties()).food(FoodUrushi.RiceCake).tab(ModCoreUrushi.UrushiFoodTab));});
    public static final RegistryObject<Item> roasted_rice_cake =ITEMS.register("roasted_rice_cake", () -> {return new PlaceableFoodItem(()->EntityRegister.RoastedRiceCakeFoodEntity.get(),(new Item.Properties()).food(FoodUrushi.RoastedRiceCake).tab(ModCoreUrushi.UrushiFoodTab));});
    public static final RegistryObject<Item> kusa_dango =ITEMS.register("kusa_dango", () -> {return new PlaceableFoodItem(()->EntityRegister.KusaDangoFoodEntity.get(),(new Item.Properties()).food(FoodUrushi.Dango).tab(ModCoreUrushi.UrushiFoodTab));});
    public static final RegistryObject<Item> color_dango =ITEMS.register("color_dango", () -> {return new PlaceableFoodItem(()->EntityRegister.ColorDangoFoodEntity.get(),(new Item.Properties()).food(FoodUrushi.Dango).tab(ModCoreUrushi.UrushiFoodTab));});
    public static final RegistryObject<Item> mitarashi_dango =ITEMS.register("mitarashi_dango", () -> {return new PlaceableFoodItem(()->EntityRegister.MitarashiDangoFoodEntity.get(),(new Item.Properties()).food(FoodUrushi.Dango).tab(ModCoreUrushi.UrushiFoodTab));});
    public static final RegistryObject<Item> sakura_mochi =ITEMS.register("sakura_mochi", () -> {return new Item((new Item.Properties()).food(FoodUrushi.SakuraMochi).tab(ModCoreUrushi.UrushiFoodTab));});
    public static final RegistryObject<Item> kusa_mochi =ITEMS.register("kusa_mochi", () -> {return new Item((new Item.Properties()).food(FoodUrushi.KusaMochi).tab(ModCoreUrushi.UrushiFoodTab));});
    public static final RegistryObject<Item> ohagi =ITEMS.register("ohagi", () -> {return new Item((new Item.Properties()).food(FoodUrushi.Ohagi).tab(ModCoreUrushi.UrushiFoodTab));});
    public static final RegistryObject<Item> yokan =ITEMS.register("yokan", () -> {return new Item((new Item.Properties()).food(FoodUrushi.Yokan).tab(ModCoreUrushi.UrushiFoodTab));});
    public static final RegistryObject<Item> sakura_yokan =ITEMS.register("sakura_yokan", () -> {return new Item((new Item.Properties()).food(FoodUrushi.SakuraYokan).tab(ModCoreUrushi.UrushiFoodTab));});
    public static final RegistryObject<Item> karaage =ITEMS.register("karaage", () -> {return new PlaceableFoodItem(()->EntityRegister.KaraageFoodEntity.get(),(new Item.Properties()).food(FoodUrushi.Karaage).tab(ModCoreUrushi.UrushiFoodTab));});
    public static final RegistryObject<Item> tofu =ITEMS.register("tofu", () -> {return new PlaceableFoodItem(()->EntityRegister.TofuFoodEntity.get(),(new Item.Properties()).food(FoodUrushi.Tofu).tab(ModCoreUrushi.UrushiFoodTab));});
    public static final RegistryObject<Item> aburaage =ITEMS.register("abura_age", () -> {return new PlaceableFoodItem(()->EntityRegister.AburaageFoodEntity.get(),(new Item.Properties()).food(FoodUrushi.Aburaage).tab(ModCoreUrushi.UrushiFoodTab));});
    public static final RegistryObject<Item> noodle_knife =ITEMS.register("noodle_knife", () -> {return new NoodleKnifeItem((new Item.Properties()).tab(ModCoreUrushi.UrushiFoodTab).durability(1024));});
    public static final RegistryObject<Block> dough =BF("dough","n",-1,() -> {return new TwoDirectionShapedBlock(3.0D, 0.0D, 0D, 13.0D, 2.0D, 16.0D,BlockBehaviour.Properties.of(Material.CLAY, MaterialColor.WOOL).instabreak().sound(SoundType.WOOD));});
    public static final RegistryObject<Block> udon =BF("udon","n",-1,() -> {return new TwoDirectionShapedBlock(2.0D, 0.0D, 0D, 14.0D, 2.0D, 16.0D,BlockBehaviour.Properties.of(Material.CLAY, MaterialColor.WOOL).instabreak().sound(SoundType.WOOD));});
    public static final RegistryObject<Item> kitsune_udon =ITEMS.register("kitsune_udon", () -> {return new PlaceableFoodItem(()->EntityRegister.KitsuneUdonFoodEntity.get(),(new Item.Properties()).food(FoodUrushi.KitsuneUdon).tab(ModCoreUrushi.UrushiFoodTab));});
    public static final RegistryObject<Block> salt_and_sand =BF("salt_and_sand","s",-1,() -> {return new SaltAndSandBlock(BlockBehaviour.Properties.of(Material.SAND, MaterialColor.SAND).strength(1F, 10F).sound(SoundType.SAND));});
    public static final RegistryObject<Item> salt =ITEMS.register("salt", () -> {return new ToolchipItem("salt",(new Item.Properties()).tab(ModCoreUrushi.UrushiFoodTab));});
    public static final RegistryObject<Item> kanten_powder =IF("kanten_powder");
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
    public static final RegistryObject<Item> normal_katana_tier_10 =ITEMS.register("normal_katana_tier_10", () -> {return new NormalKatanaItem(Tiers.IRON,9,-2.9F,(new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> normal_katana_tier_9 =ITEMS.register("normal_katana_tier_9", () -> {return new NormalKatanaItem(Tiers.IRON,8,-2.9F,(new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> normal_katana_tier_8 =ITEMS.register("normal_katana_tier_8", () -> {return new NormalKatanaItem(Tiers.IRON,7,-2.9F,(new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> normal_katana_tier_7 =ITEMS.register("normal_katana_tier_7", () -> {return new NormalKatanaItem(Tiers.IRON,6,-2.9F,(new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> normal_katana_tier_6 =ITEMS.register("normal_katana_tier_6", () -> {return new NormalKatanaItem(Tiers.IRON,5,-2.9F,(new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> normal_katana_tier_5 =ITEMS.register("normal_katana_tier_5", () -> {return new NormalKatanaItem(Tiers.IRON,4,-2.9F,(new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> normal_katana_tier_4 =ITEMS.register("normal_katana_tier_4", () -> {return new NormalKatanaItem(Tiers.IRON,3,-2.9F,(new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> normal_katana_tier_3 =ITEMS.register("normal_katana_tier_3", () -> {return new NormalKatanaItem(Tiers.IRON,2,-2.9F,(new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> normal_katana_tier_2 =ITEMS.register("normal_katana_tier_2", () -> {return new NormalKatanaItem(Tiers.IRON,1,-2.9F,(new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> normal_katana_tier_1 =ITEMS.register("normal_katana_tier_1", () -> {return new NormalKatanaItem(Tiers.IRON,0,-2.9F,(new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Block> rope =B("rope","a",-1,() -> {return new RopeBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.LADDER).strength(0.1F, 10.0F));});
    public static final RegistryObject<Item> climbing_rope =ITEMS.register("climbing_rope", () -> {return new ClimbingRopesItem((new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Item> open_wagasa =ITEMS.register("open_wagasa", () -> {return new WagasaItem(true,(new Item.Properties()).tab(ModCoreUrushi.UrushiTab).stacksTo(1));});
    public static final RegistryObject<Item> close_wagasa =ITEMS.register("close_wagasa", () -> {return new WagasaItem(false,(new Item.Properties()).stacksTo(1));});
    public static final RegistryObject<LiquidBlock> HotSpringBlock =BLOCKS.register("hot_spring_water",() -> {return new HotSpringWaterBlock(()->FluidRegister.HotSpringStill.get(),BlockBehaviour.Properties.of(Material.WATER, MaterialColor.WATER).noDrops().strength(1000F).noCollission());});
    public static final RegistryObject<Item> hot_spring_bucket =ITEMS.register("hot_spring_water_bucket", () -> {return new BucketItem(FluidRegister.HotSpringStill,(new Item.Properties()).tab(ModCoreUrushi.UrushiTab).stacksTo(1));});
     public static final RegistryObject<Item> vegetable_oil =IF("vegetable_oil");
    public static final RegistryObject<Block> oil_extractor =BF("oil_extractor","a",-1,() -> {return new OilExtractorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.LADDER).strength(1F, 3.0F));});
    public static final RegistryObject<Block> fryer =BF("fryer","p",0,() -> {return new FryerBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.WOOL).sound(SoundType.METAL).strength(1F, 10.0F).requiresCorrectToolForDrops().dynamicShape());});
    public static final RegistryObject<Block> sandpaper_block =B("sandpaper_block","h",-1,() -> {return new SandpaperBlock(BlockBehaviour.Properties.of(Material.SAND, MaterialColor.WOOL).sound(SoundType.SOUL_SAND).strength(0.3F, 10.0F));});
    public static final RegistryObject<Block> invisible_button =BLOCKS.register("invisible_button",() -> {return new InvisibleButtonBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.WOOL).sound(SoundType.SOUL_SAND).strength(0.3F, 10.0F).noCollission());});
    public static final RegistryObject<Block> hidden_invisible_button =BLOCKS.register("hidden_invisible_button",() -> {return new HiddenInvisibleButtonBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.WOOL).sound(SoundType.SOUL_SAND).strength(0.3F, 10.0F));});
    public static final RegistryObject<Item> invisible_button_item =ITEMS.register("invisible_button", () -> {return new InvisibleButtonItem(invisible_button.get(),(new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Block> invisible_lever =BLOCKS.register("invisible_lever",() -> {return new InvisibleLeverBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.WOOL).sound(SoundType.SOUL_SAND).instabreak().noCollission());});
    public static final RegistryObject<Block> hidden_invisible_lever =BLOCKS.register("hidden_invisible_lever",() -> {return new HiddenInvisibleLeverBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.WOOL).sound(SoundType.SOUL_SAND).strength(0.3F, 10.0F));});
    public static final RegistryObject<Item> invisible_lever_item =ITEMS.register("invisible_lever", () -> {return new InvisibleLeverItem(invisible_lever.get(),(new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Block> invisible_pressure_plate =BLOCKS.register("invisible_pressure_plate",() -> {return new InvisiblePressurePlateBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.WOOL).sound(SoundType.SOUL_SAND).strength(0.3F, 10.0F).noCollission());});
    public static final RegistryObject<Block> hidden_invisible_pressure_plate =BLOCKS.register("hidden_invisible_pressure_plate",() -> {return new HiddenInvisiblePressurePlateBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.WOOL).sound(SoundType.SOUL_SAND).strength(0.3F, 10.0F));});
    public static final RegistryObject<Item> invisible_pressure_plate_item =ITEMS.register("invisible_pressure_plate", () -> {return new InvisiblePressurePlateItem(invisible_pressure_plate.get(),(new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Block> kakuriyo_dirt =B("kakuriyo_dirt","s",-1,() -> {return new Block(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.TERRACOTTA_RED).strength(0.4F, 10.0F).sound(SoundType.ROOTED_DIRT));});
    public static final RegistryObject<Block> kakuriyo_grass_block =B("kakuriyo_grass_block","s",-1,() -> {return new KakuriyoGrassBlock(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.GRASS).strength(0.6F, 10.0F).sound(SoundType.GRASS).randomTicks());});
    public static final RegistryObject<Block> yomi_stone =B("yomi_stone","p",0,() -> {return new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).strength(1F, 30.0F).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops());});
    public static final RegistryObject<Block> cobbled_yomi_stone =B("cobbled_yomi_stone","p",0,() -> {return new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).strength(1F, 30.0F).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops());});
    public static final RegistryObject<Block> polished_yomi_stone =B("polished_yomi_stone","p",0,() -> {return new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).strength(1F, 30.0F).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops());});
    public static final RegistryObject<Block> large_yomi_stone_bricks =B("large_yomi_stone_bricks","p",0,() -> {return new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).strength(1F, 30.0F).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops());});
    public static final RegistryObject<Block> small_yomi_stone_bricks =B("small_yomi_stone_bricks","p",0,() -> {return new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).strength(1F, 30.0F).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops());});
    public static final RegistryObject<Block> yomi_stone_slab =B("yomi_stone_slab","p",0,() -> {return new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops().strength(1.0F, 30.0F));});
    public static final RegistryObject<Block> cobbled_yomi_stone_slab =B("cobbled_yomi_stone_slab","p",0,() -> {return new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops().strength(1.0F, 30.0F));});
    public static final RegistryObject<Block> polished_yomi_stone_slab =B("polished_yomi_stone_slab","p",0,() -> {return new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops().strength(1.0F, 30.0F));});
    public static final RegistryObject<Block> large_yomi_stone_brick_slab =B("large_yomi_stone_brick_slab","p",0,() -> {return new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops().strength(1.0F, 30.0F));});
    public static final RegistryObject<Block> small_yomi_stone_brick_slab =B("small_yomi_stone_brick_slab","p",0,() -> {return new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops().strength(1.0F, 30.0F));});
    public static final RegistryObject<Block> yomi_stone_stairs =B("yomi_stone_stairs","p",0,() -> {return new StairBlock(yomi_stone.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops().strength(1.0F, 30.0F));});
    public static final RegistryObject<Block> cobbled_yomi_stone_stairs =B("cobbled_yomi_stone_stairs","p",0,() -> {return new StairBlock(cobbled_yomi_stone.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops().strength(1.0F, 30.0F));});
    public static final RegistryObject<Block> polished_yomi_stone_stairs =B("polished_yomi_stone_stairs","p",0,() -> {return new StairBlock(polished_yomi_stone.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops().strength(1.0F, 30.0F));});
    public static final RegistryObject<Block> large_yomi_stone_brick_stairs =B("large_yomi_stone_brick_stairs","p",0,() -> {return new StairBlock(large_yomi_stone_bricks.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops().strength(1.0F, 30.0F));});
    public static final RegistryObject<Block> small_yomi_stone_brick_stairs =B("small_yomi_stone_brick_stairs","p",0,() -> {return new StairBlock(small_yomi_stone_bricks.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops().strength(1.0F, 30.0F));});
    public static final RegistryObject<Block> cobbled_yomi_stone_wall =B("cobbled_yomi_stone_wall","p",0,() -> {return new WallBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops().strength(1.0F, 30.0F));});
    public static final RegistryObject<Block> polished_yomi_stone_wall =B("polished_yomi_stone_wall","p",0,() -> {return new WallBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops().strength(1.0F, 30.0F));});
    public static final RegistryObject<Block> large_yomi_stone_brick_wall =B("large_yomi_stone_brick_wall","p",0,() -> {return new WallBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops().strength(1.0F, 30.0F));});
    public static final RegistryObject<Block> small_yomi_stone_brick_wall =B("small_yomi_stone_brick_wall","p",0,() -> {return new WallBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops().strength(1.0F, 30.0F));});
    public static final RegistryObject<Block> yomi_stone_trapdoor =B("yomi_stone_trapdoor","p",-1,() -> {return new TrapDoorBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).sound(SoundType.STONE).strength(1.0F, 10.0F).noOcclusion().requiresCorrectToolForDrops().isValidSpawn(ItemAndBlockRegister::never));});
    public static final RegistryObject<Block> jadeite_ore =B("jadeite_ore","p",2,() -> {return new OreBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(3F, 30.0F).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops());});
    public static final RegistryObject<Block> yomi_copper_ore =B("yomi_copper_ore","p",1,() -> {return new OreBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(3F, 30.0F).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops());});
    public static final RegistryObject<Block> yomi_iron_ore =B("yomi_iron_ore","p",1,() -> {return new OreBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(3F, 30.0F).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops());});
    public static final RegistryObject<Block> yomi_gold_ore =B("yomi_gold_ore","p",2,() -> {return new OreBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(3F, 30.0F).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops());});
    public static final RegistryObject<Block> quartz_cluster =B("quartz_cluster","p",-1,() -> {return new QuartzClusterBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.WOOL).strength(0.5F, 5.0F).sound(SoundType.AMETHYST_CLUSTER).noCollission().lightLevel((p_235470_0_) -> {return 5;}));});
    public static final RegistryObject<Item> jadeite =I("jadeite");
    public static final RegistryObject<Item> enhanced_jadeite =I("enhanced_jadeite");
    public static final RegistryObject<Block> shiitake =BN("shiitake","a",-1,() -> {return new ShiitakeBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.COLOR_BROWN).randomTicks().instabreak().noCollission().sound(SoundType.GRASS));});
    public static final RegistryObject<Block> wall_shiitake =BN("wall_shiitake","a",-1,() -> {return new WallShiitakeBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.COLOR_BROWN).randomTicks().instabreak().noCollission().sound(SoundType.GRASS));});
    public static final RegistryObject<StandingAndWallBlockItem> shiitake_item =ITEMS.register("shiitake",() -> {return new StandingAndWallBlockItem(shiitake.get(), wall_shiitake.get(), (new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Block> eulalia =B("eulalia","h",-1,() -> {return new EulaliaBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.WOOD).instabreak().noCollission().sound(SoundType.GRASS));});
    public static final RegistryObject<Block> double_eulalia =BN("double_eulalia","h",-1,() -> {return new DoubleEulaliaBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.WOOD).instabreak().noCollission().sound(SoundType.GRASS));});
    public static final RegistryObject<Block> lycoris =B("lycoris","h",-1,() -> {return new SmallFlowerBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.COLOR_RED).instabreak().noCollission().sound(SoundType.GRASS));});
    public static final RegistryObject<Block> yomi_vines =BN("yomi_vines","n",-1,() -> {return new YomiVinesBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.PLANT).instabreak().sound(SoundType.CAVE_VINES).noCollission().lightLevel(YomiVinesBlock.LIGHT_EMISSION));});
    public static final RegistryObject<Block> yomi_vines_plant =BN("yomi_vines_plant","n",-1,() -> {return new YomiVinesPlantBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.PLANT).instabreak().sound(SoundType.CAVE_VINES).noCollission().lightLevel(YomiVinesPlantBlock.LIGHT_EMISSION));});
    public static final RegistryObject<Item> yomotsuhegui_fruit =ITEMS.register("yomotsuhegui_fruit", () -> {return new ItemNameBlockItem(yomi_vines.get(),(new Item.Properties()).food(FoodUrushi.YomitsuheguiFruit).tab(ModCoreUrushi.UrushiFoodTab));});
    public static final RegistryObject<Block> lantern_plant =BN("lantern_plant","a",-1,() -> {return new LanternPlantBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.PLANT).instabreak().sound(SoundType.CAVE_VINES).randomTicks().noCollission().lightLevel(LanternPlantBlock.LIGHT_EMISSION));});
    public static final RegistryObject<Item> lantern_plant_fruit =ITEMS.register("lantern_plant_fruit", () -> {return new ItemNameBlockItem(lantern_plant.get(),(new Item.Properties()).food(FoodUrushi.LanternPlant).tab(ModCoreUrushi.UrushiFoodTab));});
    public static final RegistryObject<Block> lantern_plant_torch =BN("lantern_plant_torch","a",-1,() -> {return new LanternPlantTorchBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).instabreak().noCollission().noOcclusion().lightLevel((p_235470_0_) -> {return 15;}));});
    public static final RegistryObject<Block> wall_lantern_plant_torch =BN("wall_lantern_plant_torch","a",-1,() -> {return new WallLanternPlantTorchBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).sound(SoundType.WOOD).instabreak().noCollission().noOcclusion().lightLevel((p_235470_0_) -> {return 15;}));});
    public static final RegistryObject<StandingAndWallBlockItem> lantern_plant_torch_item =ITEMS.register("lantern_plant_torch",() -> {return new StandingAndWallBlockItem(lantern_plant_torch.get(), wall_lantern_plant_torch.get(), (new Item.Properties()).tab(ModCoreUrushi.UrushiTab));});
    public static final RegistryObject<Block> kakuriyo_portal =BN("kakuriyo_portal","n",-1,() -> {return new KakuriyoPortalBlock(BlockBehaviour.Properties.of(Material.PORTAL, MaterialColor.COLOR_YELLOW).strength(1F, 30.0F).sound(SoundType.GLASS).noCollission().lightLevel((p_235470_0_) -> {return 15;}));});
    public static final RegistryObject<Block> kakuriyo_portal_core =B("kakuriyo_portal_core","a",-1,() -> {return new KakuriyoPortalCoreBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).sound(SoundType.WOOD).strength(2.0F, 10.0F).noDrops());});
    public static final RegistryObject<Block> ghost_kakuriyo_portal_core =B("ghost_kakuriyo_portal_core","a",-1,() -> {return new GhostKakuriyoPortalCoreBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).sound(SoundType.WOOD).strength(2.0F, 10.0F).noDrops().noOcclusion().isRedstoneConductor(ItemAndBlockRegister::never).isSuffocating(ItemAndBlockRegister::never).isViewBlocking(ItemAndBlockRegister::never));});
    public static final RegistryObject<Block> red_kakuriyo_portal_frame =B("red_kakuriyo_portal_frame","a",-1,() -> {return new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).sound(SoundType.WOOD).strength(2.0F, 10.0F).noDrops());});
    public static final RegistryObject<Block> ghost_red_kakuriyo_portal_frame =B("ghost_red_kakuriyo_portal_frame","a",-1,() -> {return new GhostRotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).sound(SoundType.WOOD).strength(2.0F, 10.0F).noDrops().noOcclusion().isRedstoneConductor(ItemAndBlockRegister::never).isSuffocating(ItemAndBlockRegister::never).isViewBlocking(ItemAndBlockRegister::never));});
    public static final RegistryObject<Block> black_kakuriyo_portal_frame =B("black_kakuriyo_portal_frame","a",-1,() -> {return new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BLACK).sound(SoundType.WOOD).strength(2.0F, 10.0F).noDrops());});
    public static final RegistryObject<Block> ghost_black_kakuriyo_portal_frame =B("ghost_black_kakuriyo_portal_frame","a",-1,() -> {return new GhostBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BLACK).sound(SoundType.WOOD).strength(2.0F, 10.0F).noDrops().noOcclusion().isRedstoneConductor(ItemAndBlockRegister::never).isSuffocating(ItemAndBlockRegister::never).isViewBlocking(ItemAndBlockRegister::never));});
    public static final RegistryObject<Item> ghost_core =I("ghost_core");
    public static final RegistryObject<Block> ghost_dirt =B("ghost_dirt","s",-1,() -> {return new GhostBlock(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.DIRT).sound(SoundType.GRAVEL).strength(0.5F).noOcclusion().isRedstoneConductor(ItemAndBlockRegister::never).isSuffocating(ItemAndBlockRegister::never).isViewBlocking(ItemAndBlockRegister::never));});
    public static final RegistryObject<Block> ghost_stone =B("ghost_stone","p",-1,() -> {return new GhostBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).sound(SoundType.STONE).strength(1F).noOcclusion().isRedstoneConductor(ItemAndBlockRegister::never).isSuffocating(ItemAndBlockRegister::never).isViewBlocking(ItemAndBlockRegister::never).requiresCorrectToolForDrops());});
    public static final RegistryObject<Item> wood_element_magatama =ITEMS.register("wood_element_magatama", () -> {return new WoodMagatamaItem((new Item.Properties()).tab(ModCoreUrushi.UrushiTab).stacksTo(1));});
    public static final RegistryObject<Item> fire_element_magatama =ITEMS.register("fire_element_magatama", () -> {return new FireMagatamaItem((new Item.Properties()).tab(ModCoreUrushi.UrushiTab).stacksTo(1));});
    public static final RegistryObject<Item> earth_element_magatama =ITEMS.register("earth_element_magatama", () -> {return new EarthMagatamaItem((new Item.Properties()).tab(ModCoreUrushi.UrushiTab).stacksTo(1));});
    public static final RegistryObject<Item> metal_element_magatama =ITEMS.register("metal_element_magatama", () -> {return new MetalMagatamaItem((new Item.Properties()).tab(ModCoreUrushi.UrushiTab).stacksTo(1));});
    public static final RegistryObject<Item> water_element_magatama =ITEMS.register("water_element_magatama", () -> {return new WaterMagatamaItem((new Item.Properties()).tab(ModCoreUrushi.UrushiTab).stacksTo(1));});
    public static final RegistryObject<Block> jadeite_block =B("jadeite_block","p",-1,() -> {return new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.EMERALD).strength(1F, 10.0F).sound(SoundType.STONE).requiresCorrectToolForDrops());});
    public static final RegistryObject<Block> jadeite_slab =B("jadeite_slab","p",-1,() -> {return new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.EMERALD).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> jadeite_stairs =B("jadeite_stairs","p",-1,() -> {return new StairBlock(jadeite_block.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.STONE, MaterialColor.EMERALD).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> jadeite_brick =B("jadeite_brick","p",-1,() -> {return new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.EMERALD).strength(1F, 10.0F).sound(SoundType.STONE).requiresCorrectToolForDrops());});
    public static final RegistryObject<Block> jadeite_brick_slab =B("jadeite_brick_slab","p",-1,() -> {return new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.EMERALD).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> jadeite_brick_stairs =B("jadeite_brick_stairs","p",-1,() -> {return new StairBlock(jadeite_brick.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.STONE, MaterialColor.EMERALD).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_jadeite_block =B("smooth_jadeite_block","p",-1,() -> {return new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.EMERALD).strength(1F, 10.0F).sound(SoundType.STONE).requiresCorrectToolForDrops());});
    public static final RegistryObject<Block> smooth_jadeite_slab =B("smooth_jadeite_slab","p",-1,() -> {return new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.EMERALD).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> smooth_jadeite_stairs =B("smooth_jadeite_stairs","p",-1,() -> {return new StairBlock(smooth_jadeite_block.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.STONE, MaterialColor.EMERALD).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final RegistryObject<Block> jadeite_pillar =B("jadeite_pillar","p",-1,() -> {return new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.EMERALD).sound(SoundType.STONE).strength(1.0F, 10.0F).requiresCorrectToolForDrops());});
    //public static final RegistryObject<Item> magonote =ITEMS.register("magonote", () -> {return new MagonoteItem((new Item.Properties()).tab(ModCoreUrushi.UrushiTab).stacksTo(1).durability(4096));});
    public static final RegistryObject<Item> wood_amber =I("wood_amber");
    public static final RegistryObject<Item> fire_amber =I("fire_amber");
    public static final RegistryObject<Item> earth_amber =I("earth_amber");
    public static final RegistryObject<Item> metal_amber =I("metal_amber");
    public static final RegistryObject<Item> water_amber =I("water_amber");
    public static final RegistryObject<Block> petrified_log =BW("petrified_log","p",-1,() -> {return new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.WOOD).sound(SoundType.STONE).strength(1.0F, 10.0F).requiresCorrectToolForDrops());});
    public static final RegistryObject<Block> petrified_log_with_wood_amber =BW("petrified_log_with_wood_amber","p",-1,() -> {return new HorizonalRotateBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.WOOD).sound(SoundType.STONE).strength(1.0F, 10.0F).requiresCorrectToolForDrops());});
    public static final RegistryObject<Block> petrified_log_with_fire_amber =BW("petrified_log_with_fire_amber","p",-1,() -> {return new HorizonalRotateBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.WOOD).sound(SoundType.STONE).strength(1.0F, 10.0F).requiresCorrectToolForDrops());});
    public static final RegistryObject<Block> petrified_log_with_earth_amber =BW("petrified_log_with_earth_amber","p",-1,() -> {return new HorizonalRotateBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.WOOD).sound(SoundType.STONE).strength(1.0F, 10.0F).requiresCorrectToolForDrops());});
    public static final RegistryObject<Block> petrified_log_with_metal_amber =BW("petrified_log_with_metal_amber","p",-1,() -> {return new HorizonalRotateBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.WOOD).sound(SoundType.STONE).strength(1.0F, 10.0F).requiresCorrectToolForDrops());});
    public static final RegistryObject<Block> petrified_log_with_water_amber =BW("petrified_log_with_water_amber","p",-1,() -> {return new HorizonalRotateBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.WOOD).sound(SoundType.STONE).strength(1.0F, 10.0F).requiresCorrectToolForDrops());});
    public static final RegistryObject<Block> petrified_planks =BW("petrified_planks","p",-1,() -> {return new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.WOOD).sound(SoundType.STONE).strength(1.0F, 10.0F).requiresCorrectToolForDrops());});

    private static boolean never(BlockState state, BlockGetter blockGetter, BlockPos blockPos) {
        return false;
    }

    private static boolean never(BlockState state, BlockGetter blockGetter, BlockPos blockPos, EntityType<?> entityType) {
   return false;
    }
    private static boolean always(BlockState p_50775_, BlockGetter p_50776_, BlockPos p_50777_) {
        return true;
    }

    private static FlammableRotatedPillarBlock log(MaterialColor p_50789_, MaterialColor p_50790_) {
        return new FlammableRotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, (p_152624_) -> {
            return p_152624_.getValue(FlammableRotatedPillarBlock.AXIS) == Direction.Axis.Y ? p_50789_ : p_50790_;
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
        return new FlammableLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES,color).strength(0.2F).randomTicks().sound(p_152615_).noOcclusion().isValidSpawn(ItemAndBlockRegister::never).isSuffocating(ItemAndBlockRegister::never).isViewBlocking(ItemAndBlockRegister::never));
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
    private static <T extends Item> RegistryObject<T> IW(String name) {
        RegistryObject<Item> object = ITEMS.register(name, ()-> {
            return new Item((new Item.Properties()).tab(ModCoreUrushi.UrushiWoodTab));
        });
        return (RegistryObject<T>) object;
    }
    private static <T extends Item> RegistryObject<T> IF(String name) {
        RegistryObject<Item> object = ITEMS.register(name, ()-> {
            return new Item((new Item.Properties()).tab(ModCoreUrushi.UrushiFoodTab));
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
    private static <T extends Block> RegistryObject<T> BW(String name,String tool,int l, Supplier<T > sup) {
        RegistryObject<T> object = BLOCKS.register(name, sup);
        ITEMS.register(name,() -> {return new BlockItem( Objects.requireNonNull(object.get()), (new Item.Properties()).tab(ModCoreUrushi.UrushiWoodTab));});

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
    private static <T extends Block> RegistryObject<T> BF(String name,String tool,int l, Supplier<T > sup) {
        RegistryObject<T> object = BLOCKS.register(name, sup);
        ITEMS.register(name,() -> {return new BlockItem( Objects.requireNonNull(object.get()), (new Item.Properties()).tab(ModCoreUrushi.UrushiFoodTab));});
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
    private static <T extends Block> RegistryObject<T> BN(String name,String tool,int l, Supplier<T > sup) {
        RegistryObject<T> object = BLOCKS.register(name, sup);
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



}
