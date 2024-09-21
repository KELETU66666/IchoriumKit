package keletu.ichoriumkit.init;

import keletu.ichoriumkit.block.BlockBedrockPortal;
import keletu.ichoriumkit.block.BlockIchorBlock;
import keletu.ichoriumkit.block.BlockNitorGas;
import keletu.ichoriumkit.block.BlockWarpGate;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {
    public static final List<Block> BLOCKS = new ArrayList<>();
    public static final Block ICHOR_BLOCK = new BlockIchorBlock();
    public static final Block BEDROCK_PORTAL = new BlockBedrockPortal("bedrock_portal", Material.PORTAL);
    public static final Block NITOR_VAPOR = new BlockNitorGas();
    public static final Block WARP_GATE = new BlockWarpGate();
}