package com.whistler.randhotbar.keybinding;

import com.whistler.randhotbar.RandHotbar;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.network.MessageType;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.GameMode;
import org.lwjgl.glfw.GLFW;

public abstract class KeybindsCommon {
    protected static KeyBinding openModMenu;
    protected static KeyBinding toggleRandomizer;

    public static boolean randomizerActive = false;

    public static void registerKeybinds(){
        openModMenu = KeyBindingHelper.registerKeyBinding(new KeyBinding("key." + RandHotbar.MOD_ID + ".openmenu", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_O, "key." + RandHotbar.MOD_ID + ".category"));
        toggleRandomizer = KeyBindingHelper.registerKeyBinding(new KeyBinding("key." + RandHotbar.MOD_ID + ".toggle", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_Y, "key." + RandHotbar.MOD_ID + ".category"));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (toggleRandomizer.wasPressed() && RandHotbar.MINECRAFT.interactionManager.getCurrentGameMode() != GameMode.SPECTATOR) {
                randomizerActive = !randomizerActive;
                assert RandHotbar.MINECRAFT.player != null;
                RandHotbar.MINECRAFT.inGameHud.addChatMessage(MessageType.SYSTEM,(randomizerActive ? new TranslatableText("message." + RandHotbar.MOD_ID + ".toggle.on") : new TranslatableText("message." + RandHotbar.MOD_ID + ".toggle.off")), RandHotbar.MINECRAFT.player.getUuid());
            }
        });
    }
}
