package me.partlysunny.sunnui.inventory;

import me.partlysunny.sunnui.instance.GuiInstance;

public interface InventoryViewer<T, U> {

    void viewInventory(GuiInstance<? extends InventoryWrapper<T, U>> inventory);

    void closeInventory();

}
