package com.zhangliang.leetcode;

import static org.junit.Assert.*;
import org.junit.Test;

public class SparseMatrixMultiplicationTest {

    @Test
    public void testCase() {
        SparseMatrixMultiplication s = new SparseMatrixMultiplication();
        int[][] ans = s.multiply(new int[][] { { 1, 0, 0 }, { -1, 0, 3 } },
                new int[][] { { 7, 0, 0 }, { 0, 0, 0 }, { 0, 0, 1 } });
        assertArrayEquals(new int[][] { { 7, 0, 0 }, { -7, 0, 3 } }, ans);
    }

    @Test
    public void errCase() {
        SparseMatrixMultiplication s = new SparseMatrixMultiplication();
        int[][] ans = s.multiply(new int[][] { 
            { 1, 1 }, 
            { 1, 0 } 
        }, 
            new int[][] { 
                { 1, 0 }, 
                { 1, 0 } 
            });
        assertArrayEquals(new int[][] { { 2, 0 }, { 1, 0 } }, ans);
    }
}
