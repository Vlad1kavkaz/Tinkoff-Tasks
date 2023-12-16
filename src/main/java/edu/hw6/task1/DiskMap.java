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

public final class DiskMap implements Map<String, String> {
    private Map<String, String> map;
    private Path filePath;

    public DiskMap(Path filePath) {
        this.filePath = filePath;
        this.map = new HashMap<>();
        // Считываем данные с диска при создании объекта
        readFile();
    }

    public void saveFile() {
        try (PrintWriter writer = new PrintWriter(filePath.toFile())) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                writer.println(entry.getKey() + ":" + entry.getValue());
            }
        } catch (IOException e) {
            Logger logger = Logger.getLogger(DiskMap.class.getName());
            logger.severe(e.getMessage());
        }
    }

    public void readFile() {
        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    map.put(parts[0], parts[1]);
                } else {
                    // Обработка некорректных данных в файле, например, выброс исключения
                    throw new IOException("Invalid data format in the file: " + filePath);
                }
            }
        } catch (IOException e) {
            Logger logger = Logger.getLogger(DiskMap.class.getName());
            logger.severe(e.getMessage());
        }
    }

    public void writeFile() {
        // Сохраняем данные на диск
        saveFile();
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
        return map.put(key, value);
    }

    @Override
    public String remove(Object key) {
        return map.remove(key);
    }

    @Override
    public void putAll(Map<? extends String, ? extends String> m) {
        map.putAll(m);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Set<String> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<String> values() {
        return map.values();
    }

    @Override
    public Set<Entry<String, String>> entrySet() {
        return map.entrySet();
    }
}
