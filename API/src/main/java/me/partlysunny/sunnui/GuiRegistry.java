package me.partlysunny.sunnui;

import me.partlysunny.sunnui.inventory.InventoryWrapper;
import me.partlysunny.sunnui.type.GuiType;

/**
 * A registry for all the GUIs
 * @param <T> The type of item in the GUIs
 * @param <U> The type of inventory which holds the GUIs
 */
public interface GuiRegistry<T, U> {

    /**
     * Registers a GUI
     * @param type The type of GUI
     */
    void registerGui(GuiType<? extends InventoryWrapper<T, U>> type);

    /**
     * Unregisters a GUI
     * @param type The type of GUI
     */
    void unregisterGui(GuiType<? extends InventoryWrapper<T, U>> type);

    /**
     * Gets a GUI by name
     * @param name The name of the GUI
     * @return The GUI
     */
    GuiType<? extends InventoryWrapper<T, U>> getGui(String name);

    /**
     * Gets a GUI by class
     * @param clazz The class of the GUI
     * @return The GUI
     */
    GuiType<? extends InventoryWrapper<T, U>> getGui(Class<? extends GuiType<? extends InventoryWrapper<T, U>>> clazz);
}
