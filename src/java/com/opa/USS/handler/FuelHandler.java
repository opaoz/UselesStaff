package com.opa.USS.handler;

import com.opa.USS.init.ModBlocks;
import com.opa.USS.init.ModItems;
import com.opa.USS.util.Log;
import cpw.mods.fml.common.IFuelHandler;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;

public class FuelHandler implements IFuelHandler {
    @Override
    public int getBurnTime(ItemStack fuel) {
        Item item = fuel.getItem();
        Item charcoal = Item.getItemFromBlock(ModBlocks.boc);
        if (item == charcoal)
        {
            return 9 * TileEntityFurnace.getItemBurnTime(new ItemStack(Items.coal));
        }else if (item == ModItems.bd) return 0;
        return 0;
    }
}
