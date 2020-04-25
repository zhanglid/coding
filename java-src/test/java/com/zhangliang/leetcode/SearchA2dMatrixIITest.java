package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SearchA2dMatrixIITest {
    @Test
    public void testCase() {
        SearchA2dMatrixII s = new SearchA2dMatrixII();
        boolean ans = s.searchMatrix(new int[][] { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 },
                { 10, 13, 14, 17, 24 }, { 18, 21, 23, 26, 30 } }, 5);
        assertEquals(true, ans);
    }

    @Test
    public void testCase2() {
        SearchA2dMatrixII s = new SearchA2dMatrixII();
        boolean ans = s.searchMatrix(new int[][] { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 },
                { 10, 13, 14, 17, 24 }, { 18, 21, 23, 26, 30 } }, 20);
        assertEquals(false, ans);
    }
}
