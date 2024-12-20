package com.toondeboer.solutions;

import com.toondeboer.utils.Coordinate;
import com.toondeboer.utils.Grid;
import com.toondeboer.utils.Solution;

import java.util.*;

public class Day08 extends Solution {
    Grid grid;
    Map<Character, List<Coordinate>> antennas;
    Set<Coordinate> antinodes;
    int version;

    public Day08() {
        super("08");
    }

    @Override
    public long solvePart1(String input) {
        version = 1;
        antennas = new HashMap<>();
        antinodes = new HashSet<>();

        grid = new Grid(input);
        locateAntennas();
        return antinodes.size();
    }

    @Override
    public long solvePart2(String input) {
        version = 2;
        antennas = new HashMap<>();
        antinodes = new HashSet<>();

        grid = new Grid(input);
        locateAntennas();
        return antinodes.size();
    }

    private void locateAntennas() {
        for (int x = 1; x <= grid.getWidth(); x++) {
            for (int y = 1; y <= grid.getHeight(); y++) {
                char value = grid.getCoordinate(x, y);
                if (value != '.') {
                    Coordinate coordinate = new Coordinate(x, y);
                    addAntinodes(value, coordinate);
                    addAntenna(value, coordinate);
                }
            }
        }
    }

    private void addAntinodes(char value, Coordinate coordinate) {
        List<Coordinate> similarAntennas = antennas.get(value);
        if (similarAntennas == null) {
            return;
        }
        for (Coordinate antenna : similarAntennas) {
            List<Coordinate> antinodes;
            if (version == 1) {
                antinodes = calculateAntinodesLocations(antenna, coordinate);
            } else {
                antinodes = calculateAntinodesLocations2(antenna, coordinate);
            }
            this.antinodes.addAll(antinodes);
        }
    }

    private List<Coordinate> calculateAntinodesLocations(Coordinate antenna1, Coordinate antenna2) {
        List<Coordinate> antinodes = new ArrayList<>();
        int dx = antenna1.X - antenna2.X;
        int dy = antenna1.Y - antenna2.Y;

        int x1 = antenna1.X + dx;
        int y1 = antenna1.Y + dy;
        int x2 = antenna2.X - dx;
        int y2 = antenna2.Y - dy;

        Coordinate antinode1 = new Coordinate(x1, y1);
        Coordinate antinode2 = new Coordinate(x2, y2);

        if (grid.fits(antinode1)) {
            antinodes.add(antinode1);
        }
        if (grid.fits(antinode2)) {
            antinodes.add(antinode2);
        }

        return antinodes;
    }

    private List<Coordinate> calculateAntinodesLocations2(Coordinate antenna1, Coordinate antenna2) {
        List<Coordinate> antinodes = new ArrayList<>();
        antinodes.add(antenna1);
        antinodes.add(antenna2);

        int dx = antenna1.X - antenna2.X;
        int dy = antenna1.Y - antenna2.Y;

        int x = antenna1.X;
        int y = antenna1.Y;

        while (true) {
            x += dx;
            y += dy;
            Coordinate antenna = new Coordinate(x, y);
            if (grid.fits(antenna)) {
                antinodes.add(antenna);
            } else {
                break;
            }
        }

        x = antenna2.X;
        y = antenna2.Y;

        while (true) {
            x -= dx;
            y -= dy;
            Coordinate antenna = new Coordinate(x, y);
            if (grid.fits(antenna)) {
                antinodes.add(antenna);
            } else {
                break;
            }
        }

        return antinodes;
    }

    private void addAntenna(char value, Coordinate coordinate) {
        antennas.computeIfAbsent(value, key -> new ArrayList<>()).add(coordinate);
    }
}
