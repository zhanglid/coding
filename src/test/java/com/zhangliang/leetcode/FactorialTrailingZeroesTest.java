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
}
