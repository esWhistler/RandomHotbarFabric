package com.whistler.randhotbar.config;

import com.whistler.randhotbar.RandHotbar;
import com.whistler.randhotbar.util.UtilFunctions;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.TranslatableText;


public class WorldConfigScreen {

    public void openConfigScreen(Screen parent){
        Screen configScreen = buildScreen(parent, false);
        RandHotbar.MINECRAFT.setScreen(configScreen);
    }

    public Screen buildScreen(Screen parent, boolean warning) {
        if (warning){

        }

        double[] hotbarChance = UtilFunctions.readHotbarChance();
        
        ConfigBuilder builder = ConfigBuilder.create()
                .setParentScreen(parent)
                .setTitle(new TranslatableText("config." + RandHotbar.MOD_ID + ".title"));

        ConfigCategory general = builder.getOrCreateCategory(new TranslatableText("config." + RandHotbar.MOD_ID + ".category"));

        ConfigEntryBuilder entryBuilder = builder.entryBuilder();

        general.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar0"), hotbarChance[0])
                .setDefaultValue(0.11)
                .setSaveConsumer(newValue -> hotbarChance[0] = newValue)
                .build()
        );

        general.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar1"), hotbarChance[1])
                .setDefaultValue(0.11)
                .setSaveConsumer(newValue -> hotbarChance[1] = newValue)
                .build()
        );

        general.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar2"), hotbarChance[2])
                .setDefaultValue(0.11)
                .setSaveConsumer(newValue -> hotbarChance[2] = newValue)
                .build()
        );

        general.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar3"), hotbarChance[3])
                .setDefaultValue(0.11)
                .setSaveConsumer(newValue -> hotbarChance[3] = newValue)
                .build()
        );

        general.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar4"), hotbarChance[4])
                .setDefaultValue(0.11)
                .setSaveConsumer(newValue -> hotbarChance[4] = newValue)
                .build()
        );

        general.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar5"), hotbarChance[5])
                .setDefaultValue(0.11)
                .setSaveConsumer(newValue -> hotbarChance[5] = newValue)
                .build()
        );

        general.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar6"), hotbarChance[6])
                .setDefaultValue(0.11)
                .setSaveConsumer(newValue -> hotbarChance[6] = newValue)
                .build()
        );

        general.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar7"), hotbarChance[7])
                .setDefaultValue(0.11)
                .setSaveConsumer(newValue -> hotbarChance[7] = newValue)
                .build()
        );

        general.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar8"), hotbarChance[8])
                .setDefaultValue(0.11)
                .setSaveConsumer(newValue -> hotbarChance[8] = newValue)
                .build()
        );

        builder.setSavingRunnable(() -> {
            double totalPercentage = UtilFunctions.writeHotbarChance(hotbarChance);
            if (totalPercentage != 100.0){
                Screen configScreen = buildScreen(parent, true);
                RandHotbar.MINECRAFT.setScreen(configScreen);
            }
        });


        return builder.build();
    }
}

