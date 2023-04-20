package me.partlysunny.sunnui.inventory;

import me.partlysunny.sunnui.instance.GuiInstance;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PaperInventoryViewer implements InventoryViewer<ItemStack, Inventory> {

    private final HumanEntity player;

    public PaperInventoryViewer(HumanEntity player) {
        this.player = player;
    }

    @Override
    public void viewInventory(GuiInstance<? extends InventoryWrapper<ItemStack, Inventory>> inventory) {
        player.openInventory(inventory.inventory().getInventory());
    }

    @Override
    public void closeInventory() {
        player.closeInventory();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof PaperInventoryViewer)) return false;
        return player.getUniqueId().equals(((PaperInventoryViewer) obj).player.getUniqueId());
    }
}
