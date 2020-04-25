package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import java.util.List;

import com.zhangliang.Utils;

import org.junit.Test;

public class SubsetsTest {

    @Test
    public void testCase() {
        Subsets s = new Subsets();
        List<List<Integer>> ans = s.subsets(new int[] { 1, 2, 3 });
        int[][] expected = new int[][] { { 3 }, { 1 }, { 2 }, { 1, 2, 3 }, { 1, 3 }, { 2, 3 }, { 1, 2 }, {} };
        assertArrayEquals(Utils.getStrsFrom2DIntArray(expected), Utils.getStrsFrom2DList(ans));
    }
}
