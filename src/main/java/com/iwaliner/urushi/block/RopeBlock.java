package com.iwaliner.urushi.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Random;

public class RopeBlock extends FallingBlock implements SimpleWaterloggedBlock {
    protected static final VoxelShape SHAPE_Y = Block.box(7.0D, 0.0D, 7D, 9.0D, 16.0D, 9.0D);
    protected static final VoxelShape SHAPE_X = Block.box(0D, 7.0D, 7D, 16.0D, 9.0D, 9.0D);
    protected static final VoxelShape SHAPE_Z = Block.box(7.0D, 7.0D, 0D, 9.0D, 9.0D, 16.0D);
    protected static final VoxelShape SHAPE_HANG = Block.box(7.0D, 0.0D, 7D, 9.0D, 7.0D, 9.0D);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;
    public static final BooleanProperty HANGING = BlockStateProperties.HANGING;
    public static final BooleanProperty GRAVITY = BooleanProperty.create("gravity");
    public RopeBlock(Properties p_49795_) {
        super(p_49795_);
        this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, Boolean.valueOf(false)).setValue(GRAVITY, Boolean.valueOf(false)).setValue(AXIS, Direction.Axis.Y).setValue(HANGING, false));

    }
    public BlockState rotate(BlockState p_55930_, Rotation p_55931_) {
        return RotatedPillarBlock.rotatePillar(p_55930_, p_55931_);
    }

    public void tick(BlockState state, ServerLevel p_53217_, BlockPos p_53218_, Random p_53219_) {
        if (state.getValue(GRAVITY)&&isFree(p_53217_.getBlockState(p_53218_.below())) && p_53218_.getY() >= p_53217_.getMinBuildHeight()) {
            FallingBlockEntity fallingblockentity = FallingBlockEntity.fall(p_53217_, p_53218_, state);
            this.falling(fallingblockentity);
        }
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        if(state.getValue(AXIS)== Direction.Axis.X){
           return state.getValue(HANGING)? Shapes.or(SHAPE_X,SHAPE_HANG) : SHAPE_X;
        }else if(state.getValue(AXIS)== Direction.Axis.Z){
            return state.getValue(HANGING)? Shapes.or(SHAPE_Z,SHAPE_HANG) : SHAPE_Z;
        }else {
            return SHAPE_Y;
        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_56051_) {
        p_56051_.add( WATERLOGGED,GRAVITY,AXIS,HANGING);
    }
    public FluidState getFluidState(BlockState p_56073_) {
        return p_56073_.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(p_56073_);
    }
    public void entityInside(BlockState state, Level world, BlockPos pos, Entity entity) {
        Vec3 vec3 = entity.getDeltaMovement();
      entity.setDeltaMovement(new Vec3(0D, vec3.y,0D));
        super.entityInside(state, world, pos, entity);
    }
    private boolean canHang( LevelReader level, BlockPos pos){
        BlockState state=level.getBlockState(pos);
        VoxelShape shape= state.getCollisionShape(level,pos).optimize();
        return shape.max(Direction.Axis.Y)>=1D;
    }
    public void animateTick(BlockState p_53221_, Level p_53222_, BlockPos p_53223_, Random p_53224_) {

    }

    @Override
    public BlockState updateShape(BlockState state, Direction p_53227_, BlockState p_53228_, LevelAccessor level, BlockPos pos, BlockPos p_53231_) {
        boolean flag=false;
        if(state.getValue(HANGING)&&!canHang(level,pos.below())){
            flag=false;
        }else if(!state.getValue(HANGING)&&canHang(level,pos.below())){
             flag=true;
        }else if(state.getValue(HANGING)){
            flag=true;
        }
        return super.updateShape(state, p_53227_, p_53228_, level, pos, p_53231_).setValue(HANGING,flag);

    }

    @Override
    public void onNeighborChange(BlockState state, LevelReader level, BlockPos pos, BlockPos neighbor) {
        super.onNeighborChange(state, level, pos, neighbor);
        if(state.getValue(HANGING)&&!canHang(level,pos.below())){
            state.setValue(HANGING,false);
        }else if(!state.getValue(HANGING)&&canHang(level,pos.below())){
            state.setValue(HANGING,true);
        }
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Level level=context.getLevel();
        BlockPos pos=context.getClickedPos();


        return super.getStateForPlacement(context).setValue(AXIS, context.getClickedFace().getAxis()).setValue(HANGING,canHang(level,pos.below()));
    }
}
