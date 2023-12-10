package edu.hw6.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class FileCloner {
    private static final String PATTERN =
        "^(.*?)( — копия )?\\(?(\\d+)?\\)?(\\.txt)$";
    private static final int PATTERN_GROUP_DUPLICATE = 4;
    private static final int PATTERN_GROUP_SECOND_COPY = 3;
    private static final int PATTERN_GROUP_FIRST_COPY = 2;

    private static final Pattern FILE_NAME_PATTERN = Pattern.compile(PATTERN);

    private FileCloner() {
    }

    public static Boolean cloneFile(final Path originalPath) throws IOException {
        String newPathName = choosePattern(originalPath.toString());

        Path currentDirectory = Paths.get("").toAbsolutePath();
        Path filePath = currentDirectory.resolve(newPathName);

        // Копирование файла с использованием стандартных средств Java
        Files.copy(originalPath, filePath, StandardCopyOption.REPLACE_EXISTING);

        return true;
    }

    private static String choosePattern(final String string) {
        String patternForDuplicate = "^(.*)( — копия )\\((\\d+)\\)(\\.txt)$";
        String patternForSecondCopy = "^(.*)( — копия)(\\.txt)$";
        String patternForFirstCopy = "^(.*)(\\.txt)$";

        if (string.matches(patternForDuplicate)) {
            return concatenate(string, PATTERN_GROUP_DUPLICATE);
        } else if (string.matches(patternForSecondCopy)) {
            return concatenate(string, PATTERN_GROUP_SECOND_COPY);
        } else if (string.matches(patternForFirstCopy)) {
            return concatenate(string, PATTERN_GROUP_FIRST_COPY);
        } else {
            throw new IllegalArgumentException(
                "Invalid file name format: " + string
            );
        }
    }

    @SuppressWarnings("MagicNumber")
    private static String concatenate(final String input, final int groupCount) {
        Matcher matcher = FILE_NAME_PATTERN.matcher(input);

        if (matcher.matches()) {
            String prefix = matcher.group(1);
            String copySuffix = matcher.group(2);
            String originalNumber = matcher.group(PATTERN_GROUP_SECOND_COPY);
            String extension = matcher.group(PATTERN_GROUP_DUPLICATE);

            if (groupCount == PATTERN_GROUP_DUPLICATE) {
                int newNumber = originalNumber.equals(".txt") ? 1
                    : Integer.parseInt(originalNumber) + 1;
                return prefix + copySuffix + "(" + newNumber + ")" + extension;
            } else if (groupCount == PATTERN_GROUP_SECOND_COPY) {
                return prefix + " (2)" + extension;
            } else if (groupCount == PATTERN_GROUP_FIRST_COPY) {
                return prefix + " — копия" + extension;
            }
        }
        return "";
    }
}
