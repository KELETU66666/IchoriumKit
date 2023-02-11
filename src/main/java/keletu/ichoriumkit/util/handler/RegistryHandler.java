package keletu.ichoriumkit.util.handler;

import keletu.ichoriumkit.IchoriumKit;
import keletu.ichoriumkit.block.tiles.TileBedrockPortal;
import keletu.ichoriumkit.init.ModBlocks;
import keletu.ichoriumkit.init.ModItems;
import keletu.ichoriumkit.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectEventProxy;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.aspects.AspectRegistryEvent;

@Mod.EventBusSubscriber

public class RegistryHandler {
    public static void preInitRegistries() {
        NetworkRegistry.INSTANCE.registerGuiHandler(IchoriumKit.INSTANCE, new GuiHandler());
    }
    @SubscribeEvent
    public static void onItemRegister( RegistryEvent.Register<Item> event ) {
        event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
    }
    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
        TileBedrockPortal.register("bedrock_portal", TileBedrockPortal.class);
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void onModelRegister( ModelRegistryEvent event )
    {
        for ( Item item : ModItems.ITEMS ) {
            if (item instanceof IHasModel) {
                ((IHasModel) item).registerModels();
            }
        }
        for (Block block: ModBlocks.BLOCKS)
        {
            if (block instanceof IHasModel)
            {
                ((IHasModel)block).registerModels();
            }
        }

    }

    @SubscribeEvent
    public static void registerAspects(AspectRegistryEvent event) {
        AspectEventProxy proxy = event.register;
        proxy.registerComplexObjectTag(new ItemStack(ModItems.ResourceKami, 1, 1), new AspectList().add(Aspect.FIRE, 2).add(Aspect.UNDEAD, 2).add(Aspect.DEATH, 2));
        proxy.registerComplexObjectTag(new ItemStack(ModItems.ResourceKami, 1, 0), new AspectList().add(Aspect.ELDRITCH, 2).add(Aspect.DESIRE, 2).add(Aspect.DARKNESS, 2));
    }

    @SubscribeEvent
    public static void OreRegister(RegistryEvent.Register<Enchantment> event)
    {
        OreDictionary.registerOre("ingotIchorium", new ItemStack(ModItems.ResourceKami, 1, 3));
        OreDictionary.registerOre("itemIchorFabric", new ItemStack(ModItems.ResourceKami,1,4));
        OreDictionary.registerOre("nuggetIchorium", new ItemStack(ModItems.ResourceKami, 1, 5));
    }
}
