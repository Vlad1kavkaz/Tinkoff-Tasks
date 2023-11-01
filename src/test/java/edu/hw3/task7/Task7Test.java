package edu.hw3.task7;

import java.util.TreeMap;
import java.util.Comparator;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task7Test {

    @Test
    void testNullsFirstComparator() {
        TreeMap<String, String> tree = new TreeMap<>(Comparator.nullsFirst(Comparator.naturalOrder()));
        tree.put(null, "test");
        assertThat(tree.containsKey(null)).isTrue();
    }

    @Test
    void testNullsLastComparator() {
        TreeMap<String, String> tree = new TreeMap<>(Comparator.nullsLast(Comparator.naturalOrder()));
        tree.put(null, "test");
        assertThat(tree.containsKey(null)).isTrue();
    }

    @Test
    void testWithCommonKeys() {
        TreeMap<String, String> tree = new TreeMap<>(Comparator.nullsFirst(Comparator.naturalOrder()));

        tree.put("first", "first");
        tree.put("second", "second");

        assertThat(tree.containsKey("first")).isTrue();
        assertThat(tree.containsKey("second")).isTrue();
        assertThat(tree.containsKey("third")).isFalse();
    }
}
