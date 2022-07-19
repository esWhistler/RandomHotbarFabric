package com.whistler.randhotbar.keybinding;

import com.whistler.randhotbar.RandHotbar;
import com.whistler.randhotbar.config.ConfigScreenWithPresets;
import de.siphalor.amecs.api.AmecsKeyBinding;
import de.siphalor.amecs.api.KeyModifiers;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import net.minecraft.world.GameMode;
import org.lwjgl.glfw.GLFW;

import java.io.IOException;

public abstract class AmecsKeybinds extends KeybindsCommon{
    private static final KeyBinding[] selectPresets = new KeyBinding[10];

    public static void registerKeybinds() {
        KeybindsCommon.registerKeybinds();

        int[] key = {GLFW.GLFW_KEY_0, GLFW.GLFW_KEY_1, GLFW.GLFW_KEY_2, GLFW.GLFW_KEY_3, GLFW.GLFW_KEY_4, GLFW.GLFW_KEY_5, GLFW.GLFW_KEY_6, GLFW.GLFW_KEY_7, GLFW.GLFW_KEY_8, GLFW.GLFW_KEY_9};
        for (int i = 0; i < 10; ++i) {
            selectPresets[i] = KeyBindingHelper.registerKeyBinding(new AmecsKeyBinding("key." + RandHotbar.MOD_ID + (i == 0 ? "default" : "preset" + i), InputUtil.Type.KEYSYM, key[i], "key." + RandHotbar.MOD_ID + ".category", new KeyModifiers(true, false, false)));
        }

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            try {
                while (openModMenu.wasPressed()) {
                    Screen modMenu = ConfigScreenWithPresets.buildScreen(RandHotbar.MINECRAFT.currentScreen);
                    RandHotbar.MINECRAFT.setScreen(modMenu);
                }

                for (int i = 0; i < 10; ++i) {
                    while (selectPresets[i].wasPressed() && KeybindsCommon.randomizerActive && RandHotbar.MINECRAFT.interactionManager.getCurrentGameMode() != GameMode.SPECTATOR) {
                        RandHotbar.currentSettings = RandHotbar.configManager.readConfigs(i == 0 ? "default" : "preset" + i);
                        RandHotbar.configManager.setLastUsed(i == 0 ? "default" : "preset" + i);
                        RandHotbar.MINECRAFT.inGameHud.setOverlayMessage(Text.of((i == 0 ? "default" : "preset" + i)), false);
                    }
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
