package edu.hw1;

import java.util.Arrays;

// task3
public final class NestabilityChecker {

    private NestabilityChecker() {
    }

    public static boolean isNestable(int[] array1, int[] array2) {
        try {
            int minArray1 = Arrays.stream(array1).min().getAsInt();
            int maxArray1 = Arrays.stream(array1).max().getAsInt();

            int minArray2 = Arrays.stream(array2).min().getAsInt();
            int maxArray2 = Arrays.stream(array2).max().getAsInt();

            return minArray1 > minArray2 && maxArray1 < maxArray2;
        } catch (Exception ex) {
            return false;
        }

    }
}
