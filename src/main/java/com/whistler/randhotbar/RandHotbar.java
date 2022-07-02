package com.whistler.randhotbar;

import com.whistler.randhotbar.config.DefaultConfigScreen;
import com.whistler.randhotbar.config.ModConfigs;
import com.whistler.randhotbar.util.IEntityDataSaver;
import com.whistler.randhotbar.util.RandomizerFunction;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.network.MessageType;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class RandHotbar implements ModInitializer {
	public static final String MOD_ID = "randhotbar";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final MinecraftClient MINECRAFT = MinecraftClient.getInstance();

	private static KeyBinding openModMenu;
	private static KeyBinding toggleRandomizer;

	@Override
	public void onInitialize() {
		//Config MUST be registered first
		try {
			ModConfigs.registerConfigs();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		//Initialize keybindings
		openModMenu = KeyBindingHelper.registerKeyBinding(new KeyBinding("key." + MOD_ID + ".openmenu", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_O, "key." + MOD_ID + ".category"));
		toggleRandomizer = KeyBindingHelper.registerKeyBinding(new KeyBinding("key." + MOD_ID + ".toggle", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_Y, "key." + MOD_ID + ".category"));

		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			while (openModMenu.wasPressed()) {
				DefaultConfigScreen.openConfigScreen(MINECRAFT.currentScreen);
			}
			while (toggleRandomizer.wasPressed()) {
				IEntityDataSaver player = (IEntityDataSaver) MINECRAFT.player;
				assert player != null;
				boolean wasRhActivated = player.getPersistentData().getBoolean("rhActivated");
				player.getPersistentData().putBoolean("rhActivated", !wasRhActivated);
				MINECRAFT.inGameHud.addChatMessage(MessageType.SYSTEM,(wasRhActivated ? new TranslatableText("message." + MOD_ID + ".toggle.off") : new TranslatableText("message." + MOD_ID + ".toggle.on")), MINECRAFT.player.getUuid());
			}
		});

		UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
			if(((IEntityDataSaver)player).getPersistentData().getBoolean("rhActivated")){
				RandomizerFunction.randomizeHotbar();
			}
			return ActionResult.PASS;
		});

		LOGGER.info("Hotbar Randomizer initialized");
	}
}
