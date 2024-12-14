package com.toondeboer.day02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day02Test {
    @Test
    void testPart1() {
        String input = """
                7 6 4 2 1
                1 2 7 8 9
                9 7 6 2 1
                1 3 2 4 5
                8 6 4 4 1
                1 3 6 7 9""";
        assertEquals(2, Day02.solve(input)[0]);
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
        assertEquals(4, Day02.solve(input)[1]);
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
        assertEquals(7, Day02.solve(input)[1]);
    }
}
