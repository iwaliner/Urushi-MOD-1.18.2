package com.iwaliner.urushi.world.tree;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.world.level.block.grower.AbstractMegaTreeGrower;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import java.util.Random;

public class CypressTreeGrower extends AbstractMegaTreeGrower {
    public CypressTreeGrower() {
    }
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(Random p_204316_, boolean p_204317_) {
        return TreeGenerator.CYPRESS;
    }
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredMegaFeature(Random p_204332_) {
        return TreeGenerator.MEGA_CYPRESS;
    }
}
