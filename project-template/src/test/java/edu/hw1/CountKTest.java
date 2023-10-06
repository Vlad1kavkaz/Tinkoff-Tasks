package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountKTest {

    @Test
    @DisplayName("Test countK for number 3524")
    public void testCountK3524() {
        // given
        int number = 3524;

        // when
        int result = CountK.countK(number);

        // then
        assertEquals(3, result);
    }

    @Test
    @DisplayName("Test countK for number 6621")
    public void testCountK6621() {
        // given
        int number = 6621;

        // when
        int result = CountK.countK(number);

        // then
        assertEquals(5, result);
    }

    @Test
    @DisplayName("Test countK for number 6554")
    public void testCountK6554() {
        // given
        int number = 6554;

        // when
        int result = CountK.countK(number);

        // then
        assertEquals(4, result);
    }

    @Test
    @DisplayName("Test countK for number 1234")
    public void testCountK1234() {
        // given
        int number = 1234;

        // when
        int result = CountK.countK(number);

        // then
        assertEquals(3, result);
    }
}
