package com.whistler.randhotbar.config;

import com.whistler.randhotbar.RandHotbar;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.TranslatableText;

import java.io.IOException;


public class ConfigScreenWithPresets { //Amecs present

    public static Screen buildScreen(Screen parent) throws IOException {

        double[][] currentConfigs = new double[10][9];
        for (int i = 0; i < 10; ++i) {
            currentConfigs[i] = RandHotbar.configManager.readConfigs(i == 0 ? "default" : "preset" + i);
        }

        ConfigBuilder builder = ConfigBuilder.create()
                .setParentScreen(parent)
                .setTitle(new TranslatableText("config." + RandHotbar.MOD_ID + ".title"));

        ConfigCategory[] categories = new ConfigCategory[10];
        for (int i = 0; i < 10; ++i) { //preset category N° ("preset0" is "default")
            categories[i] = builder.getOrCreateCategory(new TranslatableText("config." + RandHotbar.MOD_ID + ".category." + (i == 0 ? "default" : "preset" + i)));
        }

        ConfigEntryBuilder entryBuilder = builder.entryBuilder();

        for (int i = 0; i < 10; ++i) { //preset category N° ("preset0" is "default")
            for (int h = 0; h < 9; ++h) { //hotbar N°
                int finalI = i;
                int finalH = h;
                categories[i].addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar" + h), currentConfigs[i][h])
                        .setDefaultValue(0)
                        .setMin(0)
                        .setMax(100)
                        .setSaveConsumer(newValue -> currentConfigs[finalI][finalH] = newValue)
                        .build()
                );
            }
        }

        builder.setSavingRunnable(() -> {
            try {
                RandHotbar.configManager.saveAll(currentConfigs);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        return builder.build();
    }
}
