package me.partlysunny.sunnui;

import me.partlysunny.sunnui.instance.GuiInstance;
import me.partlysunny.sunnui.inventory.InventoryViewer;
import me.partlysunny.sunnui.inventory.InventoryWrapper;

public interface ViewerManager<T, U> {

    GuiInstance<? extends InventoryWrapper<T, U>> getCurrentView(InventoryViewer<T, U> viewer);

    InventoryViewer<T, U>[] getViewers(GuiInstance<? extends InventoryWrapper<T, U>> view);

    void setCurrentView(InventoryViewer<T, U> viewer, GuiInstance<? extends InventoryWrapper<T, U>> view);

    void closeView(InventoryViewer<T, U> viewer);

    void closeView(GuiInstance<? extends InventoryWrapper<T, U>> view);

}
