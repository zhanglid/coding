package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

public class GenerateParenthesesTest {

    private void assertCorrect(String[] expected, String[] ans) {
        Arrays.sort(ans);
        Arrays.sort(expected);
        assertArrayEquals("default", ans, expected);
    }

    @Test
    public void testCase() {
        GenerateParentheses s = new GenerateParentheses();
        String[] ans = s.generateParenthesis(3).toArray(new String[0]);
        String[] expected = { "((()))", "(()())", "(())()", "()(())", "()()()" };
        assertCorrect(ans, expected);
    }

    @Test
    public void testCase2() {
        GenerateParentheses s = new GenerateParentheses();
        String[] ans = s.generateParenthesis(4).toArray(new String[0]);
        String[] expected = { "(((())))", "((()()))", "((())())", "((()))()", "(()(()))", "(()()())", "(()())()",
                "(())(())", "(())()()", "()((()))", "()(()())", "()(())()", "()()(())", "()()()()" };
        assertCorrect(ans, expected);
    }
}