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
        BigInteger num1 = new BigInteger("11211230");
        BigInteger num2 = new BigInteger("13001120");
        BigInteger num3 = new BigInteger("23336014");
        BigInteger num4 = new BigInteger("11");
        BigInteger num5 = new BigInteger("5");

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
