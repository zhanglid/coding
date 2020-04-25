package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class IntegerToRomanTest {

    @Test
    public void testCase() {
        IntegerToRoman s = new IntegerToRoman();
        String ans = s.intToRoman(3);
        assertEquals("III", ans);
    }

    @Test
    public void testCase2() {
        IntegerToRoman s = new IntegerToRoman();
        String ans = s.intToRoman(4);
        assertEquals(ans, "IV");
    }

    @Test
    public void testCase3() {
        IntegerToRoman s = new IntegerToRoman();
        String ans = s.intToRoman(9);
        assertEquals(ans, "IX");
    }

    @Test
    public void testCase4() {
        IntegerToRoman s = new IntegerToRoman();
        String ans = s.intToRoman(58);
        assertEquals(ans, "LVIII");
    }

    @Test
    public void testCase5() {
        IntegerToRoman s = new IntegerToRoman();
        String ans = s.intToRoman(1994);
        assertEquals(ans, "MCMXCIV");
    }
}