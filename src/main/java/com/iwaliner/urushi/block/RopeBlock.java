package com.iwaliner.urushi.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class RopeBlock extends FallingBlock implements SimpleWaterloggedBlock {
    protected static final VoxelShape SHAPE = Block.box(6.0D, 0.0D, 6D, 10.0D, 16.0D, 10.0D);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public RopeBlock(Properties p_49795_) {
        super(p_49795_);
        this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, Boolean.valueOf(false)));

    }

    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        return SHAPE;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_56051_) {
        p_56051_.add( WATERLOGGED);
    }
    public FluidState getFluidState(BlockState p_56073_) {
        return p_56073_.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(p_56073_);
    }
    public void entityInside(BlockState state, Level world, BlockPos pos, Entity entity) {
        Vec3 vec3 = entity.getDeltaMovement();
      entity.setDeltaMovement(new Vec3(0D, vec3.y,0D));
        super.entityInside(state, world, pos, entity);
    }
}
