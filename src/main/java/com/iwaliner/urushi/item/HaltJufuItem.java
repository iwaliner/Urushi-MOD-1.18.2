package com.iwaliner.urushi.item;


import com.iwaliner.urushi.ItemAndBlockRegister;
import com.iwaliner.urushi.entiity.KitsunebiEntity;
import com.iwaliner.urushi.util.ElementType;
import com.iwaliner.urushi.util.ElementUtils;
import com.iwaliner.urushi.util.UrushiUtils;
import com.iwaliner.urushi.util.interfaces.ElementItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FireBlock;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class HaltJufuItem extends Item implements ElementItem {
   public HaltJufuItem(Properties p_i48466_1_) {
      super(p_i48466_1_);
   }

   public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
      ItemStack itemstack = player.getItemInHand(hand);
      ItemStack magatama= ElementUtils.getMagatamaInInventory(player, ElementType.MetalElement);
      if(magatama!=ItemStack.EMPTY&&ElementUtils.willBeInDomain(magatama,-10)) {

         world.playSound((Player) null, player.getX(), player.getY(), player.getZ(), SoundEvents.FIRECHARGE_USE, SoundSource.PLAYERS, 0.5F, 1F);
         if (!world.isClientSide) {
            KitsunebiEntity entity = new KitsunebiEntity(world, player);
            entity.setItem(new ItemStack(ItemAndBlockRegister.halt_jufu.get()));
            entity.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
            world.addFreshEntity(entity);
         }

         player.awardStat(Stats.ITEM_USED.get(this));
         if (!player.getAbilities().instabuild) {
            itemstack.shrink(1);
            ElementUtils.increaseStoredReiryokuAmount(magatama,-10);
         }

         return InteractionResultHolder.sidedSuccess(itemstack, world.isClientSide());
      }
      return InteractionResultHolder.fail(itemstack);
   }


   @Override
   public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> list, TooltipFlag p_41424_) {
      UrushiUtils.setInfo(list,"kitsunebi");
      UrushiUtils.setInfo(list,"kitsunebi2");
      UrushiUtils.setInfo(list,"kitsunebi3");
   }


   @Override
   public ElementType getElementType() {
      return ElementType.MetalElement;
   }
}