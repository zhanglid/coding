package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class NextClosestTimeTest {

    @Test
    public void testCase() {
        NextClosestTime s = new NextClosestTime();
        String ans = s.nextClosestTime("19:34");
        assertEquals("19:39", ans);
    }

    @Test
    public void testCase2() {
        NextClosestTime s = new NextClosestTime();
        String ans = s.nextClosestTime("23:59");
        assertEquals("22:22", ans);
    }
}
