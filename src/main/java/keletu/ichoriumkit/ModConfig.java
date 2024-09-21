package keletu.ichoriumkit;

import keletu.ichoriumkit.util.Reference;
import net.minecraftforge.common.config.Config;

@Config(modid = Reference.MOD_ID, category = "IchoriumKit")
public class ModConfig {

        @Config.LangKey("Bedrock dimension ID")
        @Config.Comment("Choose bedrock dimension ID")
        @Config.RequiresMcRestart
        public static int BedRockDimensionID = 19;

        @Config.LangKey("Dimensional shard drop rate")
        @Config.Comment("Change dimensional shard drop rate, The higher the value the higher the drop rate")
        @Config.RangeInt(min = -1, max = 64)
        @Config.RequiresMcRestart
        public static double EndShardDropRate = 32;

        @Config.LangKey("Dimensional shard drop rate")
        @Config.Comment("Change dimensional shard drop rate, The higher the value the higher the drop rate")
        @Config.RangeInt(min = -1, max = 64)
        @Config.RequiresMcRestart
        public static double NetherShardDropRate = 16;

        @Config.LangKey("Awaken ichorium sword base damage")
        @Config.RangeInt(min = 2)
        @Config.RequiresMcRestart
        public static int AwakenIchorSwordBaseDamage = 10;

        @Config.LangKey("Awaken ichorium sword shield mod damage")
        @Config.RangeInt(min = 2)
        @Config.RequiresMcRestart
        public static int AwakenIchorSwordShieldmodDamage = 6;

        @Config.Comment("Can Energetic Nitor and Kami Leggings glow")
        @Config.Name("Enable Nitor Vapor")
        public static boolean EnableNitorVapor = true;
}
