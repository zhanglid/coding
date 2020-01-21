package com.zhangliang.leetcode;
/*
Given a matrix of m x n elements (m rows, n columns), return all elements of 
the matrix in spiral order.

Example 1:
Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:
Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
*/

import java.util.*;

public class SpiralMatrix {
    private static final int[][] DIRS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    private boolean isValidState(int i, int j, int t, int l, int r, int b) {
        return i >= t && i < b && j >= l && j < r;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length < 1 || matrix[0].length < 1) {
            return result;
        }
        // Current window size
        int t = 0;
        int l = 0;
        int r = matrix[0].length;
        int b = matrix.length;

        // Current cursor
        int i = 0;
        int j = 0;
        int dirIndex = 0;

        result.add(matrix[i][j]);
        while (result.size() < matrix.length * matrix[0].length) {
            while (!isValidState(i + DIRS[dirIndex][0], j + DIRS[dirIndex][1], t, l, r, b)) {
                dirIndex = (dirIndex + 1) % DIRS.length;
                int[] dir = DIRS[dirIndex];
                if (dir[0] < 0) {
                    b += dir[0];
                } else {
                    t += dir[0];
                }
                if (dir[1] < 0) {
                    r += dir[1];
                } else {
                    l += dir[1];
                }
            }
            i += DIRS[dirIndex][0];
            j += DIRS[dirIndex][1];
            result.add(matrix[i][j]);
        }

        return result;
    }
}
