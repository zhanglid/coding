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

    @Test
    public void testCase3() {
        NextClosestTime s = new NextClosestTime();
        String ans = s.nextClosestTime("22:23");
        assertEquals("22:32", ans);
    }

    @Test
    public void testCase4() {
        NextClosestTime s = new NextClosestTime();
        String ans = s.nextClosestTime("01:37");
        assertEquals("03:00", ans);
    }
}
