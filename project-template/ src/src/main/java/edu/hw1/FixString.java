package edu.hw1;

public class FixString {

    public static String fixString(String str) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i += 2) {
            if (i + 1 < str.length()) {
                char c1 = str.charAt(i);
                char c2 = str.charAt(i + 1);
                result.append(c2);
                result.append(c1);
            } else {
                char c = str.charAt(i);
                result.append(c);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String str1 = fixString("123456");
        System.out.println(str1); // Output: 214365

        String str2 = fixString("hTsii  s aimex dpus rtni.g");
        System.out.println(str2); // Output: This is a mixed up string.

        String str3 = fixString("badce");
        System.out.println(str3); // Output: abcde
    }
}
