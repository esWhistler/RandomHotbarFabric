package com.whistler.randhotbar;

import com.whistler.randhotbar.config.ConfigManager;
import com.whistler.randhotbar.event.AfterBlockPlacedCallback;
import com.whistler.randhotbar.keybinding.AmecsKeybinds;
import com.whistler.randhotbar.keybinding.KeybindsCommon;
import com.whistler.randhotbar.keybinding.StandardKebinds;
import com.whistler.randhotbar.util.UtilFunctions;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.ActionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RandHotbar implements ModInitializer {
	public static final String MOD_ID = "randhotbar";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final MinecraftClient MINECRAFT = MinecraftClient.getInstance();

	public static final boolean AMECS_PRESENT = FabricLoader.getInstance().isModLoaded("amecs");

	public static ConfigManager configManager;

	public static double[] currentSettings = new double[9];

	@Override
	public void onInitialize() {
		//Config MUST be registered first
		try {
			configManager = new ConfigManager();
			currentSettings = configManager.readConfigs(AMECS_PRESENT ? configManager.getLastUsed() : "default");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		if (AMECS_PRESENT) { // Presets only available with Amecs
			AmecsKeybinds.registerKeybinds();
		} else {
			StandardKebinds.registerKeybinds();
		}

		//Events
		AfterBlockPlacedCallback.EVENT.register((player, world, hand, hitResult) -> {
			if(KeybindsCommon.randomizerActive){
				assert MINECRAFT.player != null;
				MINECRAFT.player.getInventory().selectedSlot = UtilFunctions.weighedRandomizer(currentSettings);
			}
			return ActionResult.PASS;
		});

	}
}
