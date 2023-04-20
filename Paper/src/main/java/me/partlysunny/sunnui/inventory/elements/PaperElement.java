package me.partlysunny.sunnui.inventory.elements;

import me.partlysunny.sunnui.inventory.element.InventoryElement;
import me.partlysunny.sunnui.inventory.panes.InventoryPane;
import me.partlysunny.sunnui.util.Coord;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public abstract class PaperElement implements InventoryElement<ItemStack, Inventory> {

    protected final Coord coord;
    protected InventoryPane<ItemStack, Inventory> parent;

    public PaperElement(Coord coord) {
        this.coord = coord;
    }

    public PaperElement() {
        this(new Coord(0, 0));
    }

    @Override
    public Coord getCoord() {
        return coord;
    }

    @Override
    public InventoryPane<ItemStack, Inventory> getParent() {
        return parent;
    }

    @Override
    public void setParent(InventoryPane<ItemStack, Inventory> parent) {
        this.parent = parent;
    }
}
