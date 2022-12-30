package com.iwaliner.urushi.block;



import com.iwaliner.urushi.util.UrushiUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SlideDoorBlock extends Block {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty OPEN = BlockStateProperties.OPEN;
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    public static final BooleanProperty INVERTED = BlockStateProperties.INVERTED;
    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
    protected static final VoxelShape SOUTH_CLOSED = Block.box(0.0D, 0.0D, 8D, 16.0D, 16.0D, 10D);
    protected static final VoxelShape NORTH_CLOSED = Block.box(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 8.0D);
    protected static final VoxelShape WEST_CLOSED = Block.box(6.0D, 0.0D, 0.0D, 8.0D, 16.0D, 16.0D);
    protected static final VoxelShape EAST_CLOSED = Block.box(8.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D);
    protected static final VoxelShape NORTH_CLOSED_INV = Block.box(0.0D, 0.0D, 6D, 16.0D, 16.0D, 8D);
    protected static final VoxelShape SOUTH_CLOSED_INV = Block.box(0.0D, 0.0D, 8.0D, 16.0D, 16.0D, 10.0D);
    protected static final VoxelShape EAST_CLOSED_INV = Block.box(8.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D);
    protected static final VoxelShape WEST_CLOSED_INV = Block.box(6.0D, 0.0D, 0.0D, 8.0D, 16.0D, 16.0D);
    protected static final VoxelShape NORTH_OPEN = Block.box(-13D, 0.0D, 6D, 3.0D, 16.0D, 8D);
    protected static final VoxelShape SOUTH_OPEN = Block.box(13.0D, 0.0D, 8.0D, 29D, 16.0D, 10.0D);
    protected static final VoxelShape EAST_OPEN = Block.box(8.0D, 0.0D, -13D, 10.0D, 16.0D, 3.0D);
    protected static final VoxelShape WEST_OPEN = Block.box(6.0D, 0.0D, 13.0D, 8.0D, 16.0D, 29D);
    protected static final VoxelShape SOUTH_OPEN_INV = Block.box(-13D, 0.0D, 8D, 3.0D, 16.0D, 10D);
    protected static final VoxelShape NORTH_OPEN_INV = Block.box(13.0D, 0.0D, 6.0D, 29D, 16.0D, 8.0D);
    protected static final VoxelShape WEST_OPEN_INV = Block.box(6.0D, 0.0D, -13D, 8.0D, 16.0D, 3.0D);
    protected static final VoxelShape EAST_OPEN_INV = Block.box(8.0D, 0.0D, 13.0D, 10.0D, 16.0D, 29D);
    public SlideDoorBlock(Properties p_i48440_1_) {
        super(p_i48440_1_);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(OPEN, Boolean.valueOf(false)).setValue(POWERED, Boolean.valueOf(false)).setValue(HALF, DoubleBlockHalf.LOWER).setValue(INVERTED, Boolean.valueOf(false)));

    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        Direction direction = state.getValue(FACING);
        boolean flag = !state.getValue(OPEN);
        boolean invert = !state.getValue(INVERTED);
        switch(direction) {
            case EAST:
            default:
                return flag ? invert? EAST_CLOSED_INV:EAST_CLOSED : invert? EAST_OPEN_INV:EAST_OPEN;
            case SOUTH:
                return flag ? invert? SOUTH_CLOSED_INV:SOUTH_CLOSED : invert? SOUTH_OPEN_INV:SOUTH_OPEN;
            case WEST:
                return flag ? invert? WEST_CLOSED_INV:WEST_CLOSED : invert? WEST_OPEN_INV:WEST_OPEN;
            case NORTH:
                return flag ? invert? NORTH_CLOSED_INV:NORTH_CLOSED : invert? NORTH_OPEN_INV:NORTH_OPEN;
        }
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState state2, LevelAccessor world, BlockPos pos, BlockPos pos2) {
        DoubleBlockHalf doubleblockhalf = state.getValue(HALF);
        if (direction.getAxis() == Direction.Axis.Y && doubleblockhalf == DoubleBlockHalf.LOWER == (direction == Direction.UP)) {
            return state2.is(this) && state2.getValue(HALF) != doubleblockhalf ? state.setValue(FACING, state2.getValue(FACING)).setValue(OPEN, state2.getValue(OPEN)).setValue(POWERED, state2.getValue(POWERED)) : Blocks.AIR.defaultBlockState();
        } else {
            return doubleblockhalf == DoubleBlockHalf.LOWER && direction == Direction.DOWN && !state.canSurvive(world, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, direction, state2, world, pos, pos2);
        } }

    @Override
    public void playerWillDestroy(Level world, BlockPos pos, BlockState state, Player entity) {
        if (!world.isClientSide && entity.isCreative()) {
            this.preventCreativeDropFromBottomPart(world, pos, state, entity);
        }

        super.playerWillDestroy(world, pos, state, entity); }


    protected static void preventCreativeDropFromBottomPart(Level world, BlockPos pos, BlockState state, Player entity) {
        DoubleBlockHalf doubleblockhalf = state.getValue(HALF);
        if (doubleblockhalf == DoubleBlockHalf.UPPER) {
            BlockPos blockpos = pos.below();
            BlockState blockstate = world.getBlockState(blockpos);
            if (blockstate.getBlock() == state.getBlock() && blockstate.getValue(HALF) == DoubleBlockHalf.LOWER) {
                world.setBlock(blockpos, Blocks.AIR.defaultBlockState(), 35);
                world.levelEvent(entity, 2001, blockpos, Block.getId(blockstate));
            }
        }

    }

    @Override
    public boolean isPathfindable(BlockState state, BlockGetter p_60476_, BlockPos p_60477_, PathComputationType type) {
        switch(type) {
            case LAND:
                return state.getValue(OPEN);
            case WATER:
                return false;
            case AIR:
                return state.getValue(OPEN);
            default:
                return false;
        }
    }

    @org.jetbrains.annotations.Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Level world = context.getLevel();
            BlockPos blockpos = context.getClickedPos();
            Direction facing = context.getHorizontalDirection();
            if (blockpos.getY() < world.getMaxBuildHeight() - 1 && context.getLevel().getBlockState(blockpos.above()).canBeReplaced(context)) {
                boolean flag = world.hasNeighborSignal(blockpos) || world.hasNeighborSignal(blockpos.above());
                boolean invert = false;
                Direction direction = context.getHorizontalDirection();
                BlockState clockwiseState = world.getBlockState(blockpos.above().relative(facing.getClockWise()));
                BlockState counterclockwiseState = world.getBlockState(blockpos.above().relative(facing.getCounterClockWise()));
                if (clockwiseState.getBlock() instanceof SlideDoorBlock) {
                        if (!clockwiseState.getValue(INVERTED)) {
                            invert = facing==clockwiseState.getValue(FACING);
                            direction = facing;
                        } else {
                            invert = facing==clockwiseState.getValue(FACING);
                            direction = facing.getOpposite();
                        }
                }
                if (counterclockwiseState.getBlock() instanceof SlideDoorBlock) {
                    if (!counterclockwiseState.getValue(INVERTED)) {
                        invert = facing==counterclockwiseState.getValue(FACING).getOpposite();
                        direction = facing.getOpposite();
                    } else {
                        invert = facing==counterclockwiseState.getValue(FACING).getOpposite();
                        direction = facing;
                    }
                }
                return this.defaultBlockState().setValue(FACING,  direction).setValue(POWERED, Boolean.valueOf(flag)).setValue(OPEN, Boolean.valueOf(flag)).setValue(HALF, DoubleBlockHalf.LOWER).setValue(INVERTED, Boolean.valueOf(invert));
            }

            return this.defaultBlockState();
    }

    @Override
    public void setPlacedBy(Level world, BlockPos pos, BlockState state, @Nullable LivingEntity p_49850_, ItemStack p_49851_) {
        world.setBlock(pos.above(), state.setValue(HALF, DoubleBlockHalf.UPPER), 3);
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        state = state.cycle(OPEN);
        world.setBlock(pos, state, 10);
        world.playSound(player, pos,  SoundEvents.BARREL_OPEN, SoundSource.BLOCKS, 1.0F, 1.0F);

        return InteractionResult.sidedSuccess(world.isClientSide);
    }

    public boolean isOpen(BlockState state) {
        return state.getValue(OPEN);
    }
    public void setOpen(@javax.annotation.Nullable Entity p_153166_, Level world, BlockState state, BlockPos pos, boolean boo) {
        if (state.is(this) && state.getValue(OPEN) != boo) {
            world.setBlock(pos, state.setValue(OPEN, Boolean.valueOf(boo)), 10);
            world.playSound((Player) null, pos, SoundEvents.BARREL_OPEN, SoundSource.BLOCKS, 1.0F, 1.0F);

        }
    }


    @Override
    public void neighborChanged(BlockState state, Level world, BlockPos pos, Block block, BlockPos pos2, boolean boo) {
        boolean flag = world.hasNeighborSignal(pos) || world.hasNeighborSignal(pos.relative(state.getValue(HALF) == DoubleBlockHalf.LOWER ? Direction.UP : Direction.DOWN));
        if (block != this && flag != state.getValue(POWERED)) {
            if (flag != state.getValue(OPEN)) {
                world.playSound((Player) null, pos, SoundEvents.BARREL_OPEN, SoundSource.BLOCKS, 1.0F, 1.0F);

            }

            world.setBlock(pos, state.setValue(POWERED, Boolean.valueOf(flag)).setValue(OPEN, Boolean.valueOf(flag)), 2);
        }  }

    @Override
    public boolean canSurvive(BlockState state, LevelReader reader, BlockPos pos2) {
        BlockPos blockpos = pos2.below();
        BlockState blockstate = reader.getBlockState(blockpos);
        return state.getValue(HALF) == DoubleBlockHalf.LOWER ? blockstate.isFaceSturdy(reader, blockpos, Direction.UP) : blockstate.is(this);
    }

    @Override
    public BlockState rotate(BlockState state, LevelAccessor level, BlockPos pos, Rotation direction) {
        return state.setValue(FACING, direction.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return mirror == Mirror.NONE ? state : state.rotate(mirror.getRotation(state.getValue(FACING)));
    }



    @OnlyIn(Dist.CLIENT)
    public long getSeed(BlockState state, BlockPos pos) {
        return Mth.getSeed(pos.getX(), pos.below(state.getValue(HALF) == DoubleBlockHalf.LOWER ? 0 : 1).getY(), pos.getZ());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HALF, FACING, OPEN, POWERED,INVERTED);
    }

    public boolean useShapeForLightOcclusion(BlockState p_220074_1_) {
        return true;
    }

}
