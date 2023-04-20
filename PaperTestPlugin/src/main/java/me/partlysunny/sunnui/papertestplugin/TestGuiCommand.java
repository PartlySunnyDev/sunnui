package me.partlysunny.sunnui.papertestplugin;

import me.partlysunny.sunnui.utils.PaperGuis;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import org.jetbrains.annotations.NotNull;

public class TestGuiCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (command.getName().equals("testgui") && sender instanceof HumanEntity e) {
            PaperGuis.openGui("test-gui", e);
        }
        return true;
    }
}
