package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BasicCalculatorTest {

    @Test
    public void testCase() {
        BasicCalculator s = new BasicCalculator();
        int ans = s.calculate("1 + 1");
        assertEquals(2, ans);
    }

    @Test
    public void testCase2() {
        BasicCalculator s = new BasicCalculator();
        int ans = s.calculate(" 2-1 + 2 ");
        assertEquals(3, ans);
    }

    @Test
    public void testCase3() {
        BasicCalculator s = new BasicCalculator();
        int ans = s.calculate("(1+(4+5+2)-3)+(6+8)");
        assertEquals(23, ans);
    }
}
