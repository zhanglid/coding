package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LongestPalindromicSubsequenceTest {

    @Test
    public void testCase() {
        LongestPalindromicSubsequence s = new LongestPalindromicSubsequence();
        int ans = s.longestPalindromeSubseq("bbbab");
        assertEquals(4, ans);
    }

    @Test
    public void testCase2() {
        LongestPalindromicSubsequence s = new LongestPalindromicSubsequence();
        int ans = s.longestPalindromeSubseq("cbbd");
        assertEquals(2, ans);
    }

    @Test
    public void errCase() {
        LongestPalindromicSubsequence s = new LongestPalindromicSubsequence();
        int ans = s.longestPalindromeSubseq("a");
        assertEquals(1, ans);
    }

    @Test
    public void testCase3() {
        LongestPalindromicSubsequence s = new LongestPalindromicSubsequence();
        int ans = s.longestPalindromeSubseq("aabaa");
        assertEquals(5, ans);
    }
}
