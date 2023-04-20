package me.partlysunny.sunnui.papertestplugin;

import me.partlysunny.sunnui.PaperSunnuiHandler;
import org.bukkit.plugin.java.JavaPlugin;
public final class PaperTestPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        PaperSunnuiHandler.init(this);
        getServer().getPluginCommand("testgui").setExecutor(new TestGuiCommand());
        PaperSunnuiHandler.getInstance().getGuiRegistry().registerGui(new TestGuiType());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
