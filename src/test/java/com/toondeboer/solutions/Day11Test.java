package com.toondeboer.solutions;

import com.toondeboer.utils.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day11Test {
    Solution solution = new Day11();

    @Test
    void testPart1() {
        String input = "125 17";
        assertEquals(55312, solution.solvePart1(input));
    }
}
