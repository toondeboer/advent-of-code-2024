package com.toondeboer.solutions;

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

    @Test
    void testPart2() {
        String input = """
                .M.S......
                ..A..MSMS.
                .M.S.MAA..
                ..A.ASMSM.
                .M.S.M....
                ..........
                S.S.S.S.S.
                .A.A.A.A..
                M.M.M.M.M.
                ..........""";
        assertEquals(9, Day04.solve(input)[1]);
    }
}
