package me.partlysunny.sunnui.inventory.panes;

import me.partlysunny.sunnui.inventory.element.InventoryElement;
import me.partlysunny.sunnui.util.Coord;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static me.partlysunny.sunnui.util.Coord.toSlot;

public class SimplePane implements InventoryPane<ItemStack, Inventory> {

    private final Coord position;
    private final int width;
    private final int height;
    private final List<InventoryElement<ItemStack, Inventory>> elements = new ArrayList<>();
    private ItemStack background = null;
    private final PaneMap<ItemStack, Inventory> parent;

    public SimplePane(Coord position, int width, int height, PaneMap<ItemStack, Inventory> parent) {
        this.position = position;
        this.width = width;
        this.height = height;
        this.parent = parent;
        parent.addPane(this);
    }

    @Override
    public Coord getPosition() {
        return position;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void addElement(InventoryElement<ItemStack, Inventory> element, Coord localCoord) {
        element.getCoord().set(localCoord.add(position));
        element.setParent(this);
        elements.add(element);
        element.sendUpdate();
    }

    @Override
    public void removeElement(InventoryElement<ItemStack, Inventory> element) {
        elements.remove(element);
        element.sendUpdate();
    }

    @Override
    public void removeElement(Coord localCoord) {
        elements.stream().filter(element -> element.getBounds().contains(localCoord.add(position))).forEach(a -> {
            elements.remove(a);
            a.sendUpdate();
        });
    }

    @Override
    public void clearElements() {
        elements.clear();
    }

    @Override
    public InventoryElement<ItemStack, Inventory> getElement(Coord coord) {
        return elements.stream().filter(a -> a.getBounds().contains(coord)).findFirst().orElse(null);
    }

    @Override
    public PaneMap<ItemStack, Inventory> getParent() {
        return parent;
    }

    @Override
    public void draw() {
        Inventory inventory = getParent().getParent().getInventory();
        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                inventory.setItem(toSlot(new Coord(x, y).add(position)), background);
            }
        }
        elements.forEach(InventoryElement::draw);
    }

    @Override
    public Iterator<InventoryElement<ItemStack, Inventory>> iterator() {
        return elements.iterator();
    }

    public ItemStack background() {
        return background;
    }

    public void setBackground(ItemStack background) {
        this.background = background;
    }
}
