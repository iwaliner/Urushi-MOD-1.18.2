package com.iwaliner.urushi;

import com.iwaliner.urushi.recipe.*;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RecipeTypeRegister {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZER =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, ModCoreUrushi.ModID);

    public static final RegistryObject<FryingRecipe.FryingSerializer> FryingSerializer
            = RECIPE_SERIALIZER.register("frying", com.iwaliner.urushi.recipe.FryingRecipe.FryingSerializer::new);
    public static final RegistryObject<HammeringRecipe.HammeringSerializer> HammeringSerializer
            = RECIPE_SERIALIZER.register("hammering", com.iwaliner.urushi.recipe.HammeringRecipe.HammeringSerializer::new);

    public static final RegistryObject<com.iwaliner.urushi.recipe.OilExtractingRecipe.OilExtractingSerializer> OilExtractingSerializer
            = RECIPE_SERIALIZER.register("oil_extracting", com.iwaliner.urushi.recipe.OilExtractingRecipe.OilExtractingSerializer::new);

    public static final RegistryObject<com.iwaliner.urushi.recipe.ThrowingInRecipe.ThrowingInSerializer> ThrowingInSerializer
            = RECIPE_SERIALIZER.register("throwing_in", com.iwaliner.urushi.recipe.ThrowingInRecipe.ThrowingInSerializer::new);
    public static final RegistryObject<SenbakokiRecipe.SenbakokiSerializer> SenbakokiSerializer
            = RECIPE_SERIALIZER.register("senbakoki", com.iwaliner.urushi.recipe.SenbakokiRecipe.SenbakokiSerializer::new);
    public static final RegistryObject<com.iwaliner.urushi.recipe.FoxEatingRecipe.FoxEatingSerializer> FoxEatingSerializer
            = RECIPE_SERIALIZER.register("fox_eating", com.iwaliner.urushi.recipe.FoxEatingRecipe.FoxEatingSerializer::new);
    public static final RegistryObject<SandpaperPolishingRecipe.SandpaperPolishingSerializer> SandpaperPolishingSerializer
            = RECIPE_SERIALIZER.register("polishing", com.iwaliner.urushi.recipe.SandpaperPolishingRecipe.SandpaperPolishingSerializer::new);
    public static final RegistryObject<com.iwaliner.urushi.recipe.ChiseledLacquerLogRecipe.ChiseledLacquerLogSerializer> ChiseledLacquerLogSerializer
            = RECIPE_SERIALIZER.register("chiseled_lacquer_log", com.iwaliner.urushi.recipe.ChiseledLacquerLogRecipe.ChiseledLacquerLogSerializer::new);
    public static final RegistryObject<WoodElementTier1CraftingRecipe.WoodElementTier1CraftingSerializer> WoodElementTier1CraftingSerializer
            = RECIPE_SERIALIZER.register("wood_element_tier1_crafting", com.iwaliner.urushi.recipe.WoodElementTier1CraftingRecipe.WoodElementTier1CraftingSerializer::new);
    public static final RegistryObject<FireElementTier1CraftingRecipe.FireElementTier1CraftingSerializer> FireElementTier1CraftingSerializer
            = RECIPE_SERIALIZER.register("fire_element_tier1_crafting", com.iwaliner.urushi.recipe.FireElementTier1CraftingRecipe.FireElementTier1CraftingSerializer::new);
    public static final RegistryObject<EarthElementTier1CraftingRecipe.EarthElementTier1CraftingSerializer> EarthElementTier1CraftingSerializer
            = RECIPE_SERIALIZER.register("earth_element_tier1_crafting", com.iwaliner.urushi.recipe.EarthElementTier1CraftingRecipe.EarthElementTier1CraftingSerializer::new);
    public static final RegistryObject<MetalElementTier1CraftingRecipe.MetalElementTier1CraftingSerializer> MetalElementTier1CraftingSerializer
            = RECIPE_SERIALIZER.register("metal_element_tier1_crafting", com.iwaliner.urushi.recipe.MetalElementTier1CraftingRecipe.MetalElementTier1CraftingSerializer::new);
    public static final RegistryObject<WaterElementTier1CraftingRecipe.WaterElementTier1CraftingSerializer> WaterElementTier1CraftingSerializer
            = RECIPE_SERIALIZER.register("water_element_tier1_crafting", com.iwaliner.urushi.recipe.WaterElementTier1CraftingRecipe.WaterElementTier1CraftingSerializer::new);



    public static RecipeType<FryingRecipe> FryingRecipe = new FryingRecipe.FryingRecipeType();
    public static RecipeType<HammeringRecipe> HammeringRecipe = new HammeringRecipe.HammeringRecipeType();
    public static RecipeType<OilExtractingRecipe> OilExtractingRecipe = new OilExtractingRecipe.OilExtractingRecipeType();
    public static RecipeType<ThrowingInRecipe> ThrowingInRecipe = new ThrowingInRecipe.ThrowingInRecipeType();
    public static RecipeType<SenbakokiRecipe> SenbakokiRecipe = new SenbakokiRecipe.SenbakokiRecipeType();
    public static RecipeType<FoxEatingRecipe> FoxEatingRecipe = new FoxEatingRecipe.FoxEatingRecipeType();
    public static RecipeType<SandpaperPolishingRecipe> SandpaperPolishingRecipe = new SandpaperPolishingRecipe.SandpaperPolishingRecipeType();
    public static RecipeType<ChiseledLacquerLogRecipe> ChiseledLacquerLogRecipe = new ChiseledLacquerLogRecipe.ChiseledLacquerLogRecipeType();
    public static RecipeType<WoodElementTier1CraftingRecipe> WoodElementTier1CraftingRecipe = new WoodElementTier1CraftingRecipe.WoodElementTier1CraftingRecipeType();
    public static RecipeType<FireElementTier1CraftingRecipe> FireElementTier1CraftingRecipe = new FireElementTier1CraftingRecipe.FireElementTier1CraftingRecipeType();
    public static RecipeType<EarthElementTier1CraftingRecipe> EarthElementTier1CraftingRecipe = new EarthElementTier1CraftingRecipe.EarthElementTier1CraftingRecipeType();
    public static RecipeType<MetalElementTier1CraftingRecipe> MetalElementTier1CraftingRecipe = new MetalElementTier1CraftingRecipe.MetalElementTier1CraftingRecipeType();
    public static RecipeType<WaterElementTier1CraftingRecipe> WaterElementTier1CraftingRecipe = new WaterElementTier1CraftingRecipe.WaterElementTier1CraftingRecipeType();


    public static void register(IEventBus eventBus) {
        RECIPE_SERIALIZER.register(eventBus);
    }
}
