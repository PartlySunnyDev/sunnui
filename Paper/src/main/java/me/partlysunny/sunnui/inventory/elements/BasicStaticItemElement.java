package me.partlysunny.sunnui.inventory.elements;

import me.partlysunny.sunnui.inventory.InventoryWrapper;
import me.partlysunny.sunnui.inventory.panes.InventoryPane;
import me.partlysunny.sunnui.util.Coord;
import me.partlysunny.sunnui.utils.ItemBuilder;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class BasicStaticItemElement extends BasicStaticElement {

    private Component itemName;
    private Material itemMaterial;
    private List<Component> itemLore;

    public BasicStaticItemElement(Component itemName, Material itemMaterial, List<Component> itemLore) {
        this.itemName = itemName;
        this.itemMaterial = itemMaterial;
        this.itemLore = itemLore;
    }

    public BasicStaticItemElement(Component itemName, Material itemMaterial) {
        this(itemName, itemMaterial, new ArrayList<>());
    }

    public Component itemName() {
        return itemName;
    }

    public void setItemName(Component itemName) {
        this.itemName = itemName;
    }

    public Material itemMaterial() {
        return itemMaterial;
    }

    public void setItemMaterial(Material itemMaterial) {
        this.itemMaterial = itemMaterial;
    }

    public List<Component> itemLore() {
        return itemLore;
    }

    public void setItemLore(List<Component> itemLore) {
        this.itemLore = itemLore;
    }

    @Override
    protected ItemStack getItem() {
        return ItemBuilder.of(itemMaterial).name(itemName).lore(itemLore).create();
    }
}
