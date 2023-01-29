package keletu.ichoriumkit.util.handler;

import keletu.ichoriumkit.item.tools.ichorpouch.ContainerPouch;
import keletu.ichoriumkit.item.tools.ichorpouch.GuiPouch;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == 0)
            return new ContainerPouch(player);
        return null;
    }

    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == 0)
            return new GuiPouch(new ContainerPouch(player));
        return null;
    }
}

