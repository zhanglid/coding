package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SearchA2DMatrixTest {

    @Test
    public void testCase() {
        SearchA2DMatrix s = new SearchA2DMatrix();
        boolean ans = s.searchMatrix(new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } }, 3);
        assertEquals(true, ans);
    }

    @Test
    public void testCase2() {
        SearchA2DMatrix s = new SearchA2DMatrix();
        boolean ans = s.searchMatrix(new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } }, 13);
        assertEquals(false, ans);
    }

    @Test
    public void errCase() {
        SearchA2DMatrix s = new SearchA2DMatrix();
        boolean ans = s.searchMatrix(new int[][] { { 1 } }, 1);
        assertEquals(true, ans);
    }

    @Test
    public void errCase2() {
        SearchA2DMatrix s = new SearchA2DMatrix();
        boolean ans = s.searchMatrix(new int[][] { { 1 } }, 0);
        assertEquals(false, ans);
    }
}
