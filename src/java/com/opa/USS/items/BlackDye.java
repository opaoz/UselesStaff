package com.opa.USS.items;

import com.opa.USS.creativeTab.JustTab;
import com.opa.USS.util.NBT;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlackDye extends JustItem{

    public BlackDye(){
        super();
        this.setUnlocalizedName("blackDye");
        this.maxStackSize = 1;
        this.setCreativeTab(JustTab.USS_TAB);
    }
}

