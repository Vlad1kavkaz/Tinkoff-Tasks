package edu.hw1;

// task4
public final class FixString {

    private FixString() {
    }

    public static String fixString(String brokenString) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < brokenString.length(); i += 2) {
            if (i != (brokenString.length() - 1)) {
                sb.append(brokenString.charAt(i + 1));
            }
            sb.append(brokenString.charAt(i));
        }

        return sb.toString();
    }
}
