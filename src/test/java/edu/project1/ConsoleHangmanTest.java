package edu.project1;


import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ConsoleHangmanTest {
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;

    private ByteArrayInputStream in;
    private ByteArrayOutputStream out;

    @Before
    public void setUpStreams() {
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @After
    public void restoreStreams() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    public void testGameWon() {
        String input = "a\nq\nq\n";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ConsoleHangman hangman = new ConsoleHangman(6);
        hangman.run();

        String output = out.toString();
        assertTrue(output.contains("You won!"));
    }

    @Test
    public void testGameLost() {
        String input = "a\nb\nc\nd\ne\nf\ng\nj\n";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ConsoleHangman hangman = new ConsoleHangman(6);
        hangman.run();

        String output = out.toString();
        assertTrue(output.contains("You lost!"));
    }
}
