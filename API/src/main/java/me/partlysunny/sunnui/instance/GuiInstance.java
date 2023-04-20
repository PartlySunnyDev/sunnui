package me.partlysunny.sunnui.instance;

import me.partlysunny.sunnui.type.GuiType;
import me.partlysunny.sunnui.inventory.InventoryWrapper;
import org.jetbrains.annotations.NotNull;

/**
 * Represents an instance of a GUI.
 * @param <T> The type of inventory wrapper this GUI instance uses.
 */
public interface GuiInstance<T extends InventoryWrapper<?, ?>> {

    /**
     * The inventory wrapper for this GUI instance.
     * @return The inventory wrapper. Cannot be null.
     */
    @NotNull
    T inventory();

    /**
     * Updates the inventory wrapper for this GUI instance.
     * This should be called whenever the content needs to be pushed to the inventory.
     */
    void update();

    /**
     * The type of GUI this instance is.
     * @return The type of GUI. Cannot be null.
     */
    @NotNull
    GuiType<T> type();

}
