package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DivideTwoIntegersTest {

    @Test
    public void testCase() {
        DivideTwoIntegers s = new DivideTwoIntegers();
        int ans = s.divide(10, 3);
        assertEquals(ans, 3);
    }

    @Test
    public void testCase2() {
        DivideTwoIntegers s = new DivideTwoIntegers();
        int ans = s.divide(7, -3);
        assertEquals(ans, -2);
    }

    @Test
    public void errCase() {
        DivideTwoIntegers s = new DivideTwoIntegers();
        int ans = s.divide(1, 1);
        assertEquals(ans, 1);
    }

    @Test
    public void errCase2() {
        DivideTwoIntegers s = new DivideTwoIntegers();
        int ans = s.divide(2147483647, 1);
        assertEquals(ans, 2147483647);
    }

    @Test
    public void errCase3() {
        DivideTwoIntegers s = new DivideTwoIntegers();
        int ans = s.divide(-2147483648, 1);
        assertEquals(ans, -2147483648);
    }

    @Test
    public void errCase4() {
        DivideTwoIntegers s = new DivideTwoIntegers();
        int ans = s.divide(2147483647, 3);
        assertEquals(ans, 715827882);
    }

    @Test
    public void errCase5() {
        DivideTwoIntegers s = new DivideTwoIntegers();
        int ans = s.divide(-1010369383, -2147483648);
        assertEquals(ans, 0);
    }
}