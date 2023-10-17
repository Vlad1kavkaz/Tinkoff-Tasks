package edu.project1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class Main {
    private Main() {
    }

    public static void main(String[] args) throws IOException {
        ConsoleHangman consoleHangman = new ConsoleHangman(getMaxMistakesCount());
        consoleHangman.run();
    }

    public static int getMaxMistakesCount() throws IOException {
        Properties props = new Properties();
        props.load(new FileInputStream("src/main/resources/game.properties"));
        return Integer.parseInt(props.getProperty("MAX_MISTAKES_COUNT", "1"));
    }
}
