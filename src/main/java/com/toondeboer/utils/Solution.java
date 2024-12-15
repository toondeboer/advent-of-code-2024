package com.toondeboer.utils;

public abstract class Solution {
    private final String day;

    public Solution(String day) {
        this.day = day;
    }

    public void run() {
        String fileName = "day" + day + ".txt";
        String input = InputReader.readInput(fileName);

        int solutionPart1 = solvePart1(input);
        int solutionPart2 = solvePart2(input);

        System.out.println("Day " + day
                + "\n\tPart 1: " + solutionPart1
                + "\n\tPart 2: " + solutionPart2);
    }

    public abstract int solvePart1(String input);

    public abstract int solvePart2(String input);
}
