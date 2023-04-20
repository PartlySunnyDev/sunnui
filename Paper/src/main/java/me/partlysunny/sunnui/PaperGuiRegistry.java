package me.partlysunny.sunnui;

import me.partlysunny.sunnui.inventory.InventoryWrapper;
import me.partlysunny.sunnui.type.GuiType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class PaperGuiRegistry implements GuiRegistry<ItemStack, Inventory> {

    private final Map<String, GuiType<? extends InventoryWrapper<ItemStack, Inventory>>> guis = new HashMap<>();


    @Override
    public void registerGui(GuiType<? extends InventoryWrapper<ItemStack, Inventory>> type) {
        guis.put(type.getName(), type);
    }

    @Override
    public void unregisterGui(GuiType<? extends InventoryWrapper<ItemStack, Inventory>> type) {
        guis.remove(type.getName());
    }

    @Override
    public GuiType<? extends InventoryWrapper<ItemStack, Inventory>> getGui(String name) {
        return guis.get(name);
    }

    @Override
    public GuiType<? extends InventoryWrapper<ItemStack, Inventory>> getGui(Class<? extends GuiType<? extends InventoryWrapper<ItemStack, Inventory>>> clazz) {
        return guis.values().stream().filter(gui -> gui.getClass().equals(clazz)).findFirst().orElse(null);
    }
}
