package com.whistler.randhotbar.keybinding;

import com.whistler.randhotbar.RandHotbar;
import com.whistler.randhotbar.gui.screen.ConfigScreenNoPresets;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.gui.screen.Screen;

import java.io.IOException;

public class StandardKebinds extends KeybindsCommon {
    public StandardKebinds(){
        super();

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            try {
                while (openModMenu.wasPressed()) {
                    Screen modMenu = ConfigScreenNoPresets.buildScreen(RandHotbar.MINECRAFT.currentScreen);
                    RandHotbar.MINECRAFT.setScreen(modMenu);
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
