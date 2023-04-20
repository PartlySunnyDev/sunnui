package me.partlysunny.sunnui.instance;

import me.partlysunny.sunnui.inventory.wrappers.ChestInventoryWrapper;
import me.partlysunny.sunnui.type.GuiType;
import org.jetbrains.annotations.NotNull;

public record ChestGuiInstance(ChestInventoryWrapper inventory,
                               GuiType<ChestInventoryWrapper> type) implements GuiInstance<ChestInventoryWrapper> {

    @Override
    public @NotNull ChestInventoryWrapper inventory() {
        return inventory;
    }

    @Override
    public void update() {
        inventory.updateSlots();
    }
}
