package edu.project1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MainTest {

    // Тест для проверки успешного получения максимального количества ошибок из файла свойств
    @Test
    @DisplayName("Проверка получения количества ошибок")
    public void getMistakes() throws IOException {
        int maxMistakesCount = Main.getMaxMistakesCount();
        assertThat(maxMistakesCount).isEqualTo(10);
    }

    // Тест для проверки исключения, если файл свойств не найден
    @Test
    @DisplayName("Проверка отсутсвия файла")
    public void getMistakesFileNotFound() {
        assertThrows(IOException.class, () -> {
            Properties props = new Properties();
            props.load(new FileInputStream("src/test/resources/game.properties"));
            Main.getMaxMistakesCount();
        });
    }
}
