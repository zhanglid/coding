package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ValidTicTacToeStateTest {

    @Test
    public void testCase() {
        ValidTicTacToeState s = new ValidTicTacToeState();
        boolean ans = s.validTicTacToe(new String[] { "O  ", "   ", "   " });
        assertEquals(false, ans);
    }

    @Test
    public void testCase2() {
        ValidTicTacToeState s = new ValidTicTacToeState();
        boolean ans = s.validTicTacToe(new String[] { "XOX", " X ", "   " });
        assertEquals(false, ans);
    }

    @Test
    public void testCase3() {
        ValidTicTacToeState s = new ValidTicTacToeState();
        boolean ans = s.validTicTacToe(new String[] { "XXX", "   ", "OOO" });
        assertEquals(false, ans);
    }

    @Test
    public void testCase4() {
        ValidTicTacToeState s = new ValidTicTacToeState();
        boolean ans = s.validTicTacToe(new String[] { "XOX", "O O", "XOX" });
        assertEquals(true, ans);
    }

    @Test
    public void testCase5() {
        ValidTicTacToeState s = new ValidTicTacToeState();
        boolean ans = s.validTicTacToe(new String[] { "XXX", "XOO", "OO " });
        assertEquals(false, ans);
    }
}
