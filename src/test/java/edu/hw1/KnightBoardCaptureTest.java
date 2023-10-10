package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChessboardTest {

    @Test
    void testKnightBoardCapture_whenProvidedArrayWithTrueCondition_returnsTrue() {
        // Arrange
        int[][] chessboard1 = {
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1, 0, 0, 0}
        };

        int[][] chessboard2 = {
            {1, 0, 0, 1, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 1, 1, 1, 0},
            {1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1},
            {0, 1, 0, 0, 1, 0, 0, 0}
        };

        // Act
        boolean isNotCross1 = KnightBoardCapture.knightBoardCapture(chessboard1);
        boolean isNotCross2 = KnightBoardCapture.knightBoardCapture(chessboard2);

        // Assert
        assertTrue(isNotCross1);
        assertTrue(isNotCross2);
    }

    @Test
    void testKnightBoardCapture_whenProvidedArrayWithFalseCondition_returnsFalse() {
        // Arrange
        int[][] chessboard1 = {
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 1, 0, 1}
        };

        int[][] chessboard2 = {
            {0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0}
        };

        // Act
        boolean isNotCross1 = KnightBoardCapture.knightBoardCapture(chessboard1);
        boolean isNotCross2 = KnightBoardCapture.knightBoardCapture(chessboard2);

        // Assert
        assertFalse(isNotCross1);
        assertFalse(isNotCross2);
    }
}
