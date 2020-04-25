package com.zhangliang.leetcode;
/*
Given a matrix, and a target, return the number of non-empty submatrices that sum to target.

A submatrix x1, y1, x2, y2 is the set of all cells matrix[x][y] with x1 <= x <= x2 and y1 <= y <= y2.

Two submatrices (x1, y1, x2, y2) and (x1', y1', x2', y2') are different if they have some coordinate that is different: 
for example, if x1 != x1'.

Example 1:

Input: matrix = 
[
    [0,1,0],
    [1,1,1],
    [0,1,0]
]
, target = 0
Output: 4
Explanation: The four 1x1 submatrices that only contain 0.

Example 2:

Input: matrix = [
    [1,-1],
    [-1,1]
], target = 0
Output: 5
Explanation: The two 1x2 submatrices, plus the two 2x1 submatrices, plus the 2x2 submatrix.
 

Note:

1 <= matrix.length <= 300
1 <= matrix[0].length <= 300
-1000 <= matrix[i] <= 1000
-10^8 <= target <= 10^8
*/

import java.util.*;

public class NumberOfSubmatricesThatSumToTarget {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int count = 0;
        int[][] colSums = new int[matrix.length + 1][matrix[0].length];
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                colSums[i][j] = colSums[i - 1][j] + matrix[i - 1][j];
            }

            for (int t = 0; t < i; t++) {
                int[] nums = new int[matrix[0].length];
                for (int l = 0; l < matrix[0].length; l++) {
                    nums[l] = colSums[i][l] - colSums[t][l];
                }
                Map<Integer, Integer> counts = new HashMap<>();
                counts.put(0, 1);
                int sum = 0;
                for (int num : nums) {
                    sum += num;
                    count += counts.getOrDefault(sum - target, 0);
                    counts.put(sum, counts.getOrDefault(sum, 0) + 1);
                }
            }
        }
        return count;
    }
}
