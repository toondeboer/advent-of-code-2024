package com.toondeboer.solutions;

import com.toondeboer.utils.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day01Test {
    Solution solution = new Day01();

    @Test
    void testPart1() {
        String input = """
                3   4
                4   3
                2   5
                1   3
                3   9
                3   3""";
        assertEquals(11, solution.solvePart1(input));
    }

    @Test
    void testPart2() {
        String input = """
                3   4
                4   3
                2   5
                1   3
                3   9
                3   3""";
        assertEquals(31, solution.solvePart2(input));
    }
}
