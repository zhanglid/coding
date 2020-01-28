package com.zhangliang.google;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class TriangleArraySearchTest {

    @Test
    public void testCase() {
        TriangleArraySearch s = new TriangleArraySearch();
        int[] nums = new int[] { 1, 5, 3 };
        boolean isTrianleSort = s.isTriangleSort(nums);
        assertEquals(true, isTrianleSort);
    }

    @Test
    public void testCase2() {
        TriangleArraySearch s = new TriangleArraySearch();
        int[] nums = new int[] { 1, 5, 3 };
        int min = s.findMin(nums);
        assertEquals(1, min);
    }

    @Test
    public void testCase3() {
        TriangleArraySearch s = new TriangleArraySearch();
        int[] nums = new int[] { 1, 5, 3 };
        int peak = s.findPeak(nums);
        assertEquals(1, peak);
    }

    @Test
    public void testCase4() {
        TriangleArraySearch s = new TriangleArraySearch();
        int[] nums = new int[] { 1, 5, 3 };
        int index = s.findTarget(nums, 3);
        assertEquals(2, index);
    }
}
