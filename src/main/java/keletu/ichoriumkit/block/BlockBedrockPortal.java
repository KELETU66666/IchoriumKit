package keletu.ichoriumkit.block;

import keletu.ichoriumkit.IchoriumKit;
import keletu.ichoriumkit.ModConfig;
import keletu.ichoriumkit.block.tiles.TileBedrockPortal;
import keletu.ichoriumkit.dim.ProviderBedrock;
import keletu.ichoriumkit.init.ModBlocks;
import keletu.ichoriumkit.init.ModItems;
import keletu.ichoriumkit.util.IHasModel;
import keletu.ichoriumkit.util.TeleporterBedrock;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.FMLCommonHandler;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class BlockBedrockPortal extends BlockContainer implements IHasModel
{

    public BlockBedrockPortal(String name, Material materialIn)
    {
        super(materialIn);
        setTranslationKey(name).setRegistryName(name).setCreativeTab(IchoriumKit.ITEM_TAB);
        setResistance(6000000.0F);
        setHardness(-2.0F);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileBedrockPortal();
    }

    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean isActualState)
    {
    }

    public int quantityDropped(Random random)
    {
        return 0;
    }



    @Override
    public void onEntityCollision(World world, BlockPos pos, IBlockState state, Entity entity) {
        super.onEntityCollision(world, pos, state, entity);

        if (entity instanceof EntityPlayer && !world.isRemote) {
            if (entity.dimension != ModConfig.BedRockDimensionID) {

                int x = pos.getX();
                int y = pos.getY();
                int z = pos.getZ();

                BlockPos pos1 = pos.add(0, 251 - y, 0);
                BlockPos pos2 = pos.add(0, 252 - y, 0);
                BlockPos pos3 = pos.add(0, 253 - y, 0);
                BlockPos pos4 = pos.add(0, 254 - y, 0);
                BlockPos pos5 = pos.add(0, 255 - y, 0);

                entity.changeDimension(ModConfig.BedRockDimensionID, new TeleporterBedrock((WorldServer) world));
                entity.setPositionAndUpdate(x + 0.5, 251, z + 0.5);


                if (entity.world.getBlockState(pos1).getBlock() == Blocks.BEDROCK) {
                    entity.world.setBlockToAir(pos1);
                }
                if (entity.world.getBlockState(pos2).getBlock() == Blocks.BEDROCK) {
                    entity.world.setBlockToAir(pos2);
                }
                if (entity.world.getBlockState(pos3).getBlock() == Blocks.BEDROCK) {
                    entity.world.setBlockToAir(pos3);
                }
                if (entity.world.getBlockState(pos4).getBlock() == Blocks.BEDROCK) {
                    entity.world.setBlockToAir(pos4);
                }
                if (entity.world.getBlockState(pos5).getBlock() == Blocks.BEDROCK) {
                    entity.world.setBlockState(pos5, ModBlocks.BEDROCK_PORTAL.getDefaultState());
                }
            } else if (entity.world.provider instanceof ProviderBedrock) {
                if (entity instanceof EntityPlayer && !world.isRemote) {

                    FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList()
                            .transferPlayerToDimension(
                                    (EntityPlayerMP) entity,
                                    0,
                                    new TeleporterBedrock((WorldServer) world));

                    Random rand = new Random();

                    int x = (int) entity.posX + rand.nextInt(100);
                    int z = (int) entity.posZ + rand.nextInt(100);

                    x -= 50;
                    z -= 50;

                    int y = 120;

                    while (entity.world.getBlockState(new BlockPos(x, y, z)).getBlock() == Blocks.AIR
                            || entity.world.getBlockState(new BlockPos(x, y, z)).getBlock().isAir(entity.world.getBlockState(new BlockPos(x, y, z)), world, new BlockPos(x, y, z))) {
                        y--;
                        // Avoid infinite loop.
                        if (y <= 1) {
                            y = 120;
                            // Set up the scaffolding.
                            entity.world.setBlockState(new BlockPos(x, y - 1, z), Blocks.STONE.getDefaultState());
                        }
                    }

                    ((EntityPlayerMP) entity).connection.setPlayerLocation(x + 0.5, y + 3, z + 0.5, 0, 0);
                }
            }
        }
    }

    public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        return MapColor.BLACK;
    }

    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public void registerModels() {
        IchoriumKit.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }

}