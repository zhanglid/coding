package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FourKeysKeyboardTest {

    @Test
    public void testCase() {
        FourKeysKeyboard s = new FourKeysKeyboard();
        assertEquals(3, s.maxA(3));
    }

    @Test
    public void testCase2() {
        FourKeysKeyboard s = new FourKeysKeyboard();
        assertEquals(9, s.maxA(7));
    }

    @Test
    public void testCase3() {
        FourKeysKeyboard s = new FourKeysKeyboard();
        assertEquals(1, s.maxA(1));
    }

    @Test
    public void errCase() {
        FourKeysKeyboard s = new FourKeysKeyboard();
        assertEquals(5, s.maxA(5));
    }
}
