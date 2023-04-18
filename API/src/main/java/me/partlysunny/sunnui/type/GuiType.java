package me.partlysunny.sunnui.type;

import me.partlysunny.sunnui.instance.GuiInstance;
import me.partlysunny.sunnui.inventory.InventoryWrapper;

public interface GuiType<T extends InventoryWrapper<?>> {

    GuiInstance<T> build();

    T createInitialInventory();

}
