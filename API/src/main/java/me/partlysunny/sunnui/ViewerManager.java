package me.partlysunny.sunnui;

import me.partlysunny.sunnui.instance.GuiInstance;
import me.partlysunny.sunnui.inventory.InventoryViewer;
import me.partlysunny.sunnui.inventory.InventoryWrapper;

/**
 * A ViewerManager is responsible for managing the current view of all viewers.
 * This will mostly be players
 * @param <T> The type of item that the viewed inventories will hold
 * @param <U> The type of the viewed inventories
 */
public interface ViewerManager<T, U> {

    /**
     * Gets the current GUI of the viewer
     * @param viewer The viewer
     * @return What GUI the viewer is currently viewing
     */
    GuiInstance<? extends InventoryWrapper<T, U>> getCurrentView(InventoryViewer<T, U> viewer);

    /**
     * Gets all viewers of the GUI
     * @param view The GUI
     * @return All viewers of the view
     */
    InventoryViewer<T, U>[] getViewers(GuiInstance<? extends InventoryWrapper<T, U>> view);

    /**
     * Sets the current view of the viewer
     * Use this to open a GUI for a player
     * @param viewer The viewer
     * @param view The view
     */
    void setCurrentView(InventoryViewer<T, U> viewer, GuiInstance<? extends InventoryWrapper<T, U>> view);

    /**
     * Closes the current view of the viewer
     * @param viewer The viewer
     */
    void closeView(InventoryViewer<T, U> viewer);

    /**
     * Closes the GUI for all viewers
     * @param view The GUI
     */
    void closeView(GuiInstance<? extends InventoryWrapper<T, U>> view);

}
