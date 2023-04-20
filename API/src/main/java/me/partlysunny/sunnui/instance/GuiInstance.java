package me.partlysunny.sunnui.instance;

import me.partlysunny.sunnui.type.GuiType;
import me.partlysunny.sunnui.inventory.InventoryWrapper;
import org.jetbrains.annotations.NotNull;

public interface GuiInstance<T extends InventoryWrapper<?, ?>> {

    @NotNull
    T inventory();

    void update();

    GuiType<T> type();

}
