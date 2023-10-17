package edu.project1;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConsoleHangmanTest {
    private static final Logger LOGGER = LogManager.getLogger();

    @Test
    @DisplayName("Test run() method - Game lost")
    public void testRun_GameLost() {

        String input = "b\nb\nc\nd\ne\n";

        InputStream inputStream = System.in;
        PrintStream printStream = System.out;
        Logger testLogger = LogManager.getLogger(ConsoleHangman.class);

        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

            System.setIn(byteArrayInputStream);
            System.setOut(new PrintStream(byteArrayOutputStream));

            ConsoleHangman hangman = new ConsoleHangman(3);
            hangman.run();

            String actualOutput = byteArrayOutputStream.toString().trim();
            Assertions.assertTrue(ConsoleHangman.lostGame);

            testLogger.info(actualOutput);
        } finally {
            System.setIn(inputStream);
            System.setOut(printStream);
        }
    }

    @Test
    @DisplayName("Test run() method - Game ended by user")
    public void testRun_GameEndedByUser() {
        LOGGER.info("Running test for run() method in ConsoleHangman class (Game ended by user).");

        String input = "\\q\n";

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        System.setIn(byteArrayInputStream);
        System.setOut(new PrintStream(byteArrayOutputStream));

        ConsoleHangman hangman = new ConsoleHangman(3);
        hangman.run();

        Assertions.assertTrue(ConsoleHangman.breakGame);
    }
}
