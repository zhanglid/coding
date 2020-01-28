package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MinimumAddToMakeParenthesesValidTest {

    @Test
    public void testCase() {
        MinimumAddToMakeParenthesesValid s = new MinimumAddToMakeParenthesesValid();
        int ans = s.minAddToMakeValid("())");
        assertEquals(1, ans);
    }

    @Test
    public void testCase2() {
        MinimumAddToMakeParenthesesValid s = new MinimumAddToMakeParenthesesValid();
        int ans = s.minAddToMakeValid("(((");
        assertEquals(3, ans);
    }

    @Test
    public void testCase3() {
        MinimumAddToMakeParenthesesValid s = new MinimumAddToMakeParenthesesValid();
        int ans = s.minAddToMakeValid("()");
        assertEquals(0, ans);
    }

    @Test
    public void testCase4() {
        MinimumAddToMakeParenthesesValid s = new MinimumAddToMakeParenthesesValid();
        int ans = s.minAddToMakeValid("()))((");
        assertEquals(4, ans);
    }
}
