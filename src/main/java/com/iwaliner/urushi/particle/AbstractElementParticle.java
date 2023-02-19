package com.iwaliner.urushi.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

public abstract class AbstractElementParticle extends TextureSheetParticle {
    private boolean isOn,stoppedByCollision;
    AbstractElementParticle(ClientLevel level, double x, double y, double z, double xd, double yd, double zd, SpriteSet p_108353_) {
        super(level, x, y, z, xd, yd,zd);
        this.friction = 1F;
        this.xd = xd;
        this.yd = yd;
        this.zd = zd;
        this.quadSize *= 0.75F;
        this.lifetime = 80;
        this.setSpriteFromAge(p_108353_);
        if(this.isOn){
            this.remove();
        }

    }
    public void move(double vx, double vy, double vz) {
      //  this.setBoundingBox(this.getBoundingBox().move(vx, vy, p_107248_));
      //  this.setLocationFromBoundingbox();

        if (!this.stoppedByCollision) {
            double d0 = vx;
            double d1 = vy;
            double d2 = vz;
            if (this.hasPhysics && (vx != 0.0D || vy != 0.0D || vz != 0.0D) && vx * vx + vy * vy + vz * vz < Mth.square(100.0D)) {
                Vec3 vec3 = Entity.collideBoundingBox((Entity)null, new Vec3(vx, vy, vz), this.getBoundingBox(), this.level, List.of());
                vx = vec3.x;
                vy = vec3.y;
                vz = vec3.z;
            }

            if (vx != 0.0D || vy != 0.0D || vz != 0.0D) {
                this.setBoundingBox(this.getBoundingBox().move(vx, vy, vz));
                this.setLocationFromBoundingbox();
            }

            if (Math.abs(d1) >= (double)1.0E-5F && Math.abs(vy) < (double)1.0E-5F) {
                this.stoppedByCollision = true;
            }

            this.onGround = d1 != vy && d1 < 0.0D;
            this.isOn = (d1 != vy && d1 < 0.0D)||(d0 != vx && d0 < 0.0D)||(d2 != vz && d2 < 0.0D);
            if (d0 != vx) {
                this.xd = 0.0D;
            }

            if (d2 != vz) {
                this.zd = 0.0D;
            }

        }
    }



    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }
}
