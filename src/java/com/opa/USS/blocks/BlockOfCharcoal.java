package com.opa.USS.blocks;

import com.opa.USS.creativeTab.JustTab;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockOfCharcoal extends JustBlock{
    public BlockOfCharcoal(){
        super(Material.rock);
        this.setBlockName("boc");
        this.setBlockTextureName("boc");
        this.setHardness(5.0F);
        this.setResistance(10.0F);
        this.setStepSound(soundTypePiston);
        this.setCreativeTab(JustTab.USS_TAB);
    }
    @Override
    public Item getItemDropped(int par1, Random random, int par2)
    {
        return Item.getItemFromBlock(this);
    }
}
