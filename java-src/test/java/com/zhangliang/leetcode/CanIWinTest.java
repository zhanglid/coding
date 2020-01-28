package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CanIWinTest {

    @Test
    public void testCase() {
        CanIWin s = new CanIWin();
        boolean ans = s.canIWin(10, 11);
        assertEquals(false, ans);
    }

    @Test
    public void errCase() {
        CanIWin s = new CanIWin();
        boolean ans = s.canIWin(10, 0);
        assertEquals(true, ans);
    }

    @Test
    public void errCase2() {
        CanIWin s = new CanIWin();
        boolean ans = s.canIWin(5, 50);
        assertEquals(false, ans);
    }

    @Test
    public void errCase3() {
        CanIWin s = new CanIWin();
        boolean ans = s.canIWin(4, 6);
        assertEquals(true, ans);
    }
}
