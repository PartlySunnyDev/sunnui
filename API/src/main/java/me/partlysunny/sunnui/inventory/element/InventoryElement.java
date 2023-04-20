package me.partlysunny.sunnui.inventory.element;

import me.partlysunny.sunnui.inventory.InventoryWrapper;
import me.partlysunny.sunnui.inventory.panes.InventoryPane;
import me.partlysunny.sunnui.util.Coord;

/**
 * Represents an element inside a pane.
 * @param <T> The type of item in the element
 * @param <U> The type of inventory that contains the element
 */
public interface InventoryElement<T, U> {

    /**
     * Gets the coordinates of the element.
     * All implementations should not worry too muc, just store it somewhere
     * @return The coordinates of the element
     */
    Coord getCoord();

    /**
     * Gets the bounds of the element.
     * This is used for checking if the element is clicked.
     * @return The bounds of the element
     */
    ElementBounds getBounds();

    /**
     * Draws the element to the inventory.
     */
    default void draw() {
        draw(getParent().getParent().getParent());
    }

    /**
     * Draws the element to the inventory.
     * @param inventory The inventory to draw to
     */
    void draw(InventoryWrapper<T, U> inventory);

    /**
     * Gets the parent pane of the element.
     * @return The parent pane of the element
     */
    InventoryPane<T, U> getParent();

    /**
     * Sets the parent pane of the element.
     * @param parent The parent pane of the element
     */
    void setParent(InventoryPane<T, U> parent);

    /**
     * Sends an update to the parent pane.
     * This is used for updating the inventory upon changes.
     */
    default void sendUpdate() {
        getParent().sendUpdate();
    }

    /**
     * Checks if the element is static.
     * Static elements cannot be interacted with (InventoryClickEvent is not called)
     */
    boolean isStatic();

}
