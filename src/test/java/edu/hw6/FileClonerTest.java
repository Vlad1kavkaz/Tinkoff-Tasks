package edu.hw6;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Objects;
import static org.junit.jupiter.api.Assertions.*;

public class FileClonerTest {

    @Test
    void testCloneFile() throws IOException {
        // Создаем временный каталог и файл для теста
        File tempDir = Files.createTempDirectory("tempDir").toFile();
        File originalFile = new File(tempDir, "testFile.txt");
        assertTrue(originalFile.createNewFile());

        // Создаем экземпляр FileCloner и клонируем файл
        FileCloner.cloneFile(originalFile.getAbsolutePath());

        // Проверяем, что скопированный файл существует и имеет правильное имя
        File[] filesInTempDir = Objects.requireNonNull(tempDir.listFiles());
        assertEquals(2, filesInTempDir.length); // Оригинал + копия
        assertTrue(filesInTempDir[0].getName().endsWith(".txt"));
        assertTrue(filesInTempDir[1].getName().startsWith("testFile — копия"));

        // Проверяем, что содержимое скопированного файла идентично оригиналу
        String originalContent = Files.readString(originalFile.toPath());
        String copiedContent = Files.readString(filesInTempDir[1].toPath());
        assertEquals(originalContent, copiedContent);

        // Удаляем временный каталог
        deleteDirectory(tempDir);
    }

    // Метод для рекурсивного удаления директории
    private void deleteDirectory(File directory) {
        File[] allContents = directory.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                deleteDirectory(file);
            }
        }
        directory.delete();
    }
}
