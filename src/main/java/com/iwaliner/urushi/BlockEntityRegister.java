package com.iwaliner.urushi;

import com.iwaliner.urushi.block.FryerBlock;
import com.iwaliner.urushi.blockentity.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = ModCoreUrushi.ModID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockEntityRegister {
    public static final DeferredRegister<BlockEntityType<?>> Tiles = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, ModCoreUrushi.ModID);
    public static final RegistryObject<BlockEntityType<WoodenCabinetrySlabBlockEntity>> WoodenCabinetrySlabBlockEntity=Tiles.register("wooden_cabinetry_slab", () -> BlockEntityType.Builder.of(WoodenCabinetrySlabBlockEntity::new, ItemAndBlockRegister.wooden_cabinetry_slab.get()).build(null));
    public static final RegistryObject<BlockEntityType<WoodenCabinetryBlockEntity>> WoodenCabinetryBlockEntity=Tiles.register("wooden_cabinetry", () -> BlockEntityType.Builder.of(WoodenCabinetryBlockEntity::new, ItemAndBlockRegister.wooden_cabinetry.get()).build(null));
    public static final RegistryObject<BlockEntityType<DoubledWoodenCabinetryBlockEntity>> DoubledWoodenCabinetryBlockEntity=Tiles.register("doubled_wooden_cabinetry", () -> BlockEntityType.Builder.of(DoubledWoodenCabinetryBlockEntity::new, ItemAndBlockRegister.doubled_wooden_cabinetry.get()).build(null));
    public static final RegistryObject<BlockEntityType<RiceCauldronBlockEntity>> RiceCauldronBlockEntity=Tiles.register("rice_cauldron", () -> BlockEntityType.Builder.of(RiceCauldronBlockEntity::new, ItemAndBlockRegister.rice_cauldron.get()).build(null));
    public static final RegistryObject<BlockEntityType<FryerBlockEntity>> FryerBlockEntity=Tiles.register("fryer", () -> BlockEntityType.Builder.of(FryerBlockEntity::new, ItemAndBlockRegister.fryer.get()).build(null));
    public static final RegistryObject<BlockEntityType<FoxHopperBlockEntity>> FoxHopperBlockEntity=Tiles.register("fox_hopper", () -> BlockEntityType.Builder.of(FoxHopperBlockEntity::new, ItemAndBlockRegister.fox_hopper.get()).build(null));
    public static final RegistryObject<BlockEntityType<SenryoubakoBlockEntity>> SenryoubakoBlockEntity=Tiles.register("senryoubako", () -> BlockEntityType.Builder.of(SenryoubakoBlockEntity::new, ItemAndBlockRegister.senryoubako.get()).build(null));
    public static void register(IEventBus eventBus) {
        Tiles.register(eventBus);
    }
}
