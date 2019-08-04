package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LongestValidParenthesesTest {

    @Test
    public void testCase() {
        LongestValidParentheses s = new LongestValidParentheses();
        int ans = s.longestValidParentheses("(()");
        assertEquals(2, ans);
    }

    @Test
    public void testCase2() {
        LongestValidParentheses s = new LongestValidParentheses();
        int ans = s.longestValidParentheses(")()())");
        assertEquals(4, ans);
    }

    @Test
    public void testCase3() {
        LongestValidParentheses s = new LongestValidParentheses();
        int ans = s.longestValidParentheses("()(()");
        assertEquals(2, ans);
    }
}
