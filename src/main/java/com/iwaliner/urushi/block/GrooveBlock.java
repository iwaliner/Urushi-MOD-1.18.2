package com.iwaliner.urushi.block;


import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class GrooveBlock extends HorizonalRotateBlock implements SimpleWaterloggedBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    private boolean haslid;
    private static final VoxelShape BASE = Block.box(0D, 0.0D, 0D, 16D, 2D, 16D);
    private static final VoxelShape SIDE_A1 = Block.box(0D, 2D, 0D, 2D, 16D, 16D);
    private static final VoxelShape SIDE_A2 = Block.box(14D, 2D, 0D, 16D, 16D, 16D);
    private static final VoxelShape SIDE_B1 = Block.box(0D, 2D, 0D, 16D, 16D, 2D);
    private static final VoxelShape SIDE_B2 = Block.box(0D, 2D, 14D, 16D, 16D, 16D);
    private static final VoxelShape LID = Block.box(0D, 14D, 0D, 16D, 16D, 16D);
    private static final VoxelShape A_AXIS_AABB = Shapes.or(BASE, SIDE_A1, SIDE_A2, LID);
    private static final VoxelShape B_AXIS_AABB = Shapes.or(BASE, SIDE_B1, SIDE_B2, LID);
    private static final VoxelShape A_AXIS_AABB_LIDLESS = Shapes.or(BASE, SIDE_A1, SIDE_A2);
    private static final VoxelShape B_AXIS_AABB_LIDLESS = Shapes.or(BASE, SIDE_B1, SIDE_B2);
    public GrooveBlock(boolean hasLid, Properties p_i48377_1_) {
        super(p_i48377_1_);
        haslid=hasLid;
        this.registerDefaultState(this.defaultBlockState().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED,false));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        if(state.getValue(FACING)== Direction.NORTH||state.getValue(FACING)==Direction.SOUTH){
            return haslid?A_AXIS_AABB:A_AXIS_AABB_LIDLESS;
        }else{
            return haslid?B_AXIS_AABB:B_AXIS_AABB_LIDLESS;
        }
    }
    public FluidState getFluidState(BlockState p_204507_1_) {
        return p_204507_1_.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(p_204507_1_);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_49915_) {
        p_49915_.add(FACING,WATERLOGGED);
    }

    @Override
    public boolean isPathfindable(BlockState p_60475_, BlockGetter p_60476_, BlockPos p_60477_, PathComputationType p_60478_) {
        return true;
    }

}
