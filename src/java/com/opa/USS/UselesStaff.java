package com.opa.USS;

import com.opa.USS.handler.ConfigurationHandler;
import com.opa.USS.handler.FuelHandler;
import com.opa.USS.handler.HarvestHandler;
import com.opa.USS.init.ModBlocks;
import com.opa.USS.init.ModItems;
import com.opa.USS.init.Recipes;
import com.opa.USS.proxy.IProxy;
import com.opa.USS.reference.Reference;
import com.opa.USS.util.Log;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.world.BlockEvent;

@Mod(modid= Reference.MOD_ID, name = Reference.MOD_NAME,version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class UselesStaff {

    @Mod.Instance(Reference.MOD_ID)
    public static UselesStaff instance;

    @SidedProxy(clientSide = Reference.PROXY_CLIENT,serverSide = Reference.PROXY_SERVER)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
    //config, item, blocks
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());

        ModItems.init();
        ModBlocks.init();
        Log.info("Pre Init is Complete!");
    }

    @Mod.EventHandler
    public void Init(FMLInitializationEvent event){
    //gui, entity, recipes
        GameRegistry.registerFuelHandler(new FuelHandler());

        Recipes.init();

        MinecraftForge.EVENT_BUS.register(new HarvestHandler());
        FMLCommonHandler.instance().bus().register(new HarvestHandler());

        Log.info("Init is Complete!");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
    //"realy good staff"
        Log.info("Post Init is Complete!");
    }
}
