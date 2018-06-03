package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.List;

import org.junit.Test;

public class InsertIntervalTest {

    @Test
    public void testCase() {
        InsertInterval s = new InsertInterval();
        List<Interval> ans = s.insert(Interval.getIntervalsList(new int[][] { { 1, 3 }, { 6, 9 } }),
                new Interval(2, 5));
        assertEquals("[[1, 5], [6, 9]]", ans.toString());
    }

    @Test
    public void errCase() {
        InsertInterval s = new InsertInterval();
        List<Interval> ans = s.insert(Interval.getIntervalsList(new int[][] {}), new Interval(5, 7));
        assertEquals("[[5, 7]]", ans.toString());
    }

    @Test
    public void errCase2() {
        InsertInterval s = new InsertInterval();
        List<Interval> ans = s.insert(Interval.getIntervalsList(new int[][] { { 1, 5 } }), new Interval(0, 0));
        assertEquals("[[0, 0], [1, 5]]", ans.toString());
    }
}
