package com.iwaliner.urushi.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.iwaliner.urushi.util.UrushiUtils;
import com.mojang.math.Vector3d;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.ToolActions;
import org.jetbrains.annotations.Nullable;


import java.util.List;

public class NormalKatanaItem extends SwordItem implements Vanishable {
    private final float attackDamage;

    private final Multimap<Attribute, AttributeModifier> defaultModifiers;

    public NormalKatanaItem(Tier tier,int i,float f, Properties properties) {
        super(tier,i,f,  properties);
        this.attackDamage = (float)i + tier.getAttackDamageBonus();
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", (double)this.attackDamage, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", (double)f, AttributeModifier.Operation.ADDITION));
        this.defaultModifiers = builder.build();
    }

    public float getDamage() {
        return this.attackDamage;
    }


   @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        boolean flag=player.isOnGround();
        float a=flag?2F:1F;
        double f = -Math.sin(player.getYRot() * ((float)Math.PI / 180F)) * Math.cos(player.getXRot() * ((float)Math.PI / 180F));
        double f1 = -Math.sin((player.getXRot() + 0f) * ((float)Math.PI / 180F));
        double f2 = Math.cos(player.getYRot() * ((float)Math.PI / 180F)) * Math.cos(player.getXRot() * ((float)Math.PI / 180F));
        Vec3 vector3d = (new Vec3((double)f*a, (double)f1*a*0.4D, (double)f2*a));
        player.getCooldowns().addCooldown(this, 10);
        player.startUsingItem(hand);
        player.setDeltaMovement(vector3d);
        player.getItemInHand(hand).hurtAndBreak(1, player, (x) -> {
            x.broadcastBreakEvent(hand);
        });

       hurtListedEntities(level,player,(double)f*a, (double)f1*a*0.4D, (double)f2*a);
        return InteractionResultHolder.sidedSuccess(player.getItemInHand(hand), level.isClientSide());
    }

    private void hurtListedEntities(Level level,Player player, double Vx,double Vy,double Vz){

        for(int t=0;t<5;t++){
            BlockPos predicatedPos=new BlockPos(Mth.floor(player.getX()+Vx*t),Mth.floor(player.getY()+Vy*t),Mth.floor(player.getZ()+Vz*t));
            List<LivingEntity> list = player.level.getEntitiesOfClass(LivingEntity.class, new AABB(predicatedPos).inflate(1D,1D,1D));
            if(!list.isEmpty()) {
                for (LivingEntity entity : list) {
                    if(entity instanceof Player) {
                    }else if(entity instanceof TamableAnimal&&((TamableAnimal) entity).getOwnerUUID()!=null) {
                    }else if(entity.isAlive()){

                        entity.hurt(DamageSource.GENERIC, (getDamage()+ EnchantmentHelper.getDamageBonus(player.getItemInHand(InteractionHand.MAIN_HAND),entity.getMobType())) /2);
                        player.level.playSound((Player) null, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.PLAYER_ATTACK_KNOCKBACK, SoundSource.PLAYERS, 1.5F, 1F);
                    }
                }
            }
        }
    }


    @Override
    public InteractionResult interactLivingEntity(ItemStack itemStack, Player player, LivingEntity living, InteractionHand hand) {
            living.hurt(DamageSource.GENERIC,getDamage()/2);
            this.use(player.level,player,hand);
            player.level.playSound((Player) null, living.getX(), living.getY(), living.getZ(), SoundEvents.PLAYER_ATTACK_KNOCKBACK, SoundSource.PLAYERS, 1.5F, 1F);
            return InteractionResult.sidedSuccess(player.level.isClientSide);
        }

    @Override
    public boolean canPerformAction(ItemStack stack, net.minecraftforge.common.ToolAction toolAction) {
        return toolAction!= ToolActions.SWORD_SWEEP&&net.minecraftforge.common.ToolActions.DEFAULT_SWORD_ACTIONS.contains(toolAction);
    }
    @Override
    public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> list, TooltipFlag p_41424_) {
        UrushiUtils.setInfo(list,"katana");
    }

}
