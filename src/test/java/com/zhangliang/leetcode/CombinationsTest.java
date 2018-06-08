package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import java.util.List;

import com.zhangliang.Utils;

import org.junit.Test;

public class CombinationsTest {

    @Test
    public void testCase() {
        Combinations s = new Combinations();
        List<List<Integer>> ans = s.combine(4, 2);
        int[][] expected = new int[][] { { 2, 4 }, { 3, 4 }, { 2, 3 }, { 1, 2 }, { 1, 3 }, { 1, 4 }, };
        assertArrayEquals(Utils.getStrsFrom2DIntArray(expected), Utils.getStrsFrom2DList(ans));
    }
}
