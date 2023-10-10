package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class LengthVideoTest {
    @Test
    @DisplayName("Перевод минут и секунд в секунды")
    void minutesToSeconds() {
        // given
        String lengthVideo0 = "0:50";
        String lengthVideo1 = "1:50";

        // when
        int result0 = LengthVideo.minutesToSeconds(lengthVideo0);
        int result1 = LengthVideo.minutesToSeconds(lengthVideo1);

        // then
        assertThat(result0).isEqualTo(50);
        assertThat(result1).isEqualTo(110);
    }

    @Test
    @DisplayName("Некорректное количество секунд")
    void invalidSeconds() {
        // given
        String lengthVideo = "10:60";

        // when
        int result = LengthVideo.minutesToSeconds(lengthVideo);

        // then
        assertThat(result).isEqualTo(-1);
    }

    @Test
    @DisplayName("Пустая строка")
    void emptyString() {
        // given
        String lengthVideo = "";

        // when
        int result = LengthVideo.minutesToSeconds(lengthVideo);

        // then
        assertThat(result).isEqualTo(-1);
    }

    @Test
    @DisplayName("Строка без двоеточия")
    void noColon() {
        // given
        String lengthVideo = "1234";

        // when
        int result = LengthVideo.minutesToSeconds(lengthVideo);

        // then
        assertThat(result).isEqualTo(-1);
    }
}
