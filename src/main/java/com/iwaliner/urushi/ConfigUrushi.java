package com.iwaliner.urushi;

import net.minecraftforge.common.ForgeConfigSpec;

public final class ConfigUrushi {
    public static final ForgeConfigSpec.Builder builder=new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec spec;
    public static final ForgeConfigSpec.ConfigValue<Integer> maxHightBamboo;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TurnOnSpeedUp;
    public static final ForgeConfigSpec.ConfigValue<Boolean> ShojisAreTranslucent;
    public static final ForgeConfigSpec.ConfigValue<Integer> reiryokuCapacityOfMagatama;

    static {
        builder.push("block settings");
        maxHightBamboo=builder.comment("max height of Japanese Timber Bamboo").define("integer",10);
        ShojisAreTranslucent=builder.comment("Shoji Pane and Shoji are translucent").define("true/false",false);
        builder.pop();
        builder.push("item settings");
        reiryokuCapacityOfMagatama=builder.comment("max Reiryoku amount of Magatama").define("capacity",5600);
        builder.pop();
        builder.push("entity settings");
        TurnOnSpeedUp=builder.comment("increase the player walking spped by 16% so that you can place blocks comfortably").define("true/false",true);
        builder.pop();
        spec=builder.build();
    }
}