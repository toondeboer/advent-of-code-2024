package com.toondeboer.solutions;

import com.toondeboer.utils.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day06Test {
    Solution solution = new Day06();

    @Test
    void testPart1() {
        String input = """
                ....#.....
                .........#
                ..........
                ..#.......
                .......#..
                ..........
                .#..^.....
                ........#.
                #.........
                ......#...""";
        assertEquals(41, solution.solvePart1(input));
    }

    @Test
    void testPart2() {
        String input = """
                ....#.....
                .........#
                ..........
                ..#.......
                .......#..
                ..........
                .#..^.....
                ........#.
                #.........
                ......#...""";
        assertEquals(6, solution.solvePart2(input));
    }
}
