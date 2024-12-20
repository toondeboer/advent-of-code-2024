package com.toondeboer.utils;

import java.util.Objects;

public class Coordinate {
    public final int X;
    public final int Y;

    public Coordinate(int x, int y) {
        this.X = x;
        this.Y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return this.X == that.X && this.Y == that.Y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(X, Y);
    }

    @Override
    public String toString() {
        return "[" + X + "," + Y + "]";
    }
}
