package com.toondeboer.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GridTest {

    @Test
    void testGrid() {
        String input = """
                abcd
                efgh""";
        Grid grid = new Grid(input);
        assertEquals(4, grid.getWidth());
        assertEquals(2, grid.getHeight());
        assertEquals('a', grid.getCoordinate(1, 2));
        assertEquals('d', grid.getCoordinate(4, 2));
        assertEquals('g', grid.getCoordinate(3, 1));
    }
}
