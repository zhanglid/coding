package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class FactorialTrailingZeroesTest {

    @Test
    public void testCase() {
        FactorialTrailingZeroes s = new FactorialTrailingZeroes();
        int ans = s.trailingZeroes(3);
        assertEquals(0, ans);
    }

    @Test
    public void testCase2() {
        FactorialTrailingZeroes s = new FactorialTrailingZeroes();
        int ans = s.trailingZeroes(5);
        assertEquals(1, ans);
    }

    @Test
    public void errCase() {
        FactorialTrailingZeroes s = new FactorialTrailingZeroes();
        int ans = s.trailingZeroes(30);
        assertEquals(7, ans);
    }

    @Test
    public void errCase2() {
        FactorialTrailingZeroes s = new FactorialTrailingZeroes();
        int ans = s.trailingZeroes(300);
        assertEquals(74, ans);
    }
}
