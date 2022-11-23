package keletu.ichoriumkit.dim;

import keletu.ichoriumkit.ModConfig;
import keletu.ichoriumkit.util.Reference;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class ModDimensions {

    public static DimensionType BedrockDimensionType;

    public static void init() {
        registerDimensionTypes();
        registerDimensions();
    }

    private static void registerDimensionTypes() {
        BedrockDimensionType = DimensionType.register(Reference.MOD_ID + "bedrockworld", "_bedrockworld", ModConfig.BedRockDimensionID, ProviderBedrock.class, false);
    }

    private static void registerDimensions() {
        DimensionManager.registerDimension(ModConfig.BedRockDimensionID, BedrockDimensionType);
    }
}