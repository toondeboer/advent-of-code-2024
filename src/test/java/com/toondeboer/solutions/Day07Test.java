package com.toondeboer.solutions;

import com.toondeboer.utils.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day07Test {
    Solution solution = new Day07();

    @Test
    void testPart1() {
        String input = """
                190: 10 19
                3267: 81 40 27
                83: 17 5
                156: 15 6
                7290: 6 8 6 15
                161011: 16 10 13
                192: 17 8 14
                21037: 9 7 18 13
                292: 11 6 16 20""";
        assertEquals(3749, solution.solvePart1(input));
    }

    @Test
    void testPart2() {
        String input = """
                190: 10 19
                3267: 81 40 27
                83: 17 5
                156: 15 6
                7290: 6 8 6 15
                161011: 16 10 13
                192: 17 8 14
                21037: 9 7 18 13
                292: 11 6 16 20""";
        assertEquals(3749, solution.solvePart2(input));
    }
}
