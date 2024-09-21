package keletu.ichoriumkit.block;


import keletu.ichoriumkit.IchoriumKit;
import keletu.ichoriumkit.init.ModBlocks;
import keletu.ichoriumkit.init.ModItems;
import keletu.ichoriumkit.util.IHasModel;
import net.minecraft.block.BlockSlime;
import net.minecraft.block.SoundType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockIchorBlock extends BlockSlime implements IHasModel {
    public BlockIchorBlock() {
        super();
        this.setSoundType(SoundType.SLIME);
        this.setRegistryName("ichor_block");
        this.setTranslationKey("ichor_block");
        this.setCreativeTab(IchoriumKit.ITEM_TAB);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels() {
        IchoriumKit.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}