package com.whistler.randhotbar.config;

import java.io.IOException;
import java.util.Properties;

public class ModConfigs {

    public static double[] HOTBAR = new double[9];

    public static void registerDefaultConfigs() throws IOException {
        Properties props = new Properties();
        props.setProperty("hotbar.chances", "11.12,11.11,11.11,11.11,11.11,11.11,11.11,11.11,11.11");
        ConfigFile.create("./config/randhotbarDefault.properties", props, "Hotbar Randomizer Default Settings");

        HOTBAR = stringToDoubleArray(ConfigFile.read("hotbar.chances"));
    }

    public static void saveDefaultConfigs() throws IOException {
        Properties props = new Properties();
        props.setProperty("hotbar.chances", doubleArrayToString(HOTBAR));
        ConfigFile.update(props, "Hotbar Randomizer Default Settings");
    }

    private static double[] stringToDoubleArray(String string){
        String[] stringedDoubleArray = string.split(",");
        double[] doubleArray = new double[stringedDoubleArray.length];
        for (int i = 0; i < stringedDoubleArray.length; i++) {
            doubleArray[i] = Double.parseDouble(stringedDoubleArray[i]);
        }
        return doubleArray;
    }

    private static String doubleArrayToString(double[] doubleArray){
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < doubleArray.length - 1; i++){
            string.append(doubleArray[i]).append(",");
        }
        string.append(doubleArray[doubleArray.length - 1]);
        return string.toString();
    }
}