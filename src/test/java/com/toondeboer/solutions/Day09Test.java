package com.toondeboer.solutions;

import com.toondeboer.utils.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day09Test {
    Solution solution = new Day09();

    @Test
    void testPart1() {
        String input = "2333133121414131402";
        assertEquals(1928, solution.solvePart1(input));
    }

    @Test
    void testPart2() {
        String input = "2333133121414131402";
        assertEquals(2858, solution.solvePart2(input));
    }
}
