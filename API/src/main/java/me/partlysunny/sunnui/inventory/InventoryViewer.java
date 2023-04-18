package me.partlysunny.sunnui.inventory;

import me.partlysunny.sunnui.instance.GuiInstance;

public interface InventoryViewer {

    void viewInventory(GuiInstance<?> inventory);

    void closeInventory();

}
