package com.iwaliner.urushi.block;


import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ParapetBlock extends HorizonalRotateBlock implements SimpleWaterloggedBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    protected static final VoxelShape SHAPEA = Block.box(5.0D, 0.0D, 0D, 11.0D, 24.0D, 16.0D);
    protected static final VoxelShape SHAPEB = Block.box(0D, 0.0D, 5D, 16D, 24.0D, 11.0D);
    protected static final VoxelShape SHAPEAA = Block.box(5.0D, 0.0D, 0D, 11.0D, 16.0D, 16.0D);
    protected static final VoxelShape SHAPEBB = Block.box(0D, 0.0D, 5D, 16D, 16.0D, 11.0D);

    public ParapetBlock(Properties p_i48377_1_) {
        super(p_i48377_1_);
        this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, Boolean.valueOf(false)));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        if(state.getValue(FACING)== Direction.NORTH||state.getValue(FACING)==Direction.SOUTH){
            return SHAPEBB;
        }else{
            return SHAPEAA;
        }
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter p_60573_, BlockPos p_60574_, CollisionContext p_60575_) {
        if(state.getValue(FACING)== Direction.NORTH||state.getValue(FACING)==Direction.SOUTH){
            return SHAPEB;
        }else{
            return SHAPEA;
        }
    }
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_56051_) {
        p_56051_.add( WATERLOGGED,FACING);
    }
    public boolean propagatesSkylightDown(BlockState p_52348_, BlockGetter p_52349_, BlockPos p_52350_) {
        return !p_52348_.getValue(WATERLOGGED);
    }
    public FluidState getFluidState(BlockState p_56073_) {
        return p_56073_.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(p_56073_);
    }
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());
        return super.getStateForPlacement(context).setValue(WATERLOGGED, Boolean.valueOf(fluidstate.getType() == Fluids.WATER));
    }
    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 60;
    }
}
