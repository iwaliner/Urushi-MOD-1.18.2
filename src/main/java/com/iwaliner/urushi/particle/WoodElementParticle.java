package com.iwaliner.urushi.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.PlayerCloudParticle;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WoodElementParticle extends AbstractElementParticle{
    WoodElementParticle(ClientLevel p_108346_, double p_108347_, double p_108348_, double p_108349_, double p_108350_, double p_108351_, double p_108352_, SpriteSet p_108353_) {
        super(p_108346_, p_108347_, p_108348_, p_108349_, p_108350_, p_108351_, p_108352_, p_108353_);
    }
    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;
        public Provider(SpriteSet p_108366_) {
            this.sprites = p_108366_;
        }

        public Particle createParticle(SimpleParticleType particleType, ClientLevel level, double x, double y, double z, double xd, double yd, double zd) {
            Particle particle = new WoodElementParticle(level, x, y, z, xd, yd, zd, this.sprites);
          //  particle.setParticleSpeed(xd,yd,zd);
            return particle;
        }
    }
}
