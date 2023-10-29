package keletu.ichoriumkit.loot;

import keletu.ichoriumkit.ModConfig;
import keletu.ichoriumkit.init.ModItems;
import keletu.ichoriumkit.util.Reference;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.DimensionType;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class LootTableHandler {

    @SubscribeEvent
    public static void onEntityLivingDrops(LivingDropsEvent event) {
        if (event.getSource().getTrueSource() != null && event.getSource().getTrueSource() instanceof EntityPlayer) {
            if (event.getEntityLiving() instanceof EntityEnderman && event.getEntityLiving().dimension == DimensionType.THE_END.getId() && Math.random() <= 1D / ModConfig.EndShardDropRate)
                event.getDrops().add(new EntityItem(event.getEntityLiving().world, event.getEntityLiving().posX, event.getEntityLiving().posY, event.getEntityLiving().posZ, new ItemStack(ModItems.ResourceKami, 1, 0)));

            if (event.getEntityLiving() instanceof EntityPigZombie && event.getEntityLiving().dimension == DimensionType.NETHER.getId() && Math.random() <= 1D / ModConfig.NetherShardDropRate)
                event.getDrops().add(new EntityItem(event.getEntityLiving().world, event.getEntityLiving().posX, event.getEntityLiving().posY, event.getEntityLiving().posZ, new ItemStack(ModItems.ResourceKami, 1, 1)));
        }
    }
}