package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MinimumWindowSubsequenceTest {

    @Test
    public void testCase() {
        MinimumWindowSubsequence s = new MinimumWindowSubsequence();
        String ans = s.minWindow("abcdebdde", "bde");
        assertEquals("bcde", ans);
    }
}
