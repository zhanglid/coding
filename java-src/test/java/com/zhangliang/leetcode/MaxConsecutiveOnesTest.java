package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MaxConsecutiveOnesTest {

    @Test
    public void testCase() {
        MaxConsecutiveOnes s = new MaxConsecutiveOnes();
        int ans = s.findMaxConsecutiveOnes(new int[] { 1, 1, 0, 1, 1, 1 });
        assertEquals(3, ans);
    }
}
