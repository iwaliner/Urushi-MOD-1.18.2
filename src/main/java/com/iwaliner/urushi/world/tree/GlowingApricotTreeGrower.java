package com.iwaliner.urushi.world.tree;

import com.iwaliner.urushi.world.feature.FeatureGenerator;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import java.util.Random;

public class GlowingApricotTreeGrower extends AbstractTreeGrower {
    public GlowingApricotTreeGrower() {
    }
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(Random p_204316_, boolean p_204317_) {
        return FeatureGenerator.GLOWING_APRICOT;
    }
}
