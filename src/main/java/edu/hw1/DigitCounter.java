package edu.hw1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

// task2
public final class DigitCounter {
    private static final Properties PROPERTIES = new Properties();

    static {
        try {
            PROPERTIES.load(new FileInputStream("src/main/resources/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private DigitCounter() {
    }

    public static int countDigits(int number) {
        int testingNumber = number;
        int numberOfDigits = 0;
        int divider = Integer.parseInt(PROPERTIES.getProperty("divider"));
        do {
            numberOfDigits++;
            testingNumber /= divider;
        } while (testingNumber != 0);

        return numberOfDigits;
    }
}
