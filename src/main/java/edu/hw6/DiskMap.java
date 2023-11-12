package edu.hw6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import org.jetbrains.annotations.NotNull;


public class DiskMap implements Map<String, String> {

    private static final Logger LOGGER = Logger.getLogger(DiskMap.class.getName());

    private Map<String, String> map;
    private String filePath;

    public DiskMap(String filePath) {
        this.map = new HashMap<>();
        this.filePath = filePath;
        loadFromFile();
    }

    private void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    map.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            // Обработка ошибок при чтении файла с использованием логгера
            LOGGER.warning("Error reading from file: " + e.getMessage());
        }
    }

    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            // Обработка ошибок при записи в файл с использованием логгера
            LOGGER.warning("Error writing to file: " + e.getMessage());
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
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    @Override
    public String get(Object key) {
        return map.get(key);
    }

    @Override
    public String put(String key, String value) {
        String previousValue = map.put(key, value);
        saveToFile(); // Сохранение после изменения
        return previousValue;
    }

    @Override
    public String remove(Object key) {
        String removedValue = map.remove(key);
        saveToFile(); // Сохранение после изменения
        return removedValue;
    }

    @Override
    public void putAll(@NotNull Map<? extends String, ? extends String> m) {

    }

    @Override
    public void clear() {

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

    @Override
    @NotNull
    public Set<Entry<String, String>> entrySet() {
        return map.entrySet();
    }


    private DiskMap() {

    }
}

