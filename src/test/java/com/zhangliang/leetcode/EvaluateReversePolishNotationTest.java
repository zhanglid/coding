package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class EvaluateReversePolishNotationTest {

    @Test
    public void testCase() {
        EvaluateReversePolishNotation s = new EvaluateReversePolishNotation();
        int ans = s.evalRPN(new String[] { "2", "1", "+", "3", "*" });
        assertEquals(9, ans);
    }

    @Test
    public void testCase2() {
        EvaluateReversePolishNotation s = new EvaluateReversePolishNotation();
        int ans = s.evalRPN(new String[] { "4", "13", "5", "/", "+" });
        assertEquals(6, ans);
    }

    @Test
    public void testCase3() {
        EvaluateReversePolishNotation s = new EvaluateReversePolishNotation();
        int ans = s.evalRPN(new String[] { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" });
        assertEquals(22, ans);
    }
}
