package com.whistler.randhotbar;

import com.whistler.randhotbar.config.ConfigManager;
import com.whistler.randhotbar.event.AfterBlockPlacedCallback;
import com.whistler.randhotbar.keybinding.AmecsKeybinds;
import com.whistler.randhotbar.keybinding.KeybindsCommon;
import com.whistler.randhotbar.keybinding.StandardKebinds;
import com.whistler.randhotbar.util.UtilFunctions;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.util.ActionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.RoundingMode;
import java.text.NumberFormat;

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

		HudRenderCallback.EVENT.register((matrixStack, delta) -> {
			if(KeybindsCommon.randomizerActive && !MINECRAFT.options.hudHidden){
				NumberFormat nf = NumberFormat.getInstance();
				nf.setMaximumFractionDigits(1);
				nf.setMinimumFractionDigits(1);
				nf.setMinimumIntegerDigits(2);
				nf.setRoundingMode(RoundingMode.HALF_UP);
				TextRenderer textRenderer = MINECRAFT.textRenderer;
				float widthOffset = MINECRAFT.getWindow().getScaledWidth()/2.0F - 91F;
				float heightOffset = MINECRAFT.getWindow().getScaledHeight() - 30.0F;
				for (int i = 0; i < 9; ++i) {
					textRenderer.drawWithShadow(matrixStack, nf.format(currentSettings[i]), widthOffset + i*20.1F, heightOffset, (i%2 == 0 ? 999999 : -1));
				}
			}
		});
	}
}
