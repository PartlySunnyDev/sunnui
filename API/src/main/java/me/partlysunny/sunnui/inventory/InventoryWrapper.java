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

    List<T> slots();

    PaneMap<T, U> paneMap();

    void updateSlots();

    InventoryElement<T, U> getElement(Coord coord);

    InventoryPane<T, U> getPane(Coord coord);

    void addPane(InventoryPane<T, U> pane);

    void removePane(InventoryPane<T, U> pane);

    void removePane(Coord coord);

    int getSlot(Coord coord);

    U getInventory();

}
