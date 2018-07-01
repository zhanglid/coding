package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SearchInRotatedSortedArrayIITest {

    @Test
    public void testCase() {
        SearchInRotatedSortedArrayII s = new SearchInRotatedSortedArrayII();
        boolean ans = s.search(new int[] { 2, 5, 6, 0, 0, 1, 2 }, 0);
        assertEquals(true, ans);
    }

    @Test
    public void testCase2() {
        SearchInRotatedSortedArrayII s = new SearchInRotatedSortedArrayII();
        boolean ans = s.search(new int[] { 2, 5, 6, 0, 0, 1, 2 }, 3);
        assertEquals(false, ans);
    }

    @Test
    public void errCase() {
        SearchInRotatedSortedArrayII s = new SearchInRotatedSortedArrayII();
        boolean ans = s.search(new int[] { 3, 1, 1 }, 3);
        assertEquals(true, ans);
    }

    @Test
    public void errCase2() {
        SearchInRotatedSortedArrayII s = new SearchInRotatedSortedArrayII();
        boolean ans = s.search(new int[] { 5, 1, 3 }, 3);
        assertEquals(true, ans);
    }
}
