package edu.hw1;

public class IsNestable {

    public static boolean isNestable(int[] arr1, int[] arr2) {
        int min1 = 2147483647, min2 = 2147483647, max1 = -2147483647, max2 = -2147483647;
        for (int k : arr1) {
            if (k < min1) {
                min1 = k;
            }
            if (k > max1) {
                max1 = k;
            }
        }
        for (int j : arr2) {
            if (j < min2) {
                min2 = j;
            }
            if (j > max2) {
                max2 = j;
            }
        }
        return min1 > min2 || max1 < max2;
    }

    public static void main(String[] argv) {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {2, 3};
        System.out.println(isNestable(arr1, arr2));
    }

}
