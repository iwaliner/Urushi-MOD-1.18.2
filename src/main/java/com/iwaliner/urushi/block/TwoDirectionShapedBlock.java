package com.iwaliner.urushi.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class TwoDirectionShapedBlock extends HorizonalRotateBlock{
    private static  VoxelShape SHAPEA;
    private static  VoxelShape SHAPEB;
    public TwoDirectionShapedBlock(double d1,double d2,double d3,double d4,double d5,double d6,Properties p_i48377_1_) {
        super(p_i48377_1_);
       SHAPEA= Block.box(d1, d2, d3, d4, d5, d6);
       SHAPEB= Block.box(d3, d2, d1, d6, d5, d4);
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
