package com.toondeboer.solutions;

import com.toondeboer.utils.InputReader;

import java.util.ArrayList;
import java.util.List;

public class Day04 {
    static int[][] DIRECTIONS = new int[][]{
            new int[]{1, 0},
            new int[]{1, -1},
            new int[]{0, -1},
            new int[]{-1, -1},
            new int[]{-1, 0},
            new int[]{-1, 1},
            new int[]{0, 1},
            new int[]{1, 1}
    };

    static int[][] DIAGONALS = new int[][]{
            new int[]{1, -1},
            new int[]{-1, -1},
            new int[]{-1, 1},
            new int[]{1, 1}
    };

    public static void run() {
        String input = InputReader.readInput("day04.txt");

        int[] sum = solve(input);

        System.out.println("Day 4: part 1: " + sum[0] + ", part 2: " + sum[1]);
    }

    public static int[] solve(String input) {
        List<List<Character>> grid = getGrid(input);

        int wordCount1 = countWords(grid);
        int wordCount2 = countWordsPart2(grid);

        return new int[]{wordCount1, wordCount2};
    }

    private static List<List<Character>> getGrid(String input) {
        String[] lines = input.split("\\n");
        List<List<Character>> grid = new ArrayList<>();

        for (String line : lines) {
            char[] chars = line.toCharArray();
            List<Character> charList = new ArrayList<>();
            for (char c : chars) {
                charList.add(c);
            }
            grid.add(charList);
        }

        return grid;
    }

    private static int countWords(List<List<Character>> grid) {
        int count = 0;
        for (int x = 0; x < grid.size(); x++) {
            for (int y = 0; y < grid.getFirst().size(); y++) {
                if (grid.get(x).get(y) == 'X') {
                    count += findWords(grid, x, y);
                }
            }
        }

        return count;
    }

    private static int countWordsPart2(List<List<Character>> grid) {
        int count = 0;
        for (int x = 0; x < grid.size(); x++) {
            for (int y = 0; y < grid.getFirst().size(); y++) {
                if (grid.get(x).get(y) == 'A') {
                    if (findWordsPart2(grid, x, y)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private static int findWords(List<List<Character>> grid, int x, int y) {
        int count = 0;

        for (int[] direction : DIRECTIONS) {
            if (wordInDirection(grid, x, y, direction)) {
                count++;
            }
        }

        return count;
    }

    private static boolean findWordsPart2(List<List<Character>> grid, int x, int y) {
        int count = 0;

        for (int[] direction : DIAGONALS) {
            if (wordInDirectionPart2(grid, x, y, direction)) {
                count++;
            }
        }

        return count == 2;
    }

    private static boolean wordInDirection(List<List<Character>> grid, int x, int y, int[] direction) {
        int xDirection = direction[0];
        int yDirection = direction[1];
        int currentX = x;
        int currentY = y;

        String mas = "MAS";

        if (!fitsInGrid(grid, x, y, xDirection, yDirection, mas.length())) {
            return false;
        }

        for (char c : mas.toCharArray()) {
            currentX += xDirection;
            currentY += yDirection;

            if (grid.get(currentX).get(currentY) != c) {
                return false;
            }
        }

        return true;
    }

    private static boolean wordInDirectionPart2(List<List<Character>> grid, int x, int y, int[] direction) {
        int xDirection = direction[0];
        int yDirection = direction[1];

        if (!fitsInGridPart2(grid, x, y)) {
            return false;
        }

        if (grid.get(x - xDirection).get(y - yDirection) != 'M') {
            return false;
        }

        return grid.get(x + xDirection).get(y + yDirection) == 'S';
    }

    private static boolean fitsInGrid(List<List<Character>> grid, int x, int y, int xDirection, int yDirection, int wordLength) {
        int finalX = x + (wordLength * xDirection);
        if (finalX < 0 || finalX >= grid.size()) {
            return false;
        }

        int finalY = y + (wordLength * yDirection);
        return finalY >= 0 && finalY < grid.getFirst().size();
    }

    private static boolean fitsInGridPart2(List<List<Character>> grid, int x, int y) {
        if (x < 1 || x >= grid.size() - 1) {
            return false;
        }

        return y >= 1 && y < grid.getFirst().size() - 1;
    }
}
