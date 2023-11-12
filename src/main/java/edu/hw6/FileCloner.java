package edu.hw6;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileCloner {

    private static final Logger LOGGER = Logger.getLogger(FileCloner.class.getName());

    public static void main(String[] args) {
        String filePath = "путь_к_вашему_файлу/Tinkoff Bank Biggest Secret.txt";
        cloneFile(filePath);
    }

    public static void cloneFile(String filePath) {
        File originalFile = new File(filePath);
        String directory = originalFile.getParent();
        String fileName = originalFile.getName();

        String baseName = fileName.substring(0, fileName.lastIndexOf('.'));
        String extension = fileName.substring(fileName.lastIndexOf('.'));

        int counter = 1;
        String newFileName;
        File newFile;

        do {
            newFileName = counter > 1 ?
                String.format("%s — копия (%d)%s", baseName, counter, extension) :
                String.format("%s — копия%s", baseName, extension);

            newFile = new File(directory, newFileName);
            counter++;
        } while (newFile.exists());

        try {
            Files.copy(originalFile.toPath(), newFile.toPath(), StandardCopyOption.COPY_ATTRIBUTES);
            LOGGER.info("Файл скопирован как " + newFileName);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Ошибка при копировании файла", e);
        }
    }
}

