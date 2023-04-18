package me.partlysunny.sunnui.inventory;

import me.partlysunny.sunnui.inventory.element.InventoryElement;
import me.partlysunny.sunnui.inventory.element.InventorySlot;
import me.partlysunny.sunnui.util.Coord;

import java.util.List;

public interface InventoryWrapper<T> {

    List<InventorySlot<T>> slots();

    List<InventoryElement<T>> elements();

    void updateSlots();

    void addElement(InventoryElement<T> element);

    void addElement(Coord coord, InventoryElement<T> element);

    void removeElement(InventoryElement<T> element);

    void removeElement(Coord coord);

    void clearElements();

    InventoryElement<T> getElement(Coord coord);

}
