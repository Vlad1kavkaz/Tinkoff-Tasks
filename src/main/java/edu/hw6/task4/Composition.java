package edu.hw6.task4;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;
import java.util.zip.Adler32;
import java.util.zip.CheckedOutputStream;

public final class Composition {
    private static String path = "src/test/java/edu/hw6/task4/";

    private Composition() {
    }

    public static void createComposition(
        final String filename,
        final String message
    ) {
        Path currentDirectory = Paths.get(path).toAbsolutePath();
        Path filePath = currentDirectory.resolve(filename);

        try (
            OutputStream fileOutputStream = Files.newOutputStream(filePath);
            CheckedOutputStream checkedOutputStream =
                new CheckedOutputStream(fileOutputStream, new Adler32());
            BufferedOutputStream bufferedOutputStream =
                new BufferedOutputStream(checkedOutputStream);
            OutputStreamWriter outputStreamWriter =
                new OutputStreamWriter(bufferedOutputStream, "UTF-8");
            PrintWriter printWriter = new PrintWriter(outputStreamWriter)) {

            printWriter.println(message);

        } catch (IOException e) {
            Logger logger = Logger.getLogger(Composition.class.getName());
            logger.severe("Error: " + e.getMessage());
        }
    }
}
