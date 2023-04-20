package me.partlysunny.sunnui.inventory.wrappers;

import com.google.common.collect.Streams;
import me.partlysunny.sunnui.inventory.InventoryWrapper;
import me.partlysunny.sunnui.inventory.element.InventoryElement;
import me.partlysunny.sunnui.inventory.panes.InventoryPane;
import me.partlysunny.sunnui.inventory.panes.PaneMap;
import me.partlysunny.sunnui.inventory.panes.PaperPaneMap;
import me.partlysunny.sunnui.util.Coord;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Stream;

public class ChestInventoryWrapper implements InventoryWrapper<ItemStack, Inventory> {

    private final Inventory chestInventory;
    private final PaneMap<ItemStack, Inventory> paneMap = new PaperPaneMap(this);
    private ItemStack fillItem = null;

    public ChestInventoryWrapper(Inventory chestInventory) {
        this.chestInventory = chestInventory;
        updateSlots();
    }

    @Override
    public List<ItemStack> slots() {
        return Arrays.stream(chestInventory.getStorageContents()).toList();
    }

    @Override
    public PaneMap<ItemStack, Inventory> paneMap() {
        return paneMap;
    }

    @Override
    public void updateSlots() {
        chestInventory.clear();
        ListIterator<ItemStack> iterator = chestInventory.iterator();
        while (iterator.hasNext()) {
            int nextIndex = iterator.nextIndex();
            iterator.next();
            chestInventory.setItem(nextIndex, fillItem);
        }
        paneMap.draw();
        chestInventory.setStorageContents(slots().toArray(new ItemStack[0]));
    }

    @Override
    public InventoryElement<ItemStack, Inventory> getElement(Coord coord) {
        return Streams.stream(paneMap.iterator())
                .flatMap(pane -> Streams.stream(pane.iterator()))
                .filter(a -> a.getCoord().equals(coord))
                .findFirst()
                .orElse(null);
    }

    @Override
    public int getSlot(Coord coord) {
        return Coord.toSlot(coord);
    }

    @Override
    public Inventory getInventory() {
        return chestInventory;
    }

    public ItemStack fillItem() {
        return fillItem;
    }

    public void setFillItem(ItemStack fillItem) {
        this.fillItem = fillItem;
    }
}
