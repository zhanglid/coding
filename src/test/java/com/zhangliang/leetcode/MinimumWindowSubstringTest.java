package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MinimumWindowSubstringTest {

    @Test
    public void testCase() {
        MinimumWindowSubstring s = new MinimumWindowSubstring();
        String ans = s.minWindow("ADOBECODEBANC", "ABC");
        assertEquals("BANC", ans);
    }
}
