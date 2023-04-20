package me.partlysunny.sunnui;

import me.partlysunny.sunnui.instance.GuiInstance;
import me.partlysunny.sunnui.inventory.InventoryViewer;
import me.partlysunny.sunnui.inventory.InventoryWrapper;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class PaperViewerManager implements ViewerManager<ItemStack, Inventory> {

    private final Map<InventoryViewer<ItemStack, Inventory>, GuiInstance<? extends InventoryWrapper<ItemStack, Inventory>>> viewers = new HashMap<>();

    @Override
    public GuiInstance<? extends InventoryWrapper<ItemStack, Inventory>> getCurrentView(InventoryViewer<ItemStack, Inventory> viewer) {
        return viewers.get(viewer);
    }

    @Override
    @SuppressWarnings("unchecked")
    public InventoryViewer<ItemStack, Inventory>[] getViewers(GuiInstance<? extends InventoryWrapper<ItemStack, Inventory>> view) {
        return viewers
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(view))
                .map(Map.Entry::getKey)
                .toArray(InventoryViewer[]::new);
    }

    @Override
    public void setCurrentView(InventoryViewer<ItemStack, Inventory> viewer, GuiInstance<? extends InventoryWrapper<ItemStack, Inventory>> view) {
        viewers.put(viewer, view);
        viewer.viewInventory(view);
    }

    @Override
    public void closeView(InventoryViewer<ItemStack, Inventory> viewer) {
        viewers.remove(viewer);
        viewer.closeInventory();
    }

    @Override
    public void closeView(GuiInstance<? extends InventoryWrapper<ItemStack, Inventory>> view) {
        viewers.entrySet().stream().filter(entry -> entry.getValue().equals(view)).map(Map.Entry::getKey).forEach(this::closeView);
    }
}
