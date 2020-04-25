package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class OptimalAccountBalancingTest {

    @Test
    public void testCase() {
        OptimalAccountBalancing s = new OptimalAccountBalancing();
        int ans = s.minTransfers(new int[][] { { 0, 1, 10 }, { 2, 0, 5 } });
        assertEquals(2, ans);
    }

    @Test
    public void testCase2() {
        OptimalAccountBalancing s = new OptimalAccountBalancing();
        int ans = s.minTransfers(new int[][] { { 0, 1, 10 }, { 1, 0, 1 }, { 1, 2, 5 }, { 2, 0, 5 } });
        assertEquals(1, ans);
    }
}
