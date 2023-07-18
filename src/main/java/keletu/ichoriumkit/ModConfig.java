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
        @Config.RangeInt(min = 0, max = 1)
        @Config.RequiresMcRestart
        public static float ShardDropRate = 0.0065F;

        @Config.LangKey("Looting enchantment bonus chance")
        @Config.RangeInt(min = 0, max = 1)
        @Config.RequiresMcRestart
        public static float LootPerBonus = 0.001F;

        @Config.LangKey("Awaken ichorium sword base damage")
        @Config.RangeInt(min = 2)
        @Config.RequiresMcRestart
        public static int AwakenIchorSwordBaseDamage = 10;

        @Config.LangKey("Awaken ichorium sword shield mod damage")
        @Config.RangeInt(min = 2)
        @Config.RequiresMcRestart
        public static int AwakenIchorSwordShieldmodDamage = 6;
}
