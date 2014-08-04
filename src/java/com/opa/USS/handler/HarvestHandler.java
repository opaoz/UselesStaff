package com.opa.USS.handler;

import com.opa.USS.init.ModItems;
import com.opa.USS.util.NBT;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;

import java.util.Random;


public class HarvestHandler {

    public boolean valid(Block one){
        Block blocks[] = {Blocks.iron_ore,Blocks.gold_ore,Blocks.netherrack,Blocks.cobblestone,Blocks.stone,Blocks.sand,Blocks.clay,Blocks.log,Blocks.log2,Blocks.gravel};
        for (int i=0;i<blocks.length;i++) if (one == blocks[i]) return true;
        return false;
    }

    public Item equal(Block one){
        Block blocks[] = {Blocks.iron_ore,Blocks.gold_ore,Blocks.netherrack};
        Item items[] = {Items.iron_ingot,Items.gold_ingot,Items.netherbrick};

        for(int i=0;i<3;i++) if(one == blocks[i]) return items[i];

        return Item.getItemFromBlock(Blocks.stone);
    }

    @SubscribeEvent
    public void smeltDropsEvent(BlockEvent.HarvestDropsEvent event) {
        if (event.harvester != null) {
            if (valid(event.block)) {

                ItemStack tool = event.harvester.getCurrentEquippedItem();
                //burning by tool
                if (tool.getItem() == ModItems.burnPick && NBT.getBoolean(tool, "Status")) {

                    int enchLevel = EnchantmentHelper.getEnchantmentLevel(Enchantment.fortune.effectId,tool);
                    Item drop = equal(event.block);

                    event.drops.clear();

                    if (enchLevel <= 1 || drop == Item.getItemFromBlock(Blocks.stone) || drop == Item.getItemFromBlock(Blocks.cobblestone)) {
                        event.drops.add(new ItemStack(drop));
                    }
                    else{
                        Random rand = new Random();
                        int m = rand.nextInt(enchLevel)+1;
                        for (int k=0;k<m;k++){
                            event.drops.add(new ItemStack(drop));
                        }
                    }

                }
                //burning by shovel
                if(tool.getItem() == ModItems.burnShovel && NBT.getBoolean(tool, "Status")){
                    if(event.block == Blocks.sand){
                        event.drops.clear();
                        event.drops.add(new ItemStack(Blocks.glass));
                    }

                    if(event.block == Blocks.gravel){
                        event.drops.clear();
                        event.drops.add(new ItemStack(Blocks.cobblestone));
                    }

                    if(event.block == Blocks.clay){
                        int enchLevel = EnchantmentHelper.getEnchantmentLevel(Enchantment.silkTouch.effectId,tool);
                        event.drops.clear();
                        if(enchLevel>0){
                            event.drops.add(new ItemStack(Blocks.hardened_clay));
                        }else event.drops.add(new ItemStack(Items.brick,4));
                    }
                }
                //burning by axe
                if(tool.getItem() == ModItems.burnAxe && NBT.getBoolean(tool, "Status")){
                    if(event.block == Blocks.log){
                        event.drops.clear();
                        event.drops.add(new ItemStack(Items.coal,1,1));
                    }
                    if(event.block == Blocks.log2){
                        event.drops.clear();
                        event.drops.add(new ItemStack(Items.coal,1,1));
                    }
                }
            }
        }
    }
}
