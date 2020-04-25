package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StringToIntegerTest{

    @Test
    public void testCase() {
        StringToInteger s = new StringToInteger();
        String ans = Integer.toString(s.myAtoi("42"));
        assertEquals(ans, "42");
    }
    
    @Test
    public void testCase2() {
        StringToInteger s = new StringToInteger();
        String ans = Integer.toString(s.myAtoi("   -42"));
        assertEquals(ans, "-42");
    }

    @Test
    public void testCase3() {
        StringToInteger s = new StringToInteger();
        String ans = Integer.toString(s.myAtoi("4193 with words"));
        assertEquals(ans, "4193");
    }

    @Test
    public void testCase4() {
        StringToInteger s = new StringToInteger();
        String ans = Integer.toString(s.myAtoi("words and 987"));
        assertEquals(ans, "0");
    }

    @Test
    public void testCase5() {
        StringToInteger s = new StringToInteger();
        String ans = Integer.toString(s.myAtoi("-91283472332"));
        assertEquals(ans, "-2147483648");
    }

    @Test
    public void errCase() {
        StringToInteger s = new StringToInteger();
        String ans = Integer.toString(s.myAtoi("   +0 123"));
        assertEquals(ans, "0");
    }
    
}