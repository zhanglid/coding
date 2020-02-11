package com.zhangliang.leetcode;
/*
Given a non-empty 2D matrix matrix and an integer k, find the max sum of a rectangle in the matrix such that its sum is no larger than k.

Example:

Input: matrix = [[1,0,1],[0,-2,3]], k = 2
Output: 2 
Explanation: Because the sum of rectangle [[0, 1], [-2, 3]] is 2,
             and 2 is the max number no larger than k (k = 2).
Note:

The rectangle inside the matrix must have an area > 0.
What if the number of rows is much larger than the number of columns?
*/

import java.util.*;

// Time O(n^2mlogm)
public class MaxSumOfRectangleNoLargerThanK {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        // Corner case: empty
        if (matrix.length < 1 || matrix[0].length < 1) {
            return 0;
        }
        Integer result = null;
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        // Iter each row
        for (int i = 0; i < matrix.length; i++) {
            // Build colum sum result
            for (int j = 0; j < matrix[i].length; j++) {
                dp[i + 1][j + 1] = dp[i][j + 1] + matrix[i][j];
            }
            // Check each previous row as the top
            for (int t = 0; t <= i; t++) {
                int[] sums = new int[matrix[0].length + 1];
                // Build collapsed sums array
                for (int l = 0; l < sums.length; l++) {
                    sums[l] = dp[i + 1][l] - dp[t][l];
                }
                // Search for optimal value
                TreeSet<Integer> ts = new TreeSet<>();
                int rowSum = 0;
                for (int sum : sums) {
                    rowSum += sum;
                    Integer target = ts.ceiling(rowSum - k);
                    if (target != null) {
                        int value = rowSum - target;
                        if (result == null || value > result) {
                            result = value;
                        }
                    }
                    ts.add(rowSum);
                }
            }
        }

        return result;
    }

}
