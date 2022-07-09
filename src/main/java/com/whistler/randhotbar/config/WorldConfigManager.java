package com.whistler.randhotbar.config;

import com.google.common.collect.Maps;
import net.minecraft.server.MinecraftServer;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public class WorldConfigManager extends AbstractConfigManager {
    private String filePath(String worldName){ return  "./config/randHotbar/" + worldName + "/randhotbar.properties"; }

    private Map<String, ConfigFile> configFileMap;

    public WorldConfigManager(){
        configFileMap = Maps.newHashMap();
        for (final File fileEntry : Objects.requireNonNull(new File("./config/randHotbar").listFiles())) {
            if (fileEntry.isDirectory()) {
                configFileMap.put(fileEntry.getName(), new ConfigFile(filePath(fileEntry.getName())));
            }
        }
    }

    public void saveConfigs(MinecraftServer server, double[] configs) throws IOException {
        configFileMap.put(server.getName(), new ConfigFile(filePath(server.getName())));
        Properties props = new Properties();
        props.setProperty("hotbar.chances", doubleArrayToString(configs));
        this.configFileMap.get(server.getName()).write(props, "Hotbar Randomizer Settings");
    }

    public double[] readConfigs(MinecraftServer server) throws IOException {
        String stringedArray = this.configFileMap.get(server.getName()).read("hotbar.chances");
        return stringToDoubleArray(stringedArray);
    }
}
