package edu.hw1;

public class Rotate {
    public static void main(String[] args) {
        int rotatedLeft = rotateLeft(16, 1);
        int rotatedRight = rotateRight(8, 1);
        int rotatedLeft2 = rotateLeft(17, 2);

        System.out.println(rotatedLeft); // Выводит 1
        System.out.println(rotatedRight); // Выводит 4
        System.out.println(rotatedLeft2); // Выводит 6
    }

    public static int rotateLeft(int n, int shift) {
        String bits = Integer.toBinaryString(n);
        if (bits.isEmpty() || bits.length() < shift) {
            return n;
        }
        for (int i = 0; i < shift; i++) {
            char firstChar = bits.charAt(0);
            // Отсечение первого элемента и добавление его в конец строки
            bits = bits.substring(1) + firstChar;
        }
        int result = Integer.parseInt(bits, 2);
        return result;
    }

    public static int rotateRight(int n, int shift) {
        int bits = Integer.SIZE;
        shift = shift % bits;
        if (shift == 0) {
            return n;
        }
        return (n >>> shift) | (n << (bits - shift));
    }
}
