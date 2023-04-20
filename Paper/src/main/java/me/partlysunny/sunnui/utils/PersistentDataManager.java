package me.partlysunny.sunnui.utils;

import org.bukkit.NamespacedKey;
import org.bukkit.persistence.PersistentDataAdapterContext;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

public record PersistentDataManager(PersistentDataContainer container) {

    private static final char SEPARATOR = '|';
    private static final String NAMESPACE = "realmmora";
    private static final PersistentDataType<String, String[]> STRING_ARRAY = new PersistentDataType<>() {
        @Override
        public @NotNull Class<String> getPrimitiveType() {
            return String.class;
        }

        @Override
        public @NotNull Class<String[]> getComplexType() {
            return String[].class;
        }

        @Override
        public @NotNull String toPrimitive(String @NotNull [] complex, @NotNull PersistentDataAdapterContext context) {
            return Arrays.stream(complex).collect(Collectors.joining(String.valueOf(SEPARATOR)));
        }

        @Override
        public String @NotNull [] fromPrimitive(@NotNull String primitive, @NotNull PersistentDataAdapterContext context) {
            return primitive.split(String.valueOf(SEPARATOR));
        }
    };

    public String readString(String key) {
        return container.get(NamespacedKey.fromString(NAMESPACE + ":" + key), PersistentDataType.STRING);
    }

    public void writeString(String key, String value) {
        container.set(NamespacedKey.fromString(NAMESPACE + ":" + key), PersistentDataType.STRING, value);
    }

    public Integer readInt(String key) {
        return container.get(NamespacedKey.fromString(NAMESPACE + ":" + key), PersistentDataType.INTEGER);
    }

    public void writeInt(String key, Integer value) {
        container.set(NamespacedKey.fromString(NAMESPACE + ":" + key), PersistentDataType.INTEGER, value);
    }

    public Double readDouble(String key) {
        return container.get(NamespacedKey.fromString(NAMESPACE + ":" + key), PersistentDataType.DOUBLE);
    }

    public void writeDouble(String key, Double value) {
        container.set(NamespacedKey.fromString(NAMESPACE + ":" + key), PersistentDataType.DOUBLE, value);
    }

    public Boolean readBoolean(String key) {
        return container.get(NamespacedKey.fromString(NAMESPACE + ":" + key), PersistentDataType.BYTE) == 1;
    }

    public void writeBoolean(String key, Boolean value) {
        container.set(NamespacedKey.fromString(NAMESPACE + ":" + key), PersistentDataType.BYTE, value ? (byte) 1 : (byte) 0);
    }

    public Long readLong(String key) {
        return container.get(NamespacedKey.fromString(NAMESPACE + ":" + key), PersistentDataType.LONG);
    }

    public void writeLong(String key, Long value) {
        container.set(NamespacedKey.fromString(NAMESPACE + ":" + key), PersistentDataType.LONG, value);
    }

    public Float readFloat(String key) {
        return container.get(NamespacedKey.fromString(NAMESPACE + ":" + key), PersistentDataType.FLOAT);
    }

    public void writeFloat(String key, Float value) {
        container.set(NamespacedKey.fromString(NAMESPACE + ":" + key), PersistentDataType.FLOAT, value);
    }

    public Short readShort(String key) {
        return container.get(NamespacedKey.fromString(NAMESPACE + ":" + key), PersistentDataType.SHORT);
    }

    public void writeShort(String key, Short value) {
        container.set(NamespacedKey.fromString(NAMESPACE + ":" + key), PersistentDataType.SHORT, value);
    }

    public Byte readByte(String key) {
        return container.get(NamespacedKey.fromString(NAMESPACE + ":" + key), PersistentDataType.BYTE);
    }

    public void writeByte(String key, Byte value) {
        container.set(NamespacedKey.fromString(NAMESPACE + ":" + key), PersistentDataType.BYTE, value);
    }

    public byte[] readByteArray(String key) {
        return container.get(NamespacedKey.fromString(NAMESPACE + ":" + key), PersistentDataType.BYTE_ARRAY);
    }

    public void writeByteArray(String key, byte[] value) {
        container.set(NamespacedKey.fromString(NAMESPACE + ":" + key), PersistentDataType.BYTE_ARRAY, value);
    }

    public int[] readIntArray(String key) {
        return container.get(NamespacedKey.fromString(NAMESPACE + ":" + key), PersistentDataType.INTEGER_ARRAY);
    }

    public void writeIntArray(String key, int[] value) {
        container.set(NamespacedKey.fromString(NAMESPACE + ":" + key), PersistentDataType.INTEGER_ARRAY, value);
    }

    public long[] readLongArray(String key) {
        return container.get(NamespacedKey.fromString(NAMESPACE + ":" + key), PersistentDataType.LONG_ARRAY);
    }

    public void writeLongArray(String key, long[] value) {
        container.set(NamespacedKey.fromString(NAMESPACE + ":" + key), PersistentDataType.LONG_ARRAY, value);
    }

    public String[] readStringArray(String key) {
        return container.get(NamespacedKey.fromString(NAMESPACE + ":" + key), STRING_ARRAY);
    }

    public void writeStringArray(String key, String[] value) {
        container.set(NamespacedKey.fromString(NAMESPACE + ":" + key), STRING_ARRAY, value);
    }

    public PersistentDataContainer readContainer(String key) {
        return container.get(NamespacedKey.fromString(NAMESPACE + ":" + key), PersistentDataType.TAG_CONTAINER);
    }

    public void writeContainer(String key, PersistentDataContainer value) {
        container.set(NamespacedKey.fromString(NAMESPACE + ":" + key), PersistentDataType.TAG_CONTAINER, value);
    }

    public PersistentDataContainer[] readContainers(String key) {
        return container.get(NamespacedKey.fromString(NAMESPACE + ":" + key), PersistentDataType.TAG_CONTAINER_ARRAY);
    }

    public void writeContainers(String key, PersistentDataContainer[] value) {
        container.set(NamespacedKey.fromString(NAMESPACE + ":" + key), PersistentDataType.TAG_CONTAINER_ARRAY, value);
    }

    public boolean has(String key) {
        return container.has(NamespacedKey.fromString(NAMESPACE + ":" + key), PersistentDataType.STRING);
    }

    public void remove(String key) {
        container.remove(NamespacedKey.fromString(NAMESPACE + ":" + key));
    }

    public void clear() {
        container.getKeys().forEach(container::remove);
    }

    public void write(String key, Object value) {
        if (value instanceof String) writeString(key, (String) value);
        else if (value instanceof Integer) writeInt(key, (Integer) value);
        else if (value instanceof Double) writeDouble(key, (Double) value);
        else if (value instanceof Boolean) writeBoolean(key, (Boolean) value);
        else if (value instanceof Long) writeLong(key, (Long) value);
        else if (value instanceof Float) writeFloat(key, (Float) value);
        else if (value instanceof Short) writeShort(key, (Short) value);
        else if (value instanceof Byte) writeByte(key, (Byte) value);
        else if (value instanceof byte[]) writeByteArray(key, (byte[]) value);
        else if (value instanceof int[]) writeIntArray(key, (int[]) value);
        else if (value instanceof long[]) writeLongArray(key, (long[]) value);
        else throw new IllegalArgumentException("Cannot write value of type " + value.getClass().getName());
    }

    public Set<String> keys() {
        return container.getKeys().stream().map(NamespacedKey::value).collect(Collectors.toSet());
    }

    public Iterator<String> iterator() {
        return container.getKeys().stream().map(NamespacedKey::value).iterator();
    }

}
