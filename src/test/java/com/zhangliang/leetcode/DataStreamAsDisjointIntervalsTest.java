package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class DataStreamAsDisjointIntervalsTest {

    @Test
    public void testCase() {
        DataStreamAsDisjointIntervals.SummaryRanges s = new DataStreamAsDisjointIntervals.SummaryRanges();
        s.addNum(1);
        assertArrayEquals(new int[][] { { 1, 1 } }, s.getIntervals());
        s.addNum(3);
        assertArrayEquals(new int[][] { { 1, 1 }, { 3, 3 } }, s.getIntervals());
        s.addNum(7);
        assertArrayEquals(new int[][] { { 1, 1 }, { 3, 3 }, { 7, 7 } }, s.getIntervals());
        s.addNum(2);
        assertArrayEquals(new int[][] { { 1, 3 }, { 7, 7 } }, s.getIntervals());
        s.addNum(6);
        assertArrayEquals(new int[][] { { 1, 3 }, { 6, 7 } }, s.getIntervals());
    }
}
