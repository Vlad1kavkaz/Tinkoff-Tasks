package edu.hw1;

import java.util.Arrays;

public class CountK {

    public static void main(String[] args) {
        System.out.println(countK(3524)); // Выведет 3
        System.out.println(countK(6621)); // Выведет 5
        System.out.println(countK(6554)); // Выведет 4
        System.out.println(countK(1234)); // Выведет 3
    }

    public static int countK(int n) {
        int count = 0;
        while (n != 6174) {
            int[] digits = new int[4];
            digits[0] = n % 10;
            digits[1] = (n / 10) % 10;
            digits[2] = (n / 100) % 10;
            digits[3] = (n / 1000) % 10;

            Arrays.sort(digits);
            int ascNum = digits[0] * 1000 + digits[1] * 100 + digits[2] * 10 + digits[3];
            int descNum = digits[3] * 1000 + digits[2] * 100 + digits[1] * 10 + digits[0];

            n = descNum - ascNum;
            count++;
        }
        return count;
    }
}
