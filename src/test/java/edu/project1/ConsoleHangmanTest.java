package edu.project1;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsoleHangmanTest {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream inputStream;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void tearDown() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    public void testRunGame_UserWins() {
        String input = "a\nb\nc\nd\nq\n";
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ConsoleHangman hangman = new ConsoleHangman(6);
        hangman.run();

        String output = outputStream.toString().trim();
        assertEquals("Welcome to the Hangman game!", output.split("\n")[0]);
        assertEquals("Guess a letter(or \\q to stop game):", output.split("\n")[1]);
        assertEquals("Hit!", output.split("\n")[5]);
        assertEquals("You won!", output.split("\n")[14]);
    }

    @Test
    public void testRunGame_UserLoses() {
        String input = "a\nb\nc\nd\ne\nf\nq\n";
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ConsoleHangman hangman = new ConsoleHangman(3);
        hangman.run();

        String output = outputStream.toString().trim();
        assertEquals("Welcome to the Hangman game!", output.split("\n")[0]);
        assertEquals("Guess a letter(or \\q to stop game):", output.split("\n")[1]);
        assertEquals("Missed, mistake 1 out of 3.", output.split("\n")[2]);
        assertEquals("Missed, mistake 2 out of 3.", output.split("\n")[3]);
        assertEquals("Missed, mistake 3 out of 3.", output.split("\n")[4]);
        assertEquals("You lost!", output.split("\n")[14]);
    }

    @Test
    public void testRunGame_UserQuits() {
        String input = "a\nb\nc\nd\nq\n";
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ConsoleHangman hangman = new ConsoleHangman(6);
        hangman.run();

        String output = outputStream.toString().trim();
        assertEquals("Welcome to the Hangman game!", output.split("\n")[0]);
        assertEquals("Guess a letter(or \\q to stop game):", output.split("\n")[1]);
        assertEquals("Game ended by user.", output.split("\n")[4]);
        assertEquals("You lost!", output.split("\n")[14]);
    }
}
