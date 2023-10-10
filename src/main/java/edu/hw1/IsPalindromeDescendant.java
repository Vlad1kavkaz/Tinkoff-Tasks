package edu.hw1;

// task5
public final class IsPalindromeDescendant {

    private IsPalindromeDescendant() {
    }

    public static boolean isPalindromeDescendant(int number) {
        String string = Integer.toString(number);
        String reversedString = new StringBuilder(Integer.toString(number)).reverse().toString();

        if (string.equals(reversedString) && string.length() > 1) {
            return true;
        } else {
            if (string.length() % 2 != 0) {
                return false;
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < string.length(); i += 2) {
                sb.append(
                    Character.getNumericValue(string.charAt(i)) + Character.getNumericValue(string.charAt(i + 1)));
            }

            int outputNumber = Integer.parseInt(sb.toString());
            return isPalindromeDescendant(outputNumber);
        }
    }
}
