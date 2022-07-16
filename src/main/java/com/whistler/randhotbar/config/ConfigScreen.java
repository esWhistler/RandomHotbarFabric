package com.whistler.randhotbar.config;

import com.whistler.randhotbar.RandHotbar;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.TranslatableText;

import java.io.IOException;


public class ConfigScreen {

    public static Screen buildScreen(Screen parent) throws IOException {
        double[] currentDefaultConfigs = RandHotbar.configManager.readConfigs("default");
        double[] currentPreset1Configs = RandHotbar.configManager.readConfigs("preset1");
        double[] currentPreset2Configs = RandHotbar.configManager.readConfigs("preset2");
        double[] currentPreset3Configs = RandHotbar.configManager.readConfigs("preset3");
        double[] currentPreset4Configs = RandHotbar.configManager.readConfigs("preset4");
        double[] currentPreset5Configs = RandHotbar.configManager.readConfigs("preset5");
        double[] currentPreset6Configs = RandHotbar.configManager.readConfigs("preset6");
        double[] currentPreset7Configs = RandHotbar.configManager.readConfigs("preset7");
        double[] currentPreset8Configs = RandHotbar.configManager.readConfigs("preset8");
        double[] currentPreset9Configs = RandHotbar.configManager.readConfigs("preset9");

        ConfigBuilder builder = ConfigBuilder.create()
                .setParentScreen(parent)
                .setTitle(new TranslatableText("config." + RandHotbar.MOD_ID + ".title"));

        ConfigCategory defaultCategory = builder.getOrCreateCategory(new TranslatableText("config." + RandHotbar.MOD_ID + ".category.default"));
        ConfigCategory preset1Category = builder.getOrCreateCategory(new TranslatableText("config." + RandHotbar.MOD_ID + ".category.preset1"));
        ConfigCategory preset2Category = builder.getOrCreateCategory(new TranslatableText("config." + RandHotbar.MOD_ID + ".category.preset2"));
        ConfigCategory preset3Category = builder.getOrCreateCategory(new TranslatableText("config." + RandHotbar.MOD_ID + ".category.preset3"));
        ConfigCategory preset4Category = builder.getOrCreateCategory(new TranslatableText("config." + RandHotbar.MOD_ID + ".category.preset4"));
        ConfigCategory preset5Category = builder.getOrCreateCategory(new TranslatableText("config." + RandHotbar.MOD_ID + ".category.preset5"));
        ConfigCategory preset6Category = builder.getOrCreateCategory(new TranslatableText("config." + RandHotbar.MOD_ID + ".category.preset6"));
        ConfigCategory preset7Category = builder.getOrCreateCategory(new TranslatableText("config." + RandHotbar.MOD_ID + ".category.preset7"));
        ConfigCategory preset8Category = builder.getOrCreateCategory(new TranslatableText("config." + RandHotbar.MOD_ID + ".category.preset8"));
        ConfigCategory preset9Category = builder.getOrCreateCategory(new TranslatableText("config." + RandHotbar.MOD_ID + ".category.preset9"));

        ConfigEntryBuilder entryBuilder = builder.entryBuilder();

        defaultCategory.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar0"), currentDefaultConfigs[0])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentDefaultConfigs[0] = newValue)
                .build()
        );

