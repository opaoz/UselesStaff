package com.opa.USS.items;

import com.opa.USS.creativeTab.JustTab;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;

public class BurnedHead extends JustItem{
    private IIcon shovel;
    private IIcon pickaxe;
    private IIcon axe;
    private IIcon sword;

    public BurnedHead(){
        super();
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.setCreativeTab(JustTab.USS_TAB);
    }

    public String getUnlocalizedName(ItemStack itemStack)
    {
       // return itemStack.getItemDamage() == 1 ? "item.uselesstaff:shovelHead" : "item.uselesstaff:pickaxeHead";
        switch (itemStack.getItemDamage()){
            case 0: return "item.uselesstaff:pickaxeHead";
            case 1: return "item.uselesstaff:shovelHead";
            case 2: return "item.uselesstaff:axeHead";
            case 3: return "item.uselesstaff:swordHead";
        }
        return "item.uselesstaff:pickaxeHead";
    }

    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs creativeTabs, List list)
    {
        list.add(new ItemStack(item, 1, 0));
        list.add(new ItemStack(item, 1, 1));
        list.add(new ItemStack(item, 1, 2));
        list.add(new ItemStack(item, 1, 3));
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int a)
    {
        switch (a){
            case 0: return this.pickaxe;
            case 1: return this.shovel;
            case 2: return this.axe;
            case 3: return this.sword;
        }
        return this.pickaxe;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        super.registerIcons(iconRegister);
        this.shovel = iconRegister.registerIcon(this.getUnlocalizedName(new ItemStack(this,1,1)).substring(this.getUnlocalizedName(new ItemStack(this,1,1)).indexOf(".") + 1));
        this.pickaxe = iconRegister.registerIcon(this.getUnlocalizedName(new ItemStack(this,1,0)).substring(this.getUnlocalizedName(new ItemStack(this,1,0)).indexOf(".") + 1));
        this.axe = iconRegister.registerIcon(this.getUnlocalizedName(new ItemStack(this,1,2)).substring(this.getUnlocalizedName(new ItemStack(this,1,0)).indexOf(".") + 1));
        this.sword = iconRegister.registerIcon(this.getUnlocalizedName(new ItemStack(this,1,3)).substring(this.getUnlocalizedName(new ItemStack(this,1,0)).indexOf(".") + 1));
    }
}
