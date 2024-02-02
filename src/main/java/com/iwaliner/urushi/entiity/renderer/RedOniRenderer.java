package com.iwaliner.urushi.entiity.renderer;


import com.iwaliner.urushi.ClientSetUp;
import com.iwaliner.urushi.entiity.CushionEntity;
import com.iwaliner.urushi.entiity.RedOniEntity;
import com.iwaliner.urushi.entiity.model.CushionModel;
import com.iwaliner.urushi.entiity.model.RedOniModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;


public class RedOniRenderer extends HumanoidMobRenderer<RedOniEntity, RedOniModel<RedOniEntity>> {
    private static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation("urushi:textures/entity/oni_red.png");
    public RedOniRenderer(EntityRendererProvider.Context context) {
        this(context,ClientSetUp.RED_ONI);
     }

    public RedOniRenderer(EntityRendererProvider.Context p_174382_, ModelLayerLocation p_174383_) {
        super(p_174382_, new RedOniModel<>(p_174382_.bakeLayer(p_174383_)), 0.5F);
    }


    public ResourceLocation getTextureLocation(RedOniEntity p_115941_) {
        return TEXTURE_LOCATION;
    }

}
