package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.*;
import org.junit.Test;

public class MinimumCostToMergeStonesTest {

    @Test
    public void testCase() {
        MinimumCostToMergeStones s = new MinimumCostToMergeStones();
        int ans = s.mergeStones(new int[] { 3, 2, 4, 1 }, 2);
        assertEquals(20, ans);
    }

    @Test
    public void testCase2() {
        MinimumCostToMergeStones s = new MinimumCostToMergeStones();
        int ans = s.mergeStones(new int[] { 3, 2, 4, 1 }, 3);
        assertEquals(-1, ans);
    }

    @Test
    public void testCase3() {
        MinimumCostToMergeStones s = new MinimumCostToMergeStones();
        int ans = s.mergeStones(new int[] { 3, 5, 1, 2, 6 }, 3);
        assertEquals(25, ans);
    }
}
