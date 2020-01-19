package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class RotateStringTest {

    @Test
    public void testCase() {
        RotateString s = new RotateString();
        boolean ans = s.rotateString("abcde", "cdeab");
        assertEquals(true, ans);
    }

    @Test
    public void testCase2() {
        RotateString s = new RotateString();
        boolean ans = s.rotateString("abcde", "abced");
        assertEquals(false, ans);
    }
}
