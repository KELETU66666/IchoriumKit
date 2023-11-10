package keletu.ichoriumkit.util.handler;

import keletu.ichoriumkit.block.tiles.TileWarpGate;
import keletu.ichoriumkit.client.gui.GuiWarpGate;
import keletu.ichoriumkit.client.gui.GuiWarpGateDestinations;
import keletu.ichoriumkit.container.ContainerWarpGate;
import keletu.ichoriumkit.item.tools.ichorpouch.ContainerPouch;
import keletu.ichoriumkit.item.tools.ichorpouch.GuiPouch;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
        if (ID == 0)
            return new ContainerPouch(player);
        if(ID == 1)
            return new ContainerWarpGate((TileWarpGate) te, player.inventory);
        return null;
    }

    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
        if (ID == 0)
            return new GuiPouch(new ContainerPouch(player));
        if(ID == 1)
            return new GuiWarpGate((TileWarpGate) te, player.inventory);
        if(ID == 2)
            return new GuiWarpGateDestinations((TileWarpGate) te);
        return null;
    }
}

