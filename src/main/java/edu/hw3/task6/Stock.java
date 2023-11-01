package edu.hw3.task6;

import org.jetbrains.annotations.NotNull;

public record Stock(String title, int cost) implements Comparable<Stock> {

    @Override
    public int compareTo(@NotNull Stock o) {

        return Integer.compare(this.cost, o.cost);
    }
}
