package keletu.ichoriumkit.block;

import keletu.ichoriumkit.init.ModBlocks;
import keletu.ichoriumkit.item.armor.KamiArmor;
import net.minecraft.block.BlockAir;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class NitorVapor extends BlockAir {

    public NitorVapor() {
        this.setTickRandomly(true);
        this.setRegistryName("nitor_vapor");

        ModBlocks.BLOCKS.add(this);
    }

    @Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        return true;
    }

    @Override
    public EnumPushReaction getMobilityFlag(IBlockState state)
    {
        return EnumPushReaction.DESTROY;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(Blocks.AIR);
    }

    @Override
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
    {
        return false;
    }

    @Override
    public int getLightValue(IBlockState state, IBlockAccess world, BlockPos pos)
    {
        return 15;
    }

    @Override
    public int getLightOpacity(IBlockState state)
    {
        return 0;
    }

    @Override
    public void breakBlock(World worldIn, BlockPos vec, IBlockState state) {
    }

    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random random) {


        if (!world.isRemote) {
            List<EntityPlayer> players = world.getEntitiesWithinAABB(EntityPlayer.class, new AxisAlignedBB(pos.getX() - 1, pos.getY() - 1, pos.getZ() - 1, pos.getX() + 1, pos.getY() + 1, pos.getZ() + 1));

            if (players.isEmpty()) world.setBlockToAir(pos);
            else if (players.stream().noneMatch(p -> p.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() instanceof KamiArmor))
                world.setBlockToAir(pos);

        }
    }
}