package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CoinChangeTest {

    @Test
    public void testCase() {
        CoinChange s = new CoinChange();
        int ans = s.coinChange(new int[] { 1, 2, 5 }, 11);
        assertEquals(3, ans);
    }

    @Test
    public void testCase2() {
        CoinChange s = new CoinChange();
        int ans = s.coinChange(new int[] { 2 }, 3);
        assertEquals(-1, ans);
    }
}
