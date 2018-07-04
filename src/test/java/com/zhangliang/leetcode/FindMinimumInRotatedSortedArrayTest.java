package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FindMinimumInRotatedSortedArrayTest {

    @Test
    public void testCase() {
        FindMinimumInRotatedSortedArray s = new FindMinimumInRotatedSortedArray();
        int ans = s.findMin(new int[] { 3, 4, 5, 1, 2 });
        assertEquals(1, ans);
    }

    @Test
    public void testCase2() {
        FindMinimumInRotatedSortedArray s = new FindMinimumInRotatedSortedArray();
        int ans = s.findMin(new int[] { 4, 5, 6, 7, 0, 1, 2 });
        assertEquals(0, ans);
    }
}
