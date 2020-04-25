package com.zhangliang.leetcode;

import static org.junit.Assert.*;
import org.junit.Test;

public class SpiralMatrixIIITest {
    @Test
    public void testCase() {
        SpiralMatrixIII s = new SpiralMatrixIII();
        int[][] ans = s.spiralMatrixIII(1, 4, 0, 0);
        int[][] expected = new int[][] { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 0, 3 } };
        assertArrayEquals(expected, ans);
    }

    @Test
    public void testCase2() {
        SpiralMatrixIII s = new SpiralMatrixIII();
        int[][] ans = s.spiralMatrixIII(5, 6, 1, 4);
        int[][] expected = new int[][] { { 1, 4 }, { 1, 5 }, { 2, 5 }, { 2, 4 }, { 2, 3 }, { 1, 3 }, { 0, 3 }, { 0, 4 },
                { 0, 5 }, { 3, 5 }, { 3, 4 }, { 3, 3 }, { 3, 2 }, { 2, 2 }, { 1, 2 }, { 0, 2 }, { 4, 5 }, { 4, 4 },
                { 4, 3 }, { 4, 2 }, { 4, 1 }, { 3, 1 }, { 2, 1 }, { 1, 1 }, { 0, 1 }, { 4, 0 }, { 3, 0 }, { 2, 0 },
                { 1, 0 }, { 0, 0 } };
        assertArrayEquals(expected, ans);
    }
}
