package com.whistler.randhotbar.config;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

public class ConfigManager extends AbstractConfigManager {
    private final String COMMENT = "Hotbar Randomizer Settings";
    private final String DEFAULT_VALUES = "11.12,11.11,11.11,11.11,11.11,11.11,11.11,11.11,11.11";
    private final String[] CONFIG_TYPES = {"default", "preset1", "preset2", "preset3", "preset4", "preset5", "preset6", "preset7", "preset8", "preset9"};

    private final ConfigFile config;

    public ConfigManager() throws Exception {
        String configPath = "./config/randHotbar.properties";
        config = new ConfigFile(configPath);

        if(! new File(configPath).isFile()){
            Properties props = new Properties();
            props.setProperty("lastUsed", "default");
            props.setProperty("default", DEFAULT_VALUES);
            props.setProperty("preset1", DEFAULT_VALUES);
            props.setProperty("preset2", DEFAULT_VALUES);
            props.setProperty("preset3", DEFAULT_VALUES);
            props.setProperty("preset4", DEFAULT_VALUES);
            props.setProperty("preset5", DEFAULT_VALUES);
            props.setProperty("preset6", DEFAULT_VALUES);
            props.setProperty("preset7", DEFAULT_VALUES);
            props.setProperty("preset8", DEFAULT_VALUES);
            props.setProperty("preset9", DEFAULT_VALUES);
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

    public void saveAll(double[][] allConfigs) throws IOException {
        Properties props = this.config.getProperties();
        props.setProperty("default", doubleArrayToString(allConfigs[0]));
        props.setProperty("preset1", doubleArrayToString(allConfigs[1]));
        props.setProperty("preset2", doubleArrayToString(allConfigs[2]));
        props.setProperty("preset3", doubleArrayToString(allConfigs[3]));
        props.setProperty("preset4", doubleArrayToString(allConfigs[4]));
        props.setProperty("preset5", doubleArrayToString(allConfigs[5]));
        props.setProperty("preset6", doubleArrayToString(allConfigs[6]));
        props.setProperty("preset7", doubleArrayToString(allConfigs[7]));
        props.setProperty("preset8", doubleArrayToString(allConfigs[8]));
        props.setProperty("preset9", doubleArrayToString(allConfigs[9]));
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