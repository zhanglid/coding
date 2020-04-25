package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SearchInsertPositionTest {

    @Test
    public void testCase() {
        SearchInsertPosition s = new SearchInsertPosition();
        int ans = s.searchInsert(new int[] { 1, 3, 5, 6 }, 5);
        assertEquals(ans, 2);
    }

    @Test
    public void testCase2() {
        SearchInsertPosition s = new SearchInsertPosition();
        int ans = s.searchInsert(new int[] { 1, 3, 5, 6 }, 2);
        assertEquals(ans, 1);
    }

    @Test
    public void testCase3() {
        SearchInsertPosition s = new SearchInsertPosition();
        int ans = s.searchInsert(new int[] { 1, 3, 5, 6 }, 7);
        assertEquals(ans, 4);
    }

    @Test
    public void testCase4() {
        SearchInsertPosition s = new SearchInsertPosition();
        int ans = s.searchInsert(new int[] { 1, 3, 5, 6 }, 0);
        assertEquals(ans, 0);
    }
}
