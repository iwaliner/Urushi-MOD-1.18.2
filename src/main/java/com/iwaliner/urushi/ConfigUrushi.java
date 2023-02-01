package com.iwaliner.urushi;

import net.minecraftforge.common.ForgeConfigSpec;

public final class ConfigUrushi {
    public static final ForgeConfigSpec.Builder builder=new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec spec;
    public static final ForgeConfigSpec.ConfigValue<Integer> maxHightBamboo;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TurnOnSpeedUp;
    public static final ForgeConfigSpec.ConfigValue<Boolean> ShojisAreTranslucent;
    public static final ForgeConfigSpec.ConfigValue<Integer> reiryokuCapacityOfMagatama;
    public static final ForgeConfigSpec.ConfigValue<Integer> fallingLeafParticleAmount;
    public static final ForgeConfigSpec.ConfigValue<Integer> fallingSakuraParticleAmount;
    public static final ForgeConfigSpec.ConfigValue<Boolean> WindBellSound;

    static {
        builder.push("block settings");
        maxHightBamboo=builder.comment("max height of Japanese Timber Bamboo").define("max height(1～2147483647)",10);
        ShojisAreTranslucent=builder.comment("Shoji Pane and Shoji are translucent").define("translucent(true/false)",false);
        WindBellSound=builder.comment("Play the sound of Wind Bell").define("play wind bell sound(true/false)",true);
        builder.pop();
        builder.push("item settings");
        reiryokuCapacityOfMagatama=builder.comment("max Reiryoku amount of Magatama").define("magatama(1～2147483647)",5600);
        builder.pop();
        builder.push("entity settings");
        TurnOnSpeedUp=builder.comment("increase the player walking spped by 16% so that you can place blocks comfortably").define("walking speed(true/false)",true);
        builder.pop();
        builder.push("particle settings");
        fallingLeafParticleAmount=builder.comment("amount of falling leaf particles").define("falling leaf(1～100)",50);
        fallingSakuraParticleAmount=builder.comment("amount of falling sakura particles").define("falling sakura(1～100)",60);
        builder.pop();
        spec=builder.build();
    }
}