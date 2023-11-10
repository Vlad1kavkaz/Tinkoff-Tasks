package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class FridayThe13th {

    private FridayThe13th() {

    }

    public static List<LocalDate> findFridayThe13ths(int year) {
        List<LocalDate> fridayThe13ths = new ArrayList<>();

        for (Month month : Month.values()) {
            LocalDate date = LocalDate.of(year, month, 13);
            if (date.getDayOfWeek() == DayOfWeek.FRIDAY) {
                fridayThe13ths.add(date);
            }
        }

        return fridayThe13ths;
    }

    public static LocalDate findNextFridayThe13th(LocalDate currentDate) {
        return currentDate.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)).withDayOfMonth(13);
    }
}

