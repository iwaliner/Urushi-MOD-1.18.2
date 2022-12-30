package com.iwaliner.urushi.block;


import com.iwaliner.urushi.ItemAndBlockRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BarsBlock extends HorizonalRotateBlock{
    protected static final VoxelShape SHAPEAA = Block.box(7.0D, 0.0D, 0D, 9.0D, 16.0D, 16.0D);
    protected static final VoxelShape SHAPEBB = Block.box(0D, 0.0D, 7D, 16D, 16.0D, 9.0D);
    protected static final VoxelShape SHAPEA = Block.box(7.0D, 0.0D, 0D, 9.0D, 24.0D, 16.0D);
    protected static final VoxelShape SHAPEB = Block.box(0D, 0.0D, 7D, 16D, 24.0D, 9.0D);

    public BarsBlock(Properties p_i48377_1_) {
        super(p_i48377_1_);
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
    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return state.getBlock()!= ItemAndBlockRegister.sikkui_bars.get();
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return state.getBlock()!= ItemAndBlockRegister.sikkui_bars.get()?60:0;
    }
}
