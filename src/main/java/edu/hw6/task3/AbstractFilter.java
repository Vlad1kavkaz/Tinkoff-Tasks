package edu.hw6.task3;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public interface AbstractFilter extends DirectoryStream.Filter<Path> {
    AbstractFilter REGULAR_FILE = Files::isRegularFile;
    AbstractFilter READABLE = Files::isReadable;
    AbstractFilter WRITABLE = Files::isWritable;

    boolean accept(Path entry) throws IOException;

    default AbstractFilter and(AbstractFilter other) {
        return entry -> accept(entry) && other.accept(entry);
    }

    static AbstractFilter largerThan(long size) {
        return entry -> Files.size(entry) > size;
    }

    static AbstractFilter smallThan(long size) {
        return entry -> Files.size(entry) < size;
    }

    static AbstractFilter globMatches(String glob) {
        return entry -> FileSystems.getDefault()
            .getPathMatcher("glob:" + glob)
            .matches(entry.getFileName());
    }

    static AbstractFilter magicNumber(char... bytes) {
        return path -> {
            var fileBytes = Files.readAllBytes(path);
            if (bytes.length > fileBytes.length) {
                return false;
            }

            for (int i = 0; i < bytes.length; i++) {
                if (bytes[i] != fileBytes[i]) {
                    return false;
                }
            }
            return true;
        };
    }

    static AbstractFilter regexContains(String regex) {
        return (t) -> t.getFileName().toString().matches(regex);
    }
}
