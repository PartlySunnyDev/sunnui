package me.partlysunny.sunnui.papertestplugin;

import me.partlysunny.sunnui.instance.ChestGuiInstance;
import me.partlysunny.sunnui.instance.GuiInstance;
import me.partlysunny.sunnui.inventory.elements.BasicStaticItemElement;
import me.partlysunny.sunnui.inventory.panes.SimplePane;
import me.partlysunny.sunnui.inventory.wrappers.ChestInventoryWrapper;
import me.partlysunny.sunnui.type.GuiType;
import me.partlysunny.sunnui.util.Coord;
import me.partlysunny.sunnui.utils.ItemBuilder;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;

import java.util.List;

public class TestGuiType implements GuiType<ChestInventoryWrapper> {
    @Override
    public GuiInstance<ChestInventoryWrapper> build() {
        return new ChestGuiInstance(createInitialInventory(), this);
    }

    @Override
    public ChestInventoryWrapper createInitialInventory() {
        Inventory inventory = Bukkit.createInventory(null, 27, MiniMessage.miniMessage().deserialize("<red><!italic><bold>The True <obf><white>f</obf> <blue>SUPER INVENTORY <obf><white>f</obf>"));
        ChestInventoryWrapper wrapper = new ChestInventoryWrapper(inventory);
        wrapper.setFillItem(ItemBuilder.of(Material.BLACK_STAINED_GLASS_PANE).name(Component.text("")).create());
        SimplePane pane = new SimplePane(new Coord(1, 1), 7, 1, wrapper.paneMap());
        TextComponent name = Component.text("Epic Diamond").style(Style.style(TextDecoration.ITALIC)).color(NamedTextColor.BLUE);
        List<Component> lore = List.of(Component.text("Is it real?").style(Style.style(NamedTextColor.DARK_GRAY, TextDecoration.ITALIC)));
        pane.addElement(new BasicStaticItemElement(name, Material.DIAMOND, lore), new Coord(3, 0));
        return wrapper;
    }

    @Override
    public String getName() {
        return "test-gui";
    }
}
