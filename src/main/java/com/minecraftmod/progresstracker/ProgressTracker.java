package com.minecraftmod.progresstracker;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.Arrays;

@Mod(modid = ProgressTracker.MODID, name = ProgressTracker.NAME, version = ProgressTracker.VERSION)
public class ProgressTracker {
    public static final String MODID = "progresstracker";
    public static final String NAME = "ProgressTracker";
    public static final String VERSION = "1.0";

    public static Logger logger;
    public Counter[] arr = {};
    public ArrayList<Counter> active_counter = new ArrayList<Counter>(Arrays.asList(arr));

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLServerStartingEvent event) {
        logger.info("initalise FMLServerStartingEvent :" + NAME);
        event.registerServerCommand(new TrackerCommand());
    }

}
