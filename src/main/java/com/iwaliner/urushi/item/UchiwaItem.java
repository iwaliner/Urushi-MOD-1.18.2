package com.iwaliner.urushi.item;

import com.iwaliner.urushi.block.FallenLeavesBlock;
import com.iwaliner.urushi.util.UrushiUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.LeavesBlock;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class UchiwaItem extends Item {
    public UchiwaItem(Properties p_41383_) {
        super(p_41383_);
    }
    public int getUseDuration(ItemStack p_43107_) {
        return 72000;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
       BlockPos pos=player.blockPosition();
        int w=3;
       player.swing(hand,true);
        for(int i=-w;i<=w;i++){
            for(int j=-w;j<=w;j++) {
                for(int k=-w;k<=w;k++) {
                    if(level.getBlockState(pos.offset(i,j,k)).getBlock() instanceof BushBlock||level.getBlockState(pos.offset(i,j,k)).getBlock() instanceof LeavesBlock||level.getBlockState(pos.offset(i,j,k)).getBlock() instanceof FallenLeavesBlock){

                        level.destroyBlock(pos.offset(i,j,k),true);
                        player.getItemInHand(hand).hurtAndBreak(1, player, (x) -> {
                            x.broadcastBreakEvent(hand);
                        });
                    }
                }
                }
            }
        return InteractionResultHolder.consume(itemstack);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        ItemStack itemStack=context.getItemInHand();
        BlockPos pos=context.getClickedPos();
        Level level=context.getLevel();
        Player player=context.getPlayer();
        InteractionHand hand=context.getHand();
        int w=3;
        player.swing(hand,true);
        for(int i=-w;i<=w;i++){
            for(int j=-w;j<=w;j++) {
                for(int k=-w;k<=w;k++) {
                    if(level.getBlockState(pos.offset(i,j,k)).getBlock() instanceof BushBlock||level.getBlockState(pos.offset(i,j,k)).getBlock() instanceof LeavesBlock||level.getBlockState(pos.offset(i,j,k)).getBlock() instanceof FallenLeavesBlock){

                        level.destroyBlock(pos.offset(i,j,k),true);
                        player.getItemInHand(hand).hurtAndBreak(1, player, (x) -> {
                            x.broadcastBreakEvent(hand);
                        });
                    }
                }
            }
        }
        return InteractionResult.SUCCESS;
    }
    @Override
    public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> list, TooltipFlag p_41424_) {
        UrushiUtils.setInfo(list,"uchiwa");
    }
}
