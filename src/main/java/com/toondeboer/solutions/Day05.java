package com.toondeboer.solutions;

import com.toondeboer.utils.InputReader;

import java.util.ArrayList;
import java.util.List;

public class Day05 {
    public static void run() {
        String input = InputReader.readInput("day05.txt");

        int distance = solve(input);

        System.out.println("Day 5: " + distance);
    }

    public static int solve(String input) {

        return getSumOfPageNumbers(input);
    }

    private static int getSumOfPageNumbers(String input) {
        List<List<Integer>> rules = new ArrayList<>();
        List<List<Integer>> updates = new ArrayList<>();

        boolean parsingRules = true;
        String[] lines = input.split("\\n");
        for (String line : lines) {
            if (line.equals("")) {
                parsingRules = false;
                continue;
            }
            if (parsingRules) {
                rules.add(parseRule(line));
            } else {
                updates.add(parseUpdate(line));
            }
        }

        return sumOfValidUpdates(rules, updates);
    }

    private static int sumOfValidUpdates(List<List<Integer>> rules, List<List<Integer>> updates) {
        int sum = 0;

        for (List<Integer> update : updates) {
            boolean validUpdate = true;

            for (int i = 0; i < update.size() - 1; i++) {
                if (!validUpdate(update.get(i), update.get(i + 1), rules)) {
                    validUpdate = false;
                    break;
                }
            }

            if (validUpdate) {
                sum += update.get((update.size() - 1) / 2);
            }
        }

        return sum;
    }

    private static boolean validUpdate(int x, int y, List<List<Integer>> rules) {
        for (List<Integer> rule : rules) {
            if (x == rule.get(1) && y == rule.getFirst()) {
                return false;
            }
        }
        return true;
    }

    private static List<Integer> parseRule(String line) {
        List<Integer> rule = new ArrayList<>();
        String[] pageNumbers = line.split("\\|");

        rule.add(Integer.parseInt(pageNumbers[0]));
        rule.add(Integer.parseInt(pageNumbers[1]));

        return rule;
    }

    private static List<Integer> parseUpdate(String line) {
        List<Integer> update = new ArrayList<>();
        String[] pageNumbers = line.split(",");

        for (String pageNumber : pageNumbers) {
            update.add(Integer.parseInt(pageNumber));
        }

        return update;
    }
}
