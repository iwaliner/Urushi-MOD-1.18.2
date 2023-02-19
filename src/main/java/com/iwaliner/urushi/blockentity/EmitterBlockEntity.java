package com.iwaliner.urushi.blockentity;

import com.iwaliner.urushi.BlockEntityRegister;
import com.iwaliner.urushi.ParticleRegister;
import com.iwaliner.urushi.block.EmitterBlock;
import com.iwaliner.urushi.block.SacredRockBlock;
import com.iwaliner.urushi.util.ElementType;
import com.iwaliner.urushi.util.ElementUtils;
import com.iwaliner.urushi.util.interfaces.ReiryokuExportable;
import com.iwaliner.urushi.util.interfaces.ReiryokuImportable;
import com.iwaliner.urushi.util.interfaces.ReiryokuStorable;
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

public class EmitterBlockEntity extends AbstractReiryokuStorableBlockEntity implements ReiryokuImportable,ReiryokuExportable {
   private  final double particleSpeed=0.2D;
    public EmitterBlockEntity(BlockPos p_155550_, BlockState p_155551_) {
        super(BlockEntityRegister.Emitter.get(),1000, p_155550_, p_155551_);
    }


    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag compoundtag = new CompoundTag();
        compoundtag.putInt("storedReiryoku", this.storedReiryoku);
        compoundtag.putIntArray("receiveWaitingTime", this.receiveWaitingTime);
        return compoundtag;
    }



    public static void tick(Level level, BlockPos pos, BlockState state, EmitterBlockEntity blockEntity) {
      //  if(!level.isClientSide()){
        blockEntity.recieveReiryoku(level,pos);
       int i=1;
          BlockPos importPos=pos.relative(state.getValue(SacredRockBlock.FACING).getOpposite());
           BlockState importState=level.getBlockState(importPos);
           BlockEntity importBlockEntity=level.getBlockEntity(importPos);
           if(importBlockEntity instanceof ReiryokuStorable) {
               ReiryokuStorable reiryokuStorable = (ReiryokuStorable) importBlockEntity;
               if (reiryokuStorable.canDecreaseReiryoku(i)&&blockEntity.canAddReiryoku(i)) {
                   reiryokuStorable.decreaseStoredReiryoku(i);
                   blockEntity.addStoredReiryoku(i);
                   reiryokuStorable.markUpdated();
                   blockEntity.markUpdated();
               }
           }
        if(state.getValue(EmitterBlock.POWERED)){
            if(blockEntity.sendDistance(level,pos)!=0&&blockEntity.getStoredReiryoku()>0) {
               double vX = 0D, vY = 0D, vZ = 0D;
               double v0 = blockEntity.particleSpeed;
               Direction direction = state.getValue(EmitterBlock.FACING);
               double dx=0D,dy=0D,dz=0D;
               if (direction == Direction.UP) {
                   vY = v0;
                  dy=0.6D;
               } else if (direction == Direction.DOWN) {
                   vY = -v0;
                   dy=-0.6D;
               } else if (direction == Direction.NORTH) {
                   vZ = -v0;
                   dz=-0.6D;
               } else if (direction == Direction.SOUTH) {
                   vZ = v0;
                   dz=0.6D;
               } else if (direction == Direction.EAST) {
                   vX = v0;
                   dx=0.6D;
               } else if (direction == Direction.WEST) {
                   vX = -v0;
                   dx=-0.6D;
               }
               level.addParticle(ParticleRegister.WoodElement.get(), pos.getX() + 0.5D+dx, pos.getY() + 0.5D+dy, pos.getZ() + 0.5D+dz, vX, vY, vZ);
               blockEntity.send(level,pos);

         //  }
       }}

    }
    private int sendDistance(Level level,BlockPos emitterPos){
      BlockState emitterState=level.getBlockState(emitterPos);
      Direction direction=emitterState.getValue(EmitterBlock.FACING);
      int j=0;
      int range=Mth.floor(this.particleSpeed*80+0.6D);
      for(int i=1;i<range;i++){
          BlockEntity blockEntity=level.getBlockEntity(emitterPos.relative(direction,i));
          BlockState state=level.getBlockState(emitterPos.relative(direction,i));
          VoxelShape shape= state.getCollisionShape(level,emitterPos.relative(direction,i)).optimize();
          double corner=6D;
          VoxelShape particleShape= Block.box(corner,corner,corner,16D-corner,16D-corner,16D-corner);

          if(blockEntity!=null){
              if(blockEntity instanceof ReiryokuImportable){
                  if(blockEntity instanceof EmitterBlockEntity){

                  }else {
                      ReiryokuStorable reiryokuStorable = (ReiryokuStorable) blockEntity;
                      if (reiryokuStorable.canAddReiryoku(1)) {
                          j = i;
                          break;
                      }
                  }
              }
       //   }else if (!state.isAir()&&state.isSolidRender(level, emitterPos.relative(direction,i))) {
       //       break;
          } else if(Shapes.joinIsNotEmpty(shape,particleShape, BooleanOp.AND)){
              break;
          }

      }
      return j;
    }
    private void send(Level level,BlockPos emitterPos){
        BlockState emitterState=level.getBlockState(emitterPos);
        Direction direction=emitterState.getValue(EmitterBlock.FACING);
        int distance=sendDistance(level,emitterPos);
        BlockPos goalPos=emitterPos.relative(direction,distance);
        EmitterBlockEntity emitterBlockEnitity= (EmitterBlockEntity) level.getBlockEntity(emitterPos);
        ReiryokuStorable goalBlockEntity= (ReiryokuStorable) level.getBlockEntity(goalPos);
        int arriveTick=Mth.floor ((distance-1)/particleSpeed);
        if(emitterBlockEnitity!=null&&goalBlockEntity!=null&&emitterBlockEnitity.canDecreaseReiryoku(1)&&goalBlockEntity.canAddReiryoku(1)) {
             emitterBlockEnitity.decreaseStoredReiryoku(1);
             emitterBlockEnitity.markUpdated();
            int[] receiveWaitingTime = goalBlockEntity.getReceiveWaitingTime();
            boolean flag=false;
            for(int i=0;i<receiveWaitingTime.length;i++){
                if(receiveWaitingTime[i]==0){
                    receiveWaitingTime[i]=arriveTick;
                    emitterBlockEnitity.markUpdated();
                    goalBlockEntity.markUpdated();
                    flag=true;
                    break;
                }
            }
            if(!flag){
                ItemEntity itemEntity=new ItemEntity(level,goalPos.getX()+0.5D,goalPos.getY()+1.5D,goalPos.getZ(),ElementUtils.getOverflowStack(this.getStoredElementType()));
                level.addFreshEntity(itemEntity);
            }
        }
    }

    @Override
    public ElementType getExportElementType() {
        return this.getStoredElementType();
    }

    @Override
    public ElementType getImportElementType() {
        return this.getStoredElementType();
    }
}
