package com.zhangliang.leetcode;
/*
Given an array which consists of non-negative integers and an integer m, 
you can split the array into m non-empty continuous subarrays. Write an 
algorithm to minimize the largest sum among these m subarrays.

Note:
If n is the length of array, assume the following constraints are satisfied:

1 ≤ n ≤ 1000
1 ≤ m ≤ min(50, n)
Examples:

Input:
nums = [7,2,5,10,8]
m = 2

Output:
18

Explanation:
There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8],
where the largest sum among the two subarrays is only 18.
*/

/**
 * DP approach. Time: O(n^2*k), space: O(nk)
 */
public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        if (nums.length < m) { // [7,2,5,10,8]
            return -1;
        }
        int[][] dp = new int[nums.length][m]; // 5 x 2
        dp[0][0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = dp[i - 1][0] + nums[i];
            for (int t = 1; t < m && t <= i; t++) {
                int sum = nums[i];
                dp[i][t] = -1;
                // Can be modified to use binary search.
                for (int l = i - 1; l >= t - 1; l--) {
                    int currentMaxSubSum = Math.max(sum, dp[l][t - 1]);
                    if (dp[i][t] == -1) {
                        dp[i][t] = currentMaxSubSum;
                    } else {
                        dp[i][t] = Math.min(currentMaxSubSum, dp[i][t]);
                    }
                    sum += nums[l];
                }
            }
        }
        return dp[nums.length - 1][m - 1];
    }
}
