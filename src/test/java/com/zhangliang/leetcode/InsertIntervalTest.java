package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;

import java.util.*;

import org.junit.Test;

public class InsertIntervalTest {

    private String arrayToString(int[][] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = Arrays.toString(nums[i]);
        }

        return Arrays.toString(strs);
    }

    @Test
    public void testCase() {
        InsertInterval s = new InsertInterval();
        int[][] ans = s.insert(new int[][] { { 1, 3 }, { 6, 9 } }, new int[] { 2, 5 });
        assertEquals("[[1, 5], [6, 9]]", arrayToString(ans));
    }

    // Empty input
    @Test
    public void errCase() {
        InsertInterval s = new InsertInterval();
        int[][] ans = s.insert(new int[][] {}, new int[] { 5, 7 });
        assertEquals("[[5, 7]]", arrayToString(ans));
    }

    // smaller input
    @Test
    public void errCase2() {
        InsertInterval s = new InsertInterval();
        int[][] ans = s.insert(new int[][] { { 1, 5 } }, new int[] { 0, 0 });
        assertEquals("[[0, 0], [1, 5]]", arrayToString(ans));
    }

    // inside
    @Test
    public void errCase3() {
        InsertInterval s = new InsertInterval();
        int[][] ans = s.insert(new int[][] { { 1, 5 } }, new int[] { 2, 3 });
        assertEquals("[[1, 5]]", arrayToString(ans));
    }
}
