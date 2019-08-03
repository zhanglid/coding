package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DivideTwoIntegersTest {

    @Test
    public void testCase() {
        DivideTwoIntegers s = new DivideTwoIntegers();
        int ans = s.divide(10, 3);
        assertEquals(3, ans);
    }

    @Test
    public void testCase2() {
        DivideTwoIntegers s = new DivideTwoIntegers();
        int ans = s.divide(7, -3);
        assertEquals(-2, ans);
    }

    @Test
    public void errCase() {
        DivideTwoIntegers s = new DivideTwoIntegers();
        int ans = s.divide(1, 1);
        assertEquals(1, ans);
    }

    @Test
    public void errCase2() {
        DivideTwoIntegers s = new DivideTwoIntegers();
        int ans = s.divide(2147483647, 1);
        assertEquals(2147483647, ans);
    }

    @Test
    public void errCase3() {
        DivideTwoIntegers s = new DivideTwoIntegers();
        int ans = s.divide(-2147483648, 1);
        assertEquals(-2147483648, ans);
    }

    @Test
    public void errCase4() {
        DivideTwoIntegers s = new DivideTwoIntegers();
        int ans = s.divide(2147483647, 3);
        assertEquals(715827882, ans);
    }

    @Test
    public void errCase5() {
        DivideTwoIntegers s = new DivideTwoIntegers();
        int ans = s.divide(-1010369383, -2147483648);
        assertEquals(0, ans);
    }

    @Test
    public void errCase6() {
        DivideTwoIntegers s = new DivideTwoIntegers();
        int ans = s.divide(2, 2);
        assertEquals(1, ans);
    }
}