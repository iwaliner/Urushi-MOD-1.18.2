package com.iwaliner.urushi.entiity;

import com.iwaliner.urushi.EntityRegister;
import com.iwaliner.urushi.ItemAndBlockRegister;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

public class RedOniEntity extends Zombie {
    public RedOniEntity(EntityType<? extends Zombie> p_34271_, Level p_34272_) {
        super(EntityRegister.Ghost.get(), p_34272_);
    }
    protected SoundEvent getAmbientSound() {
        return SoundEvents.PUFFER_FISH_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource p_34327_) {
        return SoundEvents.HUSK_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.HUSK_DEATH;
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.HUSK_STEP;
    }
    public boolean hurt(DamageSource p_34288_, float p_34289_) {
        if (!super.hurt(p_34288_, p_34289_)) {
            return false;
        } else if (!(this.level instanceof ServerLevel)) {
            return false;
        } else {


            return true;
        }
    }
    protected ItemStack getSkull() {
        return  ItemStack.EMPTY;
    }




    public void killed(ServerLevel p_34281_, LivingEntity p_34282_) {


    }
  /*  private ItemStack createSpawnWeapon() {
        return  new ItemStack(ItemAndBlockRegister.metal_club.get());
    }
    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_34717_, DifficultyInstance p_34718_, MobSpawnType p_34719_, @Nullable SpawnGroupData p_34720_, @Nullable CompoundTag p_34721_) {
        if (p_34719_ != MobSpawnType.STRUCTURE) {

                this.setItemSlot(EquipmentSlot.MAINHAND, this.createSpawnWeapon());

        }

        this.populateDefaultEquipmentSlots(p_34718_);
        this.populateDefaultEquipmentEnchantments(p_34718_);
        return super.finalizeSpawn(p_34717_, p_34718_, p_34719_, p_34720_, p_34721_);
    }*/

}
