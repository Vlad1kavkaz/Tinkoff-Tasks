package edu.hw5;

import java.io.IOException;
import java.io.InputStream;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FridayThe13th {

    private static final Logger logger = Logger.getLogger(FridayThe13th.class.getName());
    private static final String CONFIG_FILE = "/application.properties";
    private static final String DAY_OF_MONTH_KEY = "dayOfMonth";

    private static int dayOfMonth;

    static {
        loadConfig();
    }

    private static void loadConfig() {
        try (InputStream input = FridayThe13th.class.getResourceAsStream(CONFIG_FILE)) {
            Properties prop = new Properties();
            prop.load(input);
            dayOfMonth = Integer.parseInt(prop.getProperty(DAY_OF_MONTH_KEY));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error loading configuration", e);
            // Handle the exception as needed
        }
    }

    public static List<LocalDate> findFridayThe13ths(int year) {
        List<LocalDate> fridayThe13ths = new ArrayList<>();

        for (Month month : Month.values()) {
            LocalDate date = LocalDate.of(year, month, dayOfMonth);
            if (date.getDayOfWeek() == DayOfWeek.FRIDAY) {
                fridayThe13ths.add(date);
            }
        }

        return fridayThe13ths;
    }

    public static LocalDate findNextFridayThe13th(LocalDate currentDate) {
        return currentDate.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)).withDayOfMonth(dayOfMonth);
    }
}
