package com.zhangliang.algorithm;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MedianTrackerTest {

    @Test
    public void testCase() {
        MedianTracker s = new MedianTracker();
        s.read(1);
        s.read(2);
        s.read(3);
        s.read(4);
        assertEquals("2.5", s.median());
    }
}
