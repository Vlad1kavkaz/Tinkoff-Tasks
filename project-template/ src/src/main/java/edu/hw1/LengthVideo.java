package edu.hw1;

public final class LengthVideo {

    public static int minutesToSeconds(String lengthVideo) {
        int seconds = 0;
        String[] parts = lengthVideo.split(":");

        if (parts.length != 2) {
            return -1; // некорректный формат строки, возвращаем -1
        }

        int minutes = Integer.parseInt(parts[0]);
        int sec = Integer.parseInt(parts[1]);

        if (sec >= 60) {
            return -1; // некорректное количество секунд, возвращаем -1
        }

        seconds = minutes * 60 + sec;
        return seconds;
    }

    public static void main(String[] argv) {
        System.out.println(minutesToSeconds("01:00")); // 60
        System.out.println(minutesToSeconds("13:56")); // 836
        System.out.println(minutesToSeconds("10:60")); // -1
    }
}
