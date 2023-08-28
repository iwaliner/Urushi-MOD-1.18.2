package com.iwaliner.urushi.entiity.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.AnimationUtils;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Function;
@OnlyIn(Dist.CLIENT)
public class RedOniModel<T extends Monster> extends HumanoidModel<T> {
    private final ModelPart oniHorn1= this.head.getChild("horn1");
    private final ModelPart oniHorn2= this.head.getChild("horn2");

    public RedOniModel(ModelPart p_170677_) {
        this(p_170677_,RenderType::entityTranslucent);
      }
    public RedOniModel(ModelPart p_170679_, Function<ResourceLocation, RenderType> p_170680_) {
        super(p_170679_,p_170680_);

    }

    @Override
    public void copyPropertiesTo(HumanoidModel<T> p_102873_) {
        super.copyPropertiesTo(p_102873_);
        p_102873_.head.copyFrom(this.oniHorn1);
        p_102873_.head.copyFrom(this.oniHorn2);
    }


    public void copyPropertiesTo(RedOniModel<T> p_102625_) {
        super.copyPropertiesTo(p_102625_);
        p_102625_.oniHorn1.copyFrom(this.oniHorn1);
        p_102625_.oniHorn2.copyFrom(this.oniHorn2);
    }

    protected Iterable<ModelPart> headParts() {
        return ImmutableList.of(this.head,this.oniHorn2,this.oniHorn1);
    }
    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = HumanoidModel.createMesh(CubeDeformation.NONE, 0F);
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartPose partpose = PartPose.offset(0.0F, 0F, 0.0F);

        partdefinition.addOrReplaceChild("horn1", CubeListBuilder.create().texOffs(25, 0).addBox(2F, -10F, -2.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0F)), partpose);
        partdefinition.addOrReplaceChild("horn2", CubeListBuilder.create().texOffs(25, 0).addBox(-3F, -10F, -2.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0F)), partpose);
        return LayerDefinition.create(meshdefinition, 64, 64);
    }
    public void setupAnim(T p_102001_, float p_102002_, float p_102003_, float p_102004_, float p_102005_, float p_102006_) {
        super.setupAnim(p_102001_, p_102002_, p_102003_, p_102004_, p_102005_, p_102006_);
        AnimationUtils.animateZombieArms(this.leftArm, this.rightArm, false, this.attackTime, p_102004_);


        this.oniHorn2.copyFrom(this.head);
        this.oniHorn1.copyFrom(this.head);


    }
    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        oniHorn1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        oniHorn2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        }
    public void setAllVisible(boolean p_103419_) {
        super.setAllVisible(p_103419_);
        this.oniHorn1.visible = p_103419_;
        this.oniHorn2.visible = p_103419_;

    }
}

