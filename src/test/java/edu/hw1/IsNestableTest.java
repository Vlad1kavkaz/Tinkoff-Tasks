package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NestedArrayTest {

    @Test
    void testIsNestable_whenNestableArraysInput_returnsTrue() {
        // Arrange
        int[] array1 = {1, 2, 3, 4};
        int[] array2 = {0, 6};
        int[] array3 = {3, 1};
        int[] array4 = {4, 0};

        // Act
        boolean isNestable1 = IsNestable.isNestable(array1, array2);
        boolean isNestable2 = IsNestable.isNestable(array3, array4);

        // Assert
        assertTrue(isNestable1);
        assertTrue(isNestable2);

    }

    @Test
    void testIsNestable_whenNonNestableArraysInput_returnsFalse() {
        // Arrange
        int[] array1 = {9, 9, 8};
        int[] array2 = {8, 9};
        int[] array3 = {1, 2, 3, 4};
        int[] array4 = {2, 3};

        // Act
        boolean isNestable1 = IsNestable.isNestable(array1, array2);
        boolean isNestable2 = IsNestable.isNestable(array3, array4);

        // Assert
        assertFalse(isNestable1);
        assertFalse(isNestable2);
    }

    @Test
    void testIsNestable_whenEmptyArraysInput_returnsFalse() {
        // Arrange
        int[] array1 = {};
        int[] array2 = {1, 1, 4};

        // Act
        boolean isNestable = IsNestable.isNestable(array1, array2);

        // Assert
        assertFalse(isNestable);
    }
}
