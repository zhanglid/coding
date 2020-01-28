package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LongestArithmeticSequenceTest {

    @Test
    public void testCase() {
        LongestArithmeticSequence s = new LongestArithmeticSequence();
        int ans = s.longestArithSeqLength(new int[] { 3, 6, 9, 12 });
        assertEquals(4, ans);
    }

    @Test
    public void testCase2() {
        LongestArithmeticSequence s = new LongestArithmeticSequence();
        int ans = s.longestArithSeqLength(new int[] { 9, 4, 7, 2, 10 });
        assertEquals(3, ans);
    }

    @Test
    public void testCase3() {
        LongestArithmeticSequence s = new LongestArithmeticSequence();
        int ans = s.longestArithSeqLength(new int[] { 20, 1, 15, 3, 10, 5, 8 });
        assertEquals(4, ans);
    }
}
