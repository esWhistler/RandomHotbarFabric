package com.whistler.randhotbar.integration;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import com.whistler.randhotbar.RandHotbar;
import com.whistler.randhotbar.config.ConfigScreenNoPresets;
import com.whistler.randhotbar.config.ConfigScreenWithPresets;
import net.minecraft.client.gui.screen.Screen;

import java.io.IOException;

public class ModMenuIntegration implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return (ConfigScreenFactory<Screen>) parent -> {
            try {
                return (RandHotbar.AMECS_PRESENT ? ConfigScreenWithPresets.buildScreen(parent) : ConfigScreenNoPresets.buildScreen(parent));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }
}
