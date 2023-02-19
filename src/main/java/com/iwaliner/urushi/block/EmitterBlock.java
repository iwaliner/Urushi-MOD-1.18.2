package com.iwaliner.urushi.block;

import com.iwaliner.urushi.BlockEntityRegister;
import com.iwaliner.urushi.blockentity.EmitterBlockEntity;
import com.iwaliner.urushi.blockentity.SacredRockBlockEntity;
import com.iwaliner.urushi.util.ElementType;
import com.iwaliner.urushi.util.UrushiUtils;
import com.iwaliner.urushi.util.interfaces.ElementBlock;
import com.iwaliner.urushi.util.interfaces.ReiryokuImportable;
import com.iwaliner.urushi.util.interfaces.ReiryokuStorable;
import com.iwaliner.urushi.util.interfaces.Tiered;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

public class EmitterBlock extends BaseEntityBlock implements Tiered, ElementBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    private static final VoxelShape BOX = Block.box(2D, 0.0D, 2D, 14D, 14D, 14D);
    private ElementType elementType;
    private int tier;

    public EmitterBlock(int tier, ElementType type, Properties p_i48377_1_) {
        super(p_i48377_1_);
        elementType = type;
        this.tier = tier;
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(POWERED,false));
    }

    @Nullable
    @Override
    public int getTier() {
        return tier;
    }

    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        return BOX;
    }

    @org.jetbrains.annotations.Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new EmitterBlockEntity(pos, state);
    }

    public RenderShape getRenderShape(BlockState p_49090_) {
        return RenderShape.MODEL;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_49915_) {
        p_49915_.add(FACING,POWERED);
    }

    @Override
    public BlockState rotate(BlockState state, LevelAccessor level, BlockPos pos, Rotation direction) {
        return state.setValue(FACING, direction.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @org.jetbrains.annotations.Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(POWERED, context.getLevel().hasNeighborSignal(context.getClickedPos()));
    }


    @Override
    public void appendHoverText(ItemStack p_49816_, @org.jetbrains.annotations.Nullable BlockGetter p_49817_, List<Component> list, TooltipFlag p_49819_) {
        UrushiUtils.setInfo(list, "emitter");
    }

    @Override
    public ElementType getElementType() {
        return elementType;
    }

    @javax.annotation.Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_152160_, BlockState p_152161_, BlockEntityType<T> p_152162_) {
        return createTickerHelper(p_152162_, BlockEntityRegister.Emitter.get(), EmitterBlockEntity::tick);
    }
    public void neighborChanged(BlockState p_55666_, Level p_55667_, BlockPos p_55668_, Block p_55669_, BlockPos p_55670_, boolean p_55671_) {
        if (!p_55667_.isClientSide) {
            boolean flag = p_55666_.getValue(POWERED);
            if (flag != p_55667_.hasNeighborSignal(p_55668_)) {
                 p_55667_.setBlock(p_55668_, p_55666_.cycle(POWERED), 2);
             }
        }
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if (level.getBlockEntity(pos) instanceof EmitterBlockEntity) {
            EmitterBlockEntity blockEntity = (EmitterBlockEntity) level.getBlockEntity(pos);
            if(player.getItemInHand(hand).getItem()==Items.BARRIER){
                blockEntity.addStoredReiryoku(100);
            }

            player.displayClientMessage(new TranslatableComponent("info.urushi.emitter.message").append("  " + blockEntity.getStoredReiryoku()).append(level.isClientSide()? " client":" server"), false);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.FAIL;
    }

   /* @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
     //   if(!level.isClientSide()) {
            if (level.getBlockEntity(pos) instanceof ReiryokuStorable && level.getBlockEntity(pos) instanceof ReiryokuImportable) {
                ReiryokuStorable blockEntity = (ReiryokuStorable) level.getBlockEntity(pos);
                if (blockEntity.canAddReiryoku(1)) {
                    blockEntity.addStoredReiryoku(1);
                } else {
                    ItemEntity itemEntity = new ItemEntity(level, pos.getX() + 0.5D, pos.getY() + 1.5D, pos.getZ() + 0.5D, new ItemStack(Items.APPLE));
                    level.addFreshEntity(itemEntity);
                }
       //     }
        }
    }*/
}