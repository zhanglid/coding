package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ValidPalindromeIIITest {

    @Test
    public void testCase() {
        ValidPalindromeIII s = new ValidPalindromeIII();
        boolean ans = s.isValidPalindrome("abcdeca", 2);
        assertEquals(true, ans);
    }

    @Test
    public void testCase2() {
        ValidPalindromeIII s = new ValidPalindromeIII();
        boolean ans = s.isValidPalindrome("bacabaaa", 2);
        assertEquals(false, ans);
    }
}
