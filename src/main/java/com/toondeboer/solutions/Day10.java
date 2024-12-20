package com.toondeboer.solutions;

import com.toondeboer.utils.Coordinate;
import com.toondeboer.utils.Grid;
import com.toondeboer.utils.Solution;

import java.util.HashSet;
import java.util.Set;

public class Day10 extends Solution {
    Grid grid;
    int version;

    public Day10() {
        super("10");
    }

    @Override
    public long solvePart1(String input) {
        version = 1;
        grid = new Grid(input);
        return findTrailHeads();
    }

    @Override
    public long solvePart2(String input) {
        version = 2;
        grid = new Grid(input);
        return findTrailHeads();
    }

    private int findTrailHeads() {
        int trailheads = 0;
        for (int x = 1; x <= grid.getWidth(); x++) {
            for (int y = 1; y <= grid.getHeight(); y++) {
                if (grid.getCoordinateInt(x, y) == 0) {
                    trailheads += findTrailHeadsFromLocation(new Coordinate(x, y));
                }
            }
        }
        return trailheads;
    }

    private int findTrailHeadsFromLocation(Coordinate coordinate) {
        Set<Coordinate> mountainTops = new HashSet<>();
        int rating = calculatePath(coordinate, 0, mountainTops, 0);

        if (version == 1) {
            return mountainTops.size();
        }
        return rating;
    }

    private int calculatePath(Coordinate coordinate, int height, Set<Coordinate> mountainTops, int rating) {
        if (!grid.fits(coordinate) || grid.getCoordinateInt(coordinate) != height) {
            return 0;
        }
        if (height == 9) {
            mountainTops.add(coordinate);
            return 1;
        }
        int sum = rating;
        sum += calculatePath(new Coordinate(coordinate.X + 1, coordinate.Y), height + 1, mountainTops, rating);
        sum += calculatePath(new Coordinate(coordinate.X - 1, coordinate.Y), height + 1, mountainTops, rating);
        sum += calculatePath(new Coordinate(coordinate.X, coordinate.Y + 1), height + 1, mountainTops, rating);
        sum += calculatePath(new Coordinate(coordinate.X, coordinate.Y - 1), height + 1, mountainTops, rating);
        return sum;
    }
}
