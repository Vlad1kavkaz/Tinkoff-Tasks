package edu.hw1;

public final class DigitCounter {
    public static int countDigits(int number) {
        if (number == 0) {
            return 1; // особый случай для числа 0
        }

        int count = 0;
        int absNumber = Math.abs(number);

        while (absNumber > 0) {
            absNumber /= 10;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countDigits(4666)); // 4
        System.out.println(countDigits(544)); // 3
        System.out.println(countDigits(0)); // 1
    }
}
