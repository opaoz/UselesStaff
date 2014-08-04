package com.opa.USS.blocks;

import com.opa.USS.creativeTab.JustTab;
import net.minecraft.block.material.Material;

public class BlockTable extends JustBlock {

    public BlockTable(){
        super(Material.wood);
        this.setBlockName("Table");
        this.setHardness(3.0F);
        this.setBlockTextureName("Table");
        this.setResistance(5.5F);
        this.setStepSound(soundTypeWood);
        this.setCreativeTab(JustTab.USS_TAB);
    }
}
