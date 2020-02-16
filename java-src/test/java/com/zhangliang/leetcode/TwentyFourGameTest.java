package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.*;
import org.junit.Test;

public class TwentyFourGameTest {

    @Test
    public void testCase() {
        TwentyFourGame s = new TwentyFourGame();
        boolean ans = s.judgePoint24(new int[] { 4, 1, 8, 7 });
        assertEquals(true, ans);
    }

    @Test
    public void testCase2() {
        TwentyFourGame s = new TwentyFourGame();
        boolean ans = s.judgePoint24(new int[] { 1, 2, 1, 2 });
        assertEquals(false, ans);
    }
}
