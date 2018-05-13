package com.zhangliang.leetcode;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LongestPalindromicSubstringTest {

    @Test
    public void testDefault() {
        LongestPalindromicSubstring s = new LongestPalindromicSubstring();
        String ans = s.longestPalindrome("babad");
        assertTrue("Default pass", ans.equals("bab") || ans.equals("aba"));
    }

    @Test
    public void testSameString() {
        LongestPalindromicSubstring s = new LongestPalindromicSubstring();
        String ans = s.longestPalindrome("aaaa");
        assertTrue("Default pass", ans.equals("aaaa"));
    }
}