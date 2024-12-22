package com.toondeboer.solutions;

import com.toondeboer.utils.Solution;

import java.util.ArrayList;
import java.util.List;

public class Day11 extends Solution {
    List<Long> stones;

    public Day11() {
        super("11");
    }

    @Override
    public long solvePart1(String input) {
        stones = getInitialStones(input);
        blink(25);
        return stones.size();
    }

    @Override
    public long solvePart2(String input) {
        stones = getInitialStones(input);
        blink(75);
        return stones.size();
    }

    private List<Long> getInitialStones(String input) {
        List<Long> stones = new ArrayList<>();
        String[] stonesStrings = input.split("\\s+");
        for (String stone : stonesStrings) {
            stones.add(Long.parseLong(stone));
        }
        return stones;
    }

    private void blink(int blinksLeft) {
        if (blinksLeft == 0) {
            return;
        }

        List<Long> newArrangement = new ArrayList<>();

        for (long stone : stones) {
            List<Long> transformed = applyRules(stone);
            newArrangement.addAll(transformed);
        }

        stones = newArrangement;

        blink(blinksLeft - 1);
    }

    private List<Long> applyRules(long stone) {
        List<Long> transformed = new ArrayList<>();
        if (stone == 0) {
            transformed.add(1L);
            return transformed;
        }
        String stoneString = String.valueOf(stone);
        if (isEven(stoneString.length())) {
            String left = stoneString.substring(0, stoneString.length() / 2);
            String right = stoneString.substring(stoneString.length() / 2);
            transformed.add(Long.parseLong(left));
            transformed.add(Long.parseLong(right));
            return transformed;
        }
        transformed.add(stone * 2024);
        return transformed;
    }

    private boolean isEven(int number) {
        return number % 2 == 0;
    }
}
