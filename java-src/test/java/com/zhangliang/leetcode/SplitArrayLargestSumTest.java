package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SplitArrayLargestSumTest {

    @Test
    public void testCase() {
        SplitArrayLargestSum s = new SplitArrayLargestSum();
        int ans = s.splitArray(new int[] { 7, 2, 5, 10, 8 }, 2);
        assertEquals(18, ans);
    }
}
