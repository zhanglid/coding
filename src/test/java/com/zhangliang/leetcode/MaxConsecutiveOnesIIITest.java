package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MaxConsecutiveOnesIIITest {

    @Test
    public void testCase() {
        MaxConsecutiveOnesIII s = new MaxConsecutiveOnesIII();
        int ans = s.longestOnes(new int[] { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 }, 2);
        assertEquals(6, ans);
    }

    @Test
    public void testCase2() {
        MaxConsecutiveOnesIII s = new MaxConsecutiveOnesIII();
        int ans = s.longestOnes(new int[] { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 }, 3);
        assertEquals(10, ans);
    }

    @Test
    public void errCase() {
        MaxConsecutiveOnesIII s = new MaxConsecutiveOnesIII();
        int ans = s.longestOnes(new int[] { 0, 0, 1, 1, 1, 0, 0 }, 0);
        assertEquals(3, ans);
    }
}
