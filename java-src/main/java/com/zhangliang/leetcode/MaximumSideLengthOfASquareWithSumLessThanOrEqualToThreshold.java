package com.zhangliang.leetcode;
/*
Given a m x n matrix mat and an integer threshold. Return the maximum side-length of a square with a sum less than or equal to 
threshold or return 0 if there is no such square.

Example 1:
Input: mat = [[1,1,3,2,4,3,2],[1,1,3,2,4,3,2],[1,1,3,2,4,3,2]], threshold = 4
Output: 2
Explanation: The maximum side length of square with sum less than 4 is 2 as shown.


Input: mat = [[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2]], threshold = 1
Output: 0

Example 3:
Input: mat = [
    [1,1,1,1],
    [1,0,0,0],
    [1,0,0,0],
    [1,0,0,0]], threshold = 6
Output: 3

Example 4:
Input: mat = [
    [18,70],
    [61,1],
    [25,85],
    [14,40],
    [11,96],
    [97,96],
    [63,45]
], threshold = 40184
Output: 2
 

Constraints:

1 <= m, n <= 300
m == mat.length
n == mat[i].length
0 <= mat[i][j] <= 10000
0 <= threshold <= 10^5
*/

// BinarySearch Time: O(n^2*log(n))
public class MaximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold {
    private int getMinSumOfSize(int[][] sums, int size) {
        int minSum = -1;
        for (int i = size; i < sums.length; i++) {
            for (int j = size; j < sums[0].length; j++) {
                int li = i - size;
                int lj = j - size;
                int sum = sums[i][j] + sums[li][lj] - sums[i][lj] - sums[li][j];
                minSum = minSum == -1 ? sum : Math.min(sum, minSum);
            }
        }
        return minSum;
    }

    public int maxSideLength(int[][] mat, int threshold) {
        // Prepare sums
        int[][] sums = new int[mat.length + 1][mat[0].length + 1];
        for (int i = 1; i <= mat.length; i++) {
            int sum = 0;
            for (int j = 1; j <= mat[0].length; j++) {
                sum += mat[i - 1][j - 1];
                sums[i][j] = sum + sums[i - 1][j];
            }
        }
        // Binary search
        int l = 0;
        int r = mat.length;
        while (l < r - 1) {
            int mid = l + (r - l) / 2;
            int minSum = getMinSumOfSize(sums, mid);
            if (minSum != -1 && minSum <= threshold) {
                l = mid;
            } else {
                r = mid;
            }
        }
        int rMinSum = getMinSumOfSize(sums, r);
        if (rMinSum != -1 && rMinSum <= threshold) {
            return r;
        }
        return l;
    }
}
