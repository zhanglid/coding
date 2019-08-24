package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MaximumSwapTest {
    @Test
    public void testCase() {
        MaximumSwap s = new MaximumSwap();
        int ans = s.maximumSwap(2736);
        assertEquals(7236, ans);
    }

    @Test
    public void testCase2() {
        MaximumSwap s = new MaximumSwap();
        int ans = s.maximumSwap(9973);
        assertEquals(9973, ans);
    }

    /**
     * During scanning from the end, when you meet a smaller number and the small
     * number becomes the final swap target. You have to make sure you know the max
     * one it will swap with. Because it is possible the max element will change
     * when you meet a larger one while the swap target does not change.
     */
    @Test
    public void errCase() {
        MaximumSwap s = new MaximumSwap();
        int ans = s.maximumSwap(98368);
        assertEquals(98863, ans);
    }

    /**
     * When you have multiple max targets. You have to choose the one later. Since
     * it will result larger number.
     */
    @Test
    public void errCase2() {
        MaximumSwap s = new MaximumSwap();
        int ans = s.maximumSwap(1993);
        assertEquals(9913, ans);
    }
}
