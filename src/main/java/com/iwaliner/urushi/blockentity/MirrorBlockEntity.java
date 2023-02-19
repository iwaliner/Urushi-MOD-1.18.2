package com.iwaliner.urushi.blockentity;

import com.iwaliner.urushi.BlockEntityRegister;
import com.iwaliner.urushi.util.ElementType;
import com.iwaliner.urushi.util.interfaces.ReiryokuExportable;
import com.iwaliner.urushi.util.interfaces.ReiryokuImportable;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class MirrorBlockEntity extends AbstractReiryokuStorableBlockEntity implements ReiryokuImportable,ReiryokuExportable {
    public MirrorBlockEntity(BlockPos p_155550_, BlockState p_155551_) {
        super(BlockEntityRegister.Mirror.get(),1000, p_155550_, p_155551_);
    }


    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag compoundtag = new CompoundTag();
        compoundtag.putInt("storedReiryoku", this.storedReiryoku);
        compoundtag.putIntArray("receiveWaitingTime", this.receiveWaitingTime);
        return compoundtag;
    }



    public static void tick(Level level, BlockPos pos, BlockState state, MirrorBlockEntity blockEntity) {
       blockEntity.recieveReiryoku(level,pos);
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
