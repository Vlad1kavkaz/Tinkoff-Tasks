package edu.project1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DictionaryTest {
    private Dictionary dictionary;

    @Test
    @DisplayName("Проверка генерации слова")
    void getRandomWord() {
        String randomWord = dictionary.getRandomWord();
        Assertions.assertThat(randomWord).isNotEmpty();
        Assertions.assertThat(randomWord).isIn(Dictionary.getWords());
    }

    @Test
    @DisplayName("Проверка доступа по индексам")
    void getIndexes() {
        String word = "emphasis";
        HashMap<Character, HashSet<Integer>> expectedIndexes = new HashMap<>();
        expectedIndexes.put('e', new HashSet<>(Set.of(0)));
        expectedIndexes.put('m', new HashSet<>(Set.of(1)));
        expectedIndexes.put('p', new HashSet<>(Set.of(2)));
        expectedIndexes.put('h', new HashSet<>(Set.of(3)));
        expectedIndexes.put('a', new HashSet<>(Set.of(4)));
        expectedIndexes.put('s', new HashSet<>(Set.of(5, 7)));
        expectedIndexes.put('i', new HashSet<>(Set.of(6)));

        HashMap<Character, HashSet<Integer>> actualIndexes = dictionary.getIndexes(word);

        Assertions.assertThat(actualIndexes).isEqualTo(expectedIndexes);
    }

    @Test
    @DisplayName("Добавление нового слова")
    void addWords_1() {
        String word1 = "NewWord1";
        String word2 = "NewWord2";
        int len1 = Dictionary.getWORDSLength()+2;
        Dictionary.addWords(word1, word2);
        int len2 = Dictionary.getWORDSLength();
        assertEquals(len1, len2);
    }


}
