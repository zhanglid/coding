package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ValidPalindromeIITest {

    @Test
    public void testCase() {
        ValidPalindromeII s = new ValidPalindromeII();
        boolean ans = s.validPalindrome("aba");
        assertEquals(true, ans);
    }

    @Test
    public void testCase2() {
        ValidPalindromeII s = new ValidPalindromeII();
        boolean ans = s.validPalindrome("abca");
        assertEquals(true, ans);
    }

    @Test
    public void testCase3() {
        ValidPalindromeII s = new ValidPalindromeII();
        boolean ans = s.validPalindrome("bddb");
        assertEquals(true, ans);
    }
}
