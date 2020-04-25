package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DecodeWaysTest {

    @Test
    public void testCase() {
        DecodeWays s = new DecodeWays();
        int ans = s.numDecodings("12");
        assertEquals(2, ans);
    }

    @Test
    public void testCase2() {
        DecodeWays s = new DecodeWays();
        int ans = s.numDecodings("226");
        assertEquals(3, ans);
    }

    @Test
    public void errCase() {
        DecodeWays s = new DecodeWays();
        int ans = s.numDecodings("0");
        assertEquals(0, ans);
    }
}
