package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MaximumProductSubarrayTest {

    @Test
    public void testCase() {
        MaximumProductSubarray s = new MaximumProductSubarray();
        int ans = s.maxProduct(new int[] { 2, 3, -2, 4 });
        assertEquals(6, ans);
    }

    @Test
    public void testCase2() {
        MaximumProductSubarray s = new MaximumProductSubarray();
        int ans = s.maxProduct(new int[] { -2, 0, -1 });
        assertEquals(0, ans);
    }

    @Test
    public void errCase() {
        MaximumProductSubarray s = new MaximumProductSubarray();
        int ans = s.maxProduct(new int[] { -2 });
        assertEquals(-2, ans);
    }
}
