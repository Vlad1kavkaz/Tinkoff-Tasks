package edu.hw2.rectangle_square;

public final class Square extends Rectangle {
    public Square() {
    }

    public final Square setSide(int side) {
        return new Square(side);
    }

    public Square(int side) {
        super(side, side);
    }
}
