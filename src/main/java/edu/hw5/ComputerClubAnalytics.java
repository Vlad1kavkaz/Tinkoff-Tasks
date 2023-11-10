package edu.hw5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class ComputerClubAnalytics {

    private ComputerClubAnalytics() {

    }

    public static Duration calculateAverageSessionDuration(List<String> sessions) {
        long totalSeconds = 0;
        for (String session : sessions) {
            String[] parts = session.split(" - ");
            LocalDateTime start = LocalDateTime.parse(parts[0],
                SessionDateTimeFormatter.FORMATTER);
            LocalDateTime end = LocalDateTime.parse(parts[1],
                SessionDateTimeFormatter.FORMATTER);
            totalSeconds += Duration.between(start, end).getSeconds();
        }

        long averageSeconds = totalSeconds / sessions.size();
        return Duration.ofSeconds(averageSeconds);
    }

    public static String formatDuration(Duration duration) {
        long hours = duration.toHours();
        long minutes = duration.toMinutesPart();
        return String.format("%dч %02dм", hours, minutes);
    }

    static class SessionDateTimeFormatter {
        static final String PATTERN = "yyyy-MM-dd, HH:mm";
        static final java.time.format.DateTimeFormatter FORMATTER =
            java.time.format.DateTimeFormatter.ofPattern(PATTERN);
    }
}

