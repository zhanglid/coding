package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MinimumSwapsToMakeSequencesIncreasingTest {

    @Test
    public void testCase() {
        MinimumSwapsToMakeSequencesIncreasing s = new MinimumSwapsToMakeSequencesIncreasing();
        int ans = s.minSwap(new int[] { 1, 3, 5, 4 }, new int[] { 1, 2, 3, 7 });
        assertEquals(1, ans);
    }

    @Test
    public void errCase2() {
        MinimumSwapsToMakeSequencesIncreasing s = new MinimumSwapsToMakeSequencesIncreasing();
        int ans = s.minSwap(new int[] { 0, 3, 5, 8, 9 }, new int[] { 2, 1, 4, 6, 9 });
        assertEquals(1, ans);
    }
}