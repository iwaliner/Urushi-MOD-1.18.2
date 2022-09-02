package com.iwaliner.urushi.item;

import com.iwaliner.urushi.ItemAndBlockRegister;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class WagasaItem extends Item {
    boolean isOpen;
    public WagasaItem(boolean b,Properties p_41383_) {
        super(p_41383_);
        isOpen=b;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
       if(isOpen){
           player.setItemInHand(hand,new ItemStack(ItemAndBlockRegister.close_wagasa.get()));
           level.playSound(player,player.getX(),player.getY(),player.getZ(), SoundEvents.ENDER_DRAGON_FLAP, SoundSource.PLAYERS,1F,1F);
           return InteractionResultHolder.success(player.getItemInHand(hand));
       }else{
           player.setItemInHand(hand,new ItemStack(ItemAndBlockRegister.open_wagasa.get()));
           level.playSound(player,player.getX(),player.getY(),player.getZ(), SoundEvents.ENDER_DRAGON_FLAP, SoundSource.PLAYERS,1F,1F);
           return InteractionResultHolder.success(player.getItemInHand(hand));
       }
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int i, boolean b) {
        if(isOpen){
            if(entity instanceof Player){
                Player player= (Player) entity;
                if(player.getOffhandItem().getItem()==this||player.getMainHandItem().getItem()==this){
                    Vec3 vec3 = entity.getDeltaMovement();
                    if(vec3.y<0D){
                        entity.setDeltaMovement(new Vec3(vec3.x,vec3.y*0.6D,vec3.z));
                    }
                    entity.fallDistance=0f;
                }

            }else{
                Vec3 vec3 = entity.getDeltaMovement();
                if(vec3.y<0D){
                    entity.setDeltaMovement(new Vec3(vec3.x,vec3.y*0.6D,vec3.z));
                }
                entity.fallDistance=0f;
            }
        }
    }
    @Override
    public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> list, TooltipFlag p_41424_) {
        list.add((new TranslatableComponent("info.urushi.wagasa" )).withStyle(ChatFormatting.GRAY));

    }
}
