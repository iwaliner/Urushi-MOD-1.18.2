package com.iwaliner.urushi;

import com.iwaliner.urushi.entiity.food.RiceFoodEntity;
import com.iwaliner.urushi.entiity.food.TKGFoodEntity;
import com.iwaliner.urushi.world.feature.JapaneseTimberBambooFeature;
import com.iwaliner.urushi.world.feature.KakuriyoPortalFeature;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.ColumnFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class FeatureRegister {
    public static final DeferredRegister<Feature<?>> Features = DeferredRegister.create(ForgeRegistries.FEATURES, ModCoreUrushi.ModID);
    public static final RegistryObject<Feature<JapaneseTimberBambooFeature.Configuration>> Bamboo=Features.register("bamboo", () -> new JapaneseTimberBambooFeature(JapaneseTimberBambooFeature.Configuration.CODEC));
    public static final RegistryObject<Feature<KakuriyoPortalFeature.Configuration>> KakuriyoPortal=Features.register("kakuriyo_portal", () -> new KakuriyoPortalFeature(KakuriyoPortalFeature.Configuration.CODEC));
    public static <T extends FeatureConfiguration> RegistryObject<Feature<T>> register(String name, Supplier<Feature<T>> featureSupplier) {
        return Features.register(name, featureSupplier);
    }
    public static void register(IEventBus eventBus) {
        Features.register(eventBus);
    }
}
