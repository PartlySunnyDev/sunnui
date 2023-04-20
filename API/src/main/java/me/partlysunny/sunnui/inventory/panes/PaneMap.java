package me.partlysunny.sunnui.inventory.panes;

import me.partlysunny.sunnui.inventory.InventoryWrapper;
import me.partlysunny.sunnui.util.Coord;

import java.util.Iterator;

/**
 * A PaneMap is a collection of InventoryPanes that are drawn on a parent
 * @param <T> The type of item
 * @param <U> The type of inventory
 */
public interface PaneMap<T, U> {

    /**
     * Add a pane to the map
     * @param pane The pane to add
     */
    void addPane(InventoryPane<T, U> pane);

    /**
     * Remove a pane from the map
     * @param pane The pane to remove
     */
    void removePane(InventoryPane<T, U> pane);

    /**
     * Remove a pane from the map at a specific coordinate
     * This coordinate will be the singular coordinate of the pane
     * CANNOT REMOVE A PANE FROM JUST ANY COORDINATE IN ITS BOUNDARIES
     * @param coord The coordinate of the pane to remove
     */
    void removePane(Coord coord);

    /**
     * Remove all panes from the map
     */
    void clearPanes();

    /**
     * Iterate over all panes in the map
     * @return An iterator of all panes in the map
     */
    Iterator<InventoryPane<T, U>> iterator();

    /**
     * Get a pane from the map
     * @param coord The coordinate of the pane to get
     * @return The pane at the specified coordinate
     */
    InventoryPane<T, U> getPane(Coord coord);

    /**
     * Draws all panes in the map onto the parent inventory
     */
    void draw();

    /**
     * Get the parent inventory
     * @return The parent inventory
     */
    InventoryWrapper<T, U> getParent();

}
