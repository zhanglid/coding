package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;

import com.zhangliang.utils.Point;

import org.junit.Test;

public class MaxPointsOnALineTest {

    @Test
    public void testCase() {
        MaxPointsOnALine s = new MaxPointsOnALine();
        int ans = s.maxPoints(Point.getPointsFromArray(new int[][] { { 1, 1 }, { 2, 2 }, { 3, 3 } }));
        assertEquals(3, ans);
    }

    @Test
    public void testCase2() {
        MaxPointsOnALine s = new MaxPointsOnALine();
        int ans = s.maxPoints(
                Point.getPointsFromArray(new int[][] { { 1, 1 }, { 3, 2 }, { 5, 3 }, { 4, 1 }, { 2, 3 }, { 1, 4 } }));
        assertEquals(4, ans);
    }

}
