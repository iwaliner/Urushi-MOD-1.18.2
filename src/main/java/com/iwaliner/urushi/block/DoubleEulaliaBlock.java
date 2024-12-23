package com.iwaliner.urushi.block;

import com.iwaliner.urushi.ItemAndBlockRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.RandomSource;

import java.util.Random;

public class DoubleEulaliaBlock extends DoublePlantBlock implements BonemealableBlock {
    public DoubleEulaliaBlock(Properties p_52861_) {
        super(p_52861_);
    }
    public ItemStack getCloneItemStack(BlockGetter p_152966_, BlockPos p_152967_, BlockState p_152968_) {
        return new ItemStack(ItemAndBlockRegister.eulalia.get());
    }
    public boolean isValidBonemealTarget(BlockGetter p_57303_, BlockPos p_57304_, BlockState p_57305_, boolean p_57306_) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level p_50901_, Random p_50902_, BlockPos p_50903_, BlockState p_50904_) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel p_50893_, Random p_50894_, BlockPos p_50895_, BlockState p_50896_) {
        popResource(p_50893_, p_50895_, new ItemStack(ItemAndBlockRegister.eulalia.get()));
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
