package com.iwaliner.urushi.block;

import com.iwaliner.urushi.ItemAndBlockRegister;
import com.iwaliner.urushi.UrushiUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.Material;

import java.util.Random;

public class HotSpringSourceBlock extends DirectionalBlock {
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    public HotSpringSourceBlock(Properties p_52591_) {
        super(p_52591_);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.SOUTH).setValue(POWERED, Boolean.valueOf(false)));

    }
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_55125_) {
        p_55125_.add(FACING,POWERED);
    }

    public BlockState rotate(BlockState p_55115_, Rotation p_55116_) {
        return p_55115_.setValue(FACING, p_55116_.rotate(p_55115_.getValue(FACING)));
    }

    public BlockState mirror(BlockState p_55112_, Mirror p_55113_) {
        return p_55112_.rotate(p_55113_.getRotation(p_55112_.getValue(FACING)));
    }
    public BlockState getStateForPlacement(BlockPlaceContext p_55087_) {
        return this.defaultBlockState().setValue(POWERED,Boolean.valueOf(false)).setValue(FACING, p_55087_.getNearestLookingDirection().getOpposite());
    }
    public void tick(BlockState state, ServerLevel level, BlockPos prePos, Random random) {
     Direction direction=state.getValue(FACING);
     BlockState fluid= ItemAndBlockRegister.HotSpringBlock.get().defaultBlockState();
     BlockPos pos=prePos;
     if(level.getBlockState(pos.relative(direction.getOpposite())).getMaterial()==Material.LAVA||(level.getBlockState(pos.relative(direction.getOpposite())).getBlock() instanceof HotSpringSourceBlock&&level.getBlockState(pos.relative(direction.getOpposite())).getValue(POWERED))){
     if(level.getBlockState(pos.relative(direction)).getMaterial()==Material.AIR||level.getBlockState(pos.relative(direction)).getMaterial()==Material.WATER) {
         level.setBlockAndUpdate(pos.relative(direction), fluid);
     }
     level.setBlockAndUpdate(pos,state.setValue(POWERED,Boolean.valueOf(true)));
        boolean flag=true;
     if(direction!=Direction.DOWN) {
         if (direction != Direction.UP) {
             //direction = Direction.UP;
             pos = prePos.below();
             flag = false;
         }
         int size = 5;
         for (int i = -size; i < size + 1; i++) {
             for (int j = -size; j < size + 1; j++) {
                 for (int k = -size; k < size + 1; k++) {
                     if (flag) {
                     if (level.getBlockState(pos.relative(direction).offset(i, j, k)) == fluid) {
                         for (int d = 2; d < 6; d++) {
                             if (level.getBlockState(pos.relative(direction).offset(i, j, k).relative(UrushiUtils.getDirectionFromInt(d))).getMaterial() == Material.AIR || level.getBlockState(pos.relative(direction).offset(i, j, k).relative(UrushiUtils.getDirectionFromInt(d))).getMaterial() == Material.WATER) {
                                 level.setBlockAndUpdate(pos.relative(direction).offset(i, j, k).relative(UrushiUtils.getDirectionFromInt(d)), fluid);
                                 continue;
                             }
                         }

                             for (int n = 1; n < 6; n++) {
                                 if (level.getBlockState(pos.relative(direction).offset(i, j, k).above(n)).getMaterial() == Material.AIR) {
                                     for (int d = 2; d < 6; d++) {
                                         boolean flag2=true;
                                         if (level.getBlockState(pos.relative(direction).offset(i, j, k).above(n).relative(UrushiUtils.getDirectionFromInt(d))).getMaterial() != Material.AIR&&level.getBlockState(pos.relative(direction).offset(i, j, k).above(n).relative(UrushiUtils.getDirectionFromInt(d))).getMaterial() != Material.WATER) {
                                           flag2=false;
                                           continue;
                                         }


                                     }
                                     if(flag){
                                         level.setBlockAndUpdate(pos.relative(direction).offset(i, j, k).above(n), fluid);

                                     }
                                 } else if (level.getBlockState(pos.relative(direction).offset(i, j, k).above(n)).getMaterial() == Material.WATER) {
                                     for (int d = 2; d < 6; d++) {
                                         if (level.getBlockState(pos.relative(direction).offset(i, j, k).above(n).relative(UrushiUtils.getDirectionFromInt(d))).getMaterial() == Material.AIR || level.getBlockState(pos.relative(direction).offset(i, j, k).above(n).relative(UrushiUtils.getDirectionFromInt(d))).getMaterial() == Material.WATER) {
                                             level.setBlockAndUpdate(pos.relative(direction).offset(i, j, k).above(n).relative(UrushiUtils.getDirectionFromInt(d)), fluid);
                                         }
                                         continue;
                                     }
                                 }
                             }
                         }

                         for (int n = 1; n < 6; n++) {
                             if (level.getBlockState(pos.relative(direction).offset(i, j, k).below(n)).getMaterial() == Material.WATER) {
                                 for (int d = 2; d < 6; d++) {
                                     if (level.getBlockState(pos.relative(direction).offset(i, j, k).below(n).relative(UrushiUtils.getDirectionFromInt(d))).getMaterial() == Material.AIR || level.getBlockState(pos.relative(direction).offset(i, j, k).below(n).relative(UrushiUtils.getDirectionFromInt(d))).getMaterial() == Material.WATER) {
                                         level.setBlockAndUpdate(pos.relative(direction).offset(i, j, k).below(n).relative(UrushiUtils.getDirectionFromInt(d)), fluid);
                                     }
                                     continue;
                                 }
                             }
                         }

                     }
                 }
             }
         }
     }
     }else{
         level.setBlockAndUpdate(pos,state.setValue(POWERED,Boolean.valueOf(false)));
     }
    }
}
