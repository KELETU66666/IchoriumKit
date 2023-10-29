package keletu.ichoriumkit.init;


import keletu.ichoriumkit.util.Reference;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.ThaumcraftApiHelper;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.blocks.BlocksTC;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.crafting.ShapedArcaneRecipe;
import thaumcraft.api.items.ItemsTC;

import static thaumcraft.api.ThaumcraftApi.addInfusionCraftingRecipe;

public class InitRecipes {
    private static ResourceLocation defaultGroup = new ResourceLocation("");

    public static void initRecipes() {
        initArcaneRecipes();
        initCrucibleRecipes();
        initInfusionRecipes();
    }

private static void initArcaneRecipes() {
        ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation(Reference.MOD_ID, "ichor_cloth"), new ShapedArcaneRecipe(
                defaultGroup,
                "ICHOR",
                750,
                new AspectList().add(Aspect.AIR, 10).add(Aspect.WATER, 10).add(Aspect.ORDER, 10).add(Aspect.EARTH, 10).add(Aspect.FIRE, 10).add(Aspect.ENTROPY, 10),
                 new ItemStack(ModItems.ResourceKami,3,4),
                "CCC",
                "III",
                "DDD",
                'C', new ItemStack(ItemsTC.fabric),
                'I', new ItemStack(ModItems.ResourceKami,1,2),
                'D', "gemDiamond"));
        ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation(Reference.MOD_ID, "ichor_ingot"), new ShapedArcaneRecipe(
                defaultGroup,
                "ICHOR",
                500,
                new AspectList().add(Aspect.AIR, 5).add(Aspect.WATER, 5).add(Aspect.ORDER, 5).add(Aspect.EARTH, 5).add(Aspect.FIRE, 5).add(Aspect.ENTROPY, 5),
                new ItemStack(ModItems.ResourceKami,1,3),
                " T ",
                "IDI",
                " I ",
                'T', "ingotThaumium",
                'I', new ItemStack(ModItems.ResourceKami,1,2),
                'D', "gemDiamond"));
        ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation(Reference.MOD_ID, "ichorium_sword"), new ShapedArcaneRecipe(
            defaultGroup,
            "ICHORIUMTOOLS",
            150,
            new AspectList().add(Aspect.AIR, 3).add(Aspect.WATER, 3).add(Aspect.ORDER, 3).add(Aspect.EARTH, 3).add(Aspect.FIRE, 3).add(Aspect.ENTROPY, 3),
            new ItemStack(ModItems.IchoriumSword),
            "I",
            "I",
            "S",
            'I', "ingotIchorium",
            'S', new ItemStack(BlocksTC.logSilverwood)));
    ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation(Reference.MOD_ID, "ichorium_pick"), new ShapedArcaneRecipe(
            defaultGroup,
            "ICHORIUMTOOLS",
            150,
            new AspectList().add(Aspect.AIR, 3).add(Aspect.WATER, 3).add(Aspect.ORDER, 3).add(Aspect.EARTH, 3).add(Aspect.FIRE, 3).add(Aspect.ENTROPY, 3),
            new ItemStack(ModItems.IchoriumPick),
            "III",
            " S ",
            " S ",
            'I', "ingotIchorium",
            'S', new ItemStack(BlocksTC.logSilverwood)));
    ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation(Reference.MOD_ID, "ichorium_shovel"), new ShapedArcaneRecipe(
            defaultGroup,
            "ICHORIUMTOOLS",
            150,
            new AspectList().add(Aspect.AIR, 3).add(Aspect.WATER, 3).add(Aspect.ORDER, 3).add(Aspect.EARTH, 3).add(Aspect.FIRE, 3).add(Aspect.ENTROPY, 3),
            new ItemStack(ModItems.IchoriumShovel),
            "I",
            "S",
            "S",
            'I', "ingotIchorium",
            'S', new ItemStack(BlocksTC.logSilverwood)));
    ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation(Reference.MOD_ID, "ichorium_axe"), new ShapedArcaneRecipe(
            defaultGroup,
            "ICHORIUMTOOLS",
            150,
            new AspectList().add(Aspect.AIR, 3).add(Aspect.WATER, 3).add(Aspect.ORDER, 3).add(Aspect.EARTH, 3).add(Aspect.FIRE, 3).add(Aspect.ENTROPY, 3),
            new ItemStack(ModItems.IchoriumAxe),
            "II ",
            "IS ",
            " S ",
            'I', "ingotIchorium",
            'S', new ItemStack(BlocksTC.logSilverwood)));
    ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation(Reference.MOD_ID, "ichor_helm"), new ShapedArcaneRecipe(
            defaultGroup,
            "ICHORARMOR",
            150,
            new AspectList().add(Aspect.AIR, 3).add(Aspect.WATER, 3).add(Aspect.ORDER, 3).add(Aspect.EARTH, 3).add(Aspect.FIRE, 3).add(Aspect.ENTROPY, 3),
            new ItemStack(ModItems.IchorHelm),
            "CCC",
            "C C",
            'C', "itemIchorFabric"));
    ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation(Reference.MOD_ID, "ichor_chest"), new ShapedArcaneRecipe(
            defaultGroup,
            "ICHORARMOR",
            150,
            new AspectList().add(Aspect.AIR, 3).add(Aspect.WATER, 3).add(Aspect.ORDER, 3).add(Aspect.EARTH, 3).add(Aspect.FIRE, 3).add(Aspect.ENTROPY, 3),
            new ItemStack(ModItems.IchorChest),
            "C C",
            "CCC",
            "CCC",
            'C', "itemIchorFabric"));
    ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation(Reference.MOD_ID, "ichor_legs"), new ShapedArcaneRecipe(
            defaultGroup,
            "ICHORARMOR",
            150,
            new AspectList().add(Aspect.AIR, 3).add(Aspect.WATER, 3).add(Aspect.ORDER, 3).add(Aspect.EARTH, 3).add(Aspect.FIRE, 3).add(Aspect.ENTROPY, 3),
            new ItemStack(ModItems.IchorLegs),
            "CCC",
            "C C",
            "C C",
            'C', "itemIchorFabric"));
    ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation(Reference.MOD_ID, "ichor_boots"), new ShapedArcaneRecipe(
            defaultGroup,
            "ICHORARMOR",
            150,
            new AspectList().add(Aspect.AIR, 3).add(Aspect.WATER, 3).add(Aspect.ORDER, 3).add(Aspect.EARTH, 3).add(Aspect.FIRE, 3).add(Aspect.ENTROPY, 3),
            new ItemStack(ModItems.IchorBoots),
            "C C",
            "C C",
            'C', "itemIchorFabric"));
}

