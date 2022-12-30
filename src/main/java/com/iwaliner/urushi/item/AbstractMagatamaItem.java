package com.iwaliner.urushi.item;

import com.iwaliner.urushi.ConfigUrushi;
import com.iwaliner.urushi.util.ElementUtils;
import com.iwaliner.urushi.util.UrushiUtils;
import com.iwaliner.urushi.util.interfaces.HasReiryokuItem;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.util.Mth;
import net.minecraft.util.StringUtil;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.WritableBookItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

import javax.annotation.Nullable;
import java.util.List;

public abstract class AbstractMagatamaItem extends Item implements HasReiryokuItem {

    public AbstractMagatamaItem(Properties p_41383_) {
        super(p_41383_);
    }
    @Override
    public int getReiryokuCapacity(){
        return ConfigUrushi.reiryokuCapacityOfMagatama.get();
    }

    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> list, TooltipFlag flag) {
        if (stack.hasTag()) {
            list.add((new TranslatableComponent("info.urushi.storedReiryokuAmount1").append(ElementUtils.getStoredReiryokuAmount(stack)+" ").append(new TranslatableComponent("info.urushi.storedReiryokuAmount2"))).withStyle(ChatFormatting.WHITE));
        }
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if(context.getLevel().getBlockState(context.getClickedPos()).getBlock()== Blocks.BARRIER){
            ElementUtils.increaseStoredReiryokuAmount(context.getPlayer().getItemInHand(context.getHand()),100);
            return InteractionResult.SUCCESS;
        }else if(context.getLevel().getBlockState(context.getClickedPos()).getBlock()== Blocks.STRUCTURE_VOID){
            ElementUtils.increaseStoredReiryokuAmount(context.getPlayer().getItemInHand(context.getHand()),-100);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.FAIL;
    }
}
