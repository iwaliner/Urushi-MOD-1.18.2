package com.iwaliner.urushi.block;

import com.iwaliner.urushi.ItemAndBlockRegister;
import com.iwaliner.urushi.TagUrushi;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CarpetBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Material;

public class FallenLeavesBlock extends CarpetBlock {
    public FallenLeavesBlock(Properties p_152915_) {
        super(p_152915_);
    }
    public boolean canSurvive(BlockState p_152922_, LevelReader level, BlockPos pos) {
        if(level.getBlockState(pos.below()).getMaterial()== Material.WATER){
            int depth=100;
            for(int i=1;i<8;i++){
                if(level.getBlockState(pos.below(i)).getMaterial()!=Material.WATER){
                    depth=i;
                    break;
                }
            }
            return depth>4? false: !level.isEmptyBlock(pos.below());

        }else {
            return level.getBlockState(pos.below()).isSolidRender(level, pos);
        }

    }

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        Level level=  context.getLevel();
        BlockPos pos=context.getClickedPos();
        if (level.getBlockState(pos.below()).is(TagUrushi.GRASS_BLOCK_WITH_FALLEN_LEAVES_INGREDIENT)) {
            if (state.getBlock() == ItemAndBlockRegister.fallen_red_leaves.get()) {
                level.setBlockAndUpdate(pos.below(), ItemAndBlockRegister.grass_block_with_fallen_red_leaves.get().defaultBlockState());
            } else if (state.getBlock() == ItemAndBlockRegister.fallen_orange_leaves.get()) {
                level.setBlockAndUpdate(pos.below(), ItemAndBlockRegister.grass_block_with_fallen_orange_leaves.get().defaultBlockState());
            } else if (state.getBlock() == ItemAndBlockRegister.fallen_yellow_leaves.get()) {
                level.setBlockAndUpdate(pos.below(), ItemAndBlockRegister.grass_block_with_fallen_yellow_leaves.get().defaultBlockState());
            } else if (state.getBlock() == ItemAndBlockRegister.fallen_japanese_apricot_leaves.get()) {
                level.setBlockAndUpdate(pos.below(), ItemAndBlockRegister.grass_block_with_fallen_japanese_apricot_leaves.get().defaultBlockState());
            } else if (state.getBlock() == ItemAndBlockRegister.fallen_sakura_leaves.get()) {
                level.setBlockAndUpdate(pos.below(), ItemAndBlockRegister.grass_block_with_fallen_sakura_leaves.get().defaultBlockState());
            }
        }
        return true;
    }


}
