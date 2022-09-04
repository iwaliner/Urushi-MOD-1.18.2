package com.iwaliner.urushi.item;


import com.iwaliner.urushi.UrushiUtils;
import com.iwaliner.urushi.entiity.food.FoodEntity;
import com.mojang.math.Vector3d;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PlaceableFoodItem extends Item {


    public PlaceableFoodItem( Properties p_i48487_1_) {
        super(p_i48487_1_);

    }


    @Override
    public InteractionResult useOn(UseOnContext context) {
        if(!context.getPlayer().isSuppressingBounce()){
            return InteractionResult.PASS;
        }
        EntityType<?> entity= UrushiUtils.getEntityTypeFromFoodItem(this.asItem());

        if ((context.getLevel().isClientSide)) {
            return InteractionResult.SUCCESS;
        }
       if(context.getPlayer().isSuppressingBounce()) {
           Vec3 vector3d = Vec3.atBottomCenterOf(context.getClickedPos());
           AABB axisalignedbb = entity.getDimensions().makeBoundingBox(vector3d.x(), vector3d.y(), vector3d.z());
           if (context.getLevel().getEntities((Entity) null, axisalignedbb).isEmpty()) {
               FoodEntity foodEntity = (FoodEntity) entity.create((ServerLevel) context.getLevel(), (CompoundTag) null,(Component) null,  context.getPlayer(), context.getClickedPos(), MobSpawnType.SPAWN_EGG, true, true);
              foodEntity.moveTo(context.getClickLocation().x, context.getClickLocation().y, context.getClickLocation().z, context.getRotation(), 0.0F);
              context.getLevel().addFreshEntity(foodEntity);
               context.getItemInHand().shrink(1);
               context.getLevel().playSound((Player) null, context.getClickedPos(), SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, 1.0F, 1F);
               return InteractionResult.SUCCESS;
           }
       }
       return InteractionResult.PASS;
    }
    @Override
    public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> list, TooltipFlag p_41424_) {
        list.add((new TranslatableComponent("info.urushi.placeablefood" )).withStyle(ChatFormatting.GRAY));

    }
}
