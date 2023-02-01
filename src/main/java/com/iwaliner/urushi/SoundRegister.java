package com.iwaliner.urushi;


import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SoundRegister {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, ModCoreUrushi.ModID);
    public static final RegistryObject<SoundEvent> WindBell = SOUNDS.register("wind_bell", () -> new SoundEvent(new ResourceLocation(ModCoreUrushi.ModID,"wind_bell")));

    public static void register(IEventBus eventBus) {
        SOUNDS.register(eventBus);
    }
}
