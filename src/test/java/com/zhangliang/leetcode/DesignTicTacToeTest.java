package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DesignTicTacToeTest {

    @Test
    public void testCase() {
        DesignTicTacToe.TicTacToe s = new DesignTicTacToe.TicTacToe(3);
        assertEquals(0, s.move(0, 0, 1));
        assertEquals(0, s.move(0, 2, 2));
        assertEquals(0, s.move(2, 2, 1));
        assertEquals(0, s.move(1, 1, 2));
        assertEquals(0, s.move(2, 0, 1));
        assertEquals(0, s.move(1, 0, 2));
        assertEquals(1, s.move(2, 1, 1));
    }

    @Test
    public void errCase() {
        DesignTicTacToe.TicTacToe s = new DesignTicTacToe.TicTacToe(2);
        assertEquals(0, s.move(0, 0, 2));
        assertEquals(0, s.move(1, 1, 1));
        assertEquals(2, s.move(0, 1, 2));
    }
}
