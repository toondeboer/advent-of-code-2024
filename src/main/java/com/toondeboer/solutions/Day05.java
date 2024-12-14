package com.toondeboer.solutions;

import com.toondeboer.utils.InputReader;

import java.util.ArrayList;
import java.util.List;

public class Day05 {
    public static void run() {
        String input = InputReader.readInput("day05.txt");

        int[] sum = solve(input);

        System.out.println("Day 5: part 1: " + sum[0] + ", part 2: " + sum[1]);
    }

    public static int[] solve(String input) {
        List<List<Integer>> rules = new ArrayList<>();
        List<List<Integer>> updates = new ArrayList<>();

        boolean parsingRules = true;
        String[] lines = input.split("\\n");
        for (String line : lines) {
            if (line.isEmpty()) {
                parsingRules = false;
                continue;
            }
            if (parsingRules) {
                rules.add(parseRule(line));
            } else {
                updates.add(parseUpdate(line));
            }
        }

        int part1 = sumOfValidUpdates(rules, updates);
        int part2 = sumOfInValidUpdates(rules, updates);

        return new int[]{part1, part2};
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

    private static int sumOfInValidUpdates(List<List<Integer>> rules, List<List<Integer>> updates) {
        int sum = 0;

        for (List<Integer> update : updates) {
            boolean validUpdate = true;

            for (int i = 0; i < update.size() - 1; i++) {
                if (!validUpdate(update.get(i), update.get(i + 1), rules)) {
                    validUpdate = false;
                    break;
                }
            }

            if (!validUpdate) {
                List<Integer> fixedUpdate = fixUpdate(update, rules);

                sum += fixedUpdate.get((fixedUpdate.size() - 1) / 2);
            }
        }

        return sum;
    }

    private static List<Integer> fixUpdate(List<Integer> update, List<List<Integer>> rules) {
        List<Integer> fixedUpdate = new ArrayList<>();

        for (int newValue : update) {
            if (fixedUpdate.isEmpty()) {
                fixedUpdate.add(newValue);
                continue;
            }

            for (int i = 0; i < fixedUpdate.size(); i++) {
                if (i < fixedUpdate.size() - 1 && validUpdate(fixedUpdate.get(i), newValue, rules) && validUpdate(newValue, fixedUpdate.get(i + 1), rules)) {
                    fixedUpdate.add(i + 1, newValue);
                    break;
                }
                if (i == fixedUpdate.size() - 1) {
                    if (validUpdate(newValue, fixedUpdate.getFirst(), rules)) {
                        fixedUpdate.addFirst(newValue);
                        break;
                    }
                    fixedUpdate.addLast(newValue);
                    break;
                }
            }
        }

        return fixedUpdate;
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