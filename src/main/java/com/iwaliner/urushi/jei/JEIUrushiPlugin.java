package com.iwaliner.urushi.jei;

import com.iwaliner.urushi.ItemAndBlockRegister;
import com.iwaliner.urushi.ModCoreUrushi;
import com.iwaliner.urushi.RecipeTypeRegister;
import com.iwaliner.urushi.recipe.*;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CampfireCookingRecipe;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class JEIUrushiPlugin implements IModPlugin {
    public static final RecipeType<FryingRecipe> JEI_FRYING = RecipeType.create(ModCoreUrushi.ModID, "frying", FryingRecipe.class);
    public static final RecipeType<HammeringRecipe> JEI_HAMMERING = RecipeType.create(ModCoreUrushi.ModID, "hammering", HammeringRecipe.class);
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(ModCoreUrushi.ModID,"jei_plugin");
    }


    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
       registration.addRecipeCategories(new FryingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new HammeringRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new OilExtractingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new ThrowingInRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new SenbakokiRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new FoxEatingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new SandpaperPolishingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new ChiseledLacquerLogRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new WoodElementTier1CraftingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new FireElementTier1CraftingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new EarthElementTier1CraftingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new MetalElementTier1CraftingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new WaterElementTier1CraftingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager= Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();

        List<FryingRecipe> FryingRecipes=recipeManager.getAllRecipesFor(RecipeTypeRegister.FryingRecipe);
        registration.addRecipes(new RecipeType<>(FryingRecipeCategory.location,FryingRecipe.class),FryingRecipes);

        List<HammeringRecipe> HammeringRecipes=recipeManager.getAllRecipesFor(RecipeTypeRegister.HammeringRecipe);
        registration.addRecipes(new RecipeType<>(HammeringRecipeCategory.location,HammeringRecipe.class),HammeringRecipes);

        List<OilExtractingRecipe> OilExtractingRecipes=recipeManager.getAllRecipesFor(RecipeTypeRegister.OilExtractingRecipe);
        registration.addRecipes(new RecipeType<>(OilExtractingRecipeCategory.location,OilExtractingRecipe.class),OilExtractingRecipes);

        List<ThrowingInRecipe> ThrowingInRecipes=recipeManager.getAllRecipesFor(RecipeTypeRegister.ThrowingInRecipe);
        registration.addRecipes(new RecipeType<>(ThrowingInRecipeCategory.location,ThrowingInRecipe.class),ThrowingInRecipes);
        List<SenbakokiRecipe> SenbakokiRecipes=recipeManager.getAllRecipesFor(RecipeTypeRegister.SenbakokiRecipe);
        registration.addRecipes(new RecipeType<>(SenbakokiRecipeCategory.location,SenbakokiRecipe.class),SenbakokiRecipes);
        List<FoxEatingRecipe> FoxEatingRecipes=recipeManager.getAllRecipesFor(RecipeTypeRegister.FoxEatingRecipe);
        registration.addRecipes(new RecipeType<>(FoxEatingRecipeCategory.location,FoxEatingRecipe.class),FoxEatingRecipes);
        List<SandpaperPolishingRecipe> SandpaperPolishingRecipes=recipeManager.getAllRecipesFor(RecipeTypeRegister.SandpaperPolishingRecipe);
        registration.addRecipes(new RecipeType<>(SandpaperPolishingRecipeCategory.location,SandpaperPolishingRecipe.class),SandpaperPolishingRecipes);
        List<ChiseledLacquerLogRecipe> ChiseledLacquerLogRecipes=recipeManager.getAllRecipesFor(RecipeTypeRegister.ChiseledLacquerLogRecipe);
        registration.addRecipes(new RecipeType<>(ChiseledLacquerLogRecipeCategory.location,ChiseledLacquerLogRecipe.class),ChiseledLacquerLogRecipes);
        List<WoodElementTier1CraftingRecipe> WoodElementTier1CraftingRecipes=recipeManager.getAllRecipesFor(RecipeTypeRegister.WoodElementTier1CraftingRecipe);
        registration.addRecipes(new RecipeType<>(WoodElementTier1CraftingRecipeCategory.location,WoodElementTier1CraftingRecipe.class),WoodElementTier1CraftingRecipes);
        List<FireElementTier1CraftingRecipe> FireElementTier1CraftingRecipes=recipeManager.getAllRecipesFor(RecipeTypeRegister.FireElementTier1CraftingRecipe);
        registration.addRecipes(new RecipeType<>(FireElementTier1CraftingRecipeCategory.location,FireElementTier1CraftingRecipe.class),FireElementTier1CraftingRecipes);
        List<EarthElementTier1CraftingRecipe> EarthElementTier1CraftingRecipes=recipeManager.getAllRecipesFor(RecipeTypeRegister.EarthElementTier1CraftingRecipe);
        registration.addRecipes(new RecipeType<>(EarthElementTier1CraftingRecipeCategory.location,EarthElementTier1CraftingRecipe.class),EarthElementTier1CraftingRecipes);
        List<MetalElementTier1CraftingRecipe> MetalElementTier1CraftingRecipes=recipeManager.getAllRecipesFor(RecipeTypeRegister.MetalElementTier1CraftingRecipe);
        registration.addRecipes(new RecipeType<>(MetalElementTier1CraftingRecipeCategory.location,MetalElementTier1CraftingRecipe.class),MetalElementTier1CraftingRecipes);
        List<WaterElementTier1CraftingRecipe> WaterElementTier1CraftingRecipes=recipeManager.getAllRecipesFor(RecipeTypeRegister.WaterElementTier1CraftingRecipe);
        registration.addRecipes(new RecipeType<>(WaterElementTier1CraftingRecipeCategory.location,WaterElementTier1CraftingRecipe.class),WaterElementTier1CraftingRecipes);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ItemAndBlockRegister.fryer.get()), JEI_FRYING);
        registration.addRecipeCatalyst(new ItemStack(ItemAndBlockRegister.hammer.get()), JEI_HAMMERING);
        registration.addRecipeCatalyst(new ItemStack(ItemAndBlockRegister.oil_extractor.get()), RecipeType.create(ModCoreUrushi.ModID, "oil_extracting", OilExtractingRecipe.class));
        registration.addRecipeCatalyst(new ItemStack(Items.WATER_BUCKET), RecipeType.create(ModCoreUrushi.ModID, "throwing_in", ThrowingInRecipe.class));
        registration.addRecipeCatalyst(new ItemStack(ItemAndBlockRegister.senbakoki.get()), RecipeType.create(ModCoreUrushi.ModID, "senbakoki", SenbakokiRecipe.class));
        registration.addRecipeCatalyst(new ItemStack(ItemAndBlockRegister.sandpaper_block.get()), RecipeType.create(ModCoreUrushi.ModID, "polishing", SandpaperPolishingRecipe.class));
        registration.addRecipeCatalyst(new ItemStack(ItemAndBlockRegister.chiseled_lacquer_log.get()), RecipeType.create(ModCoreUrushi.ModID, "chiseled_lacquer_log", ChiseledLacquerLogRecipe.class));
        registration.addRecipeCatalyst(new ItemStack(ItemAndBlockRegister.shichirin.get()), RecipeType.create( RecipeTypes.CAMPFIRE_COOKING.getUid().getNamespace(), RecipeTypes.CAMPFIRE_COOKING.getUid().getPath(), CampfireCookingRecipe.class));
        registration.addRecipeCatalyst(new ItemStack(ItemAndBlockRegister.wood_element_crafting_table_tier1.get()), RecipeType.create(ModCoreUrushi.ModID, "wood_element_tier1_crafting", WoodElementTier1CraftingRecipe.class));
        registration.addRecipeCatalyst(new ItemStack(ItemAndBlockRegister.fire_element_crafting_table_tier1.get()), RecipeType.create(ModCoreUrushi.ModID, "fire_element_tier1_crafting", FireElementTier1CraftingRecipe.class));
        registration.addRecipeCatalyst(new ItemStack(ItemAndBlockRegister.earth_element_crafting_table_tier1.get()), RecipeType.create(ModCoreUrushi.ModID, "earth_element_tier1_crafting", EarthElementTier1CraftingRecipe.class));
        registration.addRecipeCatalyst(new ItemStack(ItemAndBlockRegister.metal_element_crafting_table_tier1.get()), RecipeType.create(ModCoreUrushi.ModID, "metal_element_tier1_crafting", MetalElementTier1CraftingRecipe.class));
        registration.addRecipeCatalyst(new ItemStack(ItemAndBlockRegister.water_element_crafting_table_tier1.get()), RecipeType.create(ModCoreUrushi.ModID, "water_element_tier1_crafting", WaterElementTier1CraftingRecipe.class));

    }
}
