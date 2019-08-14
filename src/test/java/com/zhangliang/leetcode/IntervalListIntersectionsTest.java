package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class IntervalListIntersectionsTest {

    @Test
    public void testCase() {
        IntervalListIntersections s = new IntervalListIntersections();
        int[][] ans = s.intervalIntersection(new int[][] { { 0, 2 }, { 5, 10 }, { 13, 23 }, { 24, 25 } },
                new int[][] { { 1, 5 }, { 8, 12 }, { 15, 24 }, { 25, 26 } });
        assertArrayEquals(new int[][] { { 1, 2 }, { 5, 5 }, { 8, 10 }, { 15, 23 }, { 24, 24 }, { 25, 25 } }, ans);
    }

    @Test
    public void errCase() {
        IntervalListIntersections s = new IntervalListIntersections();
        int[][] ans = s.intervalIntersection(new int[][] {}, new int[][] {});
        assertArrayEquals(new int[][] {}, ans);
    }
}
