package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LongestCommonPrefixTest {

    @Test
    public void testCase() {
        LongestCommonPrefix s = new LongestCommonPrefix();
        String ans = s.longestCommonPrefix(new String[] { "flower", "flow", "flight" });
        assertEquals(ans, "fl");
    }

    @Test
    public void testCase2() {
        LongestCommonPrefix s = new LongestCommonPrefix();
        String ans = s.longestCommonPrefix(new String[] { "dog", "racecar", "car" });
        assertEquals(ans, "");
    }
}
