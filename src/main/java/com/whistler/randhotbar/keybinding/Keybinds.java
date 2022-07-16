package com.whistler.randhotbar.keybinding;

import com.whistler.randhotbar.RandHotbar;
import com.whistler.randhotbar.config.ConfigScreen;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.network.MessageType;
import net.minecraft.text.TranslatableText;
import org.lwjgl.glfw.GLFW;

import java.io.IOException;

public class Keybinds {
    private static KeyBinding openModMenu;
    private static KeyBinding toggleRandomizer;
    private static KeyBinding modifier;
    private static KeyBinding[] selectPresets = new KeyBinding[10];

    public static boolean randomizerActive;

    public static void registerKeybinds(){
        openModMenu = KeyBindingHelper.registerKeyBinding(new KeyBinding("key." + RandHotbar.MOD_ID + ".openmenu", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_O, "key." +RandHotbar.MOD_ID + ".category"));
        toggleRandomizer = KeyBindingHelper.registerKeyBinding(new KeyBinding("key." + RandHotbar.MOD_ID + ".toggle", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_Y, "key." + RandHotbar.MOD_ID + ".category"));
        modifier = KeyBindingHelper.registerKeyBinding(new KeyBinding("key." + RandHotbar.MOD_ID + "modifier", InputUtil.Type.KEYSYM, GLFW.GLFW_MOD_ALT, "key." + RandHotbar.MOD_ID + ".category"));
        selectPresets[0] = KeyBindingHelper.registerKeyBinding(new KeyBinding("key." + RandHotbar.MOD_ID + ".selectpresets.default", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_0, "key." + RandHotbar.MOD_ID + ".category"));
        selectPresets[1] = KeyBindingHelper.registerKeyBinding(new KeyBinding("key." + RandHotbar.MOD_ID + ".selectpresets.preset1", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_1, "key." + RandHotbar.MOD_ID + ".category"));
        selectPresets[2] = KeyBindingHelper.registerKeyBinding(new KeyBinding("key." + RandHotbar.MOD_ID + ".selectpresets.preset2", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_2, "key." + RandHotbar.MOD_ID + ".category"));
        selectPresets[3] = KeyBindingHelper.registerKeyBinding(new KeyBinding("key." + RandHotbar.MOD_ID + ".selectpresets.preset3", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_3, "key." + RandHotbar.MOD_ID + ".category"));
        selectPresets[4] = KeyBindingHelper.registerKeyBinding(new KeyBinding("key." + RandHotbar.MOD_ID + ".selectpresets.preset4", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_4, "key." + RandHotbar.MOD_ID + ".category"));
        selectPresets[5] = KeyBindingHelper.registerKeyBinding(new KeyBinding("key." + RandHotbar.MOD_ID + ".selectpresets.preset5", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_5, "key." + RandHotbar.MOD_ID + ".category"));
        selectPresets[6] = KeyBindingHelper.registerKeyBinding(new KeyBinding("key." + RandHotbar.MOD_ID + ".selectpresets.preset6", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_6, "key." + RandHotbar.MOD_ID + ".category"));
        selectPresets[7] = KeyBindingHelper.registerKeyBinding(new KeyBinding("key." + RandHotbar.MOD_ID + ".selectpresets.preset7", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_7, "key." + RandHotbar.MOD_ID + ".category"));
        selectPresets[8] = KeyBindingHelper.registerKeyBinding(new KeyBinding("key." + RandHotbar.MOD_ID + ".selectpresets.preset8", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_8, "key." + RandHotbar.MOD_ID + ".category"));
        selectPresets[9] = KeyBindingHelper.registerKeyBinding(new KeyBinding("key." + RandHotbar.MOD_ID + ".selectpresets.preset9", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_9, "key." + RandHotbar.MOD_ID + ".category"));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            try {
                while (openModMenu.wasPressed()) {
                    Screen modMenu = ConfigScreen.buildScreen(RandHotbar.MINECRAFT.currentScreen);
                    RandHotbar.MINECRAFT.setScreen(modMenu);
                }

                while (toggleRandomizer.wasPressed()) {
                    randomizerActive = !randomizerActive;
                    assert RandHotbar.MINECRAFT.player != null;
                    RandHotbar.MINECRAFT.inGameHud.addChatMessage(MessageType.SYSTEM,(randomizerActive ? new TranslatableText("message." + RandHotbar.MOD_ID + ".toggle.on") : new TranslatableText("message." + RandHotbar.MOD_ID + ".toggle.off")), RandHotbar.MINECRAFT.player.getUuid());
                }

                while (randomizerActive && modifier.isPressed() && selectPresets[0].wasPressed()) {
                    RandHotbar.currentSettings = RandHotbar.configManager.readConfigs("default");
                    RandHotbar.configManager.setLastUsed("default");
                }

                for (int i = 1; i < 10; ++i) {
                    while (randomizerActive && modifier.isPressed() && selectPresets[i].wasPressed()) {
                        RandHotbar.currentSettings = RandHotbar.configManager.readConfigs("preset" + i);
                        RandHotbar.configManager.setLastUsed("preset" + i);
                    }
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
