package edu.hw5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class FridayThe13thTest {

    @Test
    void testFindFridayThe13ths() {
        int year = 2024;
        List<LocalDate> fridayThe13ths = FridayThe13th.findFridayThe13ths(year);

        assertEquals(2, fridayThe13ths.size());
        assertEquals(LocalDate.of(2024, 9, 13), fridayThe13ths.get(0));
        assertEquals(LocalDate.of(2024, 12, 13), fridayThe13ths.get(1));
    }

    @Test
    void testFindNextFridayThe13th() {
        LocalDate currentDate = LocalDate.of(2023, 5, 1);
        LocalDate nextFridayThe13th = FridayThe13th.findNextFridayThe13th(currentDate);

        assertEquals(LocalDate.of(2023, 5, 13), nextFridayThe13th);
    }

    @ParameterizedTest
    @MethodSource("provideYearsWithFriday13ths")
    void testFindFridayThe13thsForDifferentYears(int year, int expectedCount) {
        List<LocalDate> fridayThe13ths = FridayThe13th.findFridayThe13ths(year);

        assertEquals(expectedCount, fridayThe13ths.size());
    }

    @ParameterizedTest
    @MethodSource("provideDatesForNextFridayThe13th")
    void testFindNextFridayThe13thForDifferentDates(LocalDate currentDate, LocalDate expectedDate) {
        LocalDate nextFridayThe13th = FridayThe13th.findNextFridayThe13th(currentDate);

        assertEquals(expectedDate, nextFridayThe13th);
    }

    private static Stream<Arguments> provideYearsWithFriday13ths() {
        return Stream.of(
            Arguments.of(2022, 1),
            Arguments.of(2023, 2),
            Arguments.of(2024, 2),
            Arguments.of(2025, 1)
        );
    }

    private static Stream<Arguments> provideDatesForNextFridayThe13th() {
        return Stream.of(
            Arguments.of(LocalDate.of(2023, 5, 1), LocalDate.of(2023, 5, 13)),
            Arguments.of(LocalDate.of(2023, 11, 1), LocalDate.of(2023, 11, 13)),
            Arguments.of(LocalDate.of(2024, 4, 1), LocalDate.of(2024, 4, 13))
        );
    }
}
