package com.zhangliang.leetcode;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DivideTwoIntegersTest{

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
}