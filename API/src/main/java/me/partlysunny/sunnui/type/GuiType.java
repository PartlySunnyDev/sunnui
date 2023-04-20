package me.partlysunny.sunnui.type;

import me.partlysunny.sunnui.instance.GuiInstance;
import me.partlysunny.sunnui.inventory.InventoryWrapper;

/**
 * Represents a type of gui, NOT AN INSTANCE
 * @param <T> The type of inventory wrapper this gui type uses
 */
public interface GuiType<T extends InventoryWrapper<?, ?>> {

    /**
     * Builds a new instance of this gui type
     * @return The new instance
     */
    GuiInstance<T> build();

    /**
     * Creates the initial inventory for this gui type
     * This is called when the gui is first opened
     * @return The initial {@link InventoryWrapper}
     */
    T createInitialInventory();

    /**
     * Gets the name of this gui type
     * Used for registration
     * @return The name
     */
    String getName();

}
