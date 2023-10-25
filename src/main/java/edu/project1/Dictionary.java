package edu.project1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.logging.Logger;

public class Dictionary {

    private Dictionary() {
    }

    private static String[] words = new String[] {
        "emphasis",
        "different",
        "hall",
        "pace",
        "ditch",
        "secular",
        "rotation",
        "empirical",
        "confine",
        "courtesy",
    };
    private static final Logger LOGGER = Logger.getLogger(Dictionary.class.getName());

    public static void addWordsFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineWords = line.split("\\s+");
                addWords(lineWords);
            }
        } catch (IOException e) {
            LOGGER.severe("An error occurred: " + e.getMessage());
            // Логируйте информацию об исключении, включая сообщение и стек вызовов
            LOGGER.severe("Stack trace: " + Arrays.toString(e.getStackTrace()));
        }
    }

    public static void addWords(String... wordsAdd) {
        int originalLength = words.length;
        int newLength =
            originalLength + wordsAdd.length;

        String[] updatedWords = new String[newLength];

        System.arraycopy(words, 0, updatedWords, 0, originalLength);

        System.arraycopy(wordsAdd, 0, updatedWords, originalLength, wordsAdd.length);

        words = updatedWords;
    }

    public static int getWORDSLength() {
        return words.length;
    }

    public static String[] getWords() {
        return words;
    }

    public static String getRandomWord() {
        return words[new Random().nextInt(words.length)];
    }

    public static HashMap<Character, HashSet<Integer>> getIndexes(String word) {
        var characterIndexes = new HashMap<Character, HashSet<Integer>>();

        for (int i = 0; i < word.length(); i++) {
            characterIndexes.computeIfAbsent(word.charAt(i), ignored -> new HashSet<>()).add(i);
        }

        return characterIndexes;
    }
}
