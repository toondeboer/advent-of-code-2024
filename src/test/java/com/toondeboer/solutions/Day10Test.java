package com.toondeboer.solutions;

import com.toondeboer.utils.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day10Test {
    Solution solution = new Day10();

    @Test
    void testPart1() {
        String input = """
                89010123
                78121874
                87430965
                96549874
                45678903
                32019012
                01329801
                10456732""";
        assertEquals(36, solution.solvePart1(input));
    }

    @Test
    void testPart2() {
        String input = """
                89010123
                78121874
                87430965
                96549874
                45678903
                32019012
                01329801
                10456732""";
        assertEquals(81, solution.solvePart2(input));
    }
}
