package com.whistler.randhotbar.config;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

public class ConfigManager extends AbstractConfigManager {
    private final String COMMENT = "Hotbar Randomizer Settings";
    private final String DEFAULT_VALUES = "11.2,11.1,11.1,11.1,11.1,11.1,11.1,11.1,11.1";
    private final String[] CONFIG_TYPES = {"default", "preset1", "preset2", "preset3", "preset4", "preset5", "preset6", "preset7", "preset8", "preset9"};

    private final ConfigFile config;

    public ConfigManager() throws Exception {
        String configPath = "./config/randHotbar.properties";
        config = new ConfigFile(configPath);

        if(! new File(configPath).isFile()){
            Properties props = new Properties();
            props.setProperty("lastUsed", "default");
            for(int i = 0; i < 10; ++i){
                props.setProperty(i == 0 ? "default" : "preset" + i, DEFAULT_VALUES);
            }
            config.write(props, COMMENT);
        }
    }

    public double[] readConfigs(String type) throws IOException {
        if (Arrays.asList(CONFIG_TYPES).contains(type)){
            String stringedArray = this.config.read(type);
            return stringToDoubleArray(stringedArray);
        } else {
            throw new IOException("Config type doesn't exist");
        }
    }

    public void saveDefault(double[] configs) throws IOException {
        Properties props = this.config.getProperties();
        props.setProperty("default", doubleArrayToString(configs));
        this.config.write(props, COMMENT);
    }

    public void saveAll(double[][] allConfigs) throws IOException {
        Properties props = this.config.getProperties();
        for(int i = 0; i < 10; ++i){
            props.setProperty(i == 0 ? "default" : "preset" + i, doubleArrayToString(allConfigs[i]));
        }
        this.config.write(props, COMMENT);
    }

    public void setLastUsed(String type) throws IOException {
        Properties props = this.config.getProperties();
        props.setProperty("lastUsed", type);
        this.config.write(props, COMMENT);
    }

    public String getLastUsed() throws IOException {
        return this.config.read("lastUsed");
    }

}