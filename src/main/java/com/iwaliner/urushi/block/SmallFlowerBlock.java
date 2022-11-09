package com.iwaliner.urushi.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Random;

public class SmallFlowerBlock extends BushBlock implements BonemealableBlock {
    protected static final float AABB_OFFSET = 3.0F;
    protected static final VoxelShape SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D);


    public SmallFlowerBlock( BlockBehaviour.Properties p_53514_) {
        super(p_53514_);
    }

    public VoxelShape getShape(BlockState p_53517_, BlockGetter p_53518_, BlockPos p_53519_, CollisionContext p_53520_) {
        Vec3 vec3 = p_53517_.getOffset(p_53518_, p_53519_);
        return SHAPE.move(vec3.x, vec3.y, vec3.z);
    }

    public BlockBehaviour.OffsetType getOffsetType() {
        return BlockBehaviour.OffsetType.XZ;
    }
    public boolean isValidBonemealTarget(BlockGetter p_57303_, BlockPos p_57304_, BlockState p_57305_, boolean p_57306_) {
        return true;
    }

    public boolean isBonemealSuccess(Level p_57308_, Random p_57309_, BlockPos p_57310_, BlockState p_57311_) {
        return true;
    }

    public void performBonemeal(ServerLevel p_57298_, Random p_57299_, BlockPos p_57300_, BlockState p_57301_) {
        popResource(p_57298_, p_57300_, new ItemStack(this));
    }

}
