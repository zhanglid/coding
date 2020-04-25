package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MinimumKnightMovesTest {

    @Test
    public void testCase() {
        MinimumKnightMoves s = new MinimumKnightMoves();
        int ans = s.minKnightMoves(2, 1);
        assertEquals(1, ans);
    }

    @Test
    public void testCase2() {
        MinimumKnightMoves s = new MinimumKnightMoves();
        int ans = s.minKnightMoves(5, 5);
        assertEquals(4, ans);
    }
}
