package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class PowXNTest {

    private static final double epsilon = 1e-6;
    @Test
    public void testCase() {
        PowXN s = new PowXN();
        double ans = s.myPow(2, 10);
        assertEquals(1024.00, ans, Double.MIN_VALUE);
    }

    @Test
    public void testCase2() {
        PowXN s = new PowXN();
        double ans = s.myPow(2.1, 3);
        assertEquals(9.261, ans, epsilon);
    }

    @Test
    public void testCase3() {
        PowXN s = new PowXN();
        double ans = s.myPow(2.0, -2);
        assertEquals(0.25000, ans, Double.MIN_VALUE);
    }

    @Test
    public void errCase() {
        PowXN s = new PowXN();
        double ans = s.myPow(2.0, -2147483648);
        assertEquals(0, ans, Double.MIN_VALUE);
    }
}
