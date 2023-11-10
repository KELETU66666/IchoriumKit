/**
 * This class was created by <Vazkii>. It's distributed as part of the ThaumicTinkerer Mod.
 *
 * ThaumicTinkerer is Open Source and distributed under a Creative Commons Attribution-NonCommercial-ShareAlike 3.0
 * License (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 *
 * ThaumicTinkerer is a Derivative Work on Thaumcraft 4. Thaumcraft 4 (c) Azanor 2012
 * (http://www.minecraftforum.net/topic/1585216-)
 *
 * File Created @ [Jan 10, 2014, 5:26:45 PM (GMT)]
 */
package keletu.ichoriumkit.item;

import keletu.ichoriumkit.IchoriumKit;
import keletu.ichoriumkit.block.BlockWarpGate;
import keletu.ichoriumkit.block.tiles.TileWarpGate;
import keletu.ichoriumkit.init.ModBlocks;
import keletu.ichoriumkit.init.ModItems;
import keletu.ichoriumkit.util.IHasModel;
import keletu.ichoriumkit.util.ItemNBTHelper;
import keletu.ichoriumkit.util.MiscHelper;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import thaumcraft.codechicken.lib.vec.Vector3;

import javax.annotation.Nullable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class ItemSkyPearl extends Item implements IHasModel {

    public static final String TAG_X = "x";
    public static final String TAG_Y = "y";
    public static final String TAG_Z = "z";
    public static final String TAG_DIM = "dim";

    public ItemSkyPearl() {
        super();
        setMaxStackSize(1);
        setRegistryName("sky_pearl").setTranslationKey("sky_pearl").setCreativeTab(IchoriumKit.ITEM_TAB);

        ModItems.ITEMS.add(this);
    }

    public static void addInfo(ItemStack stack, int dim, Vector3 pos, List<String> list, boolean simpleMode) {
        if (isAttuned(stack)) {
            int x = getX(stack);
            int y = getY(stack);
            int z = getZ(stack);
            list.add("X: " + x);
            if (!simpleMode) list.add("Y: " + y);
            list.add("Z: " + z);
            if (getDim(stack) != dim) {
                if (!simpleMode)
                    list.add(TextFormatting.RED + I18n.translateToLocal("ichormisc.differentDim"));
            } else list.add(
                    TextFormatting.BLUE + I18n.translateToLocal("ichormisc.distance")
                            + ": "
                            + BigDecimal.valueOf(
                                    MiscHelper.pointDistanceSpace(
                                            x,
                                            simpleMode ? 0 : y,
                                            z,
                                            pos.x,
                                            simpleMode ? 0 : pos.y,
                                            pos.z))
                                    .setScale(2, RoundingMode.UP).toString()
                            + "m");
        }
    }

    public static void setValues(ItemStack stack, BlockPos pos, int dim) {
        ItemNBTHelper.setInt(stack, TAG_X, pos.getX());
        ItemNBTHelper.setInt(stack, TAG_Y, pos.getY());
        ItemNBTHelper.setInt(stack, TAG_Z, pos.getZ());
        ItemNBTHelper.setInt(stack, TAG_DIM, dim);
    }

    public static boolean isAttuned(ItemStack stack) {
        return stack.hasTagCompound() && ItemNBTHelper.getInt(stack, TAG_Y, -1) != -1;
    }

    public static int getX(ItemStack stack) {
        if (!isAttuned(stack)) return 0;

        return ItemNBTHelper.getInt(stack, TAG_X, 0);
    }

    public static int getY(ItemStack stack) {
        if (!isAttuned(stack)) return 0;

        return ItemNBTHelper.getInt(stack, TAG_Y, 0);
    }

    public static int getZ(ItemStack stack) {
        if (!isAttuned(stack)) return 0;

        return ItemNBTHelper.getInt(stack, TAG_Z, 0);
    }

    public static int getDim(ItemStack stack) {
        if (!isAttuned(stack)) return 0;

        return ItemNBTHelper.getInt(stack, TAG_DIM, 0);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack stack = player.getHeldItem(hand);
        Block block = world.getBlockState(pos).getBlock();
        if (block == ModBlocks.WARP_GATE
                && !isAttuned(stack)) {
            setValues(stack, pos, player.dimension);
            world.playSound(null, player.getPosition(), SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.PLAYERS, 0.3F, 0.1F);
        }

        return EnumActionResult.SUCCESS;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        ItemStack stack = player.getHeldItem(hand);
        if (player.isSneaking() && isAttuned(stack)) {
            world.playSound(null, player.getPosition(), SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.PLAYERS, 0.3F, 0.1F);
            ItemNBTHelper.setInt(stack, TAG_Y, -1);
        }

        return super.onItemRightClick(world, player, hand);
    }

   //@Override
   //public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flag) {
   //    addInfo(stack, player.dimension, Vector3.fromEntityCenter(player), tooltip, false);
   //}

    @Override
    public boolean hasEffect(ItemStack par1ItemStack) {
        return isAttuned(par1ItemStack);
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