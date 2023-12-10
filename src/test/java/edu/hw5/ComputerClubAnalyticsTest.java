package edu.hw5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ComputerClubAnalyticsTest {

    @Test
    void testCalculateAverageSessionDuration() {
        List<String> sessions = new ArrayList<>();
        sessions.add("2022-03-12, 20:20 - 2022-03-12, 23:50");
        sessions.add("2022-04-01, 21:30 - 2022-04-02, 01:20");

        Duration averageDuration = ComputerClubAnalytics.calculateAverageSessionDuration(sessions);

        assertEquals(Duration.ofHours(3).plusMinutes(40), averageDuration);
    }

    @Test
    void testFormatDuration() {
        Duration duration = Duration.ofHours(3).plusMinutes(40);

        String formattedDuration = ComputerClubAnalytics.formatDuration(duration);

        assertEquals("3ч 40м", formattedDuration);
    }
}
