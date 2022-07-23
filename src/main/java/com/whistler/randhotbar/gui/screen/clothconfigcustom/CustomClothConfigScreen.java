package com.whistler.randhotbar.gui.screen.clothconfigcustom;

import com.google.common.collect.Lists;
import com.mojang.blaze3d.systems.RenderSystem;
import com.whistler.randhotbar.RandHotbar;
import me.shedaniel.clothconfig2.api.AbstractConfigEntry;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.gui.ClothConfigScreen;
import me.shedaniel.clothconfig2.gui.entries.DoubleListEntry;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.client.util.NarratorManager;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@SuppressWarnings("unchecked")
public class CustomClothConfigScreen extends ClothConfigScreen {
    private boolean hasErrors;

    public CustomClothConfigScreen(Screen parent, Text title, Map<Text, ConfigCategory> categoryMap, Identifier backgroundLocation) {
        super(parent, title, categoryMap, backgroundLocation);
    }

    protected void init() {
        super.init();

        int buttonWidths = Math.min(200, (this.width - 50 - 12) / 3);
        ClickableWidget saveButton;
        this.addDrawableChild(saveButton = new ButtonWidget(this.width / 2 + 3, this.height - 26, buttonWidths, 20, NarratorManager.EMPTY, (button) -> {
            this.saveAll(true);
        }) {
            public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
                hasErrors = false;
                Iterator var6 = Lists.newArrayList(CustomClothConfigScreen.this.getCategorizedEntries().values()).iterator();

                while(var6.hasNext()) {
                    List<AbstractConfigEntry<?>> entries = (List)var6.next();
                    Iterator var8 = entries.iterator();

                    while(var8.hasNext()) {
                        AbstractConfigEntry<?> entry = (AbstractConfigEntry)var8.next();
                        if (entry.getConfigError().isPresent()) {
                            hasErrors = true;
                            break;
                        }
                    }

                    if (hasErrors) {
                        break;
                    }
                }

                this.active = CustomClothConfigScreen.this.isEdited() && saveConditionMet() && !hasErrors;
                this.setMessage(hasErrors ? new TranslatableText("text.cloth-config.error_cannot_save") : new TranslatableText("text.cloth-config.save_and_done"));
                super.render(matrices, mouseX, mouseY, delta);
            }
        });
        saveButton.active = this.isEdited();
    }

    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        super.render(matrices, mouseX, mouseY, delta);
        if(!hasErrors && !saveConditionMet()){
            int var10004;
            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            RenderSystem.setShaderTexture(0, CONFIG_TEX);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            String text = "§c" + I18n.translate("config." + RandHotbar.MOD_ID + ".save_condition_unmet");
            int stringWidth;
            if (this.isTransparentBackground()) {
                stringWidth = this.client.textRenderer.getWidth(text);
                var10004 = 20 + stringWidth;
                Objects.requireNonNull(this.client.textRenderer);
                this.fillGradient(matrices, 8, 9, var10004, 14 + 9, 1744830464, 1744830464);
            }

            this.drawTexture(matrices, 10, 10, 0, 54, 3, 11);
            drawStringWithShadow(matrices, this.client.textRenderer, text, 18, 12, -1);
        }
    }

    // TODO: make this generic
    private boolean saveConditionMet(){
        DecimalFormat df = new DecimalFormat("#.######");
        df.setRoundingMode(RoundingMode.HALF_UP);

        boolean saveCondMet = true;
        for (List<AbstractConfigEntry<?>> category: this.getCategorizedEntries().values()) {
            Double sum = 0.0;
            for (AbstractConfigEntry<?> entry : category) {
                if (entry instanceof DoubleListEntry){
                    sum += ((DoubleListEntry)entry).getValue();
                }
            }
            saveCondMet = Double.parseDouble(df.format(sum)) == 100.0;
            if (!saveCondMet) break;
        }

        return saveCondMet;
    }


}
