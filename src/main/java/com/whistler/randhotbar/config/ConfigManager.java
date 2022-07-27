package com.whistler.randhotbar.config;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

public class ConfigManager {
    private final String COMMENT = "Hotbar Randomizer Settings";
    private final String DEFAULT_VALUES = "11.2,11.1,11.1,11.1,11.1,11.1,11.1,11.1,11.1";
    private final String[] CONFIG_TYPES = {"default", "preset1", "preset2", "preset3", "preset4", "preset5", "preset6", "preset7", "preset8", "preset9"};

    private final ConfigFile config;

    public ConfigManager() throws Exception {
        String configPath = "./config/randHotbar.properties";
        config = new ConfigFile(configPath);

        Properties defaultProperties = new Properties();
        defaultProperties.setProperty("lastUsed", "default");
        for(int i = 0; i < 10; ++i){
            defaultProperties.setProperty(CONFIG_TYPES[i], DEFAULT_VALUES);
        }

        Properties props = new Properties(defaultProperties);

        if (new File(configPath).isFile()) {
            Properties old = config.getProperties();
            props.setProperty("lastUsed", old.getProperty("lastUsed", "default"));
            for(int i = 0; i < 10; ++i){
                String type = CONFIG_TYPES[i];
                props.setProperty(type, old.getProperty(type, DEFAULT_VALUES));
            }
        }
        config.write(props, COMMENT);
    }

    public double[] readConfigs(String type) throws IOException {
        if (Arrays.asList(CONFIG_TYPES).contains(type)){
            String stringedArray = this.config.read(type, DEFAULT_VALUES);
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
        return this.config.read("lastUsed", "default");
    }


    private double[] stringToDoubleArray(String string){
        String[] stringedDoubleArray = string.split(",");
        double[] doubleArray = new double[stringedDoubleArray.length];
        for (int i = 0; i < stringedDoubleArray.length; i++) {
            doubleArray[i] = Double.parseDouble(stringedDoubleArray[i]);
        }
        return doubleArray;
    }

    private String doubleArrayToString(double[] doubleArray){
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < doubleArray.length - 1; i++){
            string.append(doubleArray[i]).append(",");
        }
        string.append(doubleArray[doubleArray.length - 1]);
        return string.toString();
    }
}