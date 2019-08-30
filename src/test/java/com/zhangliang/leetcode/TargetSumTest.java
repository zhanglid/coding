package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TargetSumTest {
    @Test
    public void testCase() {
        TargetSum s = new TargetSum();
        int ans = s.findTargetSumWays(new int[] { 1, 1, 1, 1, 1 }, 3);
        assertEquals(5, ans);
    }
}
