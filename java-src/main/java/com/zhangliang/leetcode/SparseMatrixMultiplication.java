package com.zhangliang.leetcode;
/*
Given two sparse matrices A and B, return the result of AB.

You may assume that A's column number is equal to B's row number.

Example:

Input:

A = [
  [ 1, 0, 0],
  [-1, 0, 3]
]

B = [
  [ 7, 0, 0 ],
  [ 0, 0, 0 ],
  [ 0, 0, 1 ]
]

Output:

     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                  | 0 0 1 |
*/

import java.util.*;

public class SparseMatrixMultiplication {
    private List<int[]> extractNonEmptyIndexes(int[][] A) {
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j] != 0) {
                    result.add(new int[] { i, j });
                }
            }
        }
        return result;
    }

    public int[][] multiply(int[][] A, int[][] B) {
        if (B.length == 0) {
            return new int[0][0];
        }
        List<int[]> nonEmptyElemA = extractNonEmptyIndexes(A);
        List<int[]> nonEmptyElemB = extractNonEmptyIndexes(B);
        int[][] result = new int[A.length][B[0].length];
        for (int[] aPos : nonEmptyElemA) {
            for (int[] bPos : nonEmptyElemB) {
                if (aPos[1] == bPos[0]) {
                    result[aPos[0]][bPos[1]] += A[aPos[0]][aPos[1]] * B[bPos[0]][bPos[1]];
                }
            }
        }
        return result;
    }
}
