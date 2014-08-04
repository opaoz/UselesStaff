package com.opa.USS.creativeTab;

import com.opa.USS.init.ModItems;
import com.opa.USS.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class JustTab {

    public static final CreativeTabs USS_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase()) {
        @Override
        public Item getTabIconItem() {
            return ModItems.bd;
        }
    };
}
