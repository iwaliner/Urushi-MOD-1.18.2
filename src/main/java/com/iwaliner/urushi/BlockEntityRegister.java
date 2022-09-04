package com.iwaliner.urushi;

import com.iwaliner.urushi.blockentity.RiceCauldronBlockEntity;
import com.iwaliner.urushi.blockentity.WoodenCabinetryBlockEntity;
import com.iwaliner.urushi.blockentity.WoodenCabinetrySlabBlockEntity;
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
    public static final RegistryObject<BlockEntityType<RiceCauldronBlockEntity>> RiceCauldronBlockEntity=Tiles.register("rice_cauldron", () -> BlockEntityType.Builder.of(RiceCauldronBlockEntity::new, ItemAndBlockRegister.rice_cauldron.get()).build(null));
    public static void register(IEventBus eventBus) {
        Tiles.register(eventBus);
    }
}
