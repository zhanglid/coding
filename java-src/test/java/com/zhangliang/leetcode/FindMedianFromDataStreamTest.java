package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class FindMedianFromDataStreamTest {
    static double DELTA = 10e-6;

    @Test
    public void testCase() {
        FindMedianFromDataStream.MedianFinder s = new FindMedianFromDataStream.MedianFinder();
        s.addNum(1);
        s.addNum(2);
        assertEquals(1.5, s.findMedian(), DELTA);
        s.addNum(3);
        assertEquals(2, s.findMedian(), DELTA);
    }
}
