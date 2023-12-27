package edu.hw6.task2;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Task2Test {

    @Test
    void testThatClonePathAddCopySuffix() {
        String filename = "Tinkoff Bank Biggest Secret.txt";
        createFile(filename);

        Path currentDirectory = Paths.get("src/test/java/edu/hw6/task2/").toAbsolutePath();
        Path filePath = currentDirectory.resolve(filename);

        try {
            FileCloner.cloneFile(filePath);

            // Проверяем, что новый файл с суффиксом создан
            String clonedFilename = "Tinkoff Bank Biggest Secret — копия.txt";
            Path clonedFilePath = currentDirectory.resolve(clonedFilename);
            assertTrue(Files.exists(clonedFilePath), "Cloned file should exist");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testThatClonePathAddCopyNumber() {
        String filename = "Tinkoff Bank Biggest Secret — копия.txt";
        createFile(filename);

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
        createFile(filename);

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
        createFile(filename);

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

    private void createFile(String filename) {
        try {
            Path currentDirectory = Paths.get("src/test/java/edu/hw6/task2/").toAbsolutePath();
            Path filePath = currentDirectory.resolve(filename);

            // Создание файла с использованием Files.createFile
            Files.createFile(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
