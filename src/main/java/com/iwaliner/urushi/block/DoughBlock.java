package com.iwaliner.urushi.block;


import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DoughBlock extends HorizonalRotateBlock {
    protected static final VoxelShape SHAPEA = Block.box(3.0D, 0.0D, 0D, 13.0D, 2.0D, 16.0D);
    protected static final VoxelShape SHAPEB = Block.box(0D, 0.0D, 3D, 16D, 2.0D, 13.0D);

    public DoughBlock(Properties p_i48377_1_) {
        super(p_i48377_1_);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        if(state.getValue(FACING)== Direction.NORTH||state.getValue(FACING)==Direction.SOUTH){
            return SHAPEB;
        }else{
            return SHAPEA;
        }
    }

}
