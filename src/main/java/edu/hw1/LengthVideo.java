package edu.hw1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

// task1
public final class LengthVideo {
    private static final Properties PROPERTIES = new Properties();

    static {
        try {
            PROPERTIES.load(new FileInputStream("src/main/resources/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private LengthVideo() {
    }

    public static int minutesToSeconds(String time) {
        String[] timeArray = time.split(":");

        if (timeArray.length != 2) {
            return -1;
        }

        int min;
        int sec;

        try {
            min = Integer.parseInt(timeArray[0]);
            sec = Integer.parseInt(timeArray[1]);
        } catch (NumberFormatException e) {
            return -1;
        }

        int maxNumberSecDisplay = Integer.parseInt(PROPERTIES.getProperty("max.number.sec.display"));

        if (sec > maxNumberSecDisplay || sec < 0 || min < 0) {
            return -1;
        }

        int secPerMin = Integer.parseInt(PROPERTIES.getProperty("sec.per.min"));

        int resultSec = min * secPerMin + sec;

        return resultSec;
    }
}
