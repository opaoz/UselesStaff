package com.opa.USS.util;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class Glow {
    @SideOnly(Side.CLIENT)
    public static void addGlow(ItemStack itemStack){
        Log.info("Glow has added");
    }
    @SideOnly(Side.CLIENT)
    public static void removeGlow(ItemStack itemStack) {
            Log.info("Glow has removed");
        }
}
