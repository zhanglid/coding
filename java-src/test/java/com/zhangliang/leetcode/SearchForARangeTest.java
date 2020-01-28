package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class SearchForARangeTest {

    @Test
    public void testCase() {
        SearchForARange s = new SearchForARange();
        int[] ans = s.searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 8);
        assertArrayEquals(new int[] { 3, 4 }, ans);
    }

    @Test
    public void testCase2() {
        SearchForARange s = new SearchForARange();
        int[] ans = s.searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 6);
        assertArrayEquals(new int[] { -1, -1 }, ans);
    }
}
