package com.iwaliner.urushi.blockentity;

import com.iwaliner.urushi.BlockEntityRegister;
import com.iwaliner.urushi.ParticleRegister;
import com.iwaliner.urushi.block.EmitterBlock;
import com.iwaliner.urushi.block.MirrorBlock;
import com.iwaliner.urushi.block.SacredRockBlock;
import com.iwaliner.urushi.util.ComplexDirection;
import com.iwaliner.urushi.util.ElementType;
import com.iwaliner.urushi.util.ElementUtils;
import com.iwaliner.urushi.util.interfaces.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.ticks.TickPriority;

public class EmitterBlockEntity extends AbstractReiryokuStorableBlockEntity implements ReiryokuExportable {
   public static   final double particleSpeed=0.2D;
    public EmitterBlockEntity(BlockPos p_155550_, BlockState state) {
        super(BlockEntityRegister.Emitter.get(),100, p_155550_, state);
    }


    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag compoundtag = new CompoundTag();
        this.putBaseTag(compoundtag);
        return compoundtag;
    }

    /**一度に送信する霊力の量*/
    private int getSendAmount(){
        Tiered tiered= (Tiered) getBlockState().getBlock();
        int tier=tiered.getTier();
        int i=1;
        switch (tier){
            case 1: i= 1;
            case 2: i= 10;
            case 3: i= 20;
        }

        if(this.getStoredReiryoku()-i<0){
            return getStoredReiryoku();
        }else{
            return i;
        }
    }



    /**tick毎の処理*/
    public static void tick(Level level, BlockPos pos, BlockState state, EmitterBlockEntity emitterBlockEntity) {

        /**送られた霊力を受け取る処理*/
        emitterBlockEntity.recieveReiryoku(level,pos);

        /**後ろにあるブロックから霊力を吸いだす処理　開始*/
       int i=1;
          BlockPos importPos=pos.relative(state.getValue(SacredRockBlock.FACING).getOpposite());
           BlockState importState=level.getBlockState(importPos);
           BlockEntity importBlockEntity=level.getBlockEntity(importPos);
           if(importBlockEntity instanceof ReiryokuStorable) {
               ReiryokuStorable reiryokuStorable = (ReiryokuStorable) importBlockEntity;
               ElementType elementType=reiryokuStorable.getStoredElementType();
               if (reiryokuStorable.canDecreaseReiryoku(i)&&emitterBlockEntity.canAddReiryoku(i)&&emitterBlockEntity.getStoredElementType()==elementType) {
                   reiryokuStorable.decreaseStoredReiryoku(i);
                   emitterBlockEntity.addStoredReiryoku(i);
                   reiryokuStorable.markUpdated();
                   emitterBlockEntity.markUpdated();
               }
           }
        /**後ろにあるブロックから霊力を吸いだす処理　終了*/


        if(!state.getValue(EmitterBlock.POWERED)){
            if(emitterBlockEntity.sendDistance(level,pos)!=0&&emitterBlockEntity.getStoredReiryoku()>0) {
               double vX = 0D, vY = 0D, vZ = 0D;
               double v0 = emitterBlockEntity.particleSpeed;
               Direction direction = state.getValue(EmitterBlock.FACING);
               double dx=0D,dy=0D,dz=0D;
               if (direction == Direction.UP) {
                   vY = v0;
                  dy=-0.25D;
               } else if (direction == Direction.DOWN) {
                   vY = -v0;
                   dy=0.25D;
               } else if (direction == Direction.NORTH) {
                   vZ = -v0;
                   dz=0.25D;
               } else if (direction == Direction.SOUTH) {
                   vZ = v0;
                   dz=-0.25D;
               } else if (direction == Direction.EAST) {
                   vX = v0;
                   dx=-0.25D;
               } else if (direction == Direction.WEST) {
                   vX = -v0;
                   dx=0.25D;
               }
                emitterBlockEntity.send(level,pos,pos.getX() + 0.5D+dx,pos.getY() + 0.5D+dy,pos.getZ() + 0.5D+dz,vX,vY,vZ);


       }
        }

    }

    /**送信先のブロックが何ブロック離れているか*/
    private int sendDistance(Level level,BlockPos emitterPos){
      BlockState emitterState=level.getBlockState(emitterPos);
        int j = 0;
      if(emitterState.getBlock() instanceof EmitterBlock) {
          Direction direction = emitterState.getValue(EmitterBlock.FACING);
          EmitterBlockEntity emitterBlockEntity = (EmitterBlockEntity) level.getBlockEntity(emitterPos);

          int range = Mth.floor(this.particleSpeed * 80 - 0.25D);
          for (int i = 1; i < range; i++) {
              BlockEntity blockEntity = level.getBlockEntity(emitterPos.relative(direction, i));
              BlockState state = level.getBlockState(emitterPos.relative(direction, i));
              VoxelShape shape = state.getCollisionShape(level, emitterPos.relative(direction, i)).optimize();
              double corner = 6D;
              VoxelShape particleShape = Block.box(corner, corner, corner, 16D - corner, 16D - corner, 16D - corner);

              if (blockEntity != null && emitterBlockEntity != null) {
                  if (blockEntity instanceof ReiryokuImportable || blockEntity instanceof MirrorBlockEntity) {
                      if (blockEntity instanceof EmitterBlockEntity) {
                          break;
                      } else {
                          ReiryokuStorable reiryokuStorable = (ReiryokuStorable) blockEntity;
                          if (reiryokuStorable.canAddReiryoku(emitterBlockEntity.getSendAmount())) {
                              if (blockEntity instanceof Mirror || reiryokuStorable.getStoredElementType() == emitterBlockEntity.getStoredElementType()) {
                                  j = i;
                                  if (blockEntity instanceof MirrorBlockEntity) {
                                      Mirror mirror = (Mirror) blockEntity;
                                      mirror.setIncidentDirection(direction.getOpposite());
                                  }
                                  break;
                              }
                          }
                          break;
                      }
                  }

              } else if (Shapes.joinIsNotEmpty(shape, particleShape, BooleanOp.AND)) {
                  break;
              }

          }
      }
          return j;

    }

    /**霊力を輸送*/
    private void send(Level level,BlockPos emitterPos, double dX, double dY, double dZ,double vX,double vY,double vZ){
        BlockState emitterState=level.getBlockState(emitterPos);
        Direction direction=emitterState.getValue(EmitterBlock.FACING);
        int distance=sendDistance(level,emitterPos);
        BlockPos goalPos=emitterPos.relative(direction,distance);
        EmitterBlockEntity emitterBlockEnitity= (EmitterBlockEntity) level.getBlockEntity(emitterPos);
        ReiryokuStorable goalBlockEntity= (ReiryokuStorable) level.getBlockEntity(goalPos);
        int arriveTick= Mth.floor ((distance-1)/particleSpeed)<=0? 1:Mth.floor ((distance-1)/particleSpeed);
        if(emitterBlockEnitity!=null&&goalBlockEntity!=null&&emitterBlockEnitity.canDecreaseReiryoku(emitterBlockEnitity.getSendAmount())&&goalBlockEntity.canAddReiryoku(emitterBlockEnitity.getSendAmount())) {
            int receiveWaitingTime = goalBlockEntity.getReceiveWaitingTime();
            int receiveAmount=goalBlockEntity.getReceiveAmount();
            ElementType receiveElementType=goalBlockEntity.getReceiveElementType();
              if(goalBlockEntity.isIdle()){
                  goalBlockEntity.setReceiveWaitingTime(arriveTick);
                  goalBlockEntity.setReceiveAmount(emitterBlockEnitity.getSendAmount());
                  goalBlockEntity.setReceiveElementType(emitterBlockEnitity.getExportElementType());
                  if(goalBlockEntity instanceof Mirror) {
                      Mirror mirror= (Mirror) goalBlockEntity;
                      mirror.setIncidentDirection(direction.getOpposite());
                  }
                    goalBlockEntity.markUpdated();
                  emitterBlockEnitity.decreaseStoredReiryoku(emitterBlockEnitity.getSendAmount());
                  emitterBlockEnitity.markUpdated();
                  level.addParticle(ElementUtils.getMediumElementParticle(this.getExportElementType()), dX, dY, dZ, vX, vY, vZ);

              }

        }
    }

    /**搬出時の元素*/
    @Override
    public ElementType getExportElementType() {
        return this.getStoredElementType();
    }

    public int getDisplayDistance(EmitterBlockEntity emitterBlockEntity){
        Level level=emitterBlockEntity.getLevel();
        BlockState emitterState=level.getBlockState(emitterBlockEntity.getBlockPos());
        Direction direction=emitterState.getValue(EmitterBlock.FACING);
        BlockPos emitterPos=emitterBlockEntity.getBlockPos();

        int range=Mth.floor(this.particleSpeed*80-0.25D);
        int j=0;
        for(int i=1;i<range;i++){
            BlockEntity blockEntity=level.getBlockEntity(emitterPos.relative(direction,i));
            BlockState state=level.getBlockState(emitterPos.relative(direction,i));
            VoxelShape shape= state.getCollisionShape(level,emitterPos.relative(direction,i)).optimize();
            double corner=6D;
            VoxelShape particleShape= Block.box(corner,corner,corner,16D-corner,16D-corner,16D-corner);
            Material material=state.getMaterial();
            if(Shapes.joinIsNotEmpty(shape,particleShape, BooleanOp.AND)){
                j = i;
                break;
            }

        }
        return j-1;
    }
    public BlockPos getDisplayNextPos(EmitterBlockEntity emitterBlockEntity){
        Level level=emitterBlockEntity.getLevel();
        BlockState emitterState=level.getBlockState(emitterBlockEntity.getBlockPos());
        if(emitterState.getBlock() instanceof EmitterBlock) {
            Direction direction = emitterState.getValue(EmitterBlock.FACING);
            BlockPos emitterPos = emitterBlockEntity.getBlockPos();

            return emitterPos.relative(direction, 1);
        }else{
            return null;
        }
    }
    public boolean hasGoal(EmitterBlockEntity blockEntity){
        BlockPos nextPos=blockEntity.getDisplayNextPos(blockEntity);
        return blockEntity.getLevel().getBlockEntity(nextPos) instanceof ReiryokuImportable||blockEntity.getLevel().getBlockEntity(nextPos) instanceof Mirror;
    }

}
