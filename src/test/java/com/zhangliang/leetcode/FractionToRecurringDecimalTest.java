package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FractionToRecurringDecimalTest {
    @Test
    public void testCase() {
        FractionToRecurringDecimal s = new FractionToRecurringDecimal();
        String ans = s.fractionToDecimal(1, 2);
        assertEquals("0.5", ans);
    }

    @Test
    public void testCase2() {
        FractionToRecurringDecimal s = new FractionToRecurringDecimal();
        String ans = s.fractionToDecimal(2, 1);
        assertEquals("2", ans);
    }

    @Test
    public void testCase3() {
        FractionToRecurringDecimal s = new FractionToRecurringDecimal();
        String ans = s.fractionToDecimal(2, 3);
        assertEquals("0.(6)", ans);
    }

    @Test
    public void errCase() {
        FractionToRecurringDecimal s = new FractionToRecurringDecimal();
        String ans = s.fractionToDecimal(-50, 8);
        assertEquals("-6.25", ans);
    }

    @Test
    public void testCase4() {
        FractionToRecurringDecimal s = new FractionToRecurringDecimal();
        String ans = s.fractionToDecimal(Integer.MIN_VALUE, -1);
        assertEquals(Integer.toString(Integer.MIN_VALUE).substring(1), ans);
    }

    @Test
    public void testCase5() {
        FractionToRecurringDecimal s = new FractionToRecurringDecimal();
        String ans = s.fractionToDecimal(-Integer.MIN_VALUE, 1);
        assertEquals(Integer.toString(Integer.MIN_VALUE), ans);
    }

    @Test
    public void errCase2() {
        FractionToRecurringDecimal s = new FractionToRecurringDecimal();
        String ans = s.fractionToDecimal(1, Integer.MIN_VALUE);
        assertEquals("-0.0000000004656612873077392578125", ans);
    }

    @Test
    public void errCase3() {
        FractionToRecurringDecimal s = new FractionToRecurringDecimal();
        String ans = s.fractionToDecimal(7, -12);
        assertEquals("-0.58(3)", ans);
    }
}
