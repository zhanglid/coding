package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class ShortestSubarrayWithSumAtLeastKTest {

    @Test
    public void testCase() {
        ShortestSubarrayWithSumAtLeastK s = new ShortestSubarrayWithSumAtLeastK();
        int ans = s.shortestSubarray(new int[] { 1 }, 1);
        assertEquals(1, ans);
    }

    @Test
    public void testCase2() {
        ShortestSubarrayWithSumAtLeastK s = new ShortestSubarrayWithSumAtLeastK();
        int ans = s.shortestSubarray(new int[] { 1, 2 }, 4);
        assertEquals(-1, ans);
    }

    @Test
    public void testCase3() {
        ShortestSubarrayWithSumAtLeastK s = new ShortestSubarrayWithSumAtLeastK();
        int ans = s.shortestSubarray(new int[] { 2, -1, 2 }, 3);
        assertEquals(3, ans);
    }
}
