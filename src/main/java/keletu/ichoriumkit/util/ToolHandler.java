package keletu.ichoriumkit.util;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public final class ToolHandler {

    public static Material[] materialsPick = new Material[]{Material.ROCK, Material.IRON, Material.ICE, Material.GLASS, Material.PISTON, Material.ANVIL};
    public static Material[] materialsShovel = new Material[]{Material.GRASS, Material.GROUND, Material.SAND, Material.SNOW, Material.CRAFTED_SNOW, Material.CLAY};
    public static Material[] materialsAxe = new Material[]{Material.CORAL, Material.LEAVES, Material.PLANTS, Material.WOOD};

    public static boolean isRightMaterial(Material material, Material[] materialsListing) {
        for (Material mat : materialsListing)
            if (material == mat)
                return true;

        return false;
    }

    /**
     * @author mDiyo
     */
    public static RayTraceResult raytraceFromEntity(World worldIn, Entity playerIn, boolean useLiquids, double range) {
        float f = playerIn.rotationPitch;
        float f1 = playerIn.rotationYaw;
        double d0 = playerIn.posX;
        double d1 = playerIn.posY + (double)playerIn.getEyeHeight();
        double d2 = playerIn.posZ;
        Vec3d vec3d = new Vec3d(d0, d1, d2);
        float f2 = MathHelper.cos(-f1 * 0.017453292F - (float)Math.PI);
        float f3 = MathHelper.sin(-f1 * 0.017453292F - (float)Math.PI);
        float f4 = -MathHelper.cos(-f * 0.017453292F);
        float f5 = MathHelper.sin(-f * 0.017453292F);
        float f6 = f3 * f4;
        float f7 = f2 * f4;
        double d3 = range;
        Vec3d vec3d1 = vec3d.add(new Vec3d((double)f6 * d3, (double)f5 * d3, (double)f7 * d3));
        return worldIn.rayTraceBlocks(vec3d, vec3d1, useLiquids, !useLiquids, false);
    }

}