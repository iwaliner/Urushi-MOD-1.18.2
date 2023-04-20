package com.iwaliner.urushi.block;

import com.iwaliner.urushi.ItemAndBlockRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.PushReaction;

public class KakuriyoPortalCoreBlock extends Block {
    public KakuriyoPortalCoreBlock(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public PushReaction getPistonPushReaction(BlockState p_60584_) {
        return PushReaction.DESTROY;
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState state2, boolean boo) {
        removePortalBlock(level,pos.offset(1,0,0));
        removePortalBlock(level,pos.offset(-1,0,0));
        for(int i=-1;i<2;i++){
            for(int j=2;j<6;j++){
                removePortalBlock(level,pos.offset(i,-j,0));
            }
        }
    }
    private void removePortalBlock(Level level,BlockPos pos){
        if(level.getBlockState(pos).getBlock() instanceof KakuriyoPortalBlock){
            level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
            level.playSound((Player) null,pos, SoundEvents.BEACON_DEACTIVATE, SoundSource.BLOCKS,0.5F,1F);
        }
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState state2, boolean boo) {
        placePortalBlock(level,pos.offset(1,0,0));
        placePortalBlock(level,pos.offset(-1,0,0));
        for(int i=-1;i<2;i++){
            for(int j=2;j<6;j++){
                placePortalBlock(level,pos.offset(i,-j,0));
            }
        }
    }
    private void placePortalBlock(Level level,BlockPos pos){
        if(level.getBlockState(pos).getMaterial()== Material.AIR){
            level.setBlockAndUpdate(pos, ItemAndBlockRegister.kakuriyo_portal.get().defaultBlockState());
            level.playSound((Player) null,pos, SoundEvents.BEACON_ACTIVATE, SoundSource.BLOCKS,0.5F,1F);
        }
    }
}
