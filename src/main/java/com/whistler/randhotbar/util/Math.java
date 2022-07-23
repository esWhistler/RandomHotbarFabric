package com.whistler.randhotbar.util;

public final class Math {
    public static int weighedRandomizer(double[] weights){
        double totalWeight = 0.0;
        for (double d : weights) {
            totalWeight += d;
        }

        int result = 0;

        for (double random = java.lang.Math.random() * totalWeight; result < weights.length - 1; ++result) {
            random -= weights[result];
            if (random <= 0.0) break;
        }

        return result;
    }
}
