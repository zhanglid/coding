package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class FindKPairswithSmallestSumsTest {

    @Test
    public void testCase() {
        FindKPairswithSmallestSums s = new FindKPairswithSmallestSums();
        List<int[]> ans = s.kSmallestPairs(new int[] { 1, 7, 11 }, new int[] { 2, 4, 6 }, 3);
        assertArrayEquals(ans.toArray(new int[0][]), new int[][] { { 1, 2 }, { 1, 4 }, { 1, 6 } });
    }

    @Test
    public void testCase2() {
        FindKPairswithSmallestSums s = new FindKPairswithSmallestSums();
        List<int[]> ans = s.kSmallestPairs(new int[] { 1, 1, 2 }, new int[] { 1, 2, 3 }, 2);
        assertArrayEquals(ans.toArray(new int[0][]), new int[][] { { 1, 1 }, { 1, 1 } });
    }

    @Test
    public void testCase3() {
        FindKPairswithSmallestSums s = new FindKPairswithSmallestSums();
        List<int[]> ans = s.kSmallestPairs(new int[] { 1, 2 }, new int[] { 3 }, 3);
        assertArrayEquals(ans.toArray(new int[0][]), new int[][] { { 1, 3 }, { 2, 3 } });
    }
}
