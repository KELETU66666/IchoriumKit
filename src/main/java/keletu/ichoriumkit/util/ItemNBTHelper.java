package keletu.ichoriumkit.util;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

import javax.annotation.Nullable;

public final class ItemNBTHelper {
    /** Gets the NBTTagCompound in an ItemStack. Tries to init it
     * previously in case there isn't one present **/
    public static NBTTagCompound getNBT(ItemStack stack) {
        if(!stack.hasTagCompound())
            stack.setTagCompound(new NBTTagCompound());
        return stack.getTagCompound();
    }

    // SETTERS ///////////////////////////////////////////////////////////////////

    public static void setInt(ItemStack stack, String tag, int i) {
        getNBT(stack).setInteger(tag, i);
    }

    public static void setString(ItemStack stack, String tag, String s) {
        getNBT(stack).setString(tag, s);
    }

    // GETTERS ///////////////////////////////////////////////////////////////////

    public static boolean verifyExistance(ItemStack stack, String tag) {
        return !stack.isEmpty() && getNBT(stack).hasKey(tag);
    }

    public static int getInt(ItemStack stack, String tag, int defaultExpected) {
        return verifyExistance(stack, tag) ? getNBT(stack).getInteger(tag) : defaultExpected;
    }

    /** If nullifyOnFail is true it'll return null if it doesn't find any
     * compounds, otherwise it'll return a new one. **/
    public static NBTTagCompound getCompound(ItemStack stack, String tag, boolean nullifyOnFail) {
        return verifyExistance(stack, tag) ? getNBT(stack).getCompoundTag(tag) : nullifyOnFail ? null : new NBTTagCompound();
    }

    public static String getString(ItemStack stack, String tag, String defaultExpected) {
        return verifyExistance(stack, tag) ? getNBT(stack).getString(tag) : defaultExpected;
    }

    /**
     * Returns true if the `target` tag contains all of the tags and values present in the `template` tag. Recurses into
     * compound tags and matches all template keys and values; recurses into list tags and matches the template against
     * the first elements of target. Empty lists and compounds in the template will match target lists and compounds of
     * any size.
     */

    public static boolean matchTag(@Nullable NBTBase template, @Nullable NBTBase target) {
        if(template instanceof NBTTagCompound && target instanceof NBTTagCompound) {
            return matchTagCompound((NBTTagCompound) template, (NBTTagCompound) target);
        } else if(template instanceof NBTTagList && target instanceof NBTTagList) {
            return matchTagList((NBTTagList) template, (NBTTagList) target);
        } else {
            return template == null || (target != null && target.equals(template));
        }
    }

    private static boolean matchTagCompound(NBTTagCompound template, NBTTagCompound target) {
        if(template.getSize() > target.getSize()) return false;

        for(String key : template.getKeySet()) {
            if (!matchTag(template.getTag(key), target.getTag(key))) return false;
        }

        return true;
    }

    private static boolean matchTagList(NBTTagList template, NBTTagList target) {
        if (template.tagCount() > target.tagCount()) return false;

        for (int i = 0; i < template.tagCount(); i++) {
            if (!matchTag(template.get(i), target.get(i))) return false;
        }

        return true;
    }

}