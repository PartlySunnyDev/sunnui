package me.partlysunny.sunnui.inventory.panes;

import me.partlysunny.sunnui.inventory.InventoryWrapper;
import me.partlysunny.sunnui.util.Coord;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PaperPaneMap implements PaneMap<ItemStack, Inventory> {

    private final InventoryWrapper<ItemStack, Inventory> parent;

    private final List<InventoryPane<ItemStack, Inventory>> panes = new ArrayList<>();

    public PaperPaneMap(InventoryWrapper<ItemStack, Inventory> parent) {
        this.parent = parent;
    }

    @Override
    public void addPane(InventoryPane<ItemStack, Inventory> pane) {
        panes.add(pane);
        pane.sendUpdate();
    }

    @Override
    public void removePane(InventoryPane<ItemStack, Inventory> pane) {
        panes.remove(pane);
    }

    @Override
    public void removePane(Coord coord) {
        panes.removeIf(a -> a.getPosition().equals(coord));
    }

    @Override
    public void clearPanes() {
        panes.clear();
    }

    @Override
    public Iterator<InventoryPane<ItemStack, Inventory>> iterator() {
        return panes.iterator();
    }

    @Override
    public InventoryPane<ItemStack, Inventory> getPane(Coord coord) {
        return panes.stream().filter(a -> a.getPosition().equals(coord)).findFirst().orElse(null);
    }

    @Override
    public void draw() {
        panes.forEach(InventoryPane::draw);
    }

    @Override
    public InventoryWrapper<ItemStack, Inventory> getParent() {
        return parent;
    }
}
