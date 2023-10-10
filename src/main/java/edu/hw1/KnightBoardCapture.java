package edu.hw1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

// task8
public final class KnightBoardCapture {
    private static final Properties PROPERTIES = new Properties();

    static {
        try {
            PROPERTIES.load(new FileInputStream("src/main/resources/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private KnightBoardCapture() {
    }

    public static boolean knightBoardCapture(int[][] array) {
        int[][] validationArray = array;
        int rotationTimes = Integer.parseInt(PROPERTIES.getProperty("rotations"));
        for (int k = 0; k < rotationTimes; k++) {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[0].length; j++) {
                    if (array[i][j] != 0) {
                        if ((j + 2) < array[0].length && (i + 1) < array.length) {
                            if (array[i + 1][j + 2] != 0) {
                                return false;
                            }
                        }
                        if ((j + 2) < array[0].length && (i - 1) > 0) {
                            if (array[i - 1][j + 2] != 0) {
                                return false;
                            }
                        }
                    }
                }
            }
            validationArray = rotateArray(validationArray);
        }

        return true;
    }

    private static int[][] rotateArray(int[][] originalArray) {
        int[][] rotatedArray = new int[originalArray[0].length][originalArray.length];

        for (int i = 0; i < originalArray.length; i++) {
            for (int j = 0; j < originalArray[0].length; j++) {
                rotatedArray[j][originalArray.length - 1 - i] = originalArray[i][j];
            }
        }

        return rotatedArray;
    }
}
