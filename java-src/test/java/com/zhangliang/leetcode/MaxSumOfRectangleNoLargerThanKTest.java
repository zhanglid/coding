package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MaxSumOfRectangleNoLargerThanKTest {

    @Test
    public void testCase() {
        MaxSumOfRectangleNoLargerThanK s = new MaxSumOfRectangleNoLargerThanK();
        int ans = s.maxSumSubmatrix(new int[][] { { 1, 0, 1 }, { 0, -2, 3 } }, 2);
        assertEquals(2, ans);
    }
}
