package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class TwoSumIITest {

    @Test
    public void testCase() {
        TwoSumII s = new TwoSumII();
        int[] ans = s.twoSum(new int[] { 2, 7, 11, 15 }, 9);
        assertArrayEquals(ans, new int[] { 1, 2 });
    }
}
