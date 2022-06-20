package com.whistler.randhotbar.config;

import com.whistler.randhotbar.RandHotbar;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.TranslatableText;

import java.io.IOException;


public class ConfigScreen {

    public static void openConfigScreen(Screen parent){
        Screen configScreen = buildScreen(parent);

        RandHotbar.MINECRAFT.setScreen(configScreen);
    }

    public static Screen buildScreen(Screen parent) {
        ConfigBuilder builder = ConfigBuilder.create()
                .setParentScreen(parent)
                .setTitle(new TranslatableText("config." + RandHotbar.MOD_ID + ".title"));

        ConfigCategory general = builder.getOrCreateCategory(new TranslatableText("config." + RandHotbar.MOD_ID + ".category"));

        ConfigEntryBuilder entryBuilder = builder.entryBuilder();

        general.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar0"), ModConfigs.HOTBAR[0])
                .setDefaultValue(0.11)
                .setSaveConsumer(newValue -> ModConfigs.HOTBAR[0] = newValue)
                .build());

        general.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar1"), ModConfigs.HOTBAR[1])
                .setDefaultValue(0.11)
                .setSaveConsumer(newValue -> ModConfigs.HOTBAR[1] = newValue)
                .build());

        general.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar2"), ModConfigs.HOTBAR[2])
                .setDefaultValue(0.11)
                .setSaveConsumer(newValue -> ModConfigs.HOTBAR[2] = newValue)
                .build());

        general.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar3"), ModConfigs.HOTBAR[3])
                .setDefaultValue(0.11)
                .setSaveConsumer(newValue -> ModConfigs.HOTBAR[3] = newValue)
                .build());

        general.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar4"), ModConfigs.HOTBAR[4])
                .setDefaultValue(0.11)
                .setSaveConsumer(newValue -> ModConfigs.HOTBAR[4] = newValue)
                .build());

        general.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar5"), ModConfigs.HOTBAR[5])
                .setDefaultValue(0.11)
                .setSaveConsumer(newValue -> ModConfigs.HOTBAR[5] = newValue)
                .build());

        general.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar6"), ModConfigs.HOTBAR[6])
                .setDefaultValue(0.11)
                .setSaveConsumer(newValue -> ModConfigs.HOTBAR[6] = newValue)
                .build());

        general.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar7"), ModConfigs.HOTBAR[7])
                .setDefaultValue(0.11)
                .setSaveConsumer(newValue -> ModConfigs.HOTBAR[7] = newValue)
                .build());

        general.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar8"), ModConfigs.HOTBAR[8])
                .setDefaultValue(0.11)
                .setSaveConsumer(newValue -> ModConfigs.HOTBAR[8] = newValue)
                .build());

        builder.setSavingRunnable(() -> {
                    try {
                        ModConfigs.saveConfigs();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
        );

        return builder.build();
    }
}
