package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class ThreeSumTest {

    private String[] transformToStrings(List<List<Integer>> lists) {
        List<String> ans = new ArrayList<>();
        if (lists == null) {
            return ans.toArray(new String[0]);
        }
        for (List<Integer> list : lists) {
            ans.add(list.toString());
        }

        Collections.sort(ans);
        return ans.toArray(new String[0]);
    }

    @Test
    public void testCase() {
        ThreeSum s = new ThreeSum();
        List<List<Integer>> ans = s.threeSum(new int[] { -1, 0, 1, 2, -1, -4 });
        String[] expected = new String[] { "[-1, 0, 1]", "[-1, -1, 2]" };

        Arrays.sort(expected);
        assertArrayEquals(expected, this.transformToStrings(ans));
    }

    @Test
    /*
     * Runtime Error Message: Exception in thread "main"
     * java.lang.ArrayIndexOutOfBoundsException: 4 at
     * Solution.threeSum(Solution.java:31) at
     * __DriverSolution__.__helper__(__Driver__.java:4) at
     * __Driver__.main(__Driver__.java:48)
     */
    public void errCase() {
        ThreeSum s = new ThreeSum();
        List<List<Integer>> ans = s.threeSum(new int[] { 0, 0, 0, 0 });
        String[] expected = new String[] { "[0, 0, 0]" };
        Arrays.sort(expected);
        assertNotNull(ans);
        assertArrayEquals(expected, this.transformToStrings(ans));
    }

    @Test
    /* Wrong Answer
    */
    public void errCase2() {
        ThreeSum s = new ThreeSum();
        List<List<Integer>> ans = s.threeSum(new int[] { 0, 0, 0 });
        String[] expected = new String[] { "[0, 0, 0]" };
        Arrays.sort(expected);
        assertNotNull(ans);
        assertArrayEquals(expected, this.transformToStrings(ans));
    }
}