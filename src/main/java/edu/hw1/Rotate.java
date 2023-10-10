package edu.hw1;

// task7
public final class Rotate {

    private Rotate() {
    }

    public static int rotateRight(int n, int shift) {
        if (n < 0 || shift < 0) {
            throw new RuntimeException("Incorrect data provided for right rotate");
        }

        int position = -1;
        int mold = n;

        while (mold != 0) {
            mold >>= 1;
            position++;
        }

        mold = n;
        int flag = 1 << position;

        for (int i = 0; i < shift; i++) {
            if (mold % 2 != 0) {
                mold >>= 1;
                mold = mold | flag;
            } else {
                mold >>= 1;
            }
        }
        return mold;
    }

    public static int rotateLeft(int n, int shift) {
        if (n < 0 || shift < 0) {
            throw new RuntimeException("Incorrect data provided for left rotate");
        }

        int position = 0;
        int mold = n;

        while (mold != 0) {
            mold >>= 1;
            position++;
        }

        mold = n;
        int flag = ~(1 << position);

        for (int i = 0; i < shift; i++) {
            mold <<= 1;
            if (mold > n) {
                mold = (mold & flag) + 1;
            }
        }

        return mold;
    }
}
