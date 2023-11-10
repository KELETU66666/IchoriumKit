package keletu.ichoriumkit.init;

import keletu.ichoriumkit.block.BlockBedrockPortal;
import keletu.ichoriumkit.block.BlockWarpGate;
import keletu.ichoriumkit.block.IchorBlock;
import keletu.ichoriumkit.block.NitorVapor;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {
    public static final List<Block> BLOCKS = new ArrayList<>();
    public static final Block ICHOR_BLOCK = new IchorBlock();
    public static final Block BEDROCK_PORTAL = new BlockBedrockPortal("bedrock_portal", Material.PORTAL);
    public static final Block NITOR_VAPOR = new NitorVapor();

    public static final Block WARP_GATE = new BlockWarpGate();
}