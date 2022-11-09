package com.iwaliner.urushi.block;

import com.iwaliner.urushi.ItemAndBlockRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.TallGrassBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class EulaliaBlock extends TallGrassBlock {
    public EulaliaBlock(Properties p_57318_) {
        super(p_57318_);
    }
    public void performBonemeal(ServerLevel p_57320_, Random p_57321_, BlockPos p_57322_, BlockState p_57323_) {
        DoublePlantBlock doubleplantblock = (DoublePlantBlock) ItemAndBlockRegister.double_eulalia.get();
        if (doubleplantblock.defaultBlockState().canSurvive(p_57320_, p_57322_) && p_57320_.isEmptyBlock(p_57322_.above())) {
            DoublePlantBlock.placeAt(p_57320_, doubleplantblock.defaultBlockState(), p_57322_, 2);
        }
    }
}
