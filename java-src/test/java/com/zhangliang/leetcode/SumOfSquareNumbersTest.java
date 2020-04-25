package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SumOfSquareNumbersTest {

    @Test
    public void testCase() {
        SumOfSquareNumbers s = new SumOfSquareNumbers();
        boolean ans = s.judgeSquareSum(5);
        assertEquals(true, ans);
    }

    @Test
    public void testCase2() {
        SumOfSquareNumbers s = new SumOfSquareNumbers();
        boolean ans = s.judgeSquareSum(3);
        assertEquals(false, ans);
    }

    @Test
    public void errCase() {
        SumOfSquareNumbers s = new SumOfSquareNumbers();
        boolean ans = s.judgeSquareSum(4);
        assertEquals(true, ans);
    }

    @Test
    public void errCase2() {
        SumOfSquareNumbers s = new SumOfSquareNumbers();
        boolean ans = s.judgeSquareSum(2);
        assertEquals(true, ans);
    }
}
