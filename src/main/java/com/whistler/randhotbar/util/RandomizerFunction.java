package com.whistler.randhotbar.util;

import com.whistler.randhotbar.config.ModConfigs;

import java.util.concurrent.ThreadLocalRandom;

import static com.whistler.randhotbar.RandHotbar.MINECRAFT;

public abstract class RandomizerFunction {
    public static void randomizeHotbar(){
        double[] hotbarchance = new double[9];

        hotbarchance[0] = ModConfigs.HOTBAR[0] * 100;
        hotbarchance[1] = ModConfigs.HOTBAR[1] * 100 + hotbarchance[0];
        hotbarchance[2] = ModConfigs.HOTBAR[2] * 100 + hotbarchance[1];
        hotbarchance[3] = ModConfigs.HOTBAR[3] * 100 + hotbarchance[2];
        hotbarchance[4] = ModConfigs.HOTBAR[4] * 100 + hotbarchance[3];
        hotbarchance[5] = ModConfigs.HOTBAR[5] * 100 + hotbarchance[4];
        hotbarchance[6] = ModConfigs.HOTBAR[6] * 100 + hotbarchance[5];
        hotbarchance[7] = ModConfigs.HOTBAR[7] * 100 + hotbarchance[6];
        hotbarchance[8] = ModConfigs.HOTBAR[8] * 100 + hotbarchance[7];

        int result = randomNum((int)hotbarchance[8]);


        if(hotbarchance[0] > 0 && result < hotbarchance[0]){
            assert MINECRAFT.player != null;
            MINECRAFT.player.getInventory().selectedSlot = 0;
            return;
        }

        for (int i = 1; i < 9; ++i){
            if(hotbarchance[i] > hotbarchance[i - 1] && result < hotbarchance[i]){
                assert MINECRAFT.player != null;
                MINECRAFT.player.getInventory().selectedSlot = i;
                return;
            }
        }
    }

    private static int randomNum(int max){
        return ThreadLocalRandom.current().nextInt(0, max + 1);
    }

}
