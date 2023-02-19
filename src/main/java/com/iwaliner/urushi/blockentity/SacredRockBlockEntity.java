package com.iwaliner.urushi.blockentity;

import com.iwaliner.urushi.BlockEntityRegister;
import com.iwaliner.urushi.block.SacredRockBlock;
import com.iwaliner.urushi.util.ElementType;
import com.iwaliner.urushi.util.ElementUtils;
import com.iwaliner.urushi.util.interfaces.ReiryokuExportable;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class SacredRockBlockEntity extends AbstractReiryokuStorableBlockEntity implements ReiryokuExportable {
    public int coolTime;
    public SacredRockBlockEntity(BlockPos p_155550_, BlockState p_155551_) {
        super(BlockEntityRegister.SacredRock.get(),1000, p_155550_, p_155551_);
    }

    public void load(CompoundTag tag) {
        super.load(tag);
       this.coolTime = tag.getInt("coolTime");

    }

    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putInt("coolTime", this.coolTime);

    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag compoundtag = new CompoundTag();
        compoundtag.putInt("coolTime", this.coolTime);
        compoundtag.putIntArray("receiveWaitingTime", this.receiveWaitingTime);
        return compoundtag;
    }




    @Override
    public  ElementType getExportElementType() {
      return this.getStoredElementType();
    }


    public static void tick(Level level, BlockPos pos, BlockState state, SacredRockBlockEntity blockEntity) {
       BlockPos dedicatedPos=pos.relative(state.getValue(SacredRockBlock.FACING));
        BlockState dedicatedState=level.getBlockState(dedicatedPos);
      if(ElementUtils.isSpecificElement(blockEntity.getStoredElementType(),dedicatedState)){
          if(blockEntity.coolTime<20*5) {
              blockEntity.coolTime++;
          }else if( blockEntity.canAddReiryoku(10)){
              blockEntity.addStoredReiryoku(10);
              level.setBlock(dedicatedPos, Blocks.AIR.defaultBlockState(),2);
              blockEntity.coolTime=0;
          }
       }else{
          if(blockEntity.coolTime!=0){
              blockEntity.coolTime=0;
          }
      }
    }
    }
