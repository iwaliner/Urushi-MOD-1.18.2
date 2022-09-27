package com.iwaliner.urushi.jei;

import com.iwaliner.urushi.ItemAndBlockRegister;
import com.iwaliner.urushi.ModCoreUrushi;
import com.iwaliner.urushi.RecipeTypeRegister;
import com.iwaliner.urushi.recipe.*;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.ModIds;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.block.Blocks;

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
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ItemAndBlockRegister.fryer.get()), JEI_FRYING);
        registration.addRecipeCatalyst(new ItemStack(ItemAndBlockRegister.hammer.get()), JEI_HAMMERING);
        registration.addRecipeCatalyst(new ItemStack(ItemAndBlockRegister.oil_extractor.get()), RecipeType.create(ModCoreUrushi.ModID, "oil_extracting", OilExtractingRecipe.class));
        registration.addRecipeCatalyst(new ItemStack(Items.WATER_BUCKET), RecipeType.create(ModCoreUrushi.ModID, "throwing_in", ThrowingInRecipe.class));
        registration.addRecipeCatalyst(new ItemStack(ItemAndBlockRegister.senbakoki.get()), RecipeType.create(ModCoreUrushi.ModID, "senbakoki", SenbakokiRecipe.class));

    }
}
