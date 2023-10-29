package keletu.ichoriumkit.proxy;

import keletu.ichoriumkit.dim.ModDimensions;
import keletu.ichoriumkit.dim.OreClusterGenerator;
import keletu.ichoriumkit.util.handler.EventHandler;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
    public void registerItemRenderer( Item item, int meta, String id )
    {
    }


    public void preInit( FMLPreInitializationEvent event )
    {
        EventHandler.registerEvents();
        GameRegistry.registerWorldGenerator(new OreClusterGenerator(), 3);
        ModDimensions.init();
    }

    public void registerDisplayInformationInit() {}

    public void init( FMLInitializationEvent event )
    {
    }
}
