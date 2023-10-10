package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class IsNestableTest {
    @Test
    @DisplayName("Вложенный массив")
    void isNestable() {
        //given
        int[] arr11 = {1, 2, 3, 4};
        int[] arr12 = {0, 6};
        int[] arr21 = {3, 1};
        int[] arr22 = {4, 0};
        int[] arr31 = {9, 9, 8};
        int[] arr32 = {8, 9};
        int[] arr41 = {1, 2, 3, 4};
        int[] arr42 = {2, 3};

        //when
        boolean result1 = IsNestable.isNestable(arr11, arr12);
        boolean result2 = IsNestable.isNestable(arr21, arr22);
        boolean result3 = IsNestable.isNestable(arr31, arr32);
        boolean result4 = IsNestable.isNestable(arr41, arr42);

        //then
        assertThat(result1).isEqualTo(true);
        assertThat(result2).isEqualTo(true);
        assertThat(result3).isEqualTo(false);
        assertThat(result4).isEqualTo(false);
    }
}
