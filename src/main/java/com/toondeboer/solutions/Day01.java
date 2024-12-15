package com.toondeboer.solutions;

import com.toondeboer.utils.Solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day01 extends Solution {
    public Day01() {
        super("01");
    }

    @Override
    public int solvePart1(String input) {
        List<List<Integer>> lists = getArrays(input);

        return getDistance(lists);
    }

    @Override
    public int solvePart2(String input) {
        List<List<Integer>> lists = getArrays(input);

        return getSimilarityScore(lists);
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

    private int getSimilarityScore(List<List<Integer>> lists) {
        List<Integer> leftList = lists.get(0);
        List<Integer> rightList = lists.get(1);

        int score = 0;

        for (int left : leftList) {
            int count = 0;
            for (int right : rightList) {
                if (left == right) {
                    count++;
                }
            }
            score += left * count;
        }

        return score;
    }
}
