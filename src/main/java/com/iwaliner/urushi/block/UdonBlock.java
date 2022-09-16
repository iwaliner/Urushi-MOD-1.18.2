package com.iwaliner.urushi.block;


import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.List;

public class UdonBlock extends HorizonalRotateBlock {
    protected static final VoxelShape SHAPEA = Block.box(2.0D, 0.0D, 0D, 14.0D, 2.0D, 16.0D);
    protected static final VoxelShape SHAPEB = Block.box(0D, 0.0D, 2D, 16D, 2.0D, 14.0D);

    public UdonBlock(Properties p_i48377_1_) {
        super(p_i48377_1_);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        if(state.getValue(FACING)== Direction.NORTH||state.getValue(FACING)==Direction.SOUTH){
            return SHAPEB;
        }else{
            return SHAPEA;
        }
    }

    @Override
    public void appendHoverText(ItemStack p_49816_, @org.jetbrains.annotations.Nullable BlockGetter p_49817_, List<Component> list, TooltipFlag p_49819_) {
        list.add((new TranslatableComponent("info.urushi.udon" )).withStyle(ChatFormatting.GRAY));
    }

}
