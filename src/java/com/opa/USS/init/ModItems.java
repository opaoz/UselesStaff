package com.opa.USS.init;

import com.opa.USS.items.BlackDye;
import com.opa.USS.items.BurnedHead;
import com.opa.USS.items.tools.BurnedAxe;
import com.opa.USS.items.tools.BurnedPickaxe;
import com.opa.USS.items.JustItem;
import com.opa.USS.items.tools.BurnedShovel;
import com.opa.USS.items.tools.BurnedSword;
import com.opa.USS.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.*;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems {

    static Item.ToolMaterial burn = EnumHelper.addToolMaterial("BurnedHead", 3, 2000, 13.0F, 6.0F, 20);
    public static EnumRarity rarity = EnumHelper.addRarity("burned", EnumChatFormatting.DARK_RED, "burned");

    public static final JustItem bd = new BlackDye();
    public static final Item burnHead = new BurnedHead();
    public static final ItemPickaxe burnPick = new BurnedPickaxe(burn);
    public static final ItemSpade burnShovel = new BurnedShovel(burn);
    public static final ItemAxe burnAxe = new BurnedAxe(burn);
    public static final ItemSword burnSword = new BurnedSword(burn);

    public static void init(){
        GameRegistry.registerItem(bd, "Bottle");
        OreDictionary.registerOre("dyeBlack", bd);
        GameRegistry.registerItem(burnHead, "BurnedHead");
        GameRegistry.registerItem(burnPick, Reference.BurnedPickaxe);
        GameRegistry.registerItem(burnAxe, Reference.BurnedAxe);
        GameRegistry.registerItem(burnShovel, Reference.BurnedShovel);
        GameRegistry.registerItem(burnSword, Reference.BurnedSword);
    }
}
