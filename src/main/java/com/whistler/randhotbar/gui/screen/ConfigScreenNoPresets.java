package com.whistler.randhotbar.gui.screen;

import com.google.common.collect.Maps;
import com.terraformersmc.modmenu.gui.ModsScreen;
import com.whistler.randhotbar.RandHotbar;
import com.whistler.randhotbar.gui.screen.clothconfigcustom.CustomClothConfigScreen;
import com.whistler.randhotbar.gui.screen.clothconfigcustom.CustomConfigCategoryImpl;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

import java.io.IOException;
import java.util.Map;

public class ConfigScreenNoPresets { //Amecs not present

    public static Screen buildScreen(Screen parent) throws IOException {
        Map<Text, ConfigCategory> categoryMap = Maps.newLinkedHashMap();

        double[] currentConfig = RandHotbar.configManager.readConfigs("default");

        ConfigEntryBuilder entryBuilder = ConfigEntryBuilder.create();

        Text categoryKey = new TranslatableText("config." + RandHotbar.MOD_ID + ".category.default");
        ConfigCategory category = new CustomConfigCategoryImpl(categoryKey);
        for (int h = 0; h < 9; ++h) { //hotbar N
            int finalH = h;

            category.addEntry(entryBuilder.startDoubleField(new TranslatableText("config." + RandHotbar.MOD_ID + ".variable.hotbar" + h), currentConfig[h])
                    .setDefaultValue(0)
                    .setMin(0)
                    .setMax(100)
                    .setSaveConsumer(newValue -> currentConfig[finalH] = newValue)
                    .build()
            );
        }
        categoryMap.putIfAbsent(categoryKey, category);

        CustomClothConfigScreen screen = new CustomClothConfigScreen(parent, new TranslatableText("config." + RandHotbar.MOD_ID + ".title"), categoryMap, DrawableHelper.OPTIONS_BACKGROUND_TEXTURE);

        if (!(parent instanceof ModsScreen)){
            screen.setTransparentBackground(true);
        }

        screen.setSavingRunnable(() -> {
            try {
                RandHotbar.configManager.saveDefault(currentConfig);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        return screen;
    }
}
