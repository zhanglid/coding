package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LoggerRateLimiterTest {

    @Test
    public void testCase() {
        LoggerRateLimiter.Logger s = new LoggerRateLimiter.Logger();
        assertEquals(true, s.shouldPrintMessage(1, "foo"));
        assertEquals(true, s.shouldPrintMessage(2, "bar"));
        assertEquals(false, s.shouldPrintMessage(3, "foo"));
        assertEquals(false, s.shouldPrintMessage(8, "bar"));
        assertEquals(s.shouldPrintMessage(10, "foo"), false);
        assertEquals(s.shouldPrintMessage(11, "foo"), true);
    }
}
