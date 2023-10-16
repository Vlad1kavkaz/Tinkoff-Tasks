package edu.project1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class MainTest {

    @Test
    @DisplayName("Некоректная длинна")
    void incorrectLength() {
        ConsoleHangman consoleHangman = new ConsoleHangman(10);
        consoleHangman.run();
    }

}
