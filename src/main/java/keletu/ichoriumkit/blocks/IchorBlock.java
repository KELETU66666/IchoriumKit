package keletu.ichoriumkit.blocks;


import keletu.ichoriumkit.init.ModBlocks;
import keletu.ichoriumkit.init.ModItems;
import keletu.ichoriumkit.IchoriumKit;
import keletu.ichoriumkit.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlime;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import thaumcraft.api.ThaumcraftMaterials;
import thaumcraft.api.blocks.BlocksTC;

public class IchorBlock extends BlockSlime implements IHasModel {
    public IchorBlock() {
        super();
        this.setSoundType(SoundType.SLIME);
        this.setRegistryName("ichor_block");
        this.setUnlocalizedName("ichor_block");
        this.setCreativeTab(IchoriumKit.ITEM_TAB);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels() {
        IchoriumKit.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}