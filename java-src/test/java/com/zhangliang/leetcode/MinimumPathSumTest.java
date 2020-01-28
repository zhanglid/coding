package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MinimumPathSumTest {

    @Test
    public void testCase() {
        MinimumPathSum s = new MinimumPathSum();
        int ans = s.minPathSum(new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } });
        assertEquals(7, ans);
    }
}
