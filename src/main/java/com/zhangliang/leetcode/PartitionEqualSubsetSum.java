package com.zhangliang.leetcode;
/*
Given a non-empty array containing only positive integers, find if the 
array can be partitioned into two subsets such that the sum of elements 
in both subsets is equal.

Note:

Each of the array element will not exceed 100.
The array size will not exceed 200.

Example 1:
Input: [1, 5, 11, 5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].

Example 2:
Input: [1, 2, 3, 5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
*/

import java.util.*;

public class PartitionEqualSubsetSum {
    private int sum(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result += num;
        }
        return result;
    }

    public boolean canPartition(int[] nums) {
        int total = sum(nums);
        if (total % 2 == 1) {
            return false;
        }
        int target = total / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = dp.length - 1; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
            if (dp[target]) {
                return true;
            }
        }
        return false;
    }
}
