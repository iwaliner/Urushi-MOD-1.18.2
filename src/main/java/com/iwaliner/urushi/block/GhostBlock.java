package com.iwaliner.urushi.block;

import com.iwaliner.urushi.util.IGhostBlock;
import com.iwaliner.urushi.util.UrushiUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class GhostBlock extends Block implements IGhostBlock {

    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    public GhostBlock(Properties p_49795_) {
        super(p_49795_);
        this.registerDefaultState(this.defaultBlockState().setValue(POWERED, Boolean.valueOf(false)));
    }
    @Override
    public VoxelShape getVisualShape(BlockState p_60479_, BlockGetter p_60480_, BlockPos p_60481_, CollisionContext p_60482_) {
        return Shapes.empty();
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public float getShadeBrightness(BlockState p_60472_, BlockGetter p_60473_, BlockPos p_60474_) {
        return 1.0F;
    }

    @Override
    public boolean propagatesSkylightDown(BlockState p_49928_, BlockGetter p_49929_, BlockPos p_49930_) {
        return true;
    }

    @Override
    public boolean skipRendering(BlockState p_60532_, BlockState p_60533_, Direction p_60534_) {
        return p_60533_.getBlock() instanceof IGhostBlock ? true : super.skipRendering(p_60532_, p_60533_, p_60534_);
    }
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext p_55659_) {
        return this.defaultBlockState().setValue(POWERED, Boolean.valueOf(p_55659_.getLevel().hasNeighborSignal(p_55659_.getClickedPos())));
    }
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos p_55670_, boolean p_55671_) {
        if (!level.isClientSide) {
            boolean flag = state.getValue(POWERED);
        /*    boolean northFlag=level.getBlockState(pos.north()).getValue(POWERED);
            boolean eastFlag=level.getBlockState(pos.east()).getValue(POWERED);
            boolean southFlag=level.getBlockState(pos.south()).getValue(POWERED);
            boolean westFlag=level.getBlockState(pos.west()).getValue(POWERED);
            boolean aboveFlag=level.getBlockState(pos.above()).getValue(POWERED);
            boolean belowFlag=level.getBlockState(pos.below()).getValue(POWERED);
*/
            if (flag != level.hasNeighborSignal(pos)) {
             //   if (flag) {
             //       p_55667_.scheduleTick(p_55668_, this, 4);
             //   } else {
                    level.setBlock(pos, state.cycle(POWERED), 2);
               // }
            }

            /*if(level.getBlockState(pos.north()).getBlock()==state.getBlock()&&flag!=level.getBlockState(pos.north()).getValue(POWERED)){
                level.setBlock(pos.north(), level.getBlockState(pos.north()).setValue(POWERED,flag), 2);
            }*/
        }
    }
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_55673_) {
        p_55673_.add(POWERED);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        if(state.getValue(POWERED)){
            return Shapes.block();
        }else{
            return Shapes.empty();
        }
    }
    @Override
    public void appendHoverText(ItemStack p_49816_, @org.jetbrains.annotations.Nullable BlockGetter p_49817_, List<Component> list, TooltipFlag p_49819_) {
        UrushiUtils.setInfo(list,"ghost_block");
        UrushiUtils.setInfo(list,"ghost_block2");
    }

    /**falseだとモブが足場として誤認*/
    @Override
    public boolean isPathfindable(BlockState p_60475_, BlockGetter p_60476_, BlockPos p_60477_, PathComputationType p_60478_) {
        return false;
    }
}
