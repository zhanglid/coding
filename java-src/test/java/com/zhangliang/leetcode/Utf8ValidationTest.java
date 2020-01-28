package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class Utf8ValidationTest {
    @Test
    public void testCase() {
        Utf8Validation s = new Utf8Validation();
        boolean ans = s.validUtf8(new int[] { 197, 130, 1 });
        assertEquals(true, ans);
    }

    @Test
    public void testCase2() {
        Utf8Validation s = new Utf8Validation();
        boolean ans = s.validUtf8(new int[] { 235, 140, 4 });
        assertEquals(false, ans);
    }

    @Test
    public void errCase() {
        Utf8Validation s = new Utf8Validation();
        boolean ans = s.validUtf8(new int[] { 250, 145, 145, 145, 145 });
        assertEquals(false, ans);
    }

    @Test
    public void errCase2() {
        Utf8Validation s = new Utf8Validation();
        boolean ans = s.validUtf8(new int[] { 240, 162, 138, 147 });
        assertEquals(true, ans);
    }
}
