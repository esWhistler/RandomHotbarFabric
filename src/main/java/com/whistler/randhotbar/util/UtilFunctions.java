package com.whistler.randhotbar.util;

import com.whistler.randhotbar.RandHotbar;
import net.minecraft.client.MinecraftClient;

public abstract class UtilFunctions {
    public static void randomizeHotbar(){
        double[] hotbarchance = readHotbarChance();

        double totalWeight = 0.0;
        for (double d : hotbarchance) {
            totalWeight += d;
        }

        int result = 0;
        for (double random = Math.random() * totalWeight; result < 8; ++result) {
            random -= hotbarchance[result];
            if (random <= 0.0) break;
        }

        assert RandHotbar.MINECRAFT.player != null;
        RandHotbar.MINECRAFT.player.getInventory().selectedSlot = result;
    }

    //returns the sum of all chances to check if it adds up to 100%
    public static double writeHotbarChance(double[] hotbarChance){
        //there is no NBTdoubleArray, so I'm saving it as an NBTintArray.
        //multiplying by 100 before to keep two decimals.
        int[] defaultHotbarChanceInt = new int[9];
        for (int i = 0; i < 9; ++i) {
            defaultHotbarChanceInt[i] = (int) Math.round(hotbarChance[i] * 100);
        }
        assert MinecraftClient.getInstance().player != null;
        ((IEntityDataSaver)MinecraftClient.getInstance().player).getPersistentData().putIntArray("hotbarChanceArray", defaultHotbarChanceInt);
        double sum = 0;
        for (double chance : hotbarChance)
            sum += chance;
        return sum;
    }

    public static double[] readHotbarChance(){
        assert MinecraftClient.getInstance().player != null;
        int[] defaultHotbarChanceInt = ((IEntityDataSaver)MinecraftClient.getInstance().player).getPersistentData().getIntArray("hotbarChanceArray");
        double[] defaultHotbarChance = new double[9];
        for (int i = 0; i < 9; ++i) {
            defaultHotbarChance[i] = ((double)defaultHotbarChanceInt[i])/100;
        }
        return defaultHotbarChance;
    }

}
