package com.iwaliner.urushi.item;



import com.iwaliner.urushi.ItemAndBlockRegister;
import com.iwaliner.urushi.RecipeTypeRegister;
import com.iwaliner.urushi.block.AbstractFramedBlock;
import com.iwaliner.urushi.block.FramedPaneBlock;
import com.iwaliner.urushi.block.IronIngotBlock;
import com.iwaliner.urushi.recipe.FryingRecipe;
import com.iwaliner.urushi.recipe.HammeringRecipe;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.checkerframework.checker.units.qual.C;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

public class HammerItem extends Item {
    public HammerItem(Properties p_i48487_1_) {
        super(p_i48487_1_);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player playerentity = context.getPlayer();
        ItemStack itemstack = context.getItemInHand();

        playerentity.getCooldowns().addCooldown(this, 15);
        playerentity.startUsingItem(context.getHand());
        if(context.getLevel().getBlockState(context.getClickedPos()).getBlock() instanceof IronIngotBlock){
            IronIngotBlock ironIngotBlock= (IronIngotBlock) context.getLevel().getBlockState(context.getClickedPos()).getBlock();
            if(ironIngotBlock.getPostBlock()!=null){
                Random random=new Random();
                int i=random.nextInt(16);
                double d0 = (double) context.getClickedPos().getX() +random.nextInt(8)*0.1D+0.2D;
                double d1 = (double) context.getClickedPos().getY() +random.nextInt(5)*0.1D+0.2D;
                double d2 = (double) context.getClickedPos().getZ() +random.nextInt(8)*0.1D+0.2D;
                if (i == 0) {
                    context.getLevel().setBlockAndUpdate(context.getClickedPos(), ironIngotBlock.getPostBlock().defaultBlockState().setValue(IronIngotBlock.FACING, context.getLevel().getBlockState(context.getClickedPos()).getValue(IronIngotBlock.FACING)));
                    context.getLevel().addParticle(ParticleTypes.FLAME,  d0,d1, d2, 0.0D, 0D, 0.0D);
                    context.getLevel().playSound((Player) null, context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), SoundEvents.ANVIL_USE, SoundSource.BLOCKS, 0.3F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
                    itemstack.hurtAndBreak(1, playerentity, (x) -> {
                        x.broadcastBreakEvent(context.getHand());
                    });
                    return InteractionResult.SUCCESS;
                }else{
                    context.getLevel().addParticle(ParticleTypes.FLAME,  d0,d1, d2, 0.0D, 0D, 0.0D);
                    context.getLevel().playSound((Player) null, context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), SoundEvents.ANVIL_PLACE, SoundSource.BLOCKS, 0.3F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
                    itemstack.hurtAndBreak(1, playerentity, (x) -> {
                        x.broadcastBreakEvent(context.getHand());
                    });
                    return InteractionResult.SUCCESS;
                }
            }

        }else if(context.getLevel().getBlockState(context.getClickedPos()).getBlock() instanceof FramedPaneBlock ||context.getLevel().getBlockState(context.getClickedPos()).getBlock() instanceof AbstractFramedBlock){
            BlockState state=context.getLevel().getBlockState(context.getClickedPos());
            context.getLevel().setBlockAndUpdate(context.getClickedPos(), state.setValue(AbstractFramedBlock.VARIANT, !state.getValue(AbstractFramedBlock.VARIANT)));
            itemstack.hurtAndBreak(1, playerentity, (x) -> {
                x.broadcastBreakEvent(context.getHand());
            });
            context.getLevel().playSound((Player) null, context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), SoundEvents.STONE_PLACE, SoundSource.BLOCKS, 1F, 1F);
            playerentity.getCooldowns().removeCooldown(this);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.FAIL;
    }


}
