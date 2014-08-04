package com.opa.USS.items.tools;

import com.opa.USS.creativeTab.JustTab;
import com.opa.USS.init.ModItems;
import com.opa.USS.reference.Reference;
import com.opa.USS.util.NBT;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;


public class BurnedAxe extends ItemAxe {

    public BurnedAxe(ToolMaterial material) {
        super(material);
        this.setUnlocalizedName(Reference.BurnedAxe);
        this.setCreativeTab(JustTab.USS_TAB);
    }
    @Override
    public String getUnlocalizedName()
    {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));

    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack,EntityPlayer player, List dataList, boolean b){
        boolean nbt = NBT.getBoolean(itemStack, "Status");
        String str = nbt==true? "Smelting" : "No smelting";

        dataList.add("Status: "+ str);
    }

    public ItemStack onItemRightClick(ItemStack itemStack,World world,EntityPlayer player){
        boolean nbt = true;
        if(NBT.getBoolean(itemStack, "Status")){
            nbt = false;
        }
        NBT.setBoolean(itemStack,"Status",nbt);

        return itemStack;
    }

    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack par1ItemStack){
        return ModItems.rarity;
    }
}
