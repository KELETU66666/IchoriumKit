package keletu.ichoriumkit.item.resources;

import keletu.ichoriumkit.IchoriumKit;
import keletu.ichoriumkit.init.ModItems;
import keletu.ichoriumkit.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class ItemResourceKami extends Item implements IHasModel {

    public ItemResourceKami() {
        setTranslationKey("resourcekami").setRegistryName("resourcekami").setCreativeTab(IchoriumKit.ITEM_TAB);
        setHasSubtypes(true);
        this.addPropertyOverride(new ResourceLocation("meta"), new IItemPropertyGetter() {
            @Override
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
                if (stack.getMetadata() == 1) {
                    return 1.0F;
                }
                if (stack.getMetadata() == 2) {
                    return 2.0F;
                }
                if (stack.getMetadata() == 3) {
                    return 3.0F;
                }
                if (stack.getMetadata() == 4) {
                    return 4.0F;
                }
                if (stack.getMetadata() == 5) {
                    return 5.0F;
                }
                if (stack.getMetadata() == 6) {
                    return 6.0F;
                }
                return 0.0F;
            }
        });

        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        for (int i = 0; i < 6; i++) {
            IchoriumKit.proxy.registerItemRenderer(this, i, "inventory");
        }
    }

    @Override
    public EnumRarity getRarity (final ItemStack stack) {
        return EnumRarity.EPIC;
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (!isInCreativeTab(tab)) {
            return;
        }

        for (int i = 0; i < 6; i++) {
            items.add(new ItemStack(this, 1, i));
        }
    }

    @Override
    public String getTranslationKey(ItemStack item) {
        return super.getTranslationKey() + "." + item.getItemDamage();
    }
}
