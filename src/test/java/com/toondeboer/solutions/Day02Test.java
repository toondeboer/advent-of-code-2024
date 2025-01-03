package com.toondeboer.solutions;

import com.toondeboer.utils.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day02Test {

    Solution solution = new Day02();

    @Test
    void testPart1() {
        String input = """
                7 6 4 2 1
                1 2 7 8 9
                9 7 6 2 1
                1 3 2 4 5
                8 6 4 4 1
                1 3 6 7 9""";
        assertEquals(2, solution.solvePart1(input));
    }

    @Test
    void testPart2() {
        String input = """
                7 6 4 2 1
                1 2 7 8 9
                9 7 6 2 1
                1 3 2 4 5
                8 6 4 4 1
                1 3 6 7 9""";
        assertEquals(4, solution.solvePart2(input));
    }

    @Test
    void testPart2edgeCases() {
        String input = """
                9 1 2 3 4
                2 1 2 3 4
                8 9 8 7 6
                2 1 5 6 7
                8 9 5 4 3
                1 1 2 3 4
                9 9 8 7 6""";
        assertEquals(7, solution.solvePart2(input));
    }

    @Test
    void testPart2edgeCases2() {
        String input = """
                1 3 4 5 2
                1 9 8 7 6""";
        assertEquals(2, solution.solvePart2(input));
    }
}
