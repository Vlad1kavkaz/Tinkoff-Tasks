package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CyclicBitShiftTest {

    @Test
    void testRotateRight_whenProvidedValidData_returnsNumber() {
        // Arrange
        int number1 = 8;
        int shift1 = 1;
        int number2 = 5;
        int shift2 = 2;
        int number3 = 0;
        int shift3 = 2;
        int number4 = 1;
        int shift4 = 0;

        // Act
        int result1 = Rotate.rotateRight(number1, shift1);
        int result2 = Rotate.rotateRight(number2, shift2);
        int result3 = Rotate.rotateRight(number3, shift3);
        int result4 = Rotate.rotateRight(number4, shift4);

        // Assert
        assertEquals(4, result1);
        assertEquals(3, result2);
        assertEquals(0, result3);
        assertEquals(1, result4);
    }

    @Test
    void testRotateRight_whenProvidedInvalidData_throwRuntimeException() {
        // Arrange
        int number1 = -2;
        int shift1 = 1;
        int number2 = 5;
        int shift2 = -2;

        // Act

        // Assert
        assertThrows(RuntimeException.class, () -> Rotate.rotateRight(number1, shift1));
        assertThrows(RuntimeException.class, () -> Rotate.rotateRight(number2, shift2));
    }

    @Test
    void testRotateLeft_whenProvidedValidData_returnsNumber() {
        // Arrange
        int number1 = 16;
        int shift1 = 1;
        int number2 = 17;
        int shift2 = 2;
        int number3 = 0;
        int shift3 = 2;
        int number4 = 1;
        int shift4 = 0;

        // Act
        int result1 = Rotate.rotateLeft(number1, shift1);
        int result2 = Rotate.rotateLeft(number2, shift2);
        int result3 = Rotate.rotateLeft(number3, shift3);
        int result4 = Rotate.rotateLeft(number4, shift4);

        // Assert
        assertEquals(1, result1);
        assertEquals(6, result2);
        assertEquals(0, result3);
        assertEquals(1, result4);
    }

    @Test
    void testRotateLeft_whenProvidedInvalidData_throwRuntimeException() {
        // Arrange
        int number1 = -2;
        int shift1 = 1;
        int number2 = 5;
        int shift2 = -2;

        // Act

        // Assert
        assertThrows(RuntimeException.class, () -> Rotate.rotateLeft(number1, shift1));
        assertThrows(RuntimeException.class, () -> Rotate.rotateLeft(number2, shift2));
    }
}
