package me.partlysunny.sunnui;

import me.partlysunny.sunnui.inventory.InventoryWrapper;
import me.partlysunny.sunnui.type.GuiType;

public interface GuiRegistry<T, U> {

    void registerGui(GuiType<? extends InventoryWrapper<T, U>> type);

    void unregisterGui(GuiType<? extends InventoryWrapper<T, U>> type);

    GuiType<? extends InventoryWrapper<T, U>> getGui(String name);

    GuiType<? extends InventoryWrapper<T, U>> getGui(Class<? extends GuiType<? extends InventoryWrapper<T, U>>> clazz);
}
