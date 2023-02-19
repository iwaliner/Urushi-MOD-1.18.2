package com.iwaliner.urushi.util.interfaces;

import com.iwaliner.urushi.util.ElementType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

public interface ReiryokuStorable {
    /**霊力の最大貯蔵容量*/
    int getReiryokuCapacity();

    /**霊力の現在の貯蔵量*/
    int getStoredReiryoku();

    /**霊力の貯蔵量を増加*/
    void addStoredReiryoku(int i);

    boolean canAddReiryoku(int i);

    /**霊力の貯蔵量を減少*/
    void decreaseStoredReiryoku(int i);
    boolean canDecreaseReiryoku(int i);


    /**貯蔵する気*/
    ElementType getStoredElementType();

    void recieveReiryoku(Level level, BlockPos pos);



    default int[] getReceiveWaitingTime() {
        return new int[1000];
    }
    void markUpdated();

}
