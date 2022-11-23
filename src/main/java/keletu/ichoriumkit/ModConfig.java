package keletu.ichoriumkit;

import keletu.ichoriumkit.util.Reference;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;

@Config(modid = Reference.MOD_ID, category = "IchoriumKit")
public class ModConfig {

        @Config.LangKey("ichoriumkit.configkp.bedrockworddim")
        @Config.Comment("ichoriumkit.configkp.bedrockworddim.comment")
        @Config.RequiresMcRestart
        public static int BedRockDimensionID = 19;

        @Config.LangKey("ichoriumkit.configkp.dimensionalsharddroprate")
        @Config.Comment("ichoriumkit.configkp.dimensionalsharddroprate.comment")
        @Config.RangeInt(min = 0, max = 1)
        @Config.RequiresMcRestart
        public static float SHARDDROPRATE = 0.0065F;
}
