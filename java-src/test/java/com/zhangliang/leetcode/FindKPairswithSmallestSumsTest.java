package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class FindKPairsWithSmallestSumsTest {

    @Test
    public void testCase() {
        FindKPairsWithSmallestSums s = new FindKPairsWithSmallestSums();
        List<List<Integer>> ans = s.kSmallestPairs(new int[] { 1, 7, 11 }, new int[] { 2, 4, 6 }, 3);
        assertEquals(ans.toString(), Arrays.deepToString(new int[][] { { 1, 2 }, { 1, 4 }, { 1, 6 } }));
    }

    @Test
    public void testCase2() {
        FindKPairsWithSmallestSums s = new FindKPairsWithSmallestSums();
        List<List<Integer>> ans = s.kSmallestPairs(new int[] { 1, 1, 2 }, new int[] { 1, 2, 3 }, 2);
        assertEquals(ans.toString(), Arrays.deepToString(new int[][] { { 1, 1 }, { 1, 1 } }));
    }

    @Test
    public void testCase3() {
        FindKPairsWithSmallestSums s = new FindKPairsWithSmallestSums();
        List<List<Integer>> ans = s.kSmallestPairs(new int[] { 1, 2 }, new int[] { 3 }, 3);
        assertEquals(ans.toString(), Arrays.deepToString(new int[][] { { 1, 3 }, { 2, 3 } }));
    }
}
