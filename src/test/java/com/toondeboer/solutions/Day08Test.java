package com.toondeboer.solutions;

import com.toondeboer.utils.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day08Test {
    Solution solution = new Day08();

    @Test
    void testPart1() {
        String input = """
                ............
                ........0...
                .....0......
                .......0....
                ....0.......
                ......A.....
                ............
                ............
                ........A...
                .........A..
                ............
                ............""";
        assertEquals(14, solution.solvePart1(input));
    }

    @Test
    void testPart1Simplified() {
        String input = """
                ..a.a..""";
        assertEquals(2, solution.solvePart1(input));
    }

    @Test
    void testPart2() {
        String input = """
                ............
                ........0...
                .....0......
                .......0....
                ....0.......
                ......A.....
                ............
                ............
                ........A...
                .........A..
                ............
                ............""";
        assertEquals(34, solution.solvePart2(input));
    }
}