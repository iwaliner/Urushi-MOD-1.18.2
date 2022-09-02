package com.iwaliner.urushi.block;



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
    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
    protected static final VoxelShape SOUTH_CLOSED = Block.box(0.0D, 0.0D, 8D, 16.0D, 16.0D, 9D);
    protected static final VoxelShape NORTH_CLOSED = Block.box(0.0D, 0.0D, 7.0D, 16.0D, 16.0D, 8.0D);
    protected static final VoxelShape WEST_CLOSED = Block.box(7.0D, 0.0D, 0.0D, 8.0D, 16.0D, 16.0D);
    protected static final VoxelShape EAST_CLOSED = Block.box(8.0D, 0.0D, 0.0D, 9.0D, 16.0D, 16.0D);
   protected static final VoxelShape SOUTH_OPEN = Block.box(-13D, 0.0D, 8D, 3.0D, 16.0D, 9D);
    protected static final VoxelShape NORTH_OPEN = Block.box(13.0D, 0.0D, 7.0D, 29D, 16.0D, 8.0D);
    protected static final VoxelShape WEST_OPEN = Block.box(7.0D, 0.0D, -13D, 8.0D, 16.0D, 3.0D);
    protected static final VoxelShape EAST_OPEN = Block.box(8.0D, 0.0D, 13.0D, 9.0D, 16.0D, 29D);

    public SlideDoorBlock(Properties p_i48440_1_) {
        super(p_i48440_1_);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(OPEN, Boolean.valueOf(false)).setValue(POWERED, Boolean.valueOf(false)).setValue(HALF, DoubleBlockHalf.LOWER));

    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        Direction direction = state.getValue(FACING);
        boolean flag = !state.getValue(OPEN);
        switch(direction) {
            case EAST:
            default:
                return flag ? EAST_CLOSED : EAST_OPEN;
            case SOUTH:
                return flag ? SOUTH_CLOSED : SOUTH_OPEN;
            case WEST:
                return flag ? WEST_CLOSED : WEST_OPEN;
            case NORTH:
                return flag ? NORTH_CLOSED : NORTH_OPEN;
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
        BlockPos blockpos = context.getClickedPos();
        if (blockpos.getY() < 255 && context.getLevel().getBlockState(blockpos.above()).canBeReplaced(context)) {
            Level world = context.getLevel();
            boolean flag = world.hasNeighborSignal(blockpos) || world.hasNeighborSignal(blockpos.above());

            return context.getPlayer().isSuppressingBounce()?
                    this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(POWERED, Boolean.valueOf(flag)).setValue(OPEN, Boolean.valueOf(flag)).setValue(HALF, DoubleBlockHalf.LOWER)
                    : this.defaultBlockState().setValue(FACING, context.getHorizontalDirection()).setValue(POWERED, Boolean.valueOf(flag)).setValue(OPEN, Boolean.valueOf(flag)).setValue(HALF, DoubleBlockHalf.LOWER);
        } else {
            return null;
        }
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
        builder.add(HALF, FACING, OPEN, POWERED);
    }

    public boolean useShapeForLightOcclusion(BlockState p_220074_1_) {
        return true;
    }

}
