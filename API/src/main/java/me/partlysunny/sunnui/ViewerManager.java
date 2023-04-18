package me.partlysunny.sunnui;

import me.partlysunny.sunnui.instance.GuiInstance;
import me.partlysunny.sunnui.inventory.InventoryViewer;

public interface ViewerManager {

    GuiInstance<?> getCurrentView(InventoryViewer viewer);

    InventoryViewer[] getViewers(GuiInstance<?> view);

    void setCurrentView(InventoryViewer viewer, GuiInstance<?> view);

    void closeView(InventoryViewer viewer);

    void closeView(GuiInstance<?> view);

}
