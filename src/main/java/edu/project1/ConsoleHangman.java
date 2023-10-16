package edu.project1;

import java.util.Arrays;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

public class ConsoleHangman {
    private final static Logger LOGGER = LogManager.getLogger();

    private final int maxMistakesCount;

    public ConsoleHangman(int maxMistakesCount) {
        this.maxMistakesCount = Math.max(maxMistakesCount, 1);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        LOGGER.info("Welcome to the Hangman game!");

        var word = Dictionary.getRandomWord();
        var indexes = Dictionary.getIndexes(word);
        char[] letters = new char[word.length()];
        Arrays.fill(letters, '*');

        int mistakes = 0;
        boolean gameWon = false;

        while (mistakes < maxMistakesCount && !gameWon) {
            LOGGER.info("Guess a letter(or \\q to stop game):");
            String guess = scanner.nextLine();

            if (guess.equals("\\q")) {
                LOGGER.info("Game ended by user.");
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
            LOGGER.info("You lost!");
        }

        scanner.close();
    }

    private static boolean isValidGuess(@NotNull String guess) {
        return guess.length() == 1 && guess.matches("[a-zA-Z]");
    }
}
