package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class SpiralMatrixIITest {

    @Test
    public void testCase() {
        SpiralMatrixII s = new SpiralMatrixII();
        int[][] ans = s.generateMatrix(3);
        int[][] expected = new int[][] {
            {1, 2, 3},
            {8, 9, 4},
            {7, 6, 5},
        };
        assertArrayEquals(expected, ans);
    }
}
