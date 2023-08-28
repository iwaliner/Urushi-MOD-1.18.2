package com.iwaliner.urushi.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class KettleBlock extends HorizonalRotateBlock {
    protected static final VoxelShape SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 7.0D, 12.0D);
    public static final BooleanProperty HOOK=BooleanProperty.create("hook");

    public KettleBlock(Properties p_i48377_1_) {

        super(p_i48377_1_);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(HOOK, Boolean.valueOf(false)));

    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_49915_) {
        p_49915_.add(FACING,HOOK);
    }
    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        return SHAPE;
    }
    private boolean canHang(LevelReader level, BlockPos pos) {
        BlockState state = level.getBlockState(pos);
        VoxelShape shape = state.getShape(level, pos).optimize();
        return shape.min(Direction.Axis.Y) <= 0.0D;
    }
    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState state2, LevelAccessor level, BlockPos pos, BlockPos pos2) {
        boolean flag = false;
        if ((Boolean)state.getValue(HOOK) && !this.canHang(level, pos.above())) {
            flag = false;
        } else if (!(Boolean)state.getValue(HOOK) && this.canHang(level, pos.above())) {
            flag = true;
        } else if ((Boolean)state.getValue(HOOK)) {
            flag = true;
        }

        return (BlockState)super.updateShape(state, direction, state2, level, pos, pos2).setValue(HOOK, flag);
    }
    public void onNeighborChange(BlockState state, LevelReader level, BlockPos pos, BlockPos neighbor) {
        super.onNeighborChange(state, level, pos, neighbor);
        if ((Boolean)state.getValue(HOOK) && !this.canHang(level, pos.above())) {
            state.setValue(HOOK, false);
        } else if (!(Boolean)state.getValue(HOOK) && this.canHang(level, pos.above())) {
            state.setValue(HOOK, true);
        }

    }


    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        return (BlockState)((BlockState)super.getStateForPlacement(context).setValue(FACING, context.getHorizontalDirection().getOpposite())).setValue(HOOK, this.canHang(level, pos.above()));
    }

}
