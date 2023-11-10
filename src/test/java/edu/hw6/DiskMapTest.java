package edu.hw6;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class DiskMapTest {
    private static final String TEST_FILE_PATH = "test_diskmap.txt";
    private DiskMap diskMap;

    @BeforeEach
    public void setUp() {
        diskMap = new DiskMap(TEST_FILE_PATH);
    }

    @AfterEach
    public void tearDown() {
        File testFile = new File(TEST_FILE_PATH);
        if (testFile.exists()) {
            testFile.delete();
        }
    }

    @Test
    public void testPutAndGet() {
        diskMap.put("key1", "value1");
        assertEquals("value1", diskMap.get("key1"));
    }

    @Test
    public void testRemove() {
        diskMap.put("key1", "value1");
        diskMap.remove("key1");
        assertNull(diskMap.get("key1"));
    }

    @Test
    public void testSize() {
        diskMap.put("key1", "value1");
        diskMap.put("key2", "value2");
        assertEquals(2, diskMap.size());
    }

    @Test
    public void testContainsKey() {
        diskMap.put("key1", "value1");
        assertTrue(diskMap.containsKey("key1"));
        assertFalse(diskMap.containsKey("nonexistentKey"));
    }

    // Добавьте дополнительные тесты по необходимости

}
