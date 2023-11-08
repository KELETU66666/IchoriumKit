package keletu.ichoriumkit.item;


import keletu.ichoriumkit.IchoriumKit;
import keletu.ichoriumkit.init.ModItems;
import keletu.ichoriumkit.util.IHasModel;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Protoclay extends Item implements IHasModel {

    public Protoclay() {
        setMaxStackSize(1);
        setRegistryName("proto_clay");
        setTranslationKey("proto_clay");
        setCreativeTab(IchoriumKit.ITEM_TAB);

        ModItems.ITEMS.add(this);
    }

    @Override
    public EnumRarity getRarity(ItemStack par1ItemStack) {
        return EnumRarity.EPIC;
    }

    @Override
    public void registerModels() {
        IchoriumKit.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
