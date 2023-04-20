package me.partlysunny.sunnui;

import me.partlysunny.sunnui.inventory.listeners.InteractListener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class PaperSunnuiHandler {

    private static PaperSunnuiHandler instance;

    public static PaperSunnuiHandler getInstance() {
        if (instance == null)
            throw new IllegalStateException("Sunnui has not been initialized! Please call Sunnui.init(JavaPlugin) inside your enable()!");
        return instance;
    }

    private JavaPlugin plugin;
    private GuiRegistry<ItemStack, Inventory> guiRegistry;
    private ViewerManager<ItemStack, Inventory> viewerManager;

    private PaperSunnuiHandler() {
    }

    public static void init(JavaPlugin plugin) {
        if (instance != null) throw new IllegalStateException("Sunnui has already been initialized!");
        instance = new PaperSunnuiHandler();
        instance.plugin = plugin;
        instance.guiRegistry = new PaperGuiRegistry();
        instance.viewerManager = new PaperViewerManager();
        plugin.getServer().getPluginManager().registerEvents(new InteractListener(), plugin);
    }

    public GuiRegistry<ItemStack, Inventory> getGuiRegistry() {
        return guiRegistry;
    }

    public ViewerManager<ItemStack, Inventory> getViewerManager() {
        return viewerManager;
    }
}
