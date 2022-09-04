package com.iwaliner.urushi.world.tree;

import net.minecraft.core.Holder;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import java.util.Random;

public class GlowingFancySakuraTreeGrower extends AbstractTreeGrower {
    public GlowingFancySakuraTreeGrower() {
    }
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(Random p_204316_, boolean p_204317_) {
        return TreeGenerator.GLOWING_FANCY_SAKURA;
    }
}