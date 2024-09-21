/**
 * This class was created by <Vazkii>. It's distributed as part of the ThaumicTinkerer Mod.
 * <p>
 * ThaumicTinkerer is Open Source and distributed under a Creative Commons Attribution-NonCommercial-ShareAlike 3.0
 * License (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * <p>
 * ThaumicTinkerer is a Derivative Work on Thaumcraft 4. Thaumcraft 4 (c) Azanor 2012
 * (http://www.minecraftforum.net/topic/1585216-)
 * <p>
 * File Created @ [11 Sep 2013, 17:47:28 (GMT)]
 */
package keletu.ichoriumkit.block;

import keletu.ichoriumkit.ModConfig;
import keletu.ichoriumkit.init.ModBlocks;
import keletu.ichoriumkit.init.ModItems;
import net.minecraft.block.BlockAir;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import thaumcraft.client.fx.FXDispatcher;

import java.util.List;
import java.util.Random;

public class BlockNitorGas extends BlockAir {

    public BlockNitorGas() {
        this.setTickRandomly(true);
        this.setRegistryName("nitor_vapor");

        ModBlocks.BLOCKS.add(this);
    }

    @Override
    public int tickRate(World par1World) {
        return par1World.provider.getDimension() == -1 ? 60 : 20;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState state, World par1World, BlockPos pos, Random par5Random) {
        if (par5Random.nextFloat() < 0.03F)
            FXDispatcher.INSTANCE.sparkle(pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F, 1F, 4, par5Random.nextFloat() / 2);
    }

    @Override
    public void updateTick(World par1World, BlockPos pos, IBlockState state, Random par5Random) {
        if (!par1World.isRemote) {
            boolean remove = false;
            int dist = state.getBlock().getMetaFromState(par1World.getBlockState(pos)) == 1 ? 6 : 1;
            List<EntityPlayer> players = par1World.getEntitiesWithinAABB(
                    EntityPlayer.class,
                    new AxisAlignedBB(
                            pos.getX() - dist,
                            pos.getY() - dist,
                            pos.getZ() - dist,
                            pos.getX() + dist,
                            pos.getY() + dist,
                            pos.getZ() + dist));
            if (players.isEmpty()) {
                par1World.setBlockToAir(pos);
                remove = true;
            } else {
                boolean has = false;
                for (EntityPlayer player : players)
                    if ((ModConfig.EnableNitorVapor && player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() != ModItems.IchorLegsAdv && player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getMetadata() != 1)) {
                        has = true;
                        break;
                    }

                if (!has) {
                    par1World.setBlockToAir(pos);
                    remove = true;
                }
            }
            if (!remove) par1World.scheduleBlockUpdate(pos, this, tickRate(par1World), 3);
        }
    }

    @Override
    public int getLightValue(IBlockState state) {
        return 15;
    }

    @Override
    public int getLightValue(IBlockState state, IBlockAccess world, BlockPos pos) {
        return state.getBlock().getMetaFromState(world.getBlockState(pos)) == 1 ? 15 : 12;
    }

    @Override
    public void onBlockAdded(World par1World, BlockPos pos, IBlockState state) {
        if (!par1World.isRemote)
            par1World.scheduleBlockUpdate(pos, this, tickRate(par1World), 3);
    }
}