package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class WildcardMatchingTest {

    @Test
    public void testCase() {
        WildcardMatching s = new WildcardMatching();
        boolean ans = s.isMatch("aa", "a");
        assertEquals(false, ans);
    }

    @Test
    public void testCase2() {
        WildcardMatching s = new WildcardMatching();
        boolean ans = s.isMatch("aa", "*");
        assertEquals(true, ans);
    }

    @Test
    public void testCase3() {
        WildcardMatching s = new WildcardMatching();
        boolean ans = s.isMatch("cb", "?a");
        assertEquals(false, ans);
    }

    @Test
    public void testCase4() {
        WildcardMatching s = new WildcardMatching();
        boolean ans = s.isMatch("adceb", "*a*b");
        assertEquals(true, ans);
    }

    @Test
    public void testCase5() {
        WildcardMatching s = new WildcardMatching();
        boolean ans = s.isMatch("acdcb", "a*c?b");
        assertEquals(false, ans);
    }

    @Test
    public void errCase() {
        WildcardMatching s = new WildcardMatching();
        boolean ans = s.isMatch("ab", "?*");
        assertEquals(true, ans);
    }
}
