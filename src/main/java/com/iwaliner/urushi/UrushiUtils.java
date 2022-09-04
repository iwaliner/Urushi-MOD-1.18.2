package com.iwaliner.urushi;

import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;

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
    public static EntityType<?> getEntityTypeFromFoodItem(Item item){
        if(item==ItemAndBlockRegister.rice.get()){
            return EntityRegister.RiceFoodEntity.get();
        }else if(item==ItemAndBlockRegister.tkg.get()){
            return EntityRegister.TKGFoodEntity.get();
        }else if(item==ItemAndBlockRegister.sekihan.get()){
            return EntityRegister.SekihanFoodEntity.get();
        }else if(item==ItemAndBlockRegister.gyudon.get()){
            return EntityRegister.GyudonFoodEntity.get();
        }else if(item==ItemAndBlockRegister.butadon.get()){
            return EntityRegister.ButadonFoodEntity.get();
        }
        return EntityRegister.RiceFoodEntity.get();
    }
}
