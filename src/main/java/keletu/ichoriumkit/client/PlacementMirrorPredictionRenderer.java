package keletu.ichoriumkit.client;
/*

import keletu.ichoriumkit.init.ModItems;
import keletu.ichoriumkit.item.tools.ItemPlacementMirror;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;
import thaumcraft.client.lib.RenderCubes;

import java.util.List;

public final class PlacementMirrorPredictionRenderer {

    RenderCubes blockRender = new RenderCubes();

    @SubscribeEvent
    public void onWorldRenderLast(RenderWorldLastEvent event) {

        World world = Minecraft.getMinecraft().world;
        List<EntityPlayer> playerEntities = world.playerEntities;
        for (EntityPlayer player : playerEntities) {
            ItemStack currentStack = player.getHeldItemMainhand();
            if (currentStack != ItemStack.EMPTY
                    && currentStack.getItem()
                            == ModItems.placement_mirror
                    && ItemPlacementMirror.getBlock(currentStack) != Blocks.AIR) {
                renderPlayerLook(player, currentStack);
            }
        }
    }

    private void renderPlayerLook(EntityPlayer player, ItemStack stack) {
        BlockPos[] coords = ItemPlacementMirror.getBlocksToPlace(stack, player);
        if (ItemPlacementMirror.hasBlocks(stack, player, coords)) {
            ItemStack block = new ItemStack(
                    ItemPlacementMirror.getBlock(stack),
                    1,
                    ItemPlacementMirror.getBlockMeta(stack));
            BlockPos lastCoords = new BlockPos(0, 0, 0);

            GL11.glPushMatrix();
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

            for (BlockPos coord : coords) {
                renderBlockAt(block, coord, lastCoords);
                lastCoords = coord;
            }
            GL11.glPopMatrix();
        }
    }

    private static void renderBlockAt(ItemStack block, BlockPos pos, BlockPos last) {
        if (block.getItem() == null) return;
        GL11.glPushMatrix();
        GL11.glTranslated(
                pos.getX() + 0.5 - RenderManager.renderPosX,
                pos.getY() + 0.5 - RenderManager.renderPosY,
                pos.getZ() + 0.5 - RenderManager.renderPosZ);

        GL11.glColor4f(1F, 1F, 1F, 0.6F);
        Minecraft.getMinecraft().renderEngine.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
        blockRender.useInventoryTint = false;
        blockRender.renderBlockAsItem(Block.getBlockFromItem(block.getItem()), block.getItemDamage(), 1F);

        GL11.glPopMatrix();
    }
}/**/