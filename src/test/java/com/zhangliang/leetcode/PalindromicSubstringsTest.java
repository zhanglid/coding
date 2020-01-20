package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PalindromicSubstringsTest {
    @Test
    public void testCase() {
        PalindromicSubstrings s = new PalindromicSubstrings();
        int ans = s.countSubstrings("abc");
        assertEquals(3, ans);
    }

    @Test
    public void testCase2() {
        PalindromicSubstrings s = new PalindromicSubstrings();
        int ans = s.countSubstrings("aaa");
        assertEquals(6, ans);
    }
}
