package com.iwaliner.urushi.blockentity;


import com.iwaliner.urushi.util.ElementType;
import com.iwaliner.urushi.util.ElementUtils;
import com.iwaliner.urushi.util.interfaces.ElementBlock;
import com.iwaliner.urushi.util.interfaces.ReiryokuStorable;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public abstract class AbstractReiryokuStorableBlockEntity extends BlockEntity implements ReiryokuStorable{
        protected int storedReiryoku;
        private final int capacity;
        protected int[] receiveWaitingTime;
        public AbstractReiryokuStorableBlockEntity(BlockEntityType<?> blockEntity,int capacity, BlockPos p_155550_, BlockState p_155551_) {
            super(blockEntity, p_155550_, p_155551_);
            this.capacity=capacity;
        }
    public void load(CompoundTag tag) {
        super.load(tag);
        this.storedReiryoku = tag.getInt("storedReiryoku");
        this.receiveWaitingTime = tag.getIntArray("receiveWaitingTime");
    }

    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putInt("storedReiryoku", this.storedReiryoku);
        tag.putIntArray("receiveWaitingTime", this.receiveWaitingTime);
    }





        @Override
        public int getReiryokuCapacity() {
            return capacity;
        }

        @Override
        public int getStoredReiryoku() {
            return storedReiryoku;
        }

        @Override
        public void addStoredReiryoku(int i) {
            if(getStoredReiryoku()+i<=getReiryokuCapacity()){
                storedReiryoku+=i;
            }else{
                int j=getReiryokuCapacity()-getStoredReiryoku();
                storedReiryoku=getReiryokuCapacity();
            }
        }
        @Override
        public boolean canAddReiryoku(int i){
            if(getStoredReiryoku()+i<=getReiryokuCapacity()){
                return true;
            }else{
                return false;
            }
        }

        @Override
        public void decreaseStoredReiryoku(int i) {
            if(getStoredReiryoku()-i>=0){
                storedReiryoku-=i;
            }else{
                int j=i-getStoredReiryoku();
                storedReiryoku=0;
            }
        }
        @Override
        public boolean canDecreaseReiryoku(int i) {
            if(getStoredReiryoku()-i>=0){
                return true;
            }else{
                return false;
            }
        }


        @Override
        public ElementType getStoredElementType() {
            if (this.getBlockState().getBlock() instanceof ElementBlock) {
                ElementBlock block = (ElementBlock) this.getBlockState().getBlock();
                return block.getElementType();
            }
            return null;
        }

    @Override
    public int[] getReceiveWaitingTime() {
            if(this.receiveWaitingTime==null){
                this.receiveWaitingTime=new int[1000];
            }
        return this.receiveWaitingTime;
    }

    @Override
        public void recieveReiryoku(Level level, BlockPos pos) {


        if (level.getBlockEntity(pos) instanceof ReiryokuStorable) {

            ReiryokuStorable blockEntity = (ReiryokuStorable) level.getBlockEntity(pos);
            if(blockEntity!=null){

                int[] receiveWaitingTime = blockEntity.getReceiveWaitingTime();
                for (int i = 0; i < receiveWaitingTime.length; i++) {
                if (receiveWaitingTime[i] == 1) {
                    if (blockEntity.canAddReiryoku(1)) {
                        blockEntity.addStoredReiryoku(1);
                        blockEntity.markUpdated();
                    }else{
                        ItemEntity itemEntity=new ItemEntity(level,pos.getX()+0.5D,pos.getY()+1.5D,pos.getZ(), ElementUtils.getOverflowStack(this.getStoredElementType()));
                        level.addFreshEntity(itemEntity);
                    }
                }
                if (receiveWaitingTime[i] > 0) {
                    receiveWaitingTime[i]--;
                } else {
                    receiveWaitingTime[i] = 0;
                }
            }
            }
        }
    }
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
    public CompoundTag getUpdateTag() {
        return this.saveWithoutMetadata();
    }
    public void markUpdated() {
        this.setChanged();
        this.level.sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
    }

}
