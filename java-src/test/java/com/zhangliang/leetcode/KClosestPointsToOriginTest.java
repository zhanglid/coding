package com.zhangliang.leetcode;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

public class KClosestPointsToOriginTest {
    private void sort(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            }
        });
    }

    private void assertCorrect(int[][] expected, int[][] ans) {
        sort(expected);
        sort(ans);
        assertArrayEquals(expected, ans);
    }

    @Test
    public void testCase() {
        KClosestPointsToOrigin s = new KClosestPointsToOrigin();
        int[][] ans = s.kClosest(new int[][] { { 1, 3 }, { -2, 2 } }, 1);
        assertCorrect(new int[][] { { -2, 2 } }, ans);
    }

    @Test
    public void testCase2() {
        KClosestPointsToOrigin s = new KClosestPointsToOrigin();
        int[][] ans = s.kClosest(new int[][] { { 3, 3 }, { 5, -1 }, { -2, 4 } }, 2);
        assertCorrect(new int[][] { { 3, 3 }, { -2, 4 } }, ans);
    }
}
