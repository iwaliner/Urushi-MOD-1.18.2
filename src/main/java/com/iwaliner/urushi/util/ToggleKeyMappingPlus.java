package com.iwaliner.urushi.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.BooleanSupplier;

@OnlyIn(Dist.CLIENT)
public class ToggleKeyMappingPlus extends KeyMapping {


    public ToggleKeyMappingPlus(String name, int button, String category) {
        super(name, InputConstants.Type.KEYSYM, button, category);
    }

    public void setDown(boolean p_92534_) {
            if (p_92534_ && isConflictContextAndModifierActive()) {
                super.setDown(!this.isDown());
            }

    }
  }
