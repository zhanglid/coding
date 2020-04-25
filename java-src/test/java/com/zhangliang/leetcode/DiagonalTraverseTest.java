package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class DiagonalTraverseTest {

    @Test
    public void testCase() {
        DiagonalTraverse s = new DiagonalTraverse();
        int[] ans = s.findDiagonalOrder(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } });
        assertArrayEquals(new int[] { 1, 2, 4, 7, 5, 3, 6, 8, 9 }, ans);
    }
}
