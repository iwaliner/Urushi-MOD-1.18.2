package com.iwaliner.urushi.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;


import java.util.Random;

public class AndonBlock extends Block {
    protected static final VoxelShape SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D);

    public AndonBlock(Properties p_i48440_1_) {
        super(p_i48440_1_);
    }

    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        return SHAPE;
    }

    @Override
    public void animateTick(BlockState p_180655_1_, Level p_180655_2_, BlockPos p_180655_3_, Random p_49891_) {
        double d0 = (double)p_180655_3_.getX() + 0.5D;
        double d1 = (double)p_180655_3_.getY() + 0.6D;
        double d2 = (double)p_180655_3_.getZ() + 0.5D;
        p_180655_2_.addParticle(ParticleTypes.FLAME, d0, d1, d2, 0.0D, 0.0D, 0.0D);
    }


}
