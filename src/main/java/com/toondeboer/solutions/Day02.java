package com.toondeboer.solutions;

import com.toondeboer.utils.Solution;

import java.util.ArrayList;
import java.util.List;

public class Day02 extends Solution {
    public Day02() {
        super("02");
    }

    @Override
    public long solvePart1(String input) {
        List<List<Integer>> reports = getReports(input);
        return calculateSafeReportsPart1(reports);
    }

    @Override
    public long solvePart2(String input) {
        List<List<Integer>> reports = getReports(input);
        return calculateSafeReportsPart2(reports);
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
