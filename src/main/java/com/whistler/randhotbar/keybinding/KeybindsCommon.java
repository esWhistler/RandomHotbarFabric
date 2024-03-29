package com.whistler.randhotbar.keybinding;

import com.whistler.randhotbar.RandHotbar;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.GameMode;
import org.lwjgl.glfw.GLFW;

public abstract class KeybindsCommon {
    protected KeyBinding openModMenu;
    protected KeyBinding toggleRandomizer;

    protected boolean randomizerActive = false;

    public KeybindsCommon(){
        openModMenu = KeyBindingHelper.registerKeyBinding(new KeyBinding("key." + RandHotbar.MOD_ID + ".openmenu", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_O, "key." + RandHotbar.MOD_ID + ".category"));
        toggleRandomizer = KeyBindingHelper.registerKeyBinding(new KeyBinding("key." + RandHotbar.MOD_ID + ".toggle", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_Y, "key." + RandHotbar.MOD_ID + ".category"));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (toggleRandomizer.wasPressed() && RandHotbar.MINECRAFT.interactionManager.getCurrentGameMode() != GameMode.SPECTATOR) {
                randomizerActive = !randomizerActive;
                assert RandHotbar.MINECRAFT.player != null;
                if (RandHotbar.MINECRAFT.interactionManager.getCurrentGameMode() == GameMode.CREATIVE || RandHotbar.MINECRAFT.player.getArmor() == 0)
                    RandHotbar.MINECRAFT.inGameHud.setOverlayMessage(randomizerActive ? new TranslatableText("message." + RandHotbar.MOD_ID + ".toggle.on") : new TranslatableText("message." + RandHotbar.MOD_ID + ".toggle.off"), false);
            }
        });
    }

    public boolean isRandomizerActive() {
        return randomizerActive;
    }
}
