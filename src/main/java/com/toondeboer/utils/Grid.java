package com.toondeboer.utils;

import java.util.ArrayList;
import java.util.List;

public class Grid {
    private final List<List<Character>> grid;

    public Grid(String input) {
        String[] lines = input.split("\\n");

        List<List<Character>> grid = new ArrayList<>();
        for (int i = lines.length - 1; i >= 0; i--) {
            char[] chars = lines[i].toCharArray();
            List<Character> row = new ArrayList<>();
            for (char c : chars) {
                row.add(c);
            }
            grid.add(row);
        }

        this.grid = grid;
    }

    public char getCoordinate(int x, int y) {
        return grid.get(y - 1).get(x - 1);
    }

    public int getCoordinateInt(int x, int y) {
        return Character.getNumericValue(getCoordinate(x, y));
    }

    public char getCoordinate(Coordinate coordinate) {
        return getCoordinate(coordinate.X, coordinate.Y);
    }

    public int getCoordinateInt(Coordinate coordinate) {
        return Character.getNumericValue(getCoordinate(coordinate));
    }

    public int getHeight() {
        return grid.size();
    }

    public int getWidth() {
        return grid.getFirst().size();
    }

    public boolean fits(Coordinate coordinate) {
        if (coordinate.X <= 0) return false;
        if (coordinate.X > getWidth()) return false;
        if (coordinate.Y <= 0) return false;
        return coordinate.Y <= getHeight();
    }
}
