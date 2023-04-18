package me.partlysunny.sunnui;

import me.partlysunny.sunnui.inventory.InventoryWrapper;
import me.partlysunny.sunnui.type.GuiType;

public interface GuiRegistry<T> {

    void registerGui(GuiType<? extends InventoryWrapper<T>> type);

    void unregisterGui(GuiType<? extends InventoryWrapper<T>> type);

    GuiType<? extends InventoryWrapper<T>> getGui(String name);

    GuiType<? extends InventoryWrapper<T>> getGui(Class<? extends GuiType<?>> clazz);
}
