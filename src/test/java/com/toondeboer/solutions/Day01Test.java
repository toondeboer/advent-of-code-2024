package com.toondeboer.solutions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day01Test {
    @Test
    void test() {
        String input = """
                3   4
                4   3
                2   5
                1   3
                3   9
                3   3""";
        assertEquals(11, Day01.solve(input));
    }
}
