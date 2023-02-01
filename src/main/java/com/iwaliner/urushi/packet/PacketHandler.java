package com.iwaliner.urushi.packet;

import com.iwaliner.urushi.ModCoreUrushi;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class PacketHandler {
    private static final String PROTOCOL_VERSION = "1";

    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(ModCoreUrushi.ModID, "main"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals);

    private PacketHandler() {
    }

    public static void init() {
        int index = 0;
        INSTANCE.messageBuilder(ServerKeyPressPacket.class, index++, NetworkDirection.PLAY_TO_SERVER)
                .encoder(ServerKeyPressPacket::encode).decoder(ServerKeyPressPacket::new)
                .consumer(ServerKeyPressPacket::handle).add();
        INSTANCE.messageBuilder(ClientKeyPressPacket.class, index++, NetworkDirection.PLAY_TO_CLIENT)
                .encoder(ClientKeyPressPacket::encode).decoder(ClientKeyPressPacket::new)
                .consumer(ClientKeyPressPacket::handle).add();
    }
}
