package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PalindromeNumberTest {

    @Test
    public void testCase() {
        PalindromeNumber s = new PalindromeNumber();
        boolean ans = s.isPalindrome(121);
        assertEquals(ans, true);
    }

    @Test
    public void testCase2() {
        PalindromeNumber s = new PalindromeNumber();
        boolean ans = s.isPalindrome(-121);
        assertEquals(ans, false);
    }

    @Test
    public void testCase3() {
        PalindromeNumber s = new PalindromeNumber();
        boolean ans = s.isPalindrome(10);
        assertEquals(ans, false);
    }
}
