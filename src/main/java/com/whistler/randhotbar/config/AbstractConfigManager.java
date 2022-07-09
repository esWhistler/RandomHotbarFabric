package com.whistler.randhotbar.config;

public abstract class AbstractConfigManager {
    protected double[] stringToDoubleArray(String string){
        String[] stringedDoubleArray = string.split(",");
        double[] doubleArray = new double[stringedDoubleArray.length];
        for (int i = 0; i < stringedDoubleArray.length; i++) {
            doubleArray[i] = Double.parseDouble(stringedDoubleArray[i]);
        }
        return doubleArray;
    }

    protected String doubleArrayToString(double[] doubleArray){
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < doubleArray.length - 1; i++){
            string.append(doubleArray[i]).append(",");
        }
        string.append(doubleArray[doubleArray.length - 1]);
        return string.toString();
    }
}
