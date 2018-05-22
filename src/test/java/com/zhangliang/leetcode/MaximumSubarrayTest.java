package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MaximumSubarrayTest {

    @Test
    public void testCase() {
        MaximumSubarray s = new MaximumSubarray();
        int ans = s.maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 });
        assertEquals(6, ans);
    }

    @Test
    public void errCase() {
        MaximumSubarray s = new MaximumSubarray();
        int ans = s.maxSubArray(new int[] { -1 });
        assertEquals(-1, ans);
    }
}
