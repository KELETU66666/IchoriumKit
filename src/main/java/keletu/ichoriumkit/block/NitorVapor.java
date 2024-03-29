package keletu.ichoriumkit.block;

import keletu.ichoriumkit.init.ModBlocks;
import net.minecraft.block.BlockAir;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import thaumcraft.client.fx.FXDispatcher;

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
    public EnumPushReaction getPushReaction(IBlockState state)
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
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random rand) {
        if (rand.nextFloat() < 0.03F)
            FXDispatcher.INSTANCE.sparkle(pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F, 1F, 4, rand.nextFloat() / 2);
    }

    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random random) {


        if (!world.isRemote) {
            List<EntityPlayer> players = world.getEntitiesWithinAABB(EntityPlayer.class, new AxisAlignedBB(pos.getX() - 1, pos.getY() - 1, pos.getZ() - 1, pos.getX() + 1, pos.getY() + 1, pos.getZ() + 1));

            for(EntityPlayer player : players)
                if(player.ticksExisted % 100 == 0)
                    world.setBlockToAir(pos);

            if (players.isEmpty()) world.setBlockToAir(pos);
           // else if (players.stream().noneMatch(p -> p.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() instanceof KamiArmor))
           //     world.setBlockToAir(pos);

        }
    }
}