package keletu.ichoriumkit.item.tools;

import keletu.ichoriumkit.IchoriumKit;
import keletu.ichoriumkit.init.ModItems;
import keletu.ichoriumkit.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;

public class ItemIchoriumAxe extends ItemAxe implements IHasModel{
    public ItemIchoriumAxe(String name, CreativeTabs tab, ToolMaterial material) {

        super(material,10.0F,-3.0F);
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(tab);

        ModItems.ITEMS.add(this);
    }

    @Override
    public EnumRarity getRarity(ItemStack itemstack) {
        return EnumRarity.EPIC;
    }
    @Override
    public boolean isEnchantable(ItemStack itemStack){return true;}
    @Override
    public void registerModels() {
        IchoriumKit.proxy.registerItemRenderer(this, 0, "inventory");
    }
}