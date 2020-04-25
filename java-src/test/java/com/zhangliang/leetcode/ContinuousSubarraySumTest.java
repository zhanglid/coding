package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ContinuousSubarraySumTest {

    @Test
    public void testCase() {
        ContinuousSubarraySum s = new ContinuousSubarraySum();
        boolean ans = s.checkSubarraySum(new int[] { 23, 2, 4, 6, 7 }, 6);
        assertEquals(true, ans);
    }

    @Test
    public void testCase2() {
        ContinuousSubarraySum s = new ContinuousSubarraySum();
        boolean ans = s.checkSubarraySum(new int[] { 23, 2, 6, 4, 7 }, 42);
        assertEquals(true, ans);
    }

    @Test
    public void errCase() {
        ContinuousSubarraySum s = new ContinuousSubarraySum();
        boolean ans = s.checkSubarraySum(new int[] { 5, 0, 0 }, 0);
        assertEquals(true, ans);
    }
}
