package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LongestConsecutiveSequenceTest {

    @Test
    public void testCase() {
        LongestConsecutiveSequence s = new LongestConsecutiveSequence();
        int ans = s.longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 });
        assertEquals(4, ans);
    }
}
