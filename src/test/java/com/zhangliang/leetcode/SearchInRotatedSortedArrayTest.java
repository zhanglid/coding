package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SearchInRotatedSortedArrayTest {

    @Test
    public void testCase() {
        SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
        int ans = s.search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0);
        assertEquals(4, ans);
    }

    @Test
    public void testCase2() {
        SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
        int ans = s.search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 3);
        assertEquals(-1, ans);
    }

    @Test
    public void errCase() {
        SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
        int ans = s.search(new int[] { 5, 1, 3 }, 5);
        assertEquals(0, ans);
    }

    @Test
    public void errCase2() {
        SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
        int ans = s.search(new int[] {}, 5);
        assertEquals(-1, ans);
    }
}