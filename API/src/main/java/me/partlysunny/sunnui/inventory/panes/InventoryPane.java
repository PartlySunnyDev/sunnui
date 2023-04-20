package me.partlysunny.sunnui.inventory.panes;

import me.partlysunny.sunnui.inventory.InventoryWrapper;
import me.partlysunny.sunnui.inventory.element.InventoryElement;
import me.partlysunny.sunnui.util.Coord;

import java.util.Iterator;
import java.util.OptionalDouble;

public interface InventoryPane<T, U> {

    Coord getPosition();

    int getWidth();

    int getHeight();

    void addElement(InventoryElement<T, U> element, Coord localCoord);

    void removeElement(InventoryElement<T, U> element);

    void removeElement(Coord localCoord);

    void clearElements();

    InventoryElement<T, U> getElement(Coord coord);

    PaneMap<T, U> getParent();

    void draw();

    default void sendUpdate() {
        getParent().getParent().updateSlots();
    }

    Iterator<InventoryElement<T, U>> iterator();
}
