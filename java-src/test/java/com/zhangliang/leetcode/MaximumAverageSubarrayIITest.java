package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MaximumAverageSubarrayIITest {

    private static double DELTA = 1e-5;

    @Test
    public void testCase() {
        MaximumAverageSubarrayII s = new MaximumAverageSubarrayII();
        double ans = s.findMaxAverage(new int[] { 1, 12, -5, -6, 50, 3 }, 4);
        assertEquals(12.75, ans, DELTA);
    }
}
