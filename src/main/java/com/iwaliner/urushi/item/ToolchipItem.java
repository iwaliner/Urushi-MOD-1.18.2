package com.iwaliner.urushi.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ToolchipItem extends Item {
    private String string;
    public ToolchipItem(String s,Properties p_41383_) {
        super(p_41383_);
        string=s;
    }
    @Override
    public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> list, TooltipFlag p_41424_) {
        list.add((new TranslatableComponent("info.urushi."+string )).withStyle(ChatFormatting.GRAY));

    }
}
