package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ValidPalindromeTest {

    @Test
    public void testCase() {
        ValidPalindrome s = new ValidPalindrome();
        boolean ans = s.isPalindrome("A man, a plan, a canal: Panama");
        assertEquals(true, ans);
    }

    @Test
    public void testCase2() {
        ValidPalindrome s = new ValidPalindrome();
        boolean ans = s.isPalindrome("race a car");
        assertEquals(false, ans);
    }

    @Test
    public void errCase() {
        ValidPalindrome s = new ValidPalindrome();
        boolean ans = s.isPalindrome("0P");
        assertEquals(false, ans);
    }

    @Test
    public void errCase2() {
        ValidPalindrome s = new ValidPalindrome();
        boolean ans = s.isPalindrome("Zeus was deified, saw Suez.");
        assertEquals(true, ans);
    }

}
