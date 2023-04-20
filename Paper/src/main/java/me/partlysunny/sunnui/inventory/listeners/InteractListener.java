package me.partlysunny.sunnui.inventory.listeners;

import me.partlysunny.sunnui.inventory.element.InventoryElement;
import me.partlysunny.sunnui.utils.PaperGuis;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InteractListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        InventoryElement<ItemStack, Inventory> elementClicked = PaperGuis.getElementClicked(event);
        if (elementClicked == null) {
            event.setCancelled(true);
            return;
        }
        if (elementClicked.isStatic()) event.setCancelled(true);
    }

}
