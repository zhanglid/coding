package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CountDifferentPalindromicSubsequencesTest {

    @Test
    public void testCase() {
        CountDifferentPalindromicSubsequences s = new CountDifferentPalindromicSubsequences();
        int ans = s.countPalindromicSubsequences("bccb");
        assertEquals(6, ans);
    }

    @Test
    public void testCase2() {
        CountDifferentPalindromicSubsequences s = new CountDifferentPalindromicSubsequences();
        int ans = s.countPalindromicSubsequences("abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba");
        assertEquals(104860361, ans);
    }

    @Test
    public void testCase3() {
        CountDifferentPalindromicSubsequences s = new CountDifferentPalindromicSubsequences();
        int ans = s.countPalindromicSubsequences("bcdcb");
        assertEquals(10, ans);
    }
}
