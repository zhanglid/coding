package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TrappingRainWaterTest {

    @Test
    public void testCase() {
        TrappingRainWater s = new TrappingRainWater();
        int ans = s.trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 });
        assertEquals(6, ans);
    }
}
