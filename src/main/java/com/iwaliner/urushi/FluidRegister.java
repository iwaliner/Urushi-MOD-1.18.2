package com.iwaliner.urushi;

import com.iwaliner.urushi.block.HotSpringWaterBlock;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FluidRegister {
    public static final ResourceLocation HotSpringStillTex=new ResourceLocation("block/water_still");
    public static final ResourceLocation HotSpringFlowingTex=new ResourceLocation("block/water_flow");
    public static final ResourceLocation HotSpringTex=new ResourceLocation("block/water_overlay");

    public static final DeferredRegister<Fluid> FLUIDS=DeferredRegister.create(ForgeRegistries.FLUIDS,ModCoreUrushi.ModID);

    public static final RegistryObject<FlowingFluid> HotSpringStill
            = FLUIDS.register("hot_spring_water", () -> new ForgeFlowingFluid.Source(FluidRegister.HotSpringProperty));

    public static final RegistryObject<FlowingFluid> HotSpringFlow
            = FLUIDS.register("flowing_hot_spring_water", () -> new ForgeFlowingFluid.Flowing(FluidRegister.HotSpringProperty));


    public static final ForgeFlowingFluid.Properties HotSpringProperty = new ForgeFlowingFluid.Properties(
            () -> HotSpringStill.get(), () -> HotSpringFlow.get(), FluidAttributes.builder(HotSpringStillTex, HotSpringFlowingTex)
            .density(10).luminosity(1).viscosity(5).sound(SoundEvents.BUCKET_FILL).overlay(HotSpringTex)
            .color(0xbf60c3c9)).slopeFindDistance(2).levelDecreasePerBlock(1).canMultiply()
            .block(() -> ItemAndBlockRegister.HotSpringBlock.get()).bucket(() -> ItemAndBlockRegister.hot_spring_bucket.get());


    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
