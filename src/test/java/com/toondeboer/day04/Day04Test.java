package com.toondeboer.day04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day04Test {
    @Test
    void testPart1() {
        String input = """
                MMMSXXMASM
                MSAMXMSMSA
                AMXSXMAAMM
                MSAMASMSMX
                XMASAMXAMM
                XXAMMXXAMA
                SMSMSASXSS
                SAXAMASAAA
                MAMMMXMMMM
                MXMXAXMASX""";
        assertEquals(18, Day04.solve(input)[0]);
    }

    @Test
    void testPart1Simplified() {
        String input = """
                ....XXMAS.
                .SAMXMS...
                ...S..A...
                ..A.A.MS.X
                XMASAMX.MM
                X.....XA.A
                S.S.S.S.SS
                .A.A.A.A.A
                ..M.M.M.MM
                .X.X.XMASX""";
        assertEquals(18, Day04.solve(input)[0]);
    }
}
