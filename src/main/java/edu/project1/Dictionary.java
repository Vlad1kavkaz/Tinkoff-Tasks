package edu.project1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Dictionary {

    private Dictionary() {
    }

    private static String[] WORDS = new String[] {
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

    public static void addWordsFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+"); // разделение строки на слова, предполагая, что слова разделены пробелами
                addWords(words);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addWords(String... words) {
        int originalLength = WORDS.length;
        int newLength =
            originalLength + words.length;

        String[] updatedWords = new String[newLength];

        System.arraycopy(WORDS, 0, updatedWords, 0, originalLength);

        System.arraycopy(words, 0, updatedWords, originalLength, words.length);

        WORDS = updatedWords;
    }

    public static int getWORDSLength() {
        return WORDS.length;
    }

    public static String[] getWords() {
        return WORDS;
    }

    public static String getRandomWord() {
        return WORDS[new Random().nextInt(WORDS.length)];
    }

    public static HashMap<Character, HashSet<Integer>> getIndexes(String word) {
        var characterIndexes = new HashMap<Character, HashSet<Integer>>();

        for (int i = 0; i < word.length(); i++) {
            characterIndexes.computeIfAbsent(word.charAt(i), ignored -> new HashSet<>()).add(i);
        }

        return characterIndexes;
    }
}
