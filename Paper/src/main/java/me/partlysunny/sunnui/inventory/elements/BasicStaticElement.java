package me.partlysunny.sunnui.inventory.elements;

import me.partlysunny.sunnui.inventory.InventoryWrapper;
import me.partlysunny.sunnui.inventory.element.ElementBounds;
import me.partlysunny.sunnui.inventory.element.InventoryElement;
import me.partlysunny.sunnui.inventory.panes.InventoryPane;
import me.partlysunny.sunnui.util.Coord;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public abstract class BasicStaticElement extends PaperElement {

    private final ElementBounds bounds;

    public BasicStaticElement() {
        this.bounds = new SquareElementBounds(getCoord());
    }

    @Override
    public ElementBounds getBounds() {
        return bounds;
    }

    @Override
    public void draw(InventoryWrapper<ItemStack, Inventory> inventory) {
        inventory.getInventory().setItem(inventory.getSlot(getCoord()), getItem());
    }

    @Override
    public boolean isStatic() {
        return true;
    }

    protected abstract ItemStack getItem();
}
