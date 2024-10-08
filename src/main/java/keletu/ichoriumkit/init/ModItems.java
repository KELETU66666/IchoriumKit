package keletu.ichoriumkit.init;

import keletu.ichoriumkit.IchoriumKit;
import keletu.ichoriumkit.item.ItemBlockTalisman;
import keletu.ichoriumkit.item.ItemCatAmulet;
import keletu.ichoriumkit.item.ItemProtoclay;
import keletu.ichoriumkit.item.ItemSkyPearl;
import keletu.ichoriumkit.item.armor.IchorArmor;
import keletu.ichoriumkit.item.armor.KamiArmor;
import keletu.ichoriumkit.item.resources.ItemResourceKami;
import keletu.ichoriumkit.item.tools.*;
import keletu.ichoriumkit.item.tools.ichorpouch.ItemIchorPouch;
import keletu.ichoriumkit.util.Reference;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;
import net.minecraftforge.common.util.EnumHelper;

import java.util.ArrayList;
import java.util.List;

public class ModItems {
    public static final List<Item> ITEMS = new ArrayList<>();
    public static final Item.ToolMaterial MATERIAL_ICHORIUM= EnumHelper.addToolMaterial("ICHOR", 4, -1, 10F, 5F, 25);
    public static final ItemArmor.ArmorMaterial MATERIAL_ICHOR = EnumHelper.addArmorMaterial("ichor", Reference.MOD_ID + ":ichor", -1, new int[]{3, 6, 8, 3}, 22, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 2.0F);
    public static final ItemSword IchoriumSword = new ItemIchoriumSword("ichorium_sword", IchoriumKit.ITEM_TAB, MATERIAL_ICHORIUM);
    public static final ItemPickaxe IchoriumPick = new ItemIchoriumPick("ichorium_pick", IchoriumKit.ITEM_TAB, MATERIAL_ICHORIUM);
    public static final ItemAxe IchoriumAxe = new ItemIchoriumAxe("ichorium_axe", IchoriumKit.ITEM_TAB, MATERIAL_ICHORIUM);
    public static final ItemSpade IchoriumShovel = new ItemIchoriumShovel("ichorium_shovel", IchoriumKit.ITEM_TAB, MATERIAL_ICHORIUM);
    public static final Item IchorHelm = new IchorArmor("ichor_helm", MATERIAL_ICHOR, 1, EntityEquipmentSlot.HEAD);
    public static final Item IchorChest = new IchorArmor("ichor_chest", MATERIAL_ICHOR, 1, EntityEquipmentSlot.CHEST);
    public static final Item IchorLegs = new IchorArmor("ichor_legs", MATERIAL_ICHOR, 2, EntityEquipmentSlot.LEGS);
    public static final Item IchorBoots = new IchorArmor("ichor_boots", MATERIAL_ICHOR, 1, EntityEquipmentSlot.FEET);
    public static final Item IchorHelmAdv = new KamiArmor("kami_helm", MATERIAL_ICHOR, 1, EntityEquipmentSlot.HEAD);
    public static final Item IchorChestAdv = new KamiArmor("kami_chest", MATERIAL_ICHOR, 1, EntityEquipmentSlot.CHEST);
    public static final Item IchorLegsAdv = new KamiArmor("kami_legs", MATERIAL_ICHOR, 2, EntityEquipmentSlot.LEGS);
    public static final Item IchorBootsAdv = new KamiArmor("kami_boots", MATERIAL_ICHOR, 1, EntityEquipmentSlot.FEET);
    public static final ItemPickaxe IchoriumPickAdv = new ItemIchoriumPickAdv("ichorium_pick_adv", IchoriumKit.ITEM_TAB, MATERIAL_ICHORIUM);
    public static final ItemAxe IchoriumAxeAdv = new ItemIchoriumAxeAdv("ichorium_axe_adv", IchoriumKit.ITEM_TAB, MATERIAL_ICHORIUM);
    public static final ItemSpade IchoriumShovelAdv = new ItemIchoriumShovelAdv("ichorium_shovel_adv", IchoriumKit.ITEM_TAB, MATERIAL_ICHORIUM);
    public static final Item IchoriumSwordAdv = new ItemIchoriumSwordAdv("ichorium_sword_adv", IchoriumKit.ITEM_TAB, MATERIAL_ICHORIUM);
    public static final Item ResourceKami = new ItemResourceKami();
    public static final Item IchorPouch = new ItemIchorPouch();
    public static final Item Proto_Clay = new ItemProtoclay();
    public static final Item BlackHole_Ring = new ItemBlockTalisman();
    public static final Item cat_amulet = new ItemCatAmulet();
    public static final Item placement_mirror = new ItemPlacementMirror();
    public static final Item sky_pearl = new ItemSkyPearl();
}