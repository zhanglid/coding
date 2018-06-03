package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class ValidNumberTest {

    @Test
    public void testCase() {
        ValidNumber s = new ValidNumber();
        boolean ans = s.isNumber("0");
        assertEquals(true, ans);
    }

    @Test
    public void testCase2() {
        ValidNumber s = new ValidNumber();
        boolean ans = s.isNumber(" 0.1 ");
        assertEquals(true, ans);
    }

    @Test
    public void testCase3() {
        ValidNumber s = new ValidNumber();
        boolean ans = s.isNumber("abc");
        assertEquals(false, ans);
    }

    @Test
    public void testCase4() {
        ValidNumber s = new ValidNumber();
        boolean ans = s.isNumber("1 a");
        assertEquals(false, ans);
    }

    @Test
    public void testCase5() {
        ValidNumber s = new ValidNumber();
        boolean ans = s.isNumber("2e10");
        assertEquals(true, ans);
    }

    @Test
    public void testCase6() {
        ValidNumber s = new ValidNumber();
        boolean ans = s.isNumber(" 1.5e2.5");
        assertEquals(true, ans);
    }

    @Test
    public void testCase7() {
        ValidNumber s = new ValidNumber();
        boolean ans = s.isNumber(".");
        assertEquals(false, ans);
    }

    @Test
    public void errCase() {
        ValidNumber s = new ValidNumber();
        boolean ans = s.isNumber(".1");
        assertEquals(true, ans);
    }

    @Test
    public void errCase2() {
        ValidNumber s = new ValidNumber();
        boolean ans = s.isNumber("0e");
        assertEquals(false, ans);
    }

    @Test
    public void errCase3() {
        ValidNumber s = new ValidNumber();
        boolean ans = s.isNumber("3.");
        assertEquals(true, ans);
    }
}
