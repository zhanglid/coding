package com.zhangliang.leetcode;
/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
Example 1:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true
Example 2:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false
*/

import java.util.Arrays;

public class SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }

        int[] firstCol = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            firstCol[i] = matrix[i][0];
        }

        int rowResult = Arrays.binarySearch(firstCol, target);

        if (rowResult < 0) {
            rowResult = -rowResult;
            rowResult -= 2;
        }
        if (rowResult < 0) {
            return false;
        }
        int colResult = Arrays.binarySearch(matrix[rowResult], target);
        return colResult >= 0;
    }
}
