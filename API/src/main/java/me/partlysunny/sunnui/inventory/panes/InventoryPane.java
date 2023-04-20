package me.partlysunny.sunnui.inventory.panes;

import me.partlysunny.sunnui.inventory.element.InventoryElement;
import me.partlysunny.sunnui.util.Coord;

import java.util.Iterator;

/**
 * Represents a pane of an inventory.
 * @param <T> The type of the item
 * @param <U> The type of the inventory
 */
public interface InventoryPane<T, U> {

    /**
     * Gets the position of the pane in the inventory.
     * @return The position of the pane in the inventory.
     */
    Coord getPosition();

    /**
     * Gets the width of the pane.
     * @return The width of the pane.
     */
    int getWidth();

    /**
     * Gets the height of the pane.
     * @return The height of the pane.
     */
    int getHeight();

    /**
     * Adds an element to the pane with the specified local coordinate.
     * @param element The element to add.
     * @param localCoord The local coordinate of the element.
     */
    void addElement(InventoryElement<T, U> element, Coord localCoord);

    /**
     * Removes an element from the pane.
     * @param element The element to remove.
     */
    void removeElement(InventoryElement<T, U> element);

    /**
     * Removes an element from the pane.
     * @param localCoord The local coordinate of the element to remove.
     */
    void removeElement(Coord localCoord);

    /**
     * Clears all elements from the pane.
     */
    void clearElements();

    /**
     * Gets the element at the specified coordinate. This coordinate is relative to the inventory not the pane!
     * @param coord The local coordinate of the element.
     * @return The element at the specified coordinate.
     */
    InventoryElement<T, U> getElement(Coord coord);

    /**
     * Gets the parent of the pane.
     * @return The parent of the pane.
     */
    PaneMap<T, U> getParent();

    /**
     * Draws the pane onto the inventory.
     * Should be simply calling {@link InventoryElement#draw()} on each element in the pane.
     */
    void draw();

    /**
     * Updates the parent {@link me.partlysunny.sunnui.inventory.InventoryWrapper} of the pane.
     */
    default void sendUpdate() {
        getParent().getParent().updateSlots();
    }

    /**
     * Gets an iterator for the elements in the pane.
     * @return An iterator for the elements in the pane.
     */
    Iterator<InventoryElement<T, U>> iterator();
}
