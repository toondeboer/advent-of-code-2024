package com.toondeboer.day02;

import com.toondeboer.utils.InputReader;

import java.util.ArrayList;
import java.util.List;

public class Day02 {
    public static void run() {
        String input = InputReader.readInput("day02.txt");

        int safeReports = solve(input);

        System.out.println("Day 2: " + safeReports);
    }

    public static int solve(String input) {
        List<List<Integer>> reports = getReports(input);

        return calculateSafeReports(reports);
    }

    private static List<List<Integer>> getReports(String input) {
        String[] lines = input.split("\\n");
        List<List<Integer>> reports = new ArrayList<>();

        for (String line : lines) {
            String[] numbers = line.split("\\s+");
            List<Integer> report = new ArrayList<>();
            for (String number : numbers) {
                report.add(Integer.parseInt(number));
            }
            reports.add(report);
        }

        return reports;
    }

    private static int calculateSafeReports(List<List<Integer>> reports) {
        int safeReports = 0;

        for (List<Integer> report : reports) {
            boolean safeReport = true;
            boolean increasing = report.get(1) > report.get(0);

            for (int i = 0; i < report.size() - 1; i++) {
                int currentLevel = report.get(i);
                int nextLevel = report.get(i + 1);
                if (!validateReport(currentLevel, nextLevel, increasing)) {
                    safeReport = false;
                    break;
                }
            }

            if (safeReport) {
                safeReports++;
            }
        }

        return safeReports;
    }

    private static boolean validateReport(int currentLevel, int nextLevel, boolean increasing) {
        if (increasing && nextLevel > currentLevel) {
            return nextLevel - currentLevel <= 3;
        }
        if (!increasing && nextLevel < currentLevel) {
            return currentLevel - nextLevel <= 3;
        }
        return false;
    }
}
