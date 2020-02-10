package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ConfusingNumberTest {

    @Test
    public void testCase() {
        ConfusingNumber s = new ConfusingNumber();
        boolean ans = s.confusingNumber(6);
        assertEquals(true, ans);
    }

    @Test
    public void testCase2() {
        ConfusingNumber s = new ConfusingNumber();
        boolean ans = s.confusingNumber(89);
        assertEquals(true, ans);
    }

    @Test
    public void testCase3() {
        ConfusingNumber s = new ConfusingNumber();
        boolean ans = s.confusingNumber(11);
        assertEquals(false, ans);
    }

    @Test
    public void testCase4() {
        ConfusingNumber s = new ConfusingNumber();
        boolean ans = s.confusingNumber(25);
        assertEquals(false, ans);
    }

    @Test
    public void testCase5() {
        ConfusingNumber s = new ConfusingNumber();
        boolean ans = s.confusingNumber(150);
        assertEquals(false, ans);
    }
}
