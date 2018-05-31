package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class SpiralMatrixTest {

    @Test
    public void testCase() {
        SpiralMatrix s = new SpiralMatrix();
        Integer[] ans = s.spiralOrder(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }).toArray(new Integer[0]);
        assertArrayEquals(new Integer[] { 1, 2, 3, 6, 9, 8, 7, 4, 5 }, ans);
    }

    @Test
    public void testCase2() {
        SpiralMatrix s = new SpiralMatrix();
        Integer[] ans = s.spiralOrder(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } })
                .toArray(new Integer[0]);
        assertArrayEquals(new Integer[] { 1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7 }, ans);
    }
}
