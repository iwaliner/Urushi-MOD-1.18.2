package com.iwaliner.urushi.jei;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.iwaliner.urushi.ItemAndBlockRegister;
import com.iwaliner.urushi.ModCoreUrushi;
import com.iwaliner.urushi.recipe.FryingRecipe;
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

public class FryingRecipeCategory implements IRecipeCategory<FryingRecipe> {
    public static final ResourceLocation location=new ResourceLocation(ModCoreUrushi.ModID,"frying");
    public static final ResourceLocation tex=new ResourceLocation(ModCoreUrushi.ModID,"textures/gui/fryer.png");
    private final IDrawable background;
    private final IDrawable icon;
    protected final IDrawableStatic staticFlame;
    protected final IDrawableAnimated animatedFlame;
    private final int regularCookTime;
    private final LoadingCache<Integer, IDrawableAnimated> cachedArrows;

    public  FryingRecipeCategory(IGuiHelper guiHelper){
        this.background=guiHelper.createDrawable(tex,55,16,82,54);
        this.icon=guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK,new ItemStack(ItemAndBlockRegister.fryer.get()));
       // this.background = guiHelper.createDrawable(Constants.RECIPE_GUI_VANILLA, 0, 114, 82, 54);
        this.regularCookTime = 100;
        staticFlame = guiHelper.createDrawable(tex, 176, 0, 14, 14);
        animatedFlame = guiHelper.createAnimatedDrawable(staticFlame, 300, IDrawableAnimated.StartDirection.TOP, true);

        this.cachedArrows = CacheBuilder.newBuilder()
                .maximumSize(25)
                .build(new CacheLoader<>() {
                    @Override
                    public IDrawableAnimated load(Integer cookTime) {
                         return guiHelper.drawableBuilder(tex, 176, 14, 24, 17)
                                .buildAnimated(cookTime, IDrawableAnimated.StartDirection.LEFT, false);
                    }
                });
    }


    @Override
    public Component getTitle() {
        return new TranslatableComponent("gui.jei.category.urushi.frying");
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
    public Class<? extends FryingRecipe> getRecipeClass() {
        return FryingRecipe.class;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, FryingRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(INPUT, 1, 1)
                .addIngredients(recipe.getIngredients().get(0));

        builder.addSlot(OUTPUT, 61, 19)
                .addItemStack(recipe.getResultItem());
    }

    @Override
    public void draw(FryingRecipe recipe, IRecipeSlotsView recipeSlotsView, PoseStack poseStack, double mouseX, double mouseY) {
        animatedFlame.draw(poseStack, 1, 20);

        IDrawableAnimated arrow = getArrow(recipe);
        arrow.draw(poseStack, 24, 18);
        drawCookTime(recipe, poseStack, 45);
    }
    protected void drawCookTime(FryingRecipe recipe, PoseStack poseStack, int y) {
        int cookTime = 100;
        if (cookTime > 0) {
            int cookTimeSeconds = cookTime / 20;
            TranslatableComponent timeString = new TranslatableComponent("gui.jei.category.urushi.frying.time.seconds", cookTimeSeconds);
            Minecraft minecraft = Minecraft.getInstance();
            Font fontRenderer = minecraft.font;
            int stringWidth = fontRenderer.width(timeString);
            fontRenderer.draw(poseStack, timeString, background.getWidth() - stringWidth, y, 0xFF808080);
        }
    }
    protected IDrawableAnimated getArrow(FryingRecipe recipe) {
        int cookTime = 100;
        if (cookTime <= 0) {
            cookTime = regularCookTime;
        }
        return this.cachedArrows.getUnchecked(cookTime);
    }
}
