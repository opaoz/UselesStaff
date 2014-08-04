package com.opa.USS.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class Recipes {
    public static void init(){
        //Tools recipes
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.bd),"s","g","m",'s',Items.flint,'g',Items.coal,'m',Items.bowl));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.burnPick),"psp", "cmc", "frf", 'p',Items.blaze_powder,'s',new ItemStack(ModItems.burnHead,1,0),'c',Items.magma_cream,'m',Items.lava_bucket,'r',Items.blaze_rod,'f',Items.flint_and_steel));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.burnAxe),"psp", "cmc", "frf", 'p',Items.blaze_powder,'s',new ItemStack(ModItems.burnHead,1,2),'c',Items.magma_cream,'m',Items.lava_bucket,'r',Items.blaze_rod,'f',Items.flint_and_steel));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.burnShovel),"psp", "cmc", "frf", 'p',Items.blaze_powder,'s',new ItemStack(ModItems.burnHead,1,1),'c',Items.magma_cream,'m',Items.lava_bucket,'r',Items.blaze_rod,'f',Items.flint_and_steel));

        //Add enchantment
        ItemStack itemStack = new ItemStack(ModItems.burnSword);
        itemStack.addEnchantment(Enchantment.fireAspect,3);
        GameRegistry.addRecipe(new ShapedOreRecipe(itemStack,"psp", "cmc", "frf", 'p',Items.blaze_powder,'s',new ItemStack(ModItems.burnHead,1,3),'c',Items.magma_cream,'m',Items.lava_bucket,'r',Items.blaze_rod,'f',Items.flint_and_steel));

        //Basic recipes
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.boc), new ItemStack(Items.coal, 1, 1), new ItemStack(Items.coal, 1, 1), new ItemStack(Items.coal, 1, 1), new ItemStack(Items.coal, 1, 1), new ItemStack(Items.coal, 1, 1), new ItemStack(Items.coal, 1, 1), new ItemStack(Items.coal, 1, 1), new ItemStack(Items.coal, 1, 1), new ItemStack(Items.coal, 1, 1));
        //Smelting recipes
        GameRegistry.addSmelting(new ItemStack(Items.diamond_pickaxe,1,0),new ItemStack(ModItems.burnHead,1,0),10.0f);
        GameRegistry.addSmelting(new ItemStack(Items.diamond_shovel,1,0),new ItemStack(ModItems.burnHead,1,1),10.0f);
        GameRegistry.addSmelting(new ItemStack(Items.diamond_axe,1,0),new ItemStack(ModItems.burnHead,1,2),10.0f);
        GameRegistry.addSmelting(new ItemStack(Items.diamond_sword,1,0),new ItemStack(ModItems.burnHead,1,3),10.0f);
        GameRegistry.addSmelting(new ItemStack(Blocks.cobblestone),new ItemStack(Blocks.gravel),10.0f);
    }
}
