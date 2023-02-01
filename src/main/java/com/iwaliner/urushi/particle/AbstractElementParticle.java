package com.iwaliner.urushi.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public abstract class AbstractElementParticle extends SimpleAnimatedParticle {
    AbstractElementParticle(ClientLevel p_108346_, double p_108347_, double p_108348_, double p_108349_, double p_108350_, double p_108351_, double p_108352_, SpriteSet p_108353_) {
        super(p_108346_, p_108347_, p_108348_, p_108349_, p_108353_, 0F);
        this.friction = 0F;
        this.xd = p_108350_;
        this.yd = p_108351_;
        this.zd = p_108352_;
        this.quadSize *= 0.75F;
        this.lifetime = 80;
        this.setSpriteFromAge(p_108353_);

    }



    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }
}
