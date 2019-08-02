package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import java.util.List;
import org.junit.Test;

public class RemoveInvalidParenthesesTest {

    @Test
    public void testCase() {
        RemoveInvalidParentheses s = new RemoveInvalidParentheses();
        List<String> ans = s.removeInvalidParentheses("()())()");
        assertArrayEquals(new String[] { "()()()", "(())()" }, ans.toArray(new String[0]));
    }

    @Test
    public void testCase2() {
        RemoveInvalidParentheses s = new RemoveInvalidParentheses();
        List<String> ans = s.removeInvalidParentheses("(a)())()");
        assertArrayEquals(new String[] { "(a)()()", "(a())()" }, ans.toArray(new String[0]));
    }

    @Test
    public void testCase3() {
        RemoveInvalidParentheses s = new RemoveInvalidParentheses();
        List<String> ans = s.removeInvalidParentheses(")(");
        assertArrayEquals(new String[] { "" }, ans.toArray(new String[0]));
    }
}
