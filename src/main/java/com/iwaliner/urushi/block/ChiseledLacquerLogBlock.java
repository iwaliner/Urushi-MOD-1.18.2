package com.iwaliner.urushi.block;


import com.iwaliner.urushi.ItemAndBlockRegister;
import com.iwaliner.urushi.util.ElementType;
import com.iwaliner.urushi.util.ElementUtils;
import com.iwaliner.urushi.util.UrushiUtils;
import net.minecraft.core.*;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.core.dispenser.OptionalDispenseItemBehavior;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.DispenserBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.ticks.TickPriority;
import net.minecraftforge.common.BiomeDictionary;

import java.util.List;
import java.util.Random;
import java.util.Set;

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
       if(random.nextInt(5)==0&&state.getBlock() instanceof ChiseledLacquerLogBlock&& !state.getValue(FILLED)){
           level.setBlockAndUpdate(pos,state.setValue(FILLED,Boolean.valueOf(true)));
           level.playSound((Player) null,(double) pos.getX()+0.5D,(double) pos.getY()+0.5D,(double) pos.getZ()+0.5D, SoundEvents.HONEY_BLOCK_BREAK, SoundSource.BLOCKS,1F,1F);
       }
       if(random.nextInt(5)==0&&state.getBlock() instanceof ChiseledLacquerLogBlock&& state.getValue(FILLED)){
           ElementType element=null;
           if(isPressured(level,pos)){
            /*  AABB axisalignedbb =new AABB(pos).inflate(4D,4D,4D);
               List<LivingEntity> list = level.getEntitiesOfClass(LivingEntity.class, axisalignedbb);
               if (!list.isEmpty()) {
                   for (LivingEntity entity : list) {
                       if (ElementUtils.isElementMob(entity)) {
                           absorbMob(level, pos, entity);
                           level.scheduleTick(pos, this, 40, TickPriority.VERY_HIGH);
                           break;
                       }
                   }
               }*/
               AABB aabb =new AABB(pos).inflate(0.4D,0.4D,0.4D);
               List<LivingEntity> list2 = level.getEntitiesOfClass(LivingEntity.class, aabb);
               if(!list2.isEmpty()) {
                   for (LivingEntity entity : list2) {
                       if(ElementUtils.isWoodElementMob(entity)) {
                           element=ElementType.WoodElement;
                           level.playSound((Player) null,pos,SoundEvents.STONE_PLACE,SoundSource.BLOCKS,1F,1F);
                           entity.discard();
                           break;
                       }else if(ElementUtils.isFireElementMob(entity)) {
                           element=ElementType.FireElement;
                           level.playSound((Player) null,pos,SoundEvents.STONE_PLACE,SoundSource.BLOCKS,1F,1F);
                           entity.discard();
                           break;
                       }else if(ElementUtils.isEarthElementMob(entity)) {
                           element=ElementType.EarthElement;
                           level.playSound((Player) null,pos,SoundEvents.STONE_PLACE,SoundSource.BLOCKS,1F,1F);
                           entity.discard();
                           break;
                       }else if(ElementUtils.isMetalElementMob(entity)) {
                           element=ElementType.MetalElement;
                           level.playSound((Player) null,pos,SoundEvents.STONE_PLACE,SoundSource.BLOCKS,1F,1F);
                           entity.discard();
                           break;
                       }else if(ElementUtils.isWaterElementMob(entity)) {
                           element=ElementType.WaterElement;
                           level.playSound((Player) null,pos,SoundEvents.STONE_PLACE,SoundSource.BLOCKS,1F,1F);
                           entity.discard();
                           break;
                       }
                   }
               }


               if(element!=null){
                       if(element==ElementType.WoodElement){
                           level.setBlockAndUpdate(pos,ItemAndBlockRegister.petrified_log_with_wood_amber.get().defaultBlockState().setValue(FACING,state.getValue(FACING)));
                       }else if(element==ElementType.FireElement){
                           level.setBlockAndUpdate(pos,ItemAndBlockRegister.petrified_log_with_fire_amber.get().defaultBlockState().setValue(FACING,state.getValue(FACING)));
                       }else if(element==ElementType.EarthElement){
                           level.setBlockAndUpdate(pos,ItemAndBlockRegister.petrified_log_with_earth_amber.get().defaultBlockState().setValue(FACING,state.getValue(FACING)));
                       }else if(element==ElementType.MetalElement){
                           level.setBlockAndUpdate(pos,ItemAndBlockRegister.petrified_log_with_metal_amber.get().defaultBlockState().setValue(FACING,state.getValue(FACING)));
                       }else {
                           level.setBlockAndUpdate(pos,ItemAndBlockRegister.petrified_log_with_water_amber.get().defaultBlockState().setValue(FACING,state.getValue(FACING)));
                       }
               }else{
                   level.setBlockAndUpdate(pos,ItemAndBlockRegister.petrified_log.get().defaultBlockState());
               }


           }
       }
    }
/*
    private static void absorbMob(Level level,BlockPos logPos,LivingEntity entity){
       // entity.setNoGravity(true);
       // entity.noPhysics=true;
        Vec3 mobPos=entity.position();
        double p=mobPos.x-(double) logPos.getX();
        double q=mobPos.y-(double) logPos.getY();
        double r=mobPos.z-(double) logPos.getZ();
        entity.setDeltaMovement(-p/3,-q/3,-r/3);
        //level.scheduleTick(logPos, level.getBlockState(logPos).getBlock(), 5, TickPriority.VERY_HIGH);
    }*/
    private static boolean isPressured(Level level, BlockPos pos){
        return level.getBlockState(pos.above()).getBlock()==ItemAndBlockRegister.yomi_stone.get();
    }


    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
       if(state.getBlock() instanceof ChiseledLacquerLogBlock&& state.getValue(FILLED)){
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
        UrushiUtils.setInfo(list,"chiseled_lacquer_log");
     }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 60;
    }
}