        defaultCategory.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar1"), currentDefaultConfigs[1])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentDefaultConfigs[1] = newValue)
                .build()
        );

        defaultCategory.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar2"), currentDefaultConfigs[2])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentDefaultConfigs[2] = newValue)
                .build()
        );

        defaultCategory.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar3"), currentDefaultConfigs[3])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentDefaultConfigs[3] = newValue)
                .build()
        );

        defaultCategory.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar4"), currentDefaultConfigs[4])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentDefaultConfigs[4] = newValue)
                .build()
        );

        defaultCategory.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar5"), currentDefaultConfigs[5])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentDefaultConfigs[5] = newValue)
                .build());

        defaultCategory.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar6"), currentDefaultConfigs[6])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentDefaultConfigs[6] = newValue)
                .build()
        );

        defaultCategory.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar7"), currentDefaultConfigs[7])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentDefaultConfigs[7] = newValue)
                .build()
        );

        defaultCategory.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar8"), currentDefaultConfigs[8])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentDefaultConfigs[8] = newValue)
                .build()
        );

        preset1Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar0"), currentPreset1Configs[0])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset1Configs[0] = newValue)
                .build()
        );

        preset1Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar1"), currentPreset1Configs[1])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset1Configs[1] = newValue)
                .build()
        );

        preset1Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar2"), currentPreset1Configs[2])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset1Configs[2] = newValue)
                .build()
        );

        preset1Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar3"), currentPreset1Configs[3])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset1Configs[3] = newValue)
                .build()
        );

        preset1Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar4"), currentPreset1Configs[4])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset1Configs[4] = newValue)
                .build()
        );

        preset1Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar5"), currentPreset1Configs[5])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset1Configs[5] = newValue)
                .build());

        preset1Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar6"), currentPreset1Configs[6])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset1Configs[6] = newValue)
                .build()
        );

        preset1Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar7"), currentPreset1Configs[7])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset1Configs[7] = newValue)
                .build()
        );

        preset1Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar8"), currentPreset1Configs[8])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset1Configs[8] = newValue)
                .build()
        );

        preset2Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar0"), currentPreset2Configs[0])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset2Configs[0] = newValue)
                .build()
        );

        preset2Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar1"), currentPreset2Configs[1])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset2Configs[1] = newValue)
                .build()
        );

        preset2Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar2"), currentPreset2Configs[2])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset2Configs[2] = newValue)
                .build()
        );

        preset2Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar3"), currentPreset2Configs[3])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset2Configs[3] = newValue)
                .build()
        );

        preset2Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar4"), currentPreset2Configs[4])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset2Configs[4] = newValue)
                .build()
        );

        preset2Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar5"), currentPreset2Configs[5])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset2Configs[5] = newValue)
                .build());

        preset2Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar6"), currentPreset2Configs[6])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset2Configs[6] = newValue)
                .build()
        );

        preset2Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar7"), currentPreset2Configs[7])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset2Configs[7] = newValue)
                .build()
        );

        preset2Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar8"), currentPreset2Configs[8])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset2Configs[8] = newValue)
                .build()
        );

        preset3Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar0"), currentPreset3Configs[0])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset3Configs[0] = newValue)
                .build()
        );

        preset3Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar1"), currentPreset3Configs[1])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset3Configs[1] = newValue)
                .build()
        );

        preset3Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar2"), currentPreset3Configs[2])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset3Configs[2] = newValue)
                .build()
        );

        preset3Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar3"), currentPreset3Configs[3])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset3Configs[3] = newValue)
                .build()
        );

        preset3Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar4"), currentPreset3Configs[4])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset3Configs[4] = newValue)
                .build()
        );

        preset3Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar5"), currentPreset3Configs[5])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset3Configs[5] = newValue)
                .build());

        preset3Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar6"), currentPreset3Configs[6])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset3Configs[6] = newValue)
                .build()
        );

        preset3Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar7"), currentPreset3Configs[7])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset3Configs[7] = newValue)
                .build()
        );

        preset3Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar8"), currentPreset3Configs[8])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset3Configs[8] = newValue)
                .build()
        );

        preset4Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar0"), currentPreset4Configs[0])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset4Configs[0] = newValue)
                .build()
        );

        preset4Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar1"), currentPreset4Configs[1])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset4Configs[1] = newValue)
                .build()
        );

        preset4Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar2"), currentPreset4Configs[2])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset4Configs[2] = newValue)
                .build()
        );

        preset4Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar3"), currentPreset4Configs[3])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset4Configs[3] = newValue)
                .build()
        );

        preset4Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar4"), currentPreset4Configs[4])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset4Configs[4] = newValue)
                .build()
        );

        preset4Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar5"), currentPreset4Configs[5])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset4Configs[5] = newValue)
                .build());

        preset4Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar6"), currentPreset4Configs[6])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset4Configs[6] = newValue)
                .build()
        );

        preset4Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar7"), currentPreset4Configs[7])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset4Configs[7] = newValue)
                .build()
        );

        preset4Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar8"), currentPreset4Configs[8])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset4Configs[8] = newValue)
                .build()
        );

        preset5Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar0"), currentPreset5Configs[0])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset5Configs[0] = newValue)
                .build()
        );

        preset5Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar1"), currentPreset5Configs[1])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset5Configs[1] = newValue)
                .build()
        );

        preset5Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar2"), currentPreset5Configs[2])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset5Configs[2] = newValue)
                .build()
        );

        preset5Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar3"), currentPreset5Configs[3])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset5Configs[3] = newValue)
                .build()
        );

        preset5Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar4"), currentPreset5Configs[4])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset5Configs[4] = newValue)
                .build()
        );

        preset5Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar5"), currentPreset5Configs[5])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset5Configs[5] = newValue)
                .build());

        preset5Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar6"), currentPreset5Configs[6])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset5Configs[6] = newValue)
                .build()
        );

        preset5Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar7"), currentPreset5Configs[7])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset5Configs[7] = newValue)
                .build()
        );

        preset5Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar8"), currentPreset5Configs[8])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset5Configs[8] = newValue)
                .build()
        );

        preset6Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar0"), currentPreset6Configs[0])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset6Configs[0] = newValue)
                .build()
        );

        preset6Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar1"), currentPreset6Configs[1])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset6Configs[1] = newValue)
                .build()
        );

        preset6Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar2"), currentPreset6Configs[2])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset6Configs[2] = newValue)
                .build()
        );

        preset6Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar3"), currentPreset6Configs[3])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset6Configs[3] = newValue)
                .build()
        );

        preset6Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar4"), currentPreset6Configs[4])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset6Configs[4] = newValue)
                .build()
        );

        preset6Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar5"), currentPreset6Configs[5])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset6Configs[5] = newValue)
                .build());

        preset6Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar6"), currentPreset6Configs[6])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset6Configs[6] = newValue)
                .build()
        );

        preset6Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar7"), currentPreset6Configs[7])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset6Configs[7] = newValue)
                .build()
        );

        preset6Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar8"), currentPreset6Configs[8])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset6Configs[8] = newValue)
                .build()
        );

        preset7Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar0"), currentPreset7Configs[0])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset7Configs[0] = newValue)
                .build()
        );

        preset7Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar1"), currentPreset7Configs[1])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset7Configs[1] = newValue)
                .build()
        );

        preset7Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar2"), currentPreset7Configs[2])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset7Configs[2] = newValue)
                .build()
        );

        preset7Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar3"), currentPreset7Configs[3])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset7Configs[3] = newValue)
                .build()
        );

        preset7Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar4"), currentPreset7Configs[4])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset7Configs[4] = newValue)
                .build()
        );

        preset7Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar5"), currentPreset7Configs[5])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset7Configs[5] = newValue)
                .build());

        preset7Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar6"), currentPreset7Configs[6])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset7Configs[6] = newValue)
                .build()
        );

        preset7Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar7"), currentPreset7Configs[7])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset7Configs[7] = newValue)
                .build()
        );

        preset7Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar8"), currentPreset7Configs[8])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset7Configs[8] = newValue)
                .build()
        );

        preset8Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar0"), currentPreset8Configs[0])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset8Configs[0] = newValue)
                .build()
        );

        preset8Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar1"), currentPreset8Configs[1])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset8Configs[1] = newValue)
                .build()
        );

        preset8Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar2"), currentPreset8Configs[2])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset8Configs[2] = newValue)
                .build()
        );

        preset8Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar3"), currentPreset8Configs[3])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset8Configs[3] = newValue)
                .build()
        );

        preset8Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar4"), currentPreset8Configs[4])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset8Configs[4] = newValue)
                .build()
        );

        preset8Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar5"), currentPreset8Configs[5])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset8Configs[5] = newValue)
                .build());

        preset8Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar6"), currentPreset8Configs[6])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset8Configs[6] = newValue)
                .build()
        );

        preset8Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar7"), currentPreset8Configs[7])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset8Configs[7] = newValue)
                .build()
        );

        preset8Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar8"), currentPreset8Configs[8])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset8Configs[8] = newValue)
                .build()
        );

        preset9Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar0"), currentPreset9Configs[0])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset9Configs[0] = newValue)
                .build()
        );

        preset9Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar1"), currentPreset9Configs[1])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset9Configs[1] = newValue)
                .build()
        );

        preset9Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar2"), currentPreset9Configs[2])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset9Configs[2] = newValue)
                .build()
        );

        preset9Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar3"), currentPreset9Configs[3])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset9Configs[3] = newValue)
                .build()
        );

        preset9Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar4"), currentPreset9Configs[4])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset9Configs[4] = newValue)
                .build()
        );

        preset9Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar5"), currentPreset9Configs[5])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset9Configs[5] = newValue)
                .build());

        preset9Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar6"), currentPreset9Configs[6])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset9Configs[6] = newValue)
                .build()
        );

        preset9Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar7"), currentPreset9Configs[7])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset9Configs[7] = newValue)
                .build()
        );

        preset9Category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar8"), currentPreset9Configs[8])
                .setDefaultValue(0)
                .setMin(0)
                .setMax(100)
                .setSaveConsumer(newValue -> currentPreset9Configs[8] = newValue)
                .build()
        );

        builder.setSavingRunnable(() -> {
            try {
                double[][] allConfigs = {currentDefaultConfigs, currentPreset1Configs, currentPreset2Configs, currentPreset3Configs, currentPreset4Configs, currentPreset5Configs, currentPreset6Configs, currentPreset7Configs, currentPreset8Configs, currentPreset9Configs};
                RandHotbar.configManager.saveAll(allConfigs);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        return builder.build();
    }
}
