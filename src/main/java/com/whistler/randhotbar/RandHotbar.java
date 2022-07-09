package com.whistler.randhotbar;

import com.whistler.randhotbar.config.WorldConfigManager;
import com.whistler.randhotbar.config.WorldConfigScreen;
import com.whistler.randhotbar.config.DefaultConfigManager;
import com.whistler.randhotbar.event.AfterBlockPlacedCallback;
import com.whistler.randhotbar.util.IEntityDataSaver;
import com.whistler.randhotbar.util.UtilFunctions;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.network.MessageType;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class RandHotbar implements ModInitializer {
	public static final String MOD_ID = "randhotbar";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final MinecraftClient MINECRAFT = MinecraftClient.getInstance();

	private KeyBinding openModMenu;
	private KeyBinding toggleRandomizer;

	public static DefaultConfigManager defaultConfigManager;
	public static WorldConfigManager worldConfigManager;

	public static double[] currentSettings = new double[9];

	@Override
	public void onInitialize() {
		//Config MUST be registered first
		try {
			defaultConfigManager = new DefaultConfigManager();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		worldConfigManager = new WorldConfigManager();

		//Initialize keybindings
		openModMenu = KeyBindingHelper.registerKeyBinding(new KeyBinding("key." + MOD_ID + ".openmenu", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_O, "key." + MOD_ID + ".category"));
		toggleRandomizer = KeyBindingHelper.registerKeyBinding(new KeyBinding("key." + MOD_ID + ".toggle", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_Y, "key." + MOD_ID + ".category"));

		ServerWorldEvents.LOAD.register((server, world) -> {
			try {
				if(! new File("./config/randHotbar" + server.getName() + "/randhotbar.properties").isFile()){
					worldConfigManager.saveConfigs(server, defaultConfigManager.readConfigs());
				}
				currentSettings = worldConfigManager.readConfigs(server);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		});

		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			IEntityDataSaver player = (IEntityDataSaver)MINECRAFT.player;
			assert MINECRAFT.player != null;

			while (openModMenu.wasPressed()) {
				new WorldConfigScreen().openConfigScreen(MINECRAFT.currentScreen);
			}
			while (toggleRandomizer.wasPressed()) {
				boolean wasRhActivated = player.getPersistentData().getBoolean("rhActivated");
				player.getPersistentData().putBoolean("rhActivated", !wasRhActivated);
				MINECRAFT.inGameHud.addChatMessage(MessageType.SYSTEM,(wasRhActivated ? new TranslatableText("message." + MOD_ID + ".toggle.off") : new TranslatableText("message." + MOD_ID + ".toggle.on")), MINECRAFT.player.getUuid());
			}
		});

		AfterBlockPlacedCallback.EVENT.register((player, world, hand, hitResult) -> {
			if(((IEntityDataSaver)player).getPersistentData().getBoolean("rhActivated")){
				UtilFunctions.randomizeHotbar();
			}
			return ActionResult.PASS;
		});

		LOGGER.info("Hotbar Randomizer initialized");
	}
}
