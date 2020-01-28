package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import java.util.*;
import org.junit.Test;

public class ExpressionAddOperatorsTest {

    private void assertCorrect(List<String> expected, List<String> ans) {
        Collections.sort(expected);
        Collections.sort(ans);
        assertArrayEquals(expected.toArray(new String[0]), ans.toArray(new String[0]));
    }

    @Test
    public void testCase() {
        ExpressionAddOperators s = new ExpressionAddOperators();
        List<String> ans = s.addOperators("123", 6);
        assertCorrect(Arrays.asList("1+2+3", "1*2*3"), ans);
    }

    @Test
    public void testCase2() {
        ExpressionAddOperators s = new ExpressionAddOperators();
        List<String> ans = s.addOperators("232", 8);
        assertCorrect(Arrays.asList("2*3+2", "2+3*2"), ans);
    }

    @Test
    public void testCase3() {
        ExpressionAddOperators s = new ExpressionAddOperators();
        List<String> ans = s.addOperators("105", 5);
        assertCorrect(Arrays.asList("1*0+5", "10-5"), ans);
    }

    @Test
    public void testCase4() {
        ExpressionAddOperators s = new ExpressionAddOperators();
        List<String> ans = s.addOperators("00", 0);
        assertCorrect(Arrays.asList("0+0", "0-0", "0*0"), ans);
    }

    @Test
    public void testCase5() {
        ExpressionAddOperators s = new ExpressionAddOperators();
        List<String> ans = s.addOperators("3456237490", 9191);
        assertCorrect(Arrays.asList(), ans);
    }

    @Test
    public void errCase() {
        ExpressionAddOperators s = new ExpressionAddOperators();
        List<String> ans = s.addOperators("", 6);
        assertCorrect(Arrays.asList(), ans);
    }

    @Test
    public void errCase2() {
        ExpressionAddOperators s = new ExpressionAddOperators();
        List<String> ans = s.addOperators("2147483648", -2147483648);
        assertCorrect(Arrays.asList(), ans);
    }
}
