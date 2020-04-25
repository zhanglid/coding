package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class RomanToIntegerTest {

    @Test
    public void testCase() {
        RomanToInteger s = new RomanToInteger();
        int ans = s.romanToInt("III");
        assertEquals(3, ans);
    }

    @Test
    public void testCase2() {
        RomanToInteger s = new RomanToInteger();
        int ans = s.romanToInt("IV");
        assertEquals(4, ans);
    }

    @Test
    public void testCase3() {
        RomanToInteger s = new RomanToInteger();
        int ans = s.romanToInt("IX");
        assertEquals(9, ans);
    }

    @Test
    public void testCase4() {
        RomanToInteger s = new RomanToInteger();
        int ans = s.romanToInt("LVIII");
        assertEquals(58, ans);
    }

    @Test
    public void testCase5() {
        RomanToInteger s = new RomanToInteger();
        int ans = s.romanToInt("MCMXCIV");
        assertEquals(1994, ans);
    }
}
