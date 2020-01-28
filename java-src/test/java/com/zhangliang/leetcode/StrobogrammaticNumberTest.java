package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StrobogrammaticNumberTest {

    @Test
    public void testCase() {
        StrobogrammaticNumber s = new StrobogrammaticNumber();
        boolean ans = s.isStrobogrammatic("69");
        assertEquals(true, ans);
    }

    @Test
    public void testCase2() {
        StrobogrammaticNumber s = new StrobogrammaticNumber();
        boolean ans = s.isStrobogrammatic("88");
        assertEquals(true, ans);
    }

    @Test
    public void testCase3() {
        StrobogrammaticNumber s = new StrobogrammaticNumber();
        boolean ans = s.isStrobogrammatic("962");
        assertEquals(false, ans);
    }
}
