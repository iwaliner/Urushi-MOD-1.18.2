package com.iwaliner.urushi.item;

import com.iwaliner.urushi.ItemAndBlockRegister;
import com.iwaliner.urushi.block.RopeBlock;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ClimbingRopesItem extends Item {
    public ClimbingRopesItem(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        blockpos = blockpos.relative(context.getClickedFace());
        if (world.getBlockState(blockpos).getMaterial()== Material.AIR||world.getBlockState(blockpos).getMaterial()== Material.WATER) {
            world.playSound((Player) null, context.getPlayer().getX(), context.getPlayer().getY(), context.getPlayer().getZ(), SoundEvents.LADDER_PLACE, SoundSource.PLAYERS, 1F, 1F);
            world.setBlockAndUpdate(blockpos, ItemAndBlockRegister.rope.get().defaultBlockState());
            for(int i=1; i<512;i++){
                if(world.getBlockState(blockpos.below(i)).getMaterial()==Material.AIR){
                    world.setBlockAndUpdate(blockpos.below(i),ItemAndBlockRegister.rope.get().defaultBlockState());
                    world.playSound((Player) null, context.getPlayer().getX(), context.getPlayer().getY(), context.getPlayer().getZ(), SoundEvents.LADDER_PLACE, SoundSource.PLAYERS, 1F, 1F);
                    continue;
                }else if(world.getBlockState(blockpos.below(i)).getMaterial()==Material.WATER){
                    world.setBlockAndUpdate(blockpos.below(i),ItemAndBlockRegister.rope.get().defaultBlockState().setValue(RopeBlock.WATERLOGGED,Boolean.valueOf(true)));
                    world.playSound((Player) null, context.getPlayer().getX(), context.getPlayer().getY(), context.getPlayer().getZ(), SoundEvents.LADDER_PLACE, SoundSource.PLAYERS, 1F, 1F);
                    continue;
                }else{
                    break;
                }
            }
            context.getItemInHand().shrink(1);
            return InteractionResult.SUCCESS;
        }
            return  InteractionResult.FAIL;

    }
    @Override
    public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> list, TooltipFlag p_41424_) {
        list.add((new TranslatableComponent("info.urushi.climbing_rope" )).withStyle(ChatFormatting.GRAY));

    }
}
