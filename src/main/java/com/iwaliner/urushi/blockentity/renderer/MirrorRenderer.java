package com.iwaliner.urushi.blockentity.renderer;

import com.iwaliner.urushi.ItemAndBlockRegister;
import com.iwaliner.urushi.ModCoreUrushi;
import com.iwaliner.urushi.blockentity.EmitterBlockEntity;
import com.iwaliner.urushi.blockentity.MirrorBlockEntity;
import com.iwaliner.urushi.util.interfaces.Mirror;
import com.iwaliner.urushi.util.interfaces.ReiryokuImportable;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Matrix3f;
import com.mojang.math.Matrix4f;
import com.mojang.math.Vector3f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;

import java.util.List;


public class MirrorRenderer implements BlockEntityRenderer<MirrorBlockEntity> {

    private final BlockEntityRendererProvider.Context context;
    public MirrorRenderer(BlockEntityRendererProvider.Context context) {
        this.context=context;
    }

    public void render(MirrorBlockEntity blockEntity, float f1, PoseStack poseStack, MultiBufferSource bufferSource, int combinedLight, int combinedOverlay) {
   /*    if(blockEntity.getDisplayNextPos(blockEntity)!=null) {
           BlockPos mirrorPos = blockEntity.getBlockPos();
           List<LivingEntity> list = blockEntity.getLevel().getEntitiesOfClass(LivingEntity.class, new AABB(mirrorPos).inflate(20D));
           if (!list.isEmpty()) {
               for (LivingEntity entity : list) {
                   if (entity instanceof Player) {
                       Player player = (Player) entity;
                       if (player.getItemBySlot(EquipmentSlot.HEAD).getItem() == ItemAndBlockRegister.visualization_goggles.get()) {

                           BlockPos nextPos = blockEntity.getDisplayNextPos(blockEntity);

                           boolean hasGoal=blockEntity.getDisplayDistance(blockEntity)!=-1;
                           int size=hasGoal? blockEntity.getDisplayDistance(blockEntity) : Mth.floor(EmitterBlockEntity.particleSpeed*80-0.25D);
                           boolean isOblique=Mth.abs(nextPos.getX() - mirrorPos.getX())+Mth.abs(nextPos.getY() - mirrorPos.getY())+Mth.abs(nextPos.getZ() - mirrorPos.getZ())==2;
                           if(hasGoal) {
                               for (int i = 0; i <= size; i++) {
                                   poseStack.translate((double) nextPos.getX() - mirrorPos.getX(), (double) nextPos.getY() - mirrorPos.getY(), (double) nextPos.getZ() - mirrorPos.getZ());
                                   PoseStack.Pose pose = poseStack.last();

                                   if (i < size) {
                                       VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.lines());
                                       LevelRenderer.renderLineBox(poseStack, vertexConsumer, 0.4D, 0.4D, 0.4D, 0.6D, 0.6D, 0.6D, 1.0F, 0.75F, 0.75F, 1.0F, 1.0F, 0.75F, 0.75F);
                                   } else {

                                       VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.lines());
                                       LevelRenderer.renderLineBox(poseStack, vertexConsumer, 0D, 0D, 0D, 1D, 1D, 1D, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F);
                                   }
                               }
                           }else{
                               if(isOblique){ size=Mth.floor((double) size*0.7072136D);}
                               for (int i = 0; i <= size; i++) {
                                   poseStack.translate((double) nextPos.getX() - mirrorPos.getX(), (double) nextPos.getY() - mirrorPos.getY(), (double) nextPos.getZ() - mirrorPos.getZ());
                                   PoseStack.Pose pose = poseStack.last();

                                   if (i < size) {
                                       VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.lines());
                                       LevelRenderer.renderLineBox(poseStack, vertexConsumer, 0.4D, 0.4D, 0.4D, 0.6D, 0.6D, 0.6D, 1.0F, 0.75F, 0.75F, 1.0F, 1.0F, 0.75F, 0.75F);
                                   }
                               }
                           }
                       }
                   }
                   }
               }
           }

*/
    }


}