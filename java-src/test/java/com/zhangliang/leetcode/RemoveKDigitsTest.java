package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class RemoveKDigitsTest {

    @Test
    public void testCase() {
        RemoveKDigits s = new RemoveKDigits();
        String ans = s.removeKdigits("1432219", 3);
        assertEquals("1219", ans);
    }

    @Test
    public void testCase2() {
        RemoveKDigits s = new RemoveKDigits();
        String ans = s.removeKdigits("10200", 1);
        assertEquals("200", ans);
    }

    @Test
    public void testCase3() {
        RemoveKDigits s = new RemoveKDigits();
        String ans = s.removeKdigits("10", 2);
        assertEquals("0", ans);
    }

    @Test
    public void errCase() {
        RemoveKDigits s = new RemoveKDigits();
        String ans = s.removeKdigits("9", 1);
        assertEquals("0", ans);
    }

    @Test
    public void errCase2() {
        RemoveKDigits s = new RemoveKDigits();
        String ans = s.removeKdigits("1111111", 3);
        assertEquals("1111", ans);
    }
}
