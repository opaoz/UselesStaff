package com.opa.USS.init;

import com.opa.USS.blocks.BlockOfCharcoal;
import com.opa.USS.blocks.BlockTable;
import com.opa.USS.blocks.JustBlock;
import com.opa.USS.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks {

    public static final JustBlock table = new BlockTable();
    public static final JustBlock boc = new BlockOfCharcoal();

    public static void init(){
        GameRegistry.registerBlock(table,"Table");
        GameRegistry.registerBlock(boc,"boc");
    }
}
