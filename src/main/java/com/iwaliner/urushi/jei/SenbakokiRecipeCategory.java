package com.iwaliner.urushi.jei;

import com.iwaliner.urushi.ItemAndBlockRegister;
import com.iwaliner.urushi.ModCoreUrushi;
import com.iwaliner.urushi.recipe.HammeringRecipe;
import com.iwaliner.urushi.recipe.SenbakokiRecipe;
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
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import static mezz.jei.api.recipe.RecipeIngredientRole.INPUT;
import static mezz.jei.api.recipe.RecipeIngredientRole.OUTPUT;

public class SenbakokiRecipeCategory implements IRecipeCategory<SenbakokiRecipe> {
    public static final ResourceLocation location=new ResourceLocation(ModCoreUrushi.ModID,"senbakoki");
    public static final ResourceLocation tex=new ResourceLocation(ModCoreUrushi.ModID,"textures/gui/fryer.png");
    private final IDrawable background;
    private final IDrawable icon;
    private  final String textName;



    public SenbakokiRecipeCategory(IGuiHelper guiHelper){
        this.background=guiHelper.createDrawable(tex,0,166,82,35);
        this.icon=guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK,new ItemStack(ItemAndBlockRegister.senbakoki.get()));
        textName="senbakoki";
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
    public Class<? extends SenbakokiRecipe> getRecipeClass() {
        return SenbakokiRecipe.class;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, SenbakokiRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(INPUT, 1, 5)
                .addIngredients(recipe.getIngredients().get(0));

        builder.addSlot(OUTPUT, 61, 5)
                .addItemStack(recipe.getResultItem());
    }

    @Override
    public void draw(SenbakokiRecipe recipe, IRecipeSlotsView recipeSlotsView, PoseStack stack, double mouseX, double mouseY) {
        TranslatableComponent text = new TranslatableComponent("gui.jei.category.urushi."+textName+".text");
        Minecraft minecraft = Minecraft.getInstance();
        Font fontRenderer = minecraft.font;
        int stringWidth = fontRenderer.width(text);
        fontRenderer.draw(stack, text, background.getWidth() - stringWidth, 28, 0xFF808080);

    }
}
