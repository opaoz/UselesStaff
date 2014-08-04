package com.opa.USS.handler;


import com.opa.USS.reference.Reference;
import com.opa.USS.util.Log;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigurationHandler {

    public static Configuration conf;
    public static boolean enable = true;

    public static void init(File configFile){
       if(conf == null) {
           conf = new Configuration(configFile);
           Log.info("Create File");
           loadConfiguration();
       }
    }

    @SubscribeEvent
    public void onConfigurationChangeEvent(ConfigChangedEvent.OnConfigChangedEvent event){
        if(event.modID.equalsIgnoreCase(Reference.MOD_ID)){
            //Resync configs
            Log.info("Change config");
            loadConfiguration();
        }
    }

    private static void loadConfiguration(){
        enable = conf.getBoolean("enable", Configuration.CATEGORY_GENERAL, false, "Fuck It!");

        if (conf.hasChanged()){
            conf.save();
            Log.info("Save file");
        }
    }
}
