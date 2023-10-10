package edu.hw1;

import java.math.BigInteger;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IsPalindromeDescendantTest {
    @Test
    @DisplayName("Особый палиндром")
    public void testIsPalindromeDescendant() {
        // given
        int num1 = 11211230;
        int num2 = 13001120;
        int num3 = 23336014;
        int num4 = 11;
        int num5 = 5;

        // when
        boolean result1 = IsPalindromeDescendant.isPalindromeDescendant(num1);
        boolean result2 = IsPalindromeDescendant.isPalindromeDescendant(num2);
        boolean result3 = IsPalindromeDescendant.isPalindromeDescendant(num3);
        boolean result4 = IsPalindromeDescendant.isPalindromeDescendant(num4);
        boolean result5 = IsPalindromeDescendant.isPalindromeDescendant(num5);

        // then
        assertTrue(result1);
        assertTrue(result2);
        assertTrue(result3);
        assertTrue(result4);
        assertFalse(result5);
    }
}
