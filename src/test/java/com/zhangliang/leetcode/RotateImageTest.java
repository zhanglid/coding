package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class RotateImageTest {

    @Test
    public void testCase() {
        RotateImage s = new RotateImage();
        int[][] ans = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[][] expected = new int[][] { { 7, 4, 1 }, { 8, 5, 2 }, { 9, 6, 3 } };
        s.rotate(ans);
        assertArrayEquals(expected, ans);
    }

    @Test
    public void testCase2() {
        RotateImage s = new RotateImage();
        int[][] ans = new int[][] { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };
        int[][] expected = new int[][] { { 15, 13, 2, 5 }, { 14, 3, 4, 1 }, { 12, 6, 8, 9 }, { 16, 7, 10, 11 } };
        s.rotate(ans);
        assertArrayEquals(expected, ans);
    }

}
