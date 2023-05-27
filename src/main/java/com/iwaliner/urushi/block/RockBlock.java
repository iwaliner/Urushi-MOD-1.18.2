package com.iwaliner.urushi.block;

import com.iwaliner.urushi.ItemAndBlockRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Random;

public class RockBlock extends Block {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    private static final VoxelShape NORTH_BOX = Block.box(1D, 0.0D, 1D, 14D, 16D, 14D);
    private static final VoxelShape SOUTH_BOX = Block.box(2D, 0.0D, 2D, 15D, 16D, 15D);
    private static final VoxelShape EAST_BOX = Block.box(2D, 0.0D, 1D, 15D, 16D, 14D);
    private static final VoxelShape WEST_BOX = Block.box(1D, 0.0D, 2D, 14D, 16D, 15D);

    public RockBlock(Properties p_49795_) {
        super(p_49795_);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        if(state.getValue(FACING)==Direction.EAST){
            return EAST_BOX;
        }else if(state.getValue(FACING)==Direction.WEST){
            return WEST_BOX;
        }else if(state.getValue(FACING)==Direction.SOUTH){
            return SOUTH_BOX;
        }else {
            return NORTH_BOX;
        }
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_49915_) {
        p_49915_.add(FACING);
    }
    @Override
    public BlockState rotate(BlockState state, LevelAccessor level, BlockPos pos, Rotation direction) {
        return state.setValue(FACING, direction.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @org.jetbrains.annotations.Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
        if(state.getBlock()== ItemAndBlockRegister.rock.get()) {
            if (random.nextInt(8) == 0) {
                Direction facing=state.getValue(FACING);
                for(int i=1;i<400;i++){
                    BlockState stateX=level.getBlockState(pos.above(i));
                    if(stateX.getBlock()== Blocks.POINTED_DRIPSTONE){
                        level.setBlock(pos,ItemAndBlockRegister.sazare_ishi.get().defaultBlockState().setValue(FACING,facing),2);
                        break;
                    }else if(stateX.getMaterial()!= Material.AIR){
                        break;
                    }
                }

            }
        }
    }
}
