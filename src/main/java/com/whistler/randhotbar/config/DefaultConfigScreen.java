package com.whistler.randhotbar.config;

import com.whistler.randhotbar.RandHotbar;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.TranslatableText;

import java.io.IOException;


public class DefaultConfigScreen {

    public static Screen buildScreen(Screen parent) throws IOException {
        double[] currentDefaultConfigs = RandHotbar.defaultConfigManager.readConfigs();

        ConfigBuilder builder = ConfigBuilder.create()
                .setParentScreen(parent)
                .setTitle(new TranslatableText("config." + RandHotbar.MOD_ID + ".default.title"));

        ConfigCategory general = builder.getOrCreateCategory(new TranslatableText("config." + RandHotbar.MOD_ID + ".category"));

        ConfigEntryBuilder entryBuilder = builder.entryBuilder();

        general.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar0"), currentDefaultConfigs[0])
                .setDefaultValue(0.11)
                .setSaveConsumer(newValue -> currentDefaultConfigs[0] = newValue)
                .build()
        );

        general.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar1"), currentDefaultConfigs[1])
                .setDefaultValue(0.11)
                .setSaveConsumer(newValue -> currentDefaultConfigs[1] = newValue)
                .build()
        );

        general.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar2"), currentDefaultConfigs[2])
                .setDefaultValue(0.11)
                .setSaveConsumer(newValue -> currentDefaultConfigs[2] = newValue)
                .build()
        );

        general.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar3"), currentDefaultConfigs[3])
                .setDefaultValue(0.11)
                .setSaveConsumer(newValue -> currentDefaultConfigs[3] = newValue)
                .build()
        );

        general.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar4"), currentDefaultConfigs[4])
                .setDefaultValue(0.11)
                .setSaveConsumer(newValue -> currentDefaultConfigs[4] = newValue)
                .build()
        );

        general.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar5"), currentDefaultConfigs[5])
                .setDefaultValue(0.11)
                .setSaveConsumer(newValue -> currentDefaultConfigs[5] = newValue)
                .build());

        general.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar6"), currentDefaultConfigs[6])
                .setDefaultValue(0.11)
                .setSaveConsumer(newValue -> currentDefaultConfigs[6] = newValue)
                .build()
        );

        general.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar7"), currentDefaultConfigs[7])
                .setDefaultValue(0.11)
                .setSaveConsumer(newValue -> currentDefaultConfigs[7] = newValue)
                .build()
        );

        general.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar8"), currentDefaultConfigs[8])
                .setDefaultValue(0.11)
                .setSaveConsumer(newValue -> currentDefaultConfigs[8] = newValue)
                .build()
        );

        builder.setSavingRunnable(() -> {
                    try {
                        RandHotbar.defaultConfigManager.saveConfigs(currentDefaultConfigs);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
        });

        return builder.build();
    }
}
