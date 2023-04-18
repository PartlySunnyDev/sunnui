package me.partlysunny.sunnui.inventory.element;

import me.partlysunny.sunnui.inventory.InventoryWrapper;
import me.partlysunny.sunnui.util.Coord;

public interface InventoryElement<T> {

    Coord getCoord();

    ElementBounds getBounds();

    void draw(InventoryWrapper<T> inventory);

}
