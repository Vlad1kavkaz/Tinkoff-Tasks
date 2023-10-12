package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthVideoTest {

    @Test
    void testMinutesToSeconds_whenValidInput_returnsTotalSeconds() {
        // Arrange
        String inputTime1 = "1:00";
        String inputTime2 = "13:56";
        String inputTime3 = "00:59";

        // Act
        int actualSeconds1 = LengthVideo.minutesToSeconds(inputTime1);
        int actualSeconds2 = LengthVideo.minutesToSeconds(inputTime2);
        int actualSeconds3 = LengthVideo.minutesToSeconds(inputTime3);

        // Assert
        assertEquals(60, actualSeconds1);
        assertEquals(836, actualSeconds2);
        assertEquals(59, actualSeconds3);
    }

    @Test
    void testMinutesToSeconds_whenInvalidInput_returnsMinusOne() {
        // Arrange
        String inputTime1 = "10:60";
        String inputTime2 = "10:-1";
        String inputTime3 = "asd:10";
        String inputTime4 = "10:asd";
        String inputTime5 = "asd:asds";

        // Act
        int actualSeconds1 = LengthVideo.minutesToSeconds(inputTime1);
        int actualSeconds2 = LengthVideo.minutesToSeconds(inputTime2);
        int actualSeconds3 = LengthVideo.minutesToSeconds(inputTime3);
        int actualSeconds4 = LengthVideo.minutesToSeconds(inputTime4);
        int actualSeconds5 = LengthVideo.minutesToSeconds(inputTime5);

        // Assert
        assertEquals(-1, actualSeconds1);
        assertEquals(-1, actualSeconds2);
        assertEquals(-1, actualSeconds3);
        assertEquals(-1, actualSeconds4);
        assertEquals(-1, actualSeconds5);
    }
}
