package com.toondeboer.solutions;

import com.toondeboer.utils.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Day09 extends Solution {
    List<Integer> blocks;

    public Day09() {
        super("09");
    }

    @Override
    public long solvePart1(String input) {
        blocks = parseDiskMap(input);
        moveBlocks();

        return calculateChecksum();
    }

    @Override
    public long solvePart2(String input) {
        blocks = parseDiskMap(input);
        moveBlocks2();

        return calculateChecksum();
    }

    private List<Integer> parseDiskMap(String input) {
        List<Integer> blocks = new ArrayList<>();
        boolean file = true;
        int id = 0;
        for (char c : input.toCharArray()) {
            int next = Character.getNumericValue(c);
            for (int i = 0; i < next; i++) {
                if (file) {
                    blocks.add(id);
                } else {
                    blocks.add(null);
                }
            }
            if (file) {
                id++;
            }
            file = !file;
        }
        return blocks;
    }

    private void moveBlocks() {
        int leftIndex = 0;
        for (int i = blocks.size() - 1; i >= 0; i--) {
            if (leftIndex > i) {
                break;
            }
            Integer rightValue = blocks.get(i);
            if (rightValue == null) {
                continue;
            }
            while (blocks.get(leftIndex) != null && leftIndex < i) {
                leftIndex++;
            }
            blocks.set(i, null);
            blocks.set(leftIndex, rightValue);
        }
    }

    private void moveBlocks2() {
        for (int i = blocks.size() - 1; i >= 0; i--) {
            Integer rightValue = blocks.get(i);

            if (rightValue == null) {
                continue;
            }

            int blockSize = 1;
            while (i > 0 && Objects.equals(blocks.get(i - 1), (rightValue))) {
                blockSize++;
                i--;
            }

            int nullCount = 0;
            for (int j = 1; j < blocks.size(); j++) {
                if (j >= i) {
                    break;
                }
                if (blocks.get(j) == null) {
                    nullCount++;
                } else {
                    nullCount = 0;
                }
                if (nullCount == blockSize) {
                    moveEntireBlock(rightValue, blockSize, j - blockSize + 1, i);
                    break;
                }
            }
        }
    }

    private void moveEntireBlock(Integer rightValue, int blockSize, int leftIndex, int rightIndex) {
        for (int i = 0; i < blockSize; i++) {
            blocks.set(rightIndex + i, null);
            blocks.set(leftIndex + i, rightValue);
        }
    }

    private long calculateChecksum() {
        long sum = 0;
        for (int i = 0; i < blocks.size(); i++) {
            Integer id = blocks.get(i);
            if (id == null) {
                continue;
            }
            sum += (long) i * id;
        }
        return sum;
    }
}
