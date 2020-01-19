package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CoinChangeIITest {

    @Test
    public void testCase() {
        CoinChangeII s = new CoinChangeII();
        int ans = s.change(5, new int[] { 1, 2, 5 });
        assertEquals(4, ans);
    }

    @Test
    public void testCase2() {
        CoinChangeII s = new CoinChangeII();
        int ans = s.change(3, new int[] { 2 });
        assertEquals(0, ans);
    }

    @Test
    public void testCase3() {
        CoinChangeII s = new CoinChangeII();
        int ans = s.change(10, new int[] { 10 });
        assertEquals(1, ans);
    }
}
