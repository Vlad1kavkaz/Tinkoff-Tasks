package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FixStringTest {

    @Test
    @DisplayName("Сломанная строка")
    public void testFixString() {
        // given
        String input1 = "123456";
        String input2 = "hTsii  s aimex dpus rtni.g";
        String input3 = "abcde";
        String input4 = "a";
        String input5 = "";

        // when
        String result1 = FixString.fixString(input1);
        String result2 = FixString.fixString(input2);
        String result3 = FixString.fixString(input3);
        String result4 = FixString.fixString(input4);
        String result5 = FixString.fixString(input5);

        // then
        String expected1 = "214365";
        String expected2 = "This is a mixed up string.";
        String expected3 = "badce";
        String expected4 = "a";
        String expected5 = "";

        Assertions.assertEquals(expected1, result1);
        Assertions.assertEquals(expected2, result2);
        Assertions.assertEquals(expected3, result3);
        Assertions.assertEquals(expected4, result4);
        Assertions.assertEquals(expected5, result5);
    }
}
