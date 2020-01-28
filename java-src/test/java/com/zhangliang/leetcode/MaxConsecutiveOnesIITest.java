package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MaxConsecutiveOnesIITest {

    @Test
    public void testCase() {
        MaxConsecutiveOnesII s = new MaxConsecutiveOnesII();
        int ans = s.findMaxConsecutiveOnes(new int[] { 1, 0, 1, 1, 0 });
        assertEquals(4, ans);
    }

    @Test
    public void errCase() {
        MaxConsecutiveOnesII s = new MaxConsecutiveOnesII();
        int ans = s.findMaxConsecutiveOnes(new int[] { 0 });
        assertEquals(1, ans);
    }
}
