package com.toondeboer.solutions;

import com.toondeboer.utils.InputReader;

import java.util.ArrayList;
import java.util.List;

public class Day02 {
    public static void run() {
        String input = InputReader.readInput("day02.txt");

        int[] safeReports = solve(input);

        System.out.println("Day 2: part 1: " + safeReports[0] + ", part 2: " + safeReports[1]);
    }

    public static int[] solve(String input) {
        List<List<Integer>> reports = getReports(input);

        int safeReportsPart1 = calculateSafeReportsPart1(reports);
        int safeReportsPart2 = calculateSafeReportsPart2(reports);

        return new int[]{safeReportsPart1, safeReportsPart2};
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

    private static int calculateSafeReportsPart1(List<List<Integer>> reports) {
        int safeReports = 0;

        for (List<Integer> report : reports) {
            if (validReport(report)) {
                safeReports++;
            }
        }

        return safeReports;
    }

    private static int calculateSafeReportsPart2(List<List<Integer>> reports) {
        int safeReports = 0;

        for (List<Integer> report : reports) {

            // validate complete report
            if (validReport(report)) {
                safeReports++;
                continue;
            }
            for (int i = 0; i < report.size(); i++) {
                List<Integer> subReport = getSubReport(report, i);
                if (validReport(subReport)) {
                    safeReports++;
                    break;
                }
            }
        }

        return safeReports;
    }

    private static List<Integer> getSubReport(List<Integer> report, int indexToRemove) {
        List<Integer> subReport = new ArrayList<>(report);
        subReport.remove(indexToRemove);
        return subReport;
    }

    private static boolean validReport(List<Integer> report) {
        boolean increasing = report.get(1) > report.get(0);

        for (int i = 0; i < report.size() - 1; i++) {
            int currentLevel = report.get(i);
            int nextLevel = report.get(i + 1);
            if (!validLevel(currentLevel, nextLevel, increasing)) {
                return false;
            }
        }

        return true;
    }

    private static boolean validLevel(int currentLevel, int nextLevel, boolean increasing) {
        if (increasing && nextLevel > currentLevel) {
            return nextLevel - currentLevel <= 3;
        }
        if (!increasing && nextLevel < currentLevel) {
            return currentLevel - nextLevel <= 3;
        }
        return false;
    }
}
