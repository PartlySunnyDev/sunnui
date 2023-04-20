package me.partlysunny.sunnui.inventory.element;

import me.partlysunny.sunnui.inventory.InventoryWrapper;
import me.partlysunny.sunnui.inventory.panes.InventoryPane;
import me.partlysunny.sunnui.util.Coord;

public interface InventoryElement<T, U> {

    Coord getCoord();

    ElementBounds getBounds();

    default void draw() {
        draw(getParent().getParent().getParent());
    }

    void draw(InventoryWrapper<T, U> inventory);

    InventoryPane<T, U> getParent();

    void setParent(InventoryPane<T, U> parent);

    default void sendUpdate() {
        getParent().sendUpdate();
    }

    boolean isStatic();

}
