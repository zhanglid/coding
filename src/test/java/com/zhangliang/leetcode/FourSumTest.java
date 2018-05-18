package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.List;

import org.junit.Test;

public class FourSumTest {

    @Test
    public void testCase() {
        FourSum s = new FourSum();
        List<List<Integer>> ans = s.fourSum(new int[] { 1, 0, -1, 0, -2, 2 }, 0);
        assertEquals(ans.toString(), "[[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]");
    }

    @Test
    public void errCase() {
        FourSum s = new FourSum();
        List<List<Integer>> ans = s.fourSum(new int[] { -3, -2, -1, 0, 0, 1, 2, 3 }, 0);
        assertEquals(ans, "[[-3,-2,2,3],[-3,-1,1,3],[-3,0,0,3],[-3,0,1,2],[-2,-1,0,3],[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]");
    }
}