private static void initCrucibleRecipes() {}
private static void initInfusionRecipes() {
    ThaumcraftApi.addInfusionCraftingRecipe(new ResourceLocation(Reference.MOD_ID, "ichor_block_infusion"), new InfusionRecipe(
            "ICHOR@1",
            new ItemStack(ModBlocks.ICHOR_BLOCK),
            8,
            new AspectList().add(Aspect.LIGHT, 125).add(Aspect.MAN, 125).add(Aspect.SOUL, 250),
            new ItemStack(Items.NETHER_STAR),
            new ItemStack(ModItems.ResourceKami,1,1),
            "gemDiamond",
            new ItemStack(ModItems.ResourceKami,1,0),
            new ItemStack(Items.ENDER_EYE)));
    ThaumcraftApi.addInfusionCraftingRecipe(new ResourceLocation(Reference.MOD_ID, "kami_helm"), new InfusionRecipe(
            "KAMIHELM",
            new ItemStack(ModItems.IchorHelmAdv),
            40,
            new AspectList().add(Aspect.WATER, 150).add(Aspect.AURA, 125).add(Aspect.MIND, 60).add(Aspect.LIFE, 60).add(Aspect.LIGHT, 250).add(Aspect.PROTECT, 125),
                    new ItemStack(ModItems.IchorHelm),
            "gemDiamond",
            new ItemStack(ModItems.ResourceKami,1,2),
            new ItemStack(ModItems.ResourceKami,1,2),
            new ItemStack(ItemsTC.thaumonomicon),
            new ItemStack(Items.CHORUS_FRUIT_POPPED),
            new ItemStack(Items.GOLDEN_HELMET),
            PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.NIGHT_VISION),
            new ItemStack(ItemsTC.goggles),
            new ItemStack(Items.GHAST_TEAR),
            new ItemStack(Items.FISH),
            new ItemStack(Items.CAKE),
            new ItemStack(Items.ENDER_EYE)));
    ThaumcraftApi.addInfusionCraftingRecipe(new ResourceLocation(Reference.MOD_ID, "kami_chest"), new InfusionRecipe(
            "KAMICHEST",
            new ItemStack(ModItems.IchorChestAdv),
            40,
            new AspectList().add(Aspect.AIR, 150).add(Aspect.PROTECT, 125).add(Aspect.FLIGHT, 125).add(Aspect.ORDER, 125).add(Aspect.LIGHT, 250).add(Aspect.ELDRITCH, 60),
            new ItemStack(ModItems.IchorChest),
            "gemDiamond",
            new ItemStack(ModItems.ResourceKami,1,2),
            new ItemStack(ModItems.ResourceKami,1,2),
            new ItemStack(ItemsTC.thaumonomicon),
            new ItemStack(Items.CHORUS_FRUIT_POPPED),
            new ItemStack(Items.GOLDEN_CHESTPLATE),
            new ItemStack(ItemsTC.ringCloud),
            new ItemStack(Items.ELYTRA),
            new ItemStack(Items.SHIELD),
            new ItemStack(Items.FEATHER),
            new ItemStack(Items.GHAST_TEAR),
            new ItemStack(Items.ARROW)));
    ThaumcraftApi.addInfusionCraftingRecipe(new ResourceLocation(Reference.MOD_ID, "kami_legs"), new InfusionRecipe(
            "KAMILEGS",
            new ItemStack(ModItems.IchorLegsAdv),
            40,
            new AspectList().add(Aspect.AIR, 150).add(Aspect.PROTECT, 125).add(Aspect.FLIGHT, 125).add(Aspect.ORDER, 125).add(Aspect.LIGHT, 250).add(Aspect.ELDRITCH, 60),
            new ItemStack(ModItems.IchorLegs),
            "gemDiamond",
            new ItemStack(ModItems.ResourceKami,1,2),
            new ItemStack(ModItems.ResourceKami,1,2),
            new ItemStack(ItemsTC.thaumonomicon),
            new ItemStack(Items.CHORUS_FRUIT_POPPED),
            new ItemStack(Items.GOLDEN_LEGGINGS),
            PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.FIRE_RESISTANCE),
            new ItemStack(ItemsTC.modules,1 ,1),
            new ItemStack(BlocksTC.lampArcane),
            new ItemStack(Items.LAVA_BUCKET),
            new ItemStack(Items.FIRE_CHARGE),
            new ItemStack(Items.BLAZE_ROD)));
    ThaumcraftApi.addInfusionCraftingRecipe(new ResourceLocation(Reference.MOD_ID, "kami_boots"), new InfusionRecipe(
            "KAMIBOOTS",
            new ItemStack(ModItems.IchorBootsAdv),
            40,
            new AspectList().add(Aspect.EARTH, 150).add(Aspect.PROTECT, 125).add(Aspect.TOOL, 125).add(Aspect.MOTION, 125).add(Aspect.LIGHT, 250).add(Aspect.PLANT, 60).add(Aspect.FLIGHT, 60),
            new ItemStack(ModItems.IchorBoots),
            "gemDiamond",
            new ItemStack(ModItems.ResourceKami,1,2),
            new ItemStack(ModItems.ResourceKami,1,2),
            new ItemStack(ItemsTC.thaumonomicon),
            new ItemStack(Items.CHORUS_FRUIT_POPPED),
            new ItemStack(Items.GOLDEN_BOOTS),
            new ItemStack(Blocks.GRASS),
            new ItemStack(Items.WHEAT_SEEDS),
            new ItemStack(BlocksTC.lampGrowth),
            new ItemStack(ItemsTC.turretPlacer,1, 2),
            new ItemStack(Blocks.WOOL),
            new ItemStack(Items.LEAD)));
    ThaumcraftApi.addInfusionCraftingRecipe(new ResourceLocation(Reference.MOD_ID, "ichorium_pick_adv"), new InfusionRecipe(
            "ICHOR_PICK_ADV",
            new ItemStack(ModItems.IchoriumPickAdv),
            32,
            new AspectList().add(Aspect.FIRE, 150).add(Aspect.DESIRE, 60).add(Aspect.METAL, 125).add(Aspect.TOOL, 250).add(Aspect.SENSES, 60).add(Aspect.EARTH, 125),
            new ItemStack(ModItems.IchoriumPick),
            "ingotIchorium",
            new ItemStack(ModItems.ResourceKami,1,2),
            new ItemStack(ItemsTC.elementalPick),
            new ItemStack(ItemsTC.mechanismComplex),
            new ItemStack(Blocks.TNT),
            new ItemStack(ItemsTC.clusters, 1, 6),
            new ItemStack(ItemsTC.clusters, 1, 0),
            new ItemStack(ItemsTC.clusters, 1, 1),
            "gemDiamond",
            new ItemStack(ItemsTC.mechanismComplex),
            new ItemStack(ItemsTC.elementalPick),
            "itemIchorFabric"));
    ThaumcraftApi.addInfusionCraftingRecipe(new ResourceLocation(Reference.MOD_ID, "ichorium_shovel_adv"), new InfusionRecipe(
            "ICHOR_SHOVEL_ADV",
            new ItemStack(ModItems.IchoriumShovelAdv),
            32,
            new AspectList().add(Aspect.TOOL, 250).add(Aspect.SENSES, 60).add(Aspect.EARTH, 125).add(Aspect.TRAP, 60),
            new ItemStack(ModItems.IchoriumShovel),
            "ingotIchorium",
            new ItemStack(ModItems.ResourceKami,1,2),
            new ItemStack(ItemsTC.elementalShovel),
            new ItemStack(ItemsTC.mechanismComplex),
            new ItemStack(Blocks.TNT),
            new ItemStack(ItemsTC.clusters, 1, 6),
            new ItemStack(ItemsTC.clusters, 1, 0),
            new ItemStack(ItemsTC.clusters, 1, 1),
            "gemDiamond",
            new ItemStack(ItemsTC.mechanismComplex),
            new ItemStack(ItemsTC.elementalShovel),
            "itemIchorFabric"));
    ThaumcraftApi.addInfusionCraftingRecipe(new ResourceLocation(Reference.MOD_ID, "ichorium_axe_adv"), new InfusionRecipe(
            "ICHOR_AXE_ADV",
            new ItemStack(ModItems.IchoriumAxeAdv),
            32,
            new AspectList().add(Aspect.WATER, 150).add(Aspect.PLANT, 125).add(Aspect.TOOL, 250).add(Aspect.SENSES, 60),
            new ItemStack(ModItems.IchoriumAxe),
            "ingotIchorium",
            new ItemStack(ModItems.ResourceKami,1,2),
            new ItemStack(ItemsTC.elementalAxe),
            new ItemStack(ItemsTC.mechanismComplex),
            new ItemStack(Blocks.TNT),
            new ItemStack(ItemsTC.clusters, 1, 6),
            new ItemStack(ItemsTC.clusters, 1, 0),
            new ItemStack(ItemsTC.clusters, 1, 1),
            "gemDiamond",
            new ItemStack(ItemsTC.mechanismComplex),
            new ItemStack(ItemsTC.elementalAxe),
            "itemIchorFabric"));
    ThaumcraftApi.addInfusionCraftingRecipe(new ResourceLocation(Reference.MOD_ID, "ichorium_sword_adv"), new InfusionRecipe(
            "ICHOR_SWORD_ADV",
            new ItemStack(ModItems.IchoriumSwordAdv),
            32,
            new AspectList().add(Aspect.AIR, 150).add(Aspect.DESIRE, 250).add(Aspect.ORDER, 60).add(Aspect.ENERGY, 125).add(Aspect.CRYSTAL, 60).add(Aspect.SOUL, 125).add(Aspect.AVERSION, 125),
            new ItemStack(ModItems.IchoriumSword),
            "ingotIchorium",
            new ItemStack(ModItems.ResourceKami,1,2),
            new ItemStack(ItemsTC.elementalSword),
            new ItemStack(ItemsTC.mechanismComplex),
            new ItemStack(Blocks.CACTUS),
            new ItemStack(ItemsTC.clusters, 1, 6),
            new ItemStack(ItemsTC.clusters, 1, 0),
            new ItemStack(ItemsTC.clusters, 1, 1),
            "gemDiamond",
            new ItemStack(ItemsTC.mechanismComplex),
            new ItemStack(ItemsTC.elementalSword),
            "itemIchorFabric"));
    addInfusionCraftingRecipe(new ResourceLocation(Reference.MOD_ID, "blackhole_ring"), new InfusionRecipe(
            "BLACKHOLE_RING",
            new ItemStack(ModItems.BlackHole_Ring),
            9,
            new AspectList().add(Aspect.ELDRITCH, 125).add(Aspect.MAGIC, 200).add(Aspect.DARKNESS, 125).add(Aspect.VOID, 250),
            new ItemStack(ItemsTC.focus2),
            new ItemStack(ModItems.ResourceKami,1,2),
            new ItemStack(Blocks.ENDER_CHEST),
            "gemDiamond",
            new ItemStack(ModItems.ResourceKami,1,2),
            ThaumcraftApiHelper.makeCrystal(Aspect.FLUX),
            new ItemStack(BlocksTC.jarVoid)));
    addInfusionCraftingRecipe(new ResourceLocation(Reference.MOD_ID, "proto_clay"), new InfusionRecipe(
            "PROTO_CLAY",
            new ItemStack(ModItems.Proto_Clay),
            4,
            new AspectList().add(Aspect.TOOL, 30).add(Aspect.MAN, 30),
            new ItemStack(Items.CLAY_BALL),
            new ItemStack(Blocks.DIRT),
            new ItemStack(Blocks.LOG),
            new ItemStack(Blocks.STONE),
            new ItemStack(ModItems.ResourceKami,1,0)));
    addInfusionCraftingRecipe(new ResourceLocation(Reference.MOD_ID, "ichor_pouch"), new InfusionRecipe(
            "ICHOR_POUCH",
            new ItemStack(ModItems.IchorPouch),
            7,
            new AspectList().add(Aspect.AIR, 250).add(Aspect.ELDRITCH, 125).add(Aspect.MAN, 125).add(Aspect.CRAFT, 125).add(Aspect.VOID, 250),
            new ItemStack(ItemsTC.focusPouch),
            "itemIchorFabric",
            new ItemStack(BlocksTC.hungryChest),
            "gemDiamond",
            "itemIchorFabric",
            new ItemStack(ItemsTC.focus2),
            new ItemStack(BlocksTC.jarVoid)));
    }
}
