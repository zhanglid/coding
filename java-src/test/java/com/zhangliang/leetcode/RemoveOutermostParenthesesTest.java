package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class RemoveOutermostParenthesesTest {

    @Test
    public void testCase() {
        RemoveOutermostParentheses s = new RemoveOutermostParentheses();
        String ans = s.removeOuterParentheses("(()())(())");
        assertEquals("()()()", ans);
    }

    @Test
    public void testCase2() {
        RemoveOutermostParentheses s = new RemoveOutermostParentheses();
        String ans = s.removeOuterParentheses("(()())(())(()(()))");
        assertEquals("()()()()(())", ans);
    }

    @Test
    public void testCase3() {
        RemoveOutermostParentheses s = new RemoveOutermostParentheses();
        String ans = s.removeOuterParentheses("()()");
        assertEquals("", ans);
    }
}
