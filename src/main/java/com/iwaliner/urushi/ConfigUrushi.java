package com.iwaliner.urushi;

import net.minecraftforge.common.ForgeConfigSpec;

public final class ConfigUrushi {
    public static final ForgeConfigSpec.Builder builder=new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec spec;
    public static final ForgeConfigSpec.ConfigValue<Integer> maxHightBamboo;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TurnOnSpeedUp;


    static {
        builder.push("block settings");
        maxHightBamboo=builder.comment("max height of Japanese Timber Bamboo").define("integer",10);
        builder.pop();
        builder.push("entity settings");
        TurnOnSpeedUp=builder.comment("increase the player walking spped by 16% so that you can place blocks comfortably").define("true/false",true);
        builder.pop();
        spec=builder.build();
    }
}