package com.toondeboer.day01;

import com.toondeboer.utils.InputReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day01 {
    public static void run() {
        String input = InputReader.readInput("day01.txt");

        int distance = solve(input);

        System.out.println("Day 1: " + distance);
    }

    public static int solve(String input) {
        List<List<Integer>> lists = getArrays(input);

        return getDistance(lists);
    }

    private static List<List<Integer>> getArrays(String input) {
        String[] lines = input.split("\\n");
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        for (String line : lines) {
            String[] numbers = line.split("\\s+");
            leftList.add(Integer.parseInt(numbers[0]));
            rightList.add(Integer.parseInt(numbers[1]));
        }

        List<List<Integer>> lists = new ArrayList<>();
        lists.add(leftList);
        lists.add(rightList);
        return lists;
    }

    private static int getDistance(List<List<Integer>> lists) {
        List<Integer> leftList = lists.get(0);
        List<Integer> rightList = lists.get(1);

        Collections.sort(leftList);
        Collections.sort(rightList);

        int distance = 0;

        for (int i = 0; i < leftList.size(); i++) {
            distance += Math.abs(leftList.get(i) - rightList.get(i));
        }

        return distance;
    }
}
