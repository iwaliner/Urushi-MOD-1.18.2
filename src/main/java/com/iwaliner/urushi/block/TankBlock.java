package com.iwaliner.urushi.block;

import com.iwaliner.urushi.BlockEntityRegister;
import com.iwaliner.urushi.blockentity.TankBlockEntity;
import com.iwaliner.urushi.util.ElementType;
import com.iwaliner.urushi.util.UrushiUtils;
import com.iwaliner.urushi.util.interfaces.ElementBlock;
import com.iwaliner.urushi.util.interfaces.Tiered;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TankBlock extends BaseEntityBlock implements Tiered, ElementBlock {
    private static final VoxelShape BASE = Block.box(6D, 0.0D, 6D, 10D, 1D, 10D);
    private static final VoxelShape PILLAR = Block.box(7D, 1.0D, 7D, 9D, 16D, 9D);
    private static final VoxelShape OUTER_BOX = Block.box(1D, 0.0D, 1D, 15D, 16D, 15D);

    private ElementType elementType;
    private int tier;
    public TankBlock(int tier, ElementType type, Properties p_49224_) {
        super(p_49224_);
        elementType = type;
        this.tier = tier;
    }
    @Nullable
    @Override
    public int getTier() {
        return tier;
    }

    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        return OUTER_BOX;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState p_60572_, BlockGetter p_60573_, BlockPos p_60574_, CollisionContext p_60575_) {
        return Shapes.or(BASE,PILLAR);
    }

    @org.jetbrains.annotations.Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new TankBlockEntity(pos, state);
    }

    public RenderShape getRenderShape(BlockState p_49090_) {
        return RenderShape.MODEL;
    }
    @Override
    public void appendHoverText(ItemStack p_49816_, @org.jetbrains.annotations.Nullable BlockGetter p_49817_, List<Component> list, TooltipFlag p_49819_) {
        UrushiUtils.setInfo(list, "tank");
    }

    @Override
    public ElementType getElementType() {
        return elementType;
    }

    @javax.annotation.Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_152160_, BlockState p_152161_, BlockEntityType<T> p_152162_) {
        return createTickerHelper(p_152162_, BlockEntityRegister.Tank.get(), TankBlockEntity::tick);
    }
    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if (level.getBlockEntity(pos) instanceof TankBlockEntity) {
            TankBlockEntity blockEntity = (TankBlockEntity) level.getBlockEntity(pos);

            player.displayClientMessage(new TranslatableComponent("info.urushi.tank.message").append("  " + blockEntity.getStoredReiryoku()).append(level.isClientSide()? " client":" server"), false);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.FAIL;
    }
}
