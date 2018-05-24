package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.List;

import org.junit.Test;

public class MergeIntervalsTest {
    @Test
    public void testCase() {
        MergeIntervals s = new MergeIntervals();
        List<Interval> ans = s
                .merge(Interval.getIntervalsList(new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } }));
        List<Interval> expected = Interval.getIntervalsList(new int[][] { { 1, 6 }, { 8, 10 }, { 15, 18 } });
        assertEquals(expected.toString(), ans.toString());
    }

    @Test

    public void testCase2() {
        MergeIntervals s = new MergeIntervals();
        List<Interval> ans = s.merge(Interval.getIntervalsList(new int[][] { { 1, 4 }, { 4, 5 } }));
        List<Interval> expected = Interval.getIntervalsList(new int[][] { { 1, 5 } });
        assertEquals(expected.toString(), ans.toString());
    }
}
