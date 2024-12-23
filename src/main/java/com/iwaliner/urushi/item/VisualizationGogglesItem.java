package com.iwaliner.urushi.item;

import com.iwaliner.urushi.util.UrushiUtils;
import net.minecraft.core.BlockSource;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraftforge.common.extensions.IForgeItem;

import javax.annotation.Nullable;
import java.util.List;

public class VisualizationGogglesItem extends Item implements Wearable, IForgeItem {
    private final String string;
    public static final DispenseItemBehavior DISPENSE_ITEM_BEHAVIOR = new DefaultDispenseItemBehavior() {
        protected ItemStack execute(BlockSource p_40408_, ItemStack p_40409_) {
            return ArmorItem.dispenseArmor(p_40408_, p_40409_) ? p_40409_ : super.execute(p_40408_, p_40409_);
        }
    };
    public VisualizationGogglesItem(String s, Properties p_41383_) {
        super(p_41383_);
        string=s;
        DispenserBlock.registerBehavior(this, DISPENSE_ITEM_BEHAVIOR);
    }
    public InteractionResultHolder<ItemStack> use(Level p_41137_, Player p_41138_, InteractionHand p_41139_) {
        ItemStack itemstack = p_41138_.getItemInHand(p_41139_);
        EquipmentSlot equipmentslot = EquipmentSlot.HEAD;
        ItemStack itemstack1 = p_41138_.getItemBySlot(equipmentslot);
        if (itemstack1.isEmpty()) {
            p_41138_.setItemSlot(equipmentslot, itemstack.copy());
            if (!p_41137_.isClientSide()) {
                p_41138_.awardStat(Stats.ITEM_USED.get(this));
            }

            itemstack.setCount(0);
            return InteractionResultHolder.sidedSuccess(itemstack, p_41137_.isClientSide());
        } else {
            return InteractionResultHolder.fail(itemstack);
        }
    }
    @Nullable
    public SoundEvent getEquipSound() {
        return SoundEvents.ARMOR_EQUIP_LEATHER;
    }


    @Override
    public EquipmentSlot getEquipmentSlot(ItemStack stack) {
        return EquipmentSlot.HEAD;
    }

    @Override
    public boolean isEnderMask(ItemStack stack, Player player, EnderMan endermanEntity) {
        return true;
    }
    @Override
    public void appendHoverText(ItemStack p_41421_,  Level p_41422_, List<Component> list, TooltipFlag p_41424_) {
        UrushiUtils.setInfo(list,string);
    }

    @Override
    public void inventoryTick(ItemStack p_41404_, Level p_41405_, Entity p_41406_, int p_41407_, boolean p_41408_) {
        super.inventoryTick(p_41404_, p_41405_, p_41406_, p_41407_, p_41408_);
    }
}
