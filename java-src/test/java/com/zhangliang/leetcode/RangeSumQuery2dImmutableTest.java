package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import com.zhangliang.leetcode.RangeSumQuery2dImmutable.NumMatrix;

import org.junit.Test;

public class RangeSumQuery2dImmutableTest {

    @Test
    public void testCase() {
        NumMatrix s = new NumMatrix(new int[][] { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 }, { 1, 2, 0, 1, 5 },
                { 4, 1, 0, 1, 7 }, { 1, 0, 3, 0, 5 } });
        int ans = s.sumRegion(2, 1, 4, 3);
        assertEquals(8, ans);
    }

    @Test
    public void testCase2() {
        NumMatrix s = new NumMatrix(new int[][] { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 }, { 1, 2, 0, 1, 5 },
                { 4, 1, 0, 1, 7 }, { 1, 0, 3, 0, 5 } });
        int ans = s.sumRegion(1, 1, 2, 2);
        assertEquals(11, ans);
    }

    @Test
    public void testCase3() {
        NumMatrix s = new NumMatrix(new int[][] { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 }, { 1, 2, 0, 1, 5 },
                { 4, 1, 0, 1, 7 }, { 1, 0, 3, 0, 5 } });
        int ans = s.sumRegion(1, 2, 2, 4);
        assertEquals(12, ans);
    }

    @Test
    public void errCase() {
        NumMatrix s = new NumMatrix(new int[][] { { -1 } });
        int ans = s.sumRegion(0, 0, 0, 0);
        assertEquals(-1, ans);
    }
}
