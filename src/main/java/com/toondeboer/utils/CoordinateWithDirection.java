package com.toondeboer.utils;

import java.util.Objects;

public class CoordinateWithDirection extends Coordinate {
    private final String direction;

    public CoordinateWithDirection(int x, int y, String direction) {
        super(x, y);
        this.direction = direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoordinateWithDirection that = (CoordinateWithDirection) o;
        return this.X == that.X && this.Y == that.Y && this.direction.equals(that.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(X, Y, direction);
    }

    @Override
    public String toString() {
        return "[" + X + "," + Y + "] " + direction;
    }
}
