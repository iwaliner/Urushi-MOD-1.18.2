package com.iwaliner.urushi.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

public class AriakeAndonBlock extends HorizonalRotateBlock {
    protected static final VoxelShape SHAPE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 12.0D, 13.0D);
    public static final BooleanProperty OPEN = BlockStateProperties.OPEN;

    public AriakeAndonBlock(Properties p_i48377_1_) {

        super(p_i48377_1_);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(OPEN, Boolean.valueOf(false)));

    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_49915_) {
        p_49915_.add(FACING,OPEN);
    }
    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        return SHAPE;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player p_60506_, InteractionHand p_60507_, BlockHitResult result) {
       if(state.getValue(OPEN)){
           level.setBlockAndUpdate(pos,state.setValue(OPEN,Boolean.valueOf(false)));
           level.playSound((Player) null,pos, SoundEvents.BARREL_CLOSE, SoundSource.BLOCKS,1F,1F);

       }else{
           level.setBlockAndUpdate(pos,state.setValue(OPEN,Boolean.valueOf(true)));
           level.playSound((Player) null,pos, SoundEvents.BARREL_OPEN, SoundSource.BLOCKS,1F,1F);
       }
        return InteractionResult.SUCCESS;
    }



}
