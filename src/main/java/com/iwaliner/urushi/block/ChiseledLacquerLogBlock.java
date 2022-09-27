package com.iwaliner.urushi.block;


import com.iwaliner.urushi.ItemAndBlockRegister;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public class ChiseledLacquerLogBlock extends HorizonalRotateBlock{
    public static final BooleanProperty FILLED = BooleanProperty.create("filled");


    public ChiseledLacquerLogBlock(Properties p_i48377_1_) {
        super(p_i48377_1_);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(FILLED, Boolean.valueOf(false)));

    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_49915_) {
        p_49915_.add(FACING,FILLED);
    }
    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
       if(random.nextInt(2)==0&&state.getBlock() instanceof ChiseledLacquerLogBlock&&state.getValue(FILLED)==false){
           level.setBlockAndUpdate(pos,state.setValue(FILLED,Boolean.valueOf(true)));
           level.playSound((Player) null,(double) pos.getX()+0.5D,(double) pos.getY()+0.5D,(double) pos.getZ()+0.5D, SoundEvents.HONEY_BLOCK_BREAK, SoundSource.BLOCKS,1F,1F);
       }
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
       if(state.getBlock() instanceof ChiseledLacquerLogBlock&&state.getValue(FILLED)==true){
           ItemStack stack=player.getItemInHand(hand);
           if(stack.getItem()== Items.BOWL){
               stack.shrink(1);
               if (stack.isEmpty()) {
                   player.setItemInHand(hand, new ItemStack(ItemAndBlockRegister.raw_urushi_ball.get()));
               } else if (!player.getInventory().add(new ItemStack(ItemAndBlockRegister.raw_urushi_ball.get()))) {
                   player.drop(new ItemStack(ItemAndBlockRegister.raw_urushi_ball.get()), false);
               }
               level.playSound((Player) null,(double) pos.getX()+0.5D,(double) pos.getY()+0.5D,(double) pos.getZ()+0.5D, SoundEvents.HONEY_BLOCK_BREAK, SoundSource.BLOCKS,1F,1F);
               level.setBlockAndUpdate(pos,state.setValue(FILLED,Boolean.valueOf(false)));
               return InteractionResult.SUCCESS;
           }
       }
       return InteractionResult.FAIL;
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, Random random) {
        if(random.nextInt(10)==0) {
            if (state.getValue(FILLED) == true) {
                BlockPos offsetPos = pos;
                if (state.getValue(FACING) == Direction.NORTH) {
                    offsetPos = pos.north();
                } else if (state.getValue(FACING) == Direction.SOUTH) {
                    offsetPos = pos.south();
                } else if (state.getValue(FACING) == Direction.WEST) {
                    offsetPos = pos.west();
                } else if (state.getValue(FACING) == Direction.EAST) {
                    offsetPos = pos.east();
                }
                double d0 = (double) offsetPos.getX() + random.nextInt(10) * 0.1D;
                double d1 = (double) offsetPos.getY() + random.nextInt(8) * 0.1D;
                double d2 = (double) offsetPos.getZ() + random.nextInt(10) * 0.1D;
                level.addParticle(ParticleTypes.FALLING_HONEY, d0, d1, d2, 0.0D, 0D, 0.0D);
            }
        }
    }
    @Override
    public void appendHoverText(ItemStack p_49816_, @org.jetbrains.annotations.Nullable BlockGetter p_49817_, List<Component> list, TooltipFlag p_49819_) {
        list.add((new TranslatableComponent("info.urushi.chiseled_lacquer_log" )).withStyle(ChatFormatting.GRAY));
    }
}
