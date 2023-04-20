package me.partlysunny.sunnui.inventory;

import me.partlysunny.sunnui.instance.GuiInstance;

/**
 * Represents an entity that can view inventories
 * @param <T> The type of item in the inventory
 * @param <U> The type of inventory
 */
public interface InventoryViewer<T, U> {

    /**
     * View an inventory
     * @param inventory The inventory to view
     */
    void viewInventory(GuiInstance<? extends InventoryWrapper<T, U>> inventory);

    /**
     * Close the inventory being viewed
     */
    void closeInventory();

}
