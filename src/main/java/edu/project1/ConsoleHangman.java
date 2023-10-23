package edu.project1;

import java.util.Arrays;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConsoleHangman {
    private final static Logger LOGGER = LogManager.getLogger();

    private final int maxMistakesCount;

    public ConsoleHangman(int maxMistakesCount) {
        this.maxMistakesCount = Math.max(maxMistakesCount, 1);
    }

    private static boolean breakGame = false;
    private static boolean lostGame = false;
    private static Scanner scanner = new Scanner(System.in);

    public static boolean getBreakGame() {
        return breakGame;
    }

    public static boolean getLostGame() {
        return lostGame;
    }

    public void run() {
        LOGGER.info("Welcome to the Hangman game!");

        var word = Dictionary.getRandomWord();
        var indexes = Dictionary.getIndexes(word);
        char[] letters = new char[word.length()];
        Arrays.fill(letters, '*');

        int mistakes = 0;
        boolean gameWon = false;

        try {
            while (mistakes < maxMistakesCount && !gameWon) {
                LOGGER.info("Guess a letter(or \\q to stop game):");
                String guess = scanner.nextLine();

                if (guess.equals("\\q")) {
                    LOGGER.info("Game ended by user.");
                    breakGame = true;
                    break;
                }

                if (!isValidGuess(guess)) {
                    LOGGER.info("Please enter a single letter.");
                    continue;
                }
                char guessChar = guess.charAt(0);

                if (indexes.containsKey(guessChar)) {
                    LOGGER.info("Hit!");

                    for (int index : indexes.get(guessChar)) {
                        letters[index] = guessChar;
                    }
                    indexes.remove(guessChar);

                    if (indexes.isEmpty()) {
                        gameWon = true;
                    }
                } else {
                    mistakes++;
                    LOGGER.info("Missed, mistake " + mistakes + " out of " + maxMistakesCount + ".");
                }

                LOGGER.info("The word: " + String.valueOf(letters));
            }

            if (gameWon) {
                LOGGER.info("You won!");
            } else {
                lostGame = true;
                LOGGER.info("You lost!");
            }
        } catch (Exception e) {
            LOGGER.error("An error occurred: " + e.getMessage());
        }
    }

    private static boolean isValidGuess(String guess) {
        return guess.length() == 1 && guess.matches("[a-zA-Z]");
    }
}
