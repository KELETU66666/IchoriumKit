package keletu.ichoriumkit.proxy;

import keletu.ichoriumkit.util.ClientHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

    public static EntityPlayer getPlayer() {
        return Minecraft.getMinecraft().player;
    }

    public void registerItemRenderer( Item item, int meta, String id )
    {
        ModelLoader.setCustomModelResourceLocation( item, meta, new ModelResourceLocation( item.getRegistryName(), id ) );
    }

    public void preInit( FMLPreInitializationEvent event )
    {
        super.preInit( event );
    }


    public void init( FMLInitializationEvent event )
    {
        //MinecraftForge.EVENT_BUS.register(new PlacementMirrorPredictionRenderer());
    }

    @Override
    public EntityPlayer getClientPlayer() {
        return ClientHelper.clientPlayer();
    }
}
