package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountKTest {

    @Test
    void testCountK_whenProvidedValidNumber_returnsNumberIterations() {
        // Arrange
        int number1 = 6621;
        int number2 = 6554;
        int number3 = 1234;
        int number4 = 1000;
        int number5 = 9998;

        // Act
        int countIterations1 = CountK.countK(number1);
        int countIterations2 = CountK.countK(number2);
        int countIterations3 = CountK.countK(number3);
        int countIterations4 = CountK.countK(number4);
        int countIterations5 = CountK.countK(number5);

        // Assert
        assertEquals(5, countIterations1);
        assertEquals(4, countIterations2);
        assertEquals(3, countIterations3);
        assertEquals(5, countIterations4);
        assertEquals(5, countIterations5);
    }

    @Test
    void testCountK_whenProvidedInvalidNumber_throwRuntimeException() {
        // Arrange
        int number1 = 999;
        int number2 = 9999;
        int number3 = 10000;

        // Act

        // Assert
        assertThrows(RuntimeException.class, () -> CountK.countK(number1));
        assertThrows(RuntimeException.class, () -> CountK.countK(number2));
        assertThrows(RuntimeException.class, () -> CountK.countK(number3));
    }
}
