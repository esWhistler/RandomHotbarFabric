package com.whistler.randhotbar.gui.screen.clothconfigcustom;

import com.google.common.collect.Lists;
import me.shedaniel.clothconfig2.api.AbstractConfigListEntry;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import net.minecraft.text.StringVisitable;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

//this is nessesary to avoid using the builder, which the default implementation depends on
@SuppressWarnings("deprecation")
public class CustomConfigCategoryImpl implements ConfigCategory {
    private final List<Object> data;
    private @Nullable Identifier background;
    private final Text categoryKey;
    private @Nullable Supplier<Optional<StringVisitable[]>> description = Optional::empty;

    public CustomConfigCategoryImpl(Text categoryKey) {
        this.data = Lists.newArrayList();
        this.categoryKey = categoryKey;
    }

    public Text getCategoryKey() {
        return this.categoryKey;
    }

    public List<Object> getEntries() {
        return this.data;
    }

    public ConfigCategory addEntry(AbstractConfigListEntry entry) {
        this.data.add(entry);
        return this;
    }

    public ConfigCategory setCategoryBackground(Identifier identifier) {
        this.background = identifier;
        return this;
    }

    public void setBackground(@Nullable Identifier background) {
        this.background = background;
    }

    public @Nullable Identifier getBackground() {
        return this.background;
    }

    public @Nullable Supplier<Optional<StringVisitable[]>> getDescription() {
        return this.description;
    }

    public void setDescription(@Nullable Supplier<Optional<StringVisitable[]>> description) {
        this.description = description;
    }

    public void removeCategory() {

    }
}
