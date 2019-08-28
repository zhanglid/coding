package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class NumberOfDistinctIslandsTest {
    @Test
    public void testCase() {
        NumberOfDistinctIslands s = new NumberOfDistinctIslands();
        int ans = s.numDistinctIslands(
                new int[][] { { 1, 1, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 0, 1, 1 }, { 0, 0, 0, 1, 1 } });
        assertEquals(1, ans);
    }

    @Test
    public void testCase2() {
        NumberOfDistinctIslands s = new NumberOfDistinctIslands();
        int ans = s.numDistinctIslands(
                new int[][] { { 1, 1, 0, 1, 1 }, { 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 1 }, { 1, 1, 0, 1, 1 } });
        assertEquals(3, ans);
    }

    @Test
    public void testCase3() {
        NumberOfDistinctIslands s = new NumberOfDistinctIslands();
        int ans = s.numDistinctIslands(new int[][] { { 1, 1, 0 }, { 0, 1, 1 }, { 0, 0, 0 }, { 1, 1, 1 }, { 0, 1, 0 } });
        assertEquals(2, ans);
    }
}
