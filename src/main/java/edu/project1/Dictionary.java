package edu.project1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import org.jetbrains.annotations.NotNull;

public class Dictionary {
    private static final String[] WORDS = new String[] {
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

    private Dictionary() {
    }

    public static @NotNull String getRandomWord() {
        return WORDS[new Random().nextInt(WORDS.length)];
    }

    public static @NotNull HashMap<Character, HashSet<Integer>> getIndexes(@NotNull String word) {
        var characterIndexes = new HashMap<Character, HashSet<Integer>>();

        for (int i = 0; i < word.length(); i++) {
            if (!characterIndexes.containsKey(word.charAt(i))) {
                characterIndexes.put(word.charAt(i), new HashSet<>());
            }

            characterIndexes.get(word.charAt(i)).add(i);
        }

        return characterIndexes;
    }
}
