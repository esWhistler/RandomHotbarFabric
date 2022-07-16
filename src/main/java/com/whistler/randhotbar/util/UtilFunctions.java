package com.whistler.randhotbar.util;

public abstract class UtilFunctions {
    public static int weighedRandomizer(double[] weights){
        double totalWeight = 0.0;
        for (double d : weights) {
            totalWeight += d;
        }

        int result = 0;

        for (double random = Math.random() * totalWeight; result < weights.length - 1; ++result) {
            random -= weights[result];
            if (random <= 0.0) break;
        }

        return result;
    }
}
