package com.iwaliner.urushi;

import net.minecraft.world.food.FoodProperties;

public class FoodUrushi {
    public static final FoodProperties Rice = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.6F).build();
    public static final FoodProperties TKG = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.8F).build();
    public static final FoodProperties Sekihan = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.8F).build();
    public static final FoodProperties Gyudon = (new FoodProperties.Builder()).nutrition(10).saturationMod(1.2F).build();
    public static final FoodProperties Butadon = (new FoodProperties.Builder()).nutrition(10).saturationMod(1.2F).build();

}
