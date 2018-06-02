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
}
