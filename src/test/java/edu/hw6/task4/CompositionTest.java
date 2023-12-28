package edu.hw6.task4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class CompositionTest {

    @Test
    void testThatCompositionSaveMessageInFile() {
        String filename = "Brain.txt";
        String message = "Programming is learned by writing programs. ― Brian Kernighan";

        Composition.createComposition(filename, message);

        Path currentDirectory = Paths.get("src/test/java/edu/hw6/task4/").toAbsolutePath();
        Path filePath = currentDirectory.resolve(filename);

        try {
            assertFalse(Files.readAllLines(filePath).isEmpty());
            assertEquals(message, Files.readAllLines(filePath).get(0));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
