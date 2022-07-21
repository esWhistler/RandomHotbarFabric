package com.whistler.randhotbar.gui.screen;

import com.whistler.randhotbar.RandHotbar;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.TranslatableText;

import java.io.IOException;

public class ConfigScreenNoPresets { //Amecs not present

    public static Screen buildScreen(Screen parent) throws IOException {

        double[] currentConfig = RandHotbar.configManager.readConfigs("default");

        ConfigBuilder builder = ConfigBuilder.create()
                .setParentScreen(parent)
                .setTitle(new TranslatableText("config." + RandHotbar.MOD_ID + ".title"));

        ConfigCategory category = builder.getOrCreateCategory(new TranslatableText("config." + RandHotbar.MOD_ID + ".category." + "default"));

        ConfigEntryBuilder entryBuilder = builder.entryBuilder();

        for (int h = 0; h < 9; ++h) { //hotbar N°
            int finalH = h;
            category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar" + h), currentConfig[h])
                    .setDefaultValue(0)
                    .setMin(0)
                    .setMax(100)
                    .setSaveConsumer(newValue -> currentConfig[finalH] = newValue)
                    .build()
                );
            }

        builder.setSavingRunnable(() -> {
            try {
                RandHotbar.configManager.saveDefault(currentConfig);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        return builder.build();
    }
}
