package me.partlysunny.sunnui.inventory.panes;

import me.partlysunny.sunnui.inventory.InventoryWrapper;
import me.partlysunny.sunnui.util.Coord;

import java.util.Iterator;

public interface PaneMap<T, U> {

    void addPane(InventoryPane<T, U> pane);

    void removePane(InventoryPane<T, U> pane);

    void removePane(Coord coord);

    void clearPanes();

    Iterator<InventoryPane<T, U>> iterator();

    InventoryPane<T, U> getPane(Coord coord);

    void draw();

    InventoryWrapper<T, U> getParent();

}
