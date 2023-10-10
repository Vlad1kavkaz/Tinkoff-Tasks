package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RotateTest {

    // Тестируем метод rotateLeft
    @Test @DisplayName("Rotate Left Test") void testRotateLeft() {
        assertEquals(1, Rotate.rotateLeft(16, 1));
        assertEquals(6, Rotate.rotateLeft(17, 2));
    }

    // Тестируем метод rotateRight
    @Test @DisplayName("Rotate Right Test") void testRotateRight() {
        assertEquals(4, Rotate.rotateRight(8, 1));
    }

}
