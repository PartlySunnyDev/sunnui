package me.partlysunny.sunnui.utils;

import net.kyori.adventure.text.Component;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

public class ItemBuilder {

    private final PersistentDataManager dataManager;
    private Material material;
    private ItemMeta meta;
    private int amount = 1;

    public static ItemBuilder of(Material material) {
        return new ItemBuilder(material);
    }

    public static ItemBuilder of(ItemStack item) {
        return new ItemBuilder(item);
    }

    public static ItemBuilder of(OfflinePlayer skullOwner) {
        return new ItemBuilder(skullOwner);
    }

    private ItemBuilder(Material material) {
        this.material = material;
        ItemMeta meta = new ItemStack(material).getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        this.dataManager = new PersistentDataManager(meta.getPersistentDataContainer());
        this.meta = meta;
    }

    private ItemBuilder(ItemStack item) {
        this.material = item.getType();
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        this.meta = meta;
        this.dataManager = new PersistentDataManager(meta.getPersistentDataContainer());
    }

    private ItemBuilder(OfflinePlayer skullOwner) {
        ItemStack temp = (new ItemBuilder(Material.PLAYER_HEAD)).skullOwner(skullOwner).create();
        this.material = temp.getType();
        ItemMeta meta = temp.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        this.meta = meta;
        this.dataManager = new PersistentDataManager(meta.getPersistentDataContainer());
    }

    public ItemBuilder name(String name) {
        meta.displayName(Component.text(name));
        return this;
    }

    public ItemBuilder name(Component name) {
        meta.displayName(name);
        return this;
    }

    public ItemBuilder loreString(List<String> lore) {
        return loreString(lore, false);
    }

    public ItemBuilder loreString(List<String> lore, boolean add) {
        if (add) {
            List<Component> oldLore = meta.lore();
            if (oldLore == null) oldLore = List.of();
            oldLore.addAll(lore.stream().map(Component::text).toList());
            meta.lore(oldLore);
        } else {
            meta.lore(lore.stream().map(Component::text).toList());
        }
        return this;
    }

    public ItemBuilder loreString(String... lore) {
        return loreString(Arrays.asList(lore), false);
    }

    public ItemBuilder lore(List<Component> lore) {
        return lore(lore, false);
    }

    public ItemBuilder lore(List<Component> lore, boolean add) {
        if (add) {
            List<Component> oldLore = meta.lore();
            if (oldLore == null) oldLore = List.of();
            oldLore.addAll(lore);
            meta.lore(oldLore);
        } else {
            meta.lore(lore);
        }
        return this;
    }

    public ItemBuilder lore(Component... lore) {
        return lore(Arrays.asList(lore), false);
    }

    public ItemBuilder clearLore() {
        meta.lore(List.of());
        return this;
    }

    public ItemBuilder amount(int amount) {
        this.amount = amount;
        return this;
    }

    public ItemBuilder material(Material material) {
        this.material = material;
        return this;
    }

    // TODO: You should probably wrap every PersistentDataManager method in the builder but im not bothered
    public ItemBuilder modifyFromData(BiConsumer<ItemBuilder, PersistentDataManager> consumer) {
        consumer.accept(this, dataManager);
        return this;
    }

    public ItemBuilder nbtString(String key, String value) {
        dataManager.writeString(key, value);
        return this;
    }

    public ItemBuilder nbtInt(String key, int value) {
        dataManager.writeInt(key, value);
        return this;
    }

    public ItemBuilder nbtDouble(String key, double value) {
        dataManager.writeDouble(key, value);
        return this;
    }

    public ItemBuilder nbtLong(String key, long value) {
        dataManager.writeLong(key, value);
        return this;
    }

    public ItemBuilder nbtBoolean(String key, boolean value) {
        dataManager.writeBoolean(key, value);
        return this;
    }

    public ItemBuilder nbtShort(String key, short value) {
        dataManager.writeShort(key, value);
        return this;
    }

    public ItemBuilder nbtByte(String key, byte value) {
        dataManager.writeByte(key, value);
        return this;
    }

    public ItemBuilder clearNBT() {
        dataManager.clear();
        return this;
    }

    public ItemBuilder skullOwner(OfflinePlayer player) {
        SkullMeta skullMeta = (SkullMeta) meta;
        skullMeta.setOwningPlayer(player);
        meta = skullMeta;
        return this;
    }

    public ItemBuilder leatherArmorColor(Color color) {
        if (material == Material.LEATHER_HELMET || material == Material.LEATHER_CHESTPLATE || material == Material.LEATHER_LEGGINGS || material == Material.LEATHER_BOOTS) {
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
            leatherArmorMeta.setColor(color);
            meta = leatherArmorMeta;
        }
        return this;
    }

    public ItemBuilder leatherArmorColor(int r, int g, int b) {
        return leatherArmorColor(Color.fromRGB(r, g, b));
    }

    public ItemBuilder leatherArmorColor(int rgb) {
        return leatherArmorColor(Color.fromRGB(rgb));
    }

    public ItemBuilder leatherArmorColor(double r, double g, double b) {
        return leatherArmorColor(Color.fromRGB((int) (r * 255), (int) (g * 255), (int) (b * 255)));
    }

    // Automatically ignores level restrictions so no problems
    public ItemBuilder enchant(Enchantment enchantment, int level) {
        meta.addEnchant(enchantment, level, true);
        return this;
    }

    public ItemBuilder clearEnchants() {
        meta.getEnchants().keySet().forEach(meta::removeEnchant);
        return this;
    }

    public ItemBuilder unbreakable(boolean unbreakable) {
        meta.setUnbreakable(unbreakable);
        return this;
    }

    public ItemBuilder addFlag(ItemFlag... flags) {
        meta.addItemFlags(flags);
        return this;
    }

    public ItemBuilder removeFlag(ItemFlag... flags) {
        meta.removeItemFlags(flags);
        return this;
    }

    public ItemBuilder clearFlags() {
        meta.removeItemFlags(ItemFlag.values());
        return this;
    }

    public ItemBuilder customModelData(int customModelData) {
        meta.setCustomModelData(customModelData);
        return this;
    }

    public ItemStack create() {
        ItemStack item = new ItemStack(material, amount);
        item.setItemMeta(meta);
        return item;
    }

    public void apply(ItemStack initial) {
        initial.setType(material);
        initial.setAmount(amount);
        initial.setItemMeta(meta);
    }
}
