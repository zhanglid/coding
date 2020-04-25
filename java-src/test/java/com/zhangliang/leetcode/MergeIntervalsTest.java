package com.zhangliang.leetcode;

import static org.junit.Assert.*;
import org.junit.Test;

public class MergeIntervalsTest {
    @Test
    public void testCase() {
        MergeIntervals s = new MergeIntervals();
        int[][] ans = s.merge(new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } });
        assertArrayEquals(new int[][] { { 1, 6 }, { 8, 10 }, { 15, 18 } }, ans);
    }

    @Test
    public void testCase2() {
        MergeIntervals s = new MergeIntervals();
        int[][] ans = s.merge(new int[][] { { 1, 4 }, { 4, 5 } });
        assertArrayEquals(new int[][] { { 1, 5 } }, ans);
    }

    @Test
    public void errCase() {
        MergeIntervals s = new MergeIntervals();
        int[][] ans = s.merge(new int[][] { { 1, 4 }, { 2, 3 } });
        assertArrayEquals(new int[][] { { 1, 4 } }, ans);
    }

    @Test
    public void errCase2() {
        MergeIntervals s = new MergeIntervals();
        int[][] ans = s.merge(new int[][] {});
        assertArrayEquals(new int[][] {}, ans);
    }
}
