package com.iwaliner.urushi.jei;

import com.iwaliner.urushi.ItemAndBlockRegister;
import com.iwaliner.urushi.ModCoreUrushi;
import com.iwaliner.urushi.recipe.FireElementTier1CraftingRecipe;
import com.iwaliner.urushi.recipe.WoodElementTier1CraftingRecipe;
import com.mojang.blaze3d.vertex.PoseStack;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import static mezz.jei.api.recipe.RecipeIngredientRole.INPUT;
import static mezz.jei.api.recipe.RecipeIngredientRole.OUTPUT;

public class FireElementTier1CraftingRecipeCategory implements IRecipeCategory<FireElementTier1CraftingRecipe> {
    public static final ResourceLocation location=new ResourceLocation(ModCoreUrushi.ModID,"fire_element_tier1_crafting");
    public static final ResourceLocation tex=new ResourceLocation(ModCoreUrushi.ModID,"textures/gui/tier1_crafting.png");
    private final IDrawable background;
    private final IDrawable icon;
    private  final String textName;



    public FireElementTier1CraftingRecipeCategory(IGuiHelper guiHelper){
        this.background=guiHelper.createDrawable(tex,0,61,116,61);
        this.icon=guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK,new ItemStack(ItemAndBlockRegister.fire_element_crafting_table_tier1.get()));
        textName="fire_element_tier1_crafting";
    }


    @Override
    public Component getTitle() {
        return new TranslatableComponent("gui.jei.category.urushi."+textName);
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public IDrawable getIcon() {
        return icon;
    }

    @Override
    public ResourceLocation getUid() {
        return location;
    }

    @Override
    public Class<? extends FireElementTier1CraftingRecipe> getRecipeClass() {
        return FireElementTier1CraftingRecipe.class;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, FireElementTier1CraftingRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(INPUT, 19, 1)
                .addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(INPUT, 37, 19)
                .addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(INPUT,19, 37)
                .addIngredients(recipe.getIngredients().get(2));
        builder.addSlot(INPUT, 1, 19)
                .addIngredients(recipe.getIngredients().get(3));

        builder.addSlot(OUTPUT, 95, 23)
                .addItemStack(recipe.getResultItem());
    }
    protected void drawReiryoku(FireElementTier1CraftingRecipe recipe, PoseStack poseStack, int y) {
          int reiryoku = recipe.getReiryoku();
        Component string = new TextComponent(String.valueOf(reiryoku));
        Minecraft minecraft = Minecraft.getInstance();
            Font fontRenderer = minecraft.font;
            int stringWidth = fontRenderer.width(string);
            fontRenderer.draw(poseStack, string, 72, y, 0xFFFFFFFF);

    }

    @Override
    public void draw(FireElementTier1CraftingRecipe recipe, IRecipeSlotsView recipeSlotsView, PoseStack stack, double mouseX, double mouseY) {
         drawReiryoku(recipe, stack, 9);
    }
}
