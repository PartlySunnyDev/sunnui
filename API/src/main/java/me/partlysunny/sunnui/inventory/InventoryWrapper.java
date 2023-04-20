package me.partlysunny.sunnui.inventory;

import me.partlysunny.sunnui.inventory.element.InventoryElement;
import me.partlysunny.sunnui.inventory.panes.InventoryPane;
import me.partlysunny.sunnui.inventory.panes.PaneMap;
import me.partlysunny.sunnui.util.Coord;

import java.util.List;

/**
 * Represents an inventory
 * @param <T> The type of item in the inventory
 * @param <U> The type of inventory
 */
public interface InventoryWrapper<T, U> {

    /**
     * Returns the items in the inventory
     * @return The items in the inventory
     */
    List<T> slots();

    /**
     * Returns the pane map for the inventory
     * @return The pane map for the inventory
     */
    PaneMap<T, U> paneMap();

    /**
     * Updates the slots in the inventory based on the pane map
     * Also applies the background item to the inventory
     */
    void updateSlots();

    /**
     * Get the element at the given coordinate
     * @param coord The coordinate
     * @return The element at the given coordinate
     */
    InventoryElement<T, U> getElement(Coord coord);

    /**
     * Convert a coordinate to the slot index in the inventory
     * @param coord The coordinate
     * @return The slot index in the inventory
     */
    int getSlot(Coord coord);

    /**
     * Get the underlying inventory object
     * @return The underlying inventory object
     */
    U getInventory();

}
