package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class DigitCounterTest {
    @Test
    @DisplayName("Количество цифр в числе")
    void countDigits() {
        // given
        int number1 = 4666;
        int number2 = 544;
        int number3 = 0;

        // when
        int result1 = DigitCounter.countDigits(number1);
        int result2 = DigitCounter.countDigits(number2);
        int result3 = DigitCounter.countDigits(number3);

        // then
        assertThat(result1).isEqualTo(4);
        assertThat(result2).isEqualTo(3);
        assertThat(result3).isEqualTo(1);
    }

    @Test
    @DisplayName("Количество цифр в отрицательном числе")
    void countDigitsNegativeNumber() {
        // given
        int number = -12345;

        // when
        int result = DigitCounter.countDigits(number);

        // then
        assertThat(result).isEqualTo(5);
    }
}
