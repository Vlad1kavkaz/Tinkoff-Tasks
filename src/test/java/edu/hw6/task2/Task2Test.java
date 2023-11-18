package edu.hw6.task2;

import edu.hw6.task1.DiskMap;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Task2Test {
    private void createDisk(String filename) {
        DiskMap diskMap = new DiskMap();

        Path currentDirectory = Paths.get("src/test/java/edu/hw6/task2/").toAbsolutePath();
        Path filePath = currentDirectory.resolve(filename);

        diskMap.saveFile(filePath);
    }

    @Test
    void testThatClonePathAddCopySuffix() {
        String filename = "Tinkoff Bank Biggest Secret.txt";
        createDisk(filename);

        Path currentDirectory = Paths.get("src/test/java/edu/hw6/task2/").toAbsolutePath();
        Path filePath = currentDirectory.resolve(filename);

        try {
            assertTrue(
                FileCloner.cloneFile(filePath)
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testThatClonePathAddCopyNumber() {
        String filename = "Tinkoff Bank Biggest Secret — копия.txt";
        createDisk(filename);

        Path currentDirectory = Paths.get("src/test/java/edu/hw6/task2/").toAbsolutePath();

        Path filePath = currentDirectory.resolve(filename);

        try {
            assertTrue(
                FileCloner.cloneFile(filePath)
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testThatClonePathIncreaseCopyNumber() {
        String filename = "Tinkoff Bank Biggest Secret — копия (2).txt";
        createDisk(filename);

        Path currentDirectory = Paths.get("src/test/java/edu/hw6/task2/").toAbsolutePath();
        Path filePath = currentDirectory.resolve(filename);

        try {
            assertTrue(
                FileCloner.cloneFile(filePath)
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testThatClonePathIncreaseTwoDigitNumberToThreeDigit() {
        String filename = "Tinkoff Bank Biggest Secret — копия (99).txt";
        createDisk(filename);

        Path currentDirectory = Paths.get("src/test/java/edu/hw6/task2/").toAbsolutePath();
        Path filePath = currentDirectory.resolve(filename);

        try {
            assertTrue(
                FileCloner.cloneFile(filePath)
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
