package com.iwaliner.urushi.world.tree;

import com.iwaliner.urushi.world.feature.FeatureGenerator;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.grower.AbstractMegaTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import java.util.Random;

public class CedarTreeGrower extends AbstractMegaTreeGrower {
    public CedarTreeGrower() {
    }
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(Random p_204316_, boolean p_204317_) {
        return FeatureGenerator.CEDAR;
    }
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredMegaFeature(Random p_204332_) {
        return FeatureGenerator.MEGA_CEDAR;
    }
}
