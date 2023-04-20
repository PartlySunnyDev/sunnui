package me.partlysunny.sunnui.parser;

import org.bukkit.event.inventory.InventoryType;

import java.util.Map;

public class InventoryShaper {

    private final InventoryType type;
    private final int size;
    private String[] paneShape;

    public InventoryShaper(InventoryType type, int size) {
        this.type = type;
        this.size = size;
    }

    public InventoryShaper(InventoryType type) {
        this(type, type.getDefaultSize());
    }

    public InventoryType type() {
        return type;
    }

    public int size() {
        return size;
    }
}
