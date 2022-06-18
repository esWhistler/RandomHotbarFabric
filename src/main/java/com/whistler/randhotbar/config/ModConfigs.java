package com.whistler.randhotbar.config;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Properties;

public class ModConfigs {

    public static double[] HOTBAR = new double[9];

    public static void registerConfigs() throws IOException {
        Properties props = new Properties();
        props.setProperty("hotbar.chances", "0.11,0.11,0.11,0.11,0.11,0.11,0.11,0.11,0.11");
        ConfigFile.create("./config/randhotbar.properties", props, "Hotbar Randomizer Settings");

        HOTBAR = stringToDoubleArray(ConfigFile.read("hotbar.chances"));
    }

    public static void saveConfigs() throws IOException {
        Properties props = new Properties();
        props.setProperty("hotbar.chances", doubleArrayToString(HOTBAR));
        ConfigFile.update(props, "Hotbar Randomizer Settings");
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
        String[] stringedDoubleArray = new String[doubleArray.length];
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < doubleArray.length - 1; i++){
            string.append(doubleArray[i]).append(",");
        }
        string.append(doubleArray[doubleArray.length - 1]);
        return string.toString();
    }
}