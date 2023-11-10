package keletu.ichoriumkit.util;

import keletu.ichoriumkit.util.packet.PacketWarpGateButton;
import keletu.ichoriumkit.util.packet.PacketWarpGateTeleport;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class PacketHandler {

    public static SimpleNetworkWrapper INSTANCE = null;
    private static int packetId = 0;

    public PacketHandler() {
    }

    public static int nextID() {
        return packetId++;
    }

    public static void registerMessages() {
        INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID + "B");
        // Register messages which are sent from the client to the server here:
        INSTANCE.registerMessage(PacketWarpGateTeleport.class, PacketWarpGateTeleport.class, nextID(), Side.SERVER);
        INSTANCE.registerMessage(PacketWarpGateButton.class, PacketWarpGateButton.class, nextID(), Side.SERVER);
    }

}
