package edu.hw3.task1;

public class Task1 {

    private static final int LOWER_A_CODE = 'a';
    private static final int LOWER_Z_CODE = 'z';
    private static final int UPPER_A_CODE = 'A';
    private static final int UPPER_Z_CODE = 'Z';

    private Task1() {
    }

    public static String encryptViaAtbash(String originalString) {
        if (originalString == null) {
            throw new IllegalArgumentException("Input string cannot be null.");
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (char c : originalString.toCharArray()) {
            // Check if the character is from the Latin alphabet
            if (c >= LOWER_A_CODE && c <= LOWER_Z_CODE) {
                stringBuilder.append((char) (LOWER_Z_CODE - c + LOWER_A_CODE));
            } else if (c >= UPPER_A_CODE && c <= UPPER_Z_CODE) {
                stringBuilder.append((char) (UPPER_Z_CODE - c + UPPER_A_CODE));
            } else {
                stringBuilder.append(c);
            }
        }

        return stringBuilder.toString();
    }
}
