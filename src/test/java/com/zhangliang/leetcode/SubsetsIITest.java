package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import java.util.List;
import static com.zhangliang.Utils.getStrsFrom2DList;
import static com.zhangliang.Utils.getStrsFrom2DIntArray;

import org.junit.Test;

public class SubsetsIITest {

    @Test
    public void testCase() {
        SubsetsII s = new SubsetsII();
        List<List<Integer>> ans = s.subsetsWithDup(new int[] { 1, 2, 2 });
        int[][] expected = new int[][] { { 2 }, { 1 }, { 1, 2, 2 }, { 2, 2 }, { 1, 2 }, {} };
        assertArrayEquals(getStrsFrom2DIntArray(expected), getStrsFrom2DList(ans));
    }
}
