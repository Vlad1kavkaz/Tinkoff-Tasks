package edu.hw6.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DiskMap implements Map<String, String> {
    private Map<String, String> map;

    public DiskMap() {
        this.map = new HashMap<>();
    }

    public void saveFile(final Path filePath) {
        try (PrintWriter writer = new PrintWriter(filePath.toFile())) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                writer.println(entry.getKey() + ":" + entry.getValue());
            }
        } catch (IOException e) {
            Logger logger = Logger.getLogger(DiskMap.class.getName());
            logger.severe(e.getMessage());
        }
    }

    public void readFile(final Path filePath) {
        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    map.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            Logger logger = Logger.getLogger(DiskMap.class.getName());
            logger.severe(e.getMessage());
        }
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean containsKey(final Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(final Object value) {
        return map.containsValue(value);
    }

    @Override
    public String get(final Object key) {
        return map.get(key);
    }

    @Nullable
    @Override
    public String put(final String key, final String value) {
        return map.put(key, value);
    }

    @Override
    public String remove(final Object key) {
        return map.remove(key);
    }

    @Override
    public void putAll(
        final @NotNull Map<? extends String, ? extends String> m
    ) {
        map.putAll(m);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @NotNull
    @Override
    public Set<String> keySet() {
        return map.keySet();
    }

    @NotNull
    @Override
    public Collection<String> values() {
        return map.values();
    }

    @NotNull
    @Override
    public Set<Entry<String, String>> entrySet() {
        return map.entrySet();
    }
}
