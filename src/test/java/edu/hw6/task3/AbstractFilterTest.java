package edu.hw6.task3;

import edu.hw6.task1.DiskMap;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.junit.jupiter.api.Test;
import static edu.hw6.task3.AbstractFilter.READABLE;
import static edu.hw6.task3.AbstractFilter.REGULAR_FILE;
import static edu.hw6.task3.AbstractFilter.WRITABLE;
import static edu.hw6.task3.AbstractFilter.globMatches;
import static edu.hw6.task3.AbstractFilter.largerThan;
import static edu.hw6.task3.AbstractFilter.regexContains;

class AbstractFilterTest {

    private void createDisk(String filename) {
        DiskMap diskMap = new DiskMap();

        Path currentDirectory = Paths.get("src/test/java/edu/hw6/task3/").toAbsolutePath();
        Path filePath = currentDirectory.resolve(filename);

        diskMap.saveFile(filePath);
    }

    @Test
    void testThatAllFilesRegularReadableWritableReturnedTrue() {
        List<String> filenames = List.of(
            "file1.txt",
            "file2.txt",
            "pictureFile1.png",
            "pictureFile2.png"
        );

        Path currentDirectory = Paths.get("src/test/java/edu/hw6/task3/files/rrw/").toAbsolutePath();
        for (String filename : filenames) {
            Path filePath = currentDirectory.resolve(filename);

            try {
                READABLE.accept(filePath);
                WRITABLE.accept(filePath);
                REGULAR_FILE.accept(filePath);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Filtered Files:");
        DirectoryStream.Filter<Path> filter = REGULAR_FILE
            .and(READABLE)
            .and(WRITABLE);

        try (DirectoryStream<Path> entries = Files.newDirectoryStream(currentDirectory, filter)) {
            entries.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testThatFilterReturnedCorrectFile() {
        Path currentDirectory = Paths.get("src/test/java/edu/hw6/task3/files/rrw/").toAbsolutePath();
        System.out.println("Filtered Files:");

        DirectoryStream.Filter<Path> filter = REGULAR_FILE
            .and(READABLE)
            .and(largerThan(10))
            .and(AbstractFilter.magicNumber('1', '2', '3'))
            .and(globMatches("*.txt"))
            .and(regexContains(".*"));

        try (DirectoryStream<Path> entries = Files.newDirectoryStream(currentDirectory, filter)) {
            entries.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
