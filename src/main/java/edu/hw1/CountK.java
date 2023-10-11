package edu.hw1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

// task6
public final class CountK {
    private final static Properties PROPERTIES = new Properties();

    static {
        try {
            PROPERTIES.load(new FileInputStream("src/main/resources/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private CountK() {
    }

    public static int countK(int number) {
        int lowerBound = Integer.parseInt(PROPERTIES.getProperty("value999.bound"));
        int upperBound = Integer.parseInt(PROPERTIES.getProperty("value9999.bound"));
        int lastIndex = Integer.parseInt(PROPERTIES.getProperty("num3.index"));
        if (number > lowerBound && number < upperBound) {
            String numberString = Integer.toString(number);
            for (int i = 1; i < numberString.length(); i++) {
                if (numberString.charAt(0) != numberString.charAt(i)) {
                    break;
                }
                if (i == lastIndex) {
                    throw new RuntimeException("All the numbers are the same");
                }
            }
            return calculateK(number, 0);
        }
        throw new RuntimeException("The boundaries of the incoming value are violated");
    }

    private static int calculateK(int number, int callCount) {
        StringBuilder sb = new StringBuilder(Integer.toString(number));

        int minNumberDigits = Integer.parseInt(PROPERTIES.getProperty("min.number.digits"));

        while (sb.length() != minNumberDigits) {
            sb.insert(0, "0");
        }

        List<Integer> digitList = sb.toString()
            .chars()
            .map(Character::getNumericValue)
            .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        digitList.sort(Collections.reverseOrder());
        int bigNumber = 0;

        int multiplier = Integer.parseInt(PROPERTIES.getProperty("multiplier"));

        for (int digit : digitList) {
            bigNumber = bigNumber * multiplier + digit;
        }

        Collections.sort(digitList);
        int smallNumber = 0;

        for (int digit : digitList) {
            smallNumber = smallNumber * multiplier + digit;
        }

        int result = bigNumber - smallNumber;

        if (result == number) {
            return callCount;
        }

        int newCallCount = callCount + 1;

        return calculateK(result, newCallCount);
    }

}
