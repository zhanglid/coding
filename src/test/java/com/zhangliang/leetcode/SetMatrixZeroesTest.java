package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

public class SetMatrixZeroesTest {

    @Test
    public void testCase() {
        SetMatrixZeroes s = new SetMatrixZeroes();
        int[][] input = new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        s.setZeroes(input);
        int[][] expected = new int[][] { { 1, 0, 1 }, { 0, 0, 0 }, { 1, 0, 1 } };
        assertArrayEquals(expected, input);
    }

    @Test
    public void testCase2() {
        SetMatrixZeroes s = new SetMatrixZeroes();
        int[][] input = new int[][] { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
        s.setZeroes(input);
        int[][] expected = new int[][] { { 0, 0, 0, 0 }, { 0, 4, 5, 0 }, { 0, 3, 1, 0 } };
        assertArrayEquals(expected, input);
    }
}
