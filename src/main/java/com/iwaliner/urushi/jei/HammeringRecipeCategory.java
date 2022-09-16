package com.iwaliner.urushi.jei;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.iwaliner.urushi.ItemAndBlockRegister;
import com.iwaliner.urushi.ModCoreUrushi;
import com.iwaliner.urushi.recipe.FryingRecipe;
import com.iwaliner.urushi.recipe.HammeringRecipe;
import com.mojang.blaze3d.vertex.PoseStack;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;


import static mezz.jei.api.recipe.RecipeIngredientRole.INPUT;
import static mezz.jei.api.recipe.RecipeIngredientRole.OUTPUT;

public class HammeringRecipeCategory implements IRecipeCategory<HammeringRecipe> {
    public static final ResourceLocation location=new ResourceLocation(ModCoreUrushi.ModID,"hammering");
    public static final ResourceLocation tex=new ResourceLocation(ModCoreUrushi.ModID,"textures/gui/fryer.png");
    private final IDrawable background;
    private final IDrawable icon;
    private  final String textName;



    public HammeringRecipeCategory(IGuiHelper guiHelper){
        this.background=guiHelper.createDrawable(tex,0,166,82,35);
        this.icon=guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK,new ItemStack(ItemAndBlockRegister.hammer.get()));
        textName="hammering";
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
    public Class<? extends HammeringRecipe> getRecipeClass() {
        return HammeringRecipe.class;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, HammeringRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(INPUT, 1, 5)
                .addIngredients(recipe.getIngredients().get(0));

        builder.addSlot(OUTPUT, 61, 5)
                .addItemStack(recipe.getResultItem());
    }

    @Override
    public void draw(HammeringRecipe recipe, IRecipeSlotsView recipeSlotsView, PoseStack stack, double mouseX, double mouseY) {
        TranslatableComponent text = new TranslatableComponent("gui.jei.category.urushi."+textName+".text");
        Minecraft minecraft = Minecraft.getInstance();
        Font fontRenderer = minecraft.font;
        int stringWidth = fontRenderer.width(text);
        fontRenderer.draw(stack, text, background.getWidth() - stringWidth, 28, 0xFF808080);

    }
}
