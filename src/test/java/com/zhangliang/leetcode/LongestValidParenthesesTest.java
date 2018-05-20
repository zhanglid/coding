package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LongestValidParenthesesTest {

    @Test
    public void testCase() {
        LongestValidParentheses s = new LongestValidParentheses();
        int ans = s.longestValidParentheses("(()");
        assertEquals(ans, 2);
    }

    @Test
    public void testCase2() {
        LongestValidParentheses s = new LongestValidParentheses();
        int ans = s.longestValidParentheses(")()())");
        assertEquals(ans, 4);
    }
}
