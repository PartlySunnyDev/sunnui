package me.partlysunny.sunnui.utils;

import me.partlysunny.sunnui.PaperSunnuiHandler;
import me.partlysunny.sunnui.ViewerManager;
import me.partlysunny.sunnui.instance.GuiInstance;
import me.partlysunny.sunnui.inventory.InventoryWrapper;
import me.partlysunny.sunnui.inventory.PaperInventoryViewer;
import me.partlysunny.sunnui.inventory.element.InventoryElement;
import me.partlysunny.sunnui.util.Coord;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PaperGuis {

    public static void openGui(String id, HumanEntity player) {
        PaperSunnuiHandler instance = PaperSunnuiHandler.getInstance();
        GuiInstance<? extends InventoryWrapper<ItemStack, Inventory>> guiInstance = instance.getGuiRegistry().getGui(id).build();
        instance.getViewerManager().setCurrentView(new PaperInventoryViewer(player), guiInstance);
    }

    public static InventoryElement<ItemStack, Inventory> getElementClicked(InventoryClickEvent e) {
        ViewerManager<ItemStack, Inventory> viewerManager = PaperSunnuiHandler.getInstance().getViewerManager();
        Inventory inventory = e.getClickedInventory();
        if (inventory == null) return null;
        GuiInstance<? extends InventoryWrapper<ItemStack, Inventory>> instance = viewerManager.getCurrentView(new PaperInventoryViewer(e.getWhoClicked()));
        if (instance == null) return null;
        return instance.inventory().getElement(Coord.from(e.getSlot()));
    }

}
