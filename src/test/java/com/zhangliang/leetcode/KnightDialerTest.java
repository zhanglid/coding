package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class KnightDialerTest {

    @Test
    public void testCase() {
        KnightDialer s = new KnightDialer();
        int ans = s.knightDialer(1);
        assertEquals(10, ans);
    }

    @Test
    public void testCase2() {
        KnightDialer s = new KnightDialer();
        int ans = s.knightDialer(2);
        assertEquals(20, ans);
    }

    @Test
    public void testCase3() {
        KnightDialer s = new KnightDialer();
        int ans = s.knightDialer(3);
        assertEquals(46, ans);
    }

    @Test
    public void errCase() {
        KnightDialer s = new KnightDialer();
        int ans = s.knightDialer(161);
        assertEquals(533302150, ans);
    }
}
