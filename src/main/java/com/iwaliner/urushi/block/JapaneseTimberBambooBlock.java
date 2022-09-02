package com.iwaliner.urushi.block;

import com.mojang.math.Vector3d;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;

import java.util.Random;

public class JapaneseTimberBambooBlock extends Block implements net.minecraftforge.common.IPlantable{
    public static final IntegerProperty AGE = BlockStateProperties.AGE_15;
    protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);




    public JapaneseTimberBambooBlock(Properties p_49795_) {
        super(p_49795_);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, Integer.valueOf(0)));
    };


    @Override
    public void tick(BlockState p_225534_1_, ServerLevel p_225534_2_, BlockPos p_225534_3_, Random p_60465_) {
        if (!p_225534_1_.canSurvive(p_225534_2_, p_225534_3_)) {
            p_225534_2_.destroyBlock(p_225534_3_, true);
        }
    }

    @Override
    public void randomTick(BlockState p_225542_1_, ServerLevel p_225542_2_, BlockPos p_225542_3_, Random p_60554_) {
        if (p_225542_2_.isEmptyBlock(p_225542_3_.above())) {
            int i;
            for(i = 1; p_225542_2_.getBlockState(p_225542_3_.below(i)).is(this); ++i) {
            }

            if (i < 10) {
                int j = p_225542_1_.getValue(AGE);
                if (j >0) {
                    p_225542_2_.setBlockAndUpdate(p_225542_3_.above(), this.defaultBlockState());
                    p_225542_2_.setBlock(p_225542_3_, p_225542_1_.setValue(AGE, Integer.valueOf(0)), 4);
                } else {
                    p_225542_2_.setBlock(p_225542_3_, p_225542_1_.setValue(AGE, Integer.valueOf(j + 1)), 4);

                }
            }
        }
    }

    @Override
    public BlockState updateShape(BlockState p_196271_1_, Direction p_196271_2_, BlockState p_196271_3_, LevelAccessor p_196271_4_, BlockPos p_196271_5_, BlockPos p_196271_6_) {
        if (!p_196271_1_.canSurvive(p_196271_4_, p_196271_5_)) {
            p_196271_4_.scheduleTick(p_196271_5_, this, 1);
        }

        return super.updateShape(p_196271_1_, p_196271_2_, p_196271_3_, p_196271_4_, p_196271_5_, p_196271_6_);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader iWorldReader, BlockPos pos) {
        BlockState soil = iWorldReader.getBlockState(pos.below());
        if (soil.canSustainPlant(iWorldReader, pos.below(), Direction.UP, this)) return true;
        BlockState blockstate = iWorldReader.getBlockState(pos.below());

        if (blockstate.getBlock() == this) {
            return true;
        } else {

            if (blockstate.is(Blocks.GRASS_BLOCK) || blockstate.is(Blocks.DIRT) || blockstate.is(Blocks.COARSE_DIRT) || blockstate.is(Blocks.PODZOL) || blockstate.is(Blocks.SAND) || blockstate.is(Blocks.RED_SAND)) {
                BlockPos blockpos = pos.below();

                return true;
            }

            return false;
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_49915_) {
        p_49915_.add(AGE);
    }

    @Override
    public PlantType getPlantType(BlockGetter level, BlockPos pos) {
        return PlantType.PLAINS;
    }

    @Override
    public BlockState getPlant(BlockGetter level, BlockPos pos) {
        return defaultBlockState();
    }

   @Override
   public VoxelShape getCollisionShape(BlockState p_220071_1_, BlockGetter p_220071_2_, BlockPos p_220071_3_, CollisionContext p_60575_) {
       Vec3 vector3d = p_220071_1_.getOffset(p_220071_2_, p_220071_3_);
       return SHAPE.move(vector3d.x, vector3d.y, vector3d.z);
   }

    public BlockBehaviour.OffsetType getOffsetType() {
        return BlockBehaviour.OffsetType.XZ;
    }


    @Override
    public VoxelShape getShape(BlockState p_220053_1_, BlockGetter p_220071_2_, BlockPos p_220071_3_, CollisionContext p_60575_) {
        Vec3 vector3d = p_220053_1_.getOffset(p_220071_2_, p_220071_3_);
        return SHAPE.move(vector3d.x, vector3d.y, vector3d.z);
    }
}
