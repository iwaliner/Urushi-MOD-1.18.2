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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
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
    public static boolean BlockNeighborBlockSurvey(Level level, BlockPos pos,Block block){
        boolean flag = false;
        for (int i = 0; i < 6; i++) {
            if (level.getBlockState(pos.relative(UrushiUtils.getDirectionFromInt(i))).getBlock() ==block) {
                flag = true;
            }
        }
        return flag;
    }
    public static boolean isShogatsu() {
        LocalDate localdate = LocalDate.now();
        int i = localdate.get(ChronoField.DAY_OF_MONTH);
        int j = localdate.get(ChronoField.MONTH_OF_YEAR);
        return j == 1 && i <=7;
    }
    public static VoxelShape rotateSimpleBoxShapeHorizontally(VoxelShape baseShape,int angle){
        double x_min=baseShape.min(Direction.Axis.X)*16D;
        double x_max=baseShape.max(Direction.Axis.X)*16D;
        double y_min=baseShape.min(Direction.Axis.Y)*16D;
        double y_max=baseShape.max(Direction.Axis.Y)*16D;
        double z_min=baseShape.min(Direction.Axis.Z)*16D;
        double z_max=baseShape.max(Direction.Axis.Z)*16D;
        if(angle==90){
            return Block.box(16D-z_max,y_min,x_min,16D-z_min,y_max,x_max);
        }else if(angle==180){
            return Block.box(16D-x_max,y_min,16D-z_max,16D-x_min,y_max,16D-z_min);
        }else if(angle==270){
            return Block.box(z_min,y_min,16D-x_max,z_max,y_max,16D-x_min);
        }else{
            return baseShape;
        }
    }
    public static VoxelShape rotateSimpleBoxShapeHorizontally(VoxelShape baseShape,Direction direction){
        if(direction==Direction.EAST){
           return rotateSimpleBoxShapeHorizontally(baseShape,90);
        }else if(direction==Direction.SOUTH){
           return rotateSimpleBoxShapeHorizontally(baseShape,180);
        }else if(direction==Direction.WEST){
           return rotateSimpleBoxShapeHorizontally(baseShape,270);
        }else{
           return baseShape;
        }
    }

}
