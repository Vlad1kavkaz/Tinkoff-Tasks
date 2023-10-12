package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FixStringTest {

    @Test
    void testFixString_whenBrokenStringInput_returnsFixedString() {
        // Arrange
        String brokenStr1 = "123456";
        String brokenStr2 = "hTsii  s aimex dpus rtni.g";

        // Act
        String fixedStr1 = FixString.fixString(brokenStr1);
        String fixedStr2 = FixString.fixString(brokenStr2);

        // Assert
        assertEquals("214365", fixedStr1);
        assertEquals("This is a mixed up string.", fixedStr2);
    }

    @Test
    void testFixString_whenProvidedStringWithOddNumberOfCharacters_returnsFixedString() {
        // Arrange
        String brokenStr1 = "badce";
        String brokenStr2 = "w";

        // Act
        String fixedStr1 = FixString.fixString(brokenStr1);
        String fixedStr2 = FixString.fixString(brokenStr2);

        // Assert
        assertEquals("abcde", fixedStr1);
        assertEquals("w", fixedStr2);
    }

    @Test
    void testFixString_whenProvidedEmptyString_returnsEmptyString() {
        // Arrange
        String brokenStr = "";

        // Act
        String fixedStr = FixString.fixString(brokenStr);

        // Assert
        assertEquals("", fixedStr);
    }
}
