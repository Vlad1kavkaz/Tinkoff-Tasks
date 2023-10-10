package edu.hw1;

import java.math.BigInteger;

public class IsPalindromeDescendant {

    public static void main(String[] args) {
        System.out.println(isPalindromeDescendant(new BigInteger("3"))); // true
        System.out.println(isPalindromeDescendant(new BigInteger("13001120"))); // true
        System.out.println(isPalindromeDescendant(new BigInteger("23336014"))); // true
        System.out.println(isPalindromeDescendant(new BigInteger("12"))); // true
    }

    public static boolean isPalindromeDescendant(BigInteger num) {
        String strNum = num.toString();

        while (strNum.length() > 1) {
            if (isPalindrome(strNum)) {
                return true;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < strNum.length() - 1; i += 2) {
                String pairSum = String.valueOf(Character.getNumericValue(strNum.charAt(i)) + Character.getNumericValue(strNum.charAt(i + 1)));
                sb.append(pairSum);
            }
            strNum = sb.toString();
        }

        return false;
    }

    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
