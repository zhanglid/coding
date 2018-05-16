package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class RegularExpressionMatchingTest {
    RegularExpressionMatching s;

    public RegularExpressionMatchingTest() {
        s = new RegularExpressionMatching();
    }

    @Test
    public void testCase() {
        boolean ans = s.isMatch("aa", "a");
        assertEquals(ans, false);
    }

    @Test
    public void testCase2() {
        boolean ans = s.isMatch("aa", "a*");
        assertEquals(ans, true);
    }

    @Test
    public void testCase3() {
        boolean ans = s.isMatch("ab", ".*");
        assertEquals(ans, true);
    }

    @Test
    public void testCase4() {
        boolean ans = s.isMatch("aab", "c*a*b");
        assertEquals(ans, true);
    }

    @Test
    public void testCase5() {
        boolean ans = s.isMatch("mississippi", "mis*is*p*.");
        assertEquals(ans, false);
    }

    @Test
    public void errCase() {
        boolean ans = s.isMatch("aaa", "ab*a");
        assertEquals(ans, false);
    }

    @Test
    public void errCase2() {
        boolean ans = s.isMatch("aaa", "ab*a*c*a");
        assertEquals(ans, true);
    }
}
