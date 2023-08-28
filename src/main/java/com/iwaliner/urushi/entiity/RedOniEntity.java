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
        super(EntityRegister.RedOni.get(), p_34272_);
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
            /*
            ServerLevel serverlevel = (ServerLevel)this.level;
            LivingEntity livingentity = this.getTarget();
            if (livingentity == null && p_34288_.getEntity() instanceof LivingEntity) {
                livingentity = (LivingEntity)p_34288_.getEntity();
            }

            int i = Mth.floor(this.getX());
            int j = Mth.floor(this.getY());
            int k = Mth.floor(this.getZ());
            net.minecraftforge.event.entity.living.ZombieEvent.SummonAidEvent event = net.minecraftforge.event.ForgeEventFactory.fireZombieSummonAid(this, level, i, j, k, livingentity, this.getAttribute(Attributes.SPAWN_REINFORCEMENTS_CHANCE).getValue());
            if (event.getResult() == net.minecraftforge.eventbus.api.Event.Result.DENY) return true;
            if (event.getResult() == net.minecraftforge.eventbus.api.Event.Result.ALLOW  ||
                    livingentity != null && this.level.getDifficulty() == Difficulty.HARD && (double)this.random.nextFloat() < this.getAttribute(Attributes.SPAWN_REINFORCEMENTS_CHANCE).getValue() && this.level.getGameRules().getBoolean(GameRules.RULE_DOMOBSPAWNING)) {
                Zombie zombie = event.getCustomSummonedAid() != null && event.getResult() == net.minecraftforge.eventbus.api.Event.Result.ALLOW ? event.getCustomSummonedAid() : EntityRegister.Ghost.get().create(this.level);

                for(int l = 0; l < 50; ++l) {
                    int i1 = i + Mth.nextInt(this.random, 7, 40) * Mth.nextInt(this.random, -1, 1);
                    int j1 = j + Mth.nextInt(this.random, 7, 40) * Mth.nextInt(this.random, -1, 1);
                    int k1 = k + Mth.nextInt(this.random, 7, 40) * Mth.nextInt(this.random, -1, 1);
                    BlockPos blockpos = new BlockPos(i1, j1, k1);
                    EntityType<?> entitytype = zombie.getType();
                    SpawnPlacements.Type spawnplacements$type = SpawnPlacements.getPlacementType(entitytype);
                    if (NaturalSpawner.isSpawnPositionOk(spawnplacements$type, this.level, blockpos, entitytype) && SpawnPlacements.checkSpawnRules(entitytype, serverlevel, MobSpawnType.REINFORCEMENT, blockpos, this.level.random)) {
                        zombie.setPos((double)i1, (double)j1, (double)k1);
                        if (!this.level.hasNearbyAlivePlayer((double)i1, (double)j1, (double)k1, 7.0D) && this.level.isUnobstructed(zombie) && this.level.noCollision(zombie) && !this.level.containsAnyLiquid(zombie.getBoundingBox())) {
                            if (livingentity != null)
                                zombie.setTarget(livingentity);
                            zombie.finalizeSpawn(serverlevel, this.level.getCurrentDifficultyAt(zombie.blockPosition()), MobSpawnType.REINFORCEMENT, (SpawnGroupData)null, (CompoundTag)null);
                            serverlevel.addFreshEntityWithPassengers(zombie);
                            this.getAttribute(Attributes.SPAWN_REINFORCEMENTS_CHANCE).addPermanentModifier(new AttributeModifier("Zombie reinforcement caller charge", (double)-0.05F, AttributeModifier.Operation.ADDITION));
                            zombie.getAttribute(Attributes.SPAWN_REINFORCEMENTS_CHANCE).addPermanentModifier(new AttributeModifier("Zombie reinforcement callee charge", (double)-0.05F, AttributeModifier.Operation.ADDITION));
                            break;
                        }
                    }
                }
            }*/

            return true;
        }
    }
    protected ItemStack getSkull() {
        return  ItemStack.EMPTY;
    }


  /*  protected PathNavigation createNavigation(Level p_29417_) {
        FlyingPathNavigation flyingpathnavigation = new FlyingPathNavigation(this, p_29417_);
        flyingpathnavigation.setCanOpenDoors(false);
        flyingpathnavigation.setCanFloat(true);
        flyingpathnavigation.setCanPassDoors(true);
        return flyingpathnavigation;
    }*/



    /*public void aiStep() {
        super.aiStep();
        this.calculateFlapping();
    }*/

    public void killed(ServerLevel p_34281_, LivingEntity p_34282_) {


    }
    private ItemStack createSpawnWeapon() {
        return  new ItemStack(ItemAndBlockRegister.metal_club.get());
    }
    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_34717_, DifficultyInstance p_34718_, MobSpawnType p_34719_, @Nullable SpawnGroupData p_34720_, @Nullable CompoundTag p_34721_) {
        if (p_34719_ != MobSpawnType.STRUCTURE) {
            if (p_34717_.getRandom().nextFloat() < 0.2F) {
                this.setBaby(true);
            }
                this.setItemSlot(EquipmentSlot.MAINHAND, this.createSpawnWeapon());

        }

        this.populateDefaultEquipmentSlots(p_34718_);
        this.populateDefaultEquipmentEnchantments(p_34718_);
        return super.finalizeSpawn(p_34717_, p_34718_, p_34719_, p_34720_, p_34721_);
    }

}
