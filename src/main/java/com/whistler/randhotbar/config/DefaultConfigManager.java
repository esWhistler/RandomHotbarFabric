package com.whistler.randhotbar.config;

import net.minecraft.server.MinecraftServer;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class DefaultConfigManager extends AbstractConfigManager {
    private final String comment = "Hotbar Randomizer Default Settings";

    private final ConfigFile defaultConfig;

    public DefaultConfigManager() throws IOException {
        String filePath = "./config/randHotbar/randhotbarDefault.properties";
        defaultConfig = new ConfigFile(filePath);

        if(! new File(filePath).isFile()){
            Properties props = new Properties();
            props.setProperty("hotbar.chances", "11.12,11.11,11.11,11.11,11.11,11.11,11.11,11.11,11.11");
            defaultConfig.write(props, comment);
        }
    }

    public void saveConfigs(double[] configs) throws IOException {
        Properties props = new Properties();
        props.setProperty("hotbar.chances", doubleArrayToString(configs));
        this.defaultConfig.write(props, comment);
    }

    public double[] readConfigs() throws IOException {
        String stringedArray = this.defaultConfig.read("hotbar.chances");
        return stringToDoubleArray(stringedArray);
    }

}