package com.zhangliang.leetcode;

import static org.junit.Assert.*;
import org.junit.Test;

public class BasicCalculatorIITest {
    @Test
    public void testCase() {
        BasicCalculatorII s = new BasicCalculatorII();
        int ans = s.calculate("3+2*2");
        assertEquals(7, ans);
    }

    @Test
    public void testCase2() {
        BasicCalculatorII s = new BasicCalculatorII();
        int ans = s.calculate(" 3/2 ");
        assertEquals(1, ans);
    }

    @Test
    public void testCase3() {
        BasicCalculatorII s = new BasicCalculatorII();
        int ans = s.calculate(" 3+5 / 2 ");
        assertEquals(5, ans);
    }
}
