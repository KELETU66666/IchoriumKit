package keletu.ichoriumkit.event;

import keletu.ichoriumkit.container.ContainerPouch;
import keletu.ichoriumkit.init.ModItems;
import keletu.ichoriumkit.item.armor.KamiArmor;
import keletu.ichoriumkit.item.tools.ItemIchoriumPickAdv;
import keletu.ichoriumkit.util.IAdvancedTool;
import keletu.ichoriumkit.util.ToolHandler;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class LivingEvent {

    @SubscribeEvent
    public void playerTick(TickEvent.PlayerTickEvent e) {
        if (e.phase != TickEvent.Phase.END)
            return;
        NBTTagCompound nbt = e.player.getEntityData();
        if (nbt.getBoolean("can_fly")) {
            e.player.capabilities.allowFlying = true;
            nbt.setBoolean("can_fly", false);
        } else if (nbt.hasKey("can_fly")) {
            if (!e.player.capabilities.isCreativeMode && !e.player.isSpectator()) {
                e.player.capabilities.allowFlying = false;
                e.player.capabilities.isFlying = false;
            }
            nbt.removeTag("can_fly");
        }
    }

    @SubscribeEvent
    public void playerJumps(net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent event) {
        ItemStack stack = event.getEntityLiving().getItemStackFromSlot(EntityEquipmentSlot.FEET);
        if (event.getEntity() instanceof EntityPlayer && stack.getItem() instanceof KamiArmor && stack.getItemDamage() != 1)
            event.getEntityLiving().motionY += 0.3;
    }


    @SubscribeEvent
    public void fall(LivingFallEvent e) {
        ItemStack boots = e.getEntityLiving().getItemStackFromSlot(EntityEquipmentSlot.FEET);
        if (!boots.isEmpty() && boots.getItem() instanceof KamiArmor && boots.getItemDamage() != 1) {
            e.setDamageMultiplier(0);
            e.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void onPlayerInteractEvent(PlayerInteractEvent.LeftClickBlock event) {
        if (event.getHand() == EnumHand.MAIN_HAND) {
            ItemStack stack = event.getEntityPlayer().getHeldItemMainhand();
            if (event.getEntityPlayer().world.getBlockState(event.getPos()).getBlock().equals(Blocks.BEDROCK)) {
                if (stack != null && stack.getItem() instanceof ItemIchoriumPickAdv) {
                    stack.getItem().onBlockStartBreak(stack, event.getPos(), event.getEntityPlayer());
                }
            }
        }
    }

    @SubscribeEvent
    public void onItemToss(ItemTossEvent event) {
        if (event.getPlayer().openContainer instanceof ContainerPouch) {
            ItemStack backpack = event.getPlayer().getHeldItem(EnumHand.MAIN_HAND);
            if (backpack.getItem() != ModItems.IchorPouch) {
                try {
                    event.getPlayer().closeScreen();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @SubscribeEvent
    public void Interact(PlayerInteractEvent event)
    {
        if(event.getEntityPlayer().inventory.hasItemStack(new ItemStack(ModItems.Proto_Clay))) {
            Entity par3Entity = event.getEntityPlayer();
            EntityPlayer player = (EntityPlayer) par3Entity;
            ItemStack currentStack = player.inventory.getCurrentItem();
            if (currentStack == ItemStack.EMPTY || !(currentStack.getItem() instanceof IAdvancedTool))
                return;
            IAdvancedTool tool = (IAdvancedTool) currentStack.getItem();

            RayTraceResult pos = ToolHandler.raytraceFromEntity(par3Entity.world, par3Entity, true, 4.5F);
            String typeToFind = "";

            if (player.isSwingInProgress && pos != null) {
                IBlockState state = par3Entity.world.getBlockState(pos.getBlockPos());

                Material mat = state.getMaterial();
                if (ToolHandler.isRightMaterial(mat, ToolHandler.materialsShovel))
                    typeToFind = "shovel";
                if (ToolHandler.isRightMaterial(mat, ToolHandler.materialsPick))
                    typeToFind = "pick";
                if (ToolHandler.isRightMaterial(mat, ToolHandler.materialsAxe))
                    typeToFind = "axe";
            }

            if (tool.getType().equals(typeToFind) || typeToFind.isEmpty())
                return;

            for (int i = 0; i < player.inventory.getSizeInventory(); i++) {
                ItemStack stackInSlot = player.inventory.getStackInSlot(i);
                if (stackInSlot.getItem() instanceof IAdvancedTool && stackInSlot != currentStack) {
                    IAdvancedTool toolInSlot = (IAdvancedTool) stackInSlot.getItem();
                    if (toolInSlot.getType().equals(typeToFind)) {
                        player.inventory.setInventorySlotContents(player.inventory.currentItem, stackInSlot);
                        player.inventory.setInventorySlotContents(i, currentStack);
                        break;
                    }
                }
            }
            event.setCanceled(true);
        }
    }
}