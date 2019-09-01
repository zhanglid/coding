package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ValidParenthesesTest {
    @Test
    public void testCase() {
        ValidParentheses s = new ValidParentheses();
        boolean ans = s.isValid("()");
        assertEquals(true, ans);
    }

    @Test
    public void testCase2() {
        ValidParentheses s = new ValidParentheses();
        boolean ans = s.isValid("()[]{}");
        assertEquals(true, ans);
    }

    @Test
    public void testCase3() {
        ValidParentheses s = new ValidParentheses();
        boolean ans = s.isValid("(]");
        assertEquals(false, ans);
    }

    @Test
    public void testCase4() {
        ValidParentheses s = new ValidParentheses();
        boolean ans = s.isValid("([)]");
        assertEquals(false, ans);
    }

    @Test
    public void testCase5() {
        ValidParentheses s = new ValidParentheses();
        boolean ans = s.isValid("{[]}");
        assertEquals(true, ans);
    }
}
