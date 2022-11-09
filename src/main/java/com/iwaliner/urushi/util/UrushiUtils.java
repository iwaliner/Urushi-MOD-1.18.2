package com.iwaliner.urushi.util;

import com.iwaliner.urushi.ItemAndBlockRegister;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

import java.util.List;
import java.util.Map;

public class UrushiUtils {
    public  static Direction getDirectionFromInt(int i){
        switch (i){
            case 0 :return  Direction.DOWN;
            case 1 :return  Direction.UP;
            case 2 :return  Direction.NORTH;
            case 3 :return  Direction.SOUTH;
            case 4 :return  Direction.WEST;
            case 5 :return  Direction.EAST;
            default: return Direction.NORTH;
        }
    }
    public  static int getIntFromDirection(Direction direction){
        switch (direction){
            case DOWN:  return  0;
            case UP:    return 1;
            case NORTH :return  2;
            case SOUTH :return  3;
            case WEST : return  4;
            case EAST : return 5;
            default:    return 6;
        }
    }
    public static void setInfo(List<Component> list,String string){
        list.add((new TranslatableComponent("info.urushi."+string )).withStyle(ChatFormatting.GRAY));
    }
    public static void setInfoWithColor(List<Component> list,String string,ChatFormatting chatFormatting){
        list.add((new TranslatableComponent("info.urushi."+string )).withStyle(chatFormatting));
    }
    public static void BlockChangeNeighborStateSurvey(Level level, BlockPos pos, BlockState detectBlock, BlockState placeBlock, SoundEvent soundEvent){
            if (BlockNeighborStateSurvey(level,pos,detectBlock)) {
               level.setBlock(pos, placeBlock, 2);
                level.playSound((Player) null,pos,soundEvent, SoundSource.BLOCKS, 1.0F, 1F);
            }
    }
    public static void BlockChangeNeighborMaterialSurvey(Level level, BlockPos pos,Material detectMaterial, BlockState placeBlock, SoundEvent soundEvent){
        if (BlockNeighborMaterialSurvey(level,pos,detectMaterial)) {
            level.setBlock(pos, placeBlock, 2);
            level.playSound((Player) null,pos,soundEvent, SoundSource.BLOCKS, 1.0F, 1F);
        }
    }
    public static boolean BlockNeighborStateSurvey(Level level, BlockPos pos, BlockState detectBlock){
        boolean flag = false;
        for (int i = 0; i < 6; i++) {
            if (level.getBlockState(pos.relative(UrushiUtils.getDirectionFromInt(i))) ==detectBlock) {
                flag = true;
            }
        }
      return flag;
    }
    public static boolean BlockNeighborMaterialSurvey(Level level, BlockPos pos,Material detectMaterial){
        boolean flag = false;
        for (int i = 0; i < 6; i++) {
            if (level.getBlockState(pos.relative(UrushiUtils.getDirectionFromInt(i))).getMaterial() ==detectMaterial) {
                flag = true;
            }
        }
        return flag;
    }
}
