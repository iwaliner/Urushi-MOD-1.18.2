package com.iwaliner.urushi.blockentity.renderer;


import com.iwaliner.urushi.ItemAndBlockRegister;
import com.iwaliner.urushi.blockentity.EmitterBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;

import java.util.List;


public class EmitterRenderer implements BlockEntityRenderer<EmitterBlockEntity> {

    private final BlockEntityRendererProvider.Context context;
    public EmitterRenderer(BlockEntityRendererProvider.Context context) {
        this.context=context;
    }

    public void render(EmitterBlockEntity blockEntity, float f1, PoseStack poseStack, MultiBufferSource bufferSource, int combinedLight, int combinedOverlay) {
       if(blockEntity.getDisplayNextPos(blockEntity)!=null) {
           BlockPos mirrorPos = blockEntity.getBlockPos();
           List<LivingEntity> list = blockEntity.getLevel().getEntitiesOfClass(LivingEntity.class, new AABB(mirrorPos).inflate(20D));
           if (!list.isEmpty()) {
               for (LivingEntity entity : list) {
                   if (entity instanceof Player) {
                       Player player = (Player) entity;
                       if (player.getItemBySlot(EquipmentSlot.HEAD).getItem()== ItemAndBlockRegister.visualization_goggles.get()) {
                           BlockPos nextPos = blockEntity.getDisplayNextPos(blockEntity);

                           int size = blockEntity.getDisplayDistance(blockEntity);
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
                       }
                   }
                   }
               }
           }


    }


}