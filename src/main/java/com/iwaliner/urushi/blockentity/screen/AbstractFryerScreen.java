package com.iwaliner.urushi.blockentity.screen;

import com.iwaliner.urushi.blockentity.menu.AbstractFryerMenu;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.recipebook.AbstractFurnaceRecipeBookComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.Slot;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public abstract class AbstractFryerScreen<T extends AbstractFryerMenu> extends AbstractContainerScreen<T>

{
    private boolean widthTooNarrow;
    private final ResourceLocation texture;

    public AbstractFryerScreen(T p_i51104_1_, Inventory p_i51104_3_, Component p_i51104_4_, ResourceLocation p_i51104_5_) {
        super(p_i51104_1_, p_i51104_3_, p_i51104_4_);
        this.texture = p_i51104_5_;
    }

    public void init() {
        super.init();
        this.widthTooNarrow = this.width < 379;
      this.titleLabelX = (this.imageWidth - this.font.width(this.title)) / 2;
    }

    public void containerTick() {
        super.containerTick();

    }

    public void render(PoseStack p_230430_1_, int p_230430_2_, int p_230430_3_, float p_230430_4_) {
        this.renderBackground(p_230430_1_);
           this.renderBg(p_230430_1_, p_230430_4_, p_230430_2_, p_230430_3_);
            super.render(p_230430_1_, p_230430_2_, p_230430_3_, p_230430_4_);
        this.renderTooltip(p_230430_1_, p_230430_2_, p_230430_3_);
       }

    protected void renderBg(PoseStack p_230450_1_, float p_230450_2_, int p_230450_3_, int p_230450_4_) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, this.texture);
        int i = this.leftPos;
        int j = this.topPos;
        this.blit(p_230450_1_, i, j, 0, 0, this.imageWidth, this.imageHeight);
        if (this.menu.isLit()) {
            int k = this.menu.getLitProgress();
            this.blit(p_230450_1_, i + 56, j + 36 + 12 - k, 176, 12 - k, 14, k + 1);
        }

        int l = this.menu.getBurnProgress();
        this.blit(p_230450_1_, i + 79, j + 34, 176, 14, l + 1, 16);
    }


    protected void slotClicked(Slot p_184098_1_, int p_184098_2_, int p_184098_3_, ClickType p_184098_4_) {
        super.slotClicked(p_184098_1_, p_184098_2_, p_184098_3_, p_184098_4_);
    }


    public void removed() {
        super.removed();
    }
}
