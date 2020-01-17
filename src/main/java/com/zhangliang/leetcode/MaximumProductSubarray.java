package com.zhangliang.leetcode;
/*
Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which 
has the largest product.

Example 1:
Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:
Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
*/

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int[] maxs = new int[nums.length + 1];
        int[] mins = new int[nums.length + 1];
        maxs[0] = 1;
        mins[0] = 1;
        Integer maxProductValue = null;
        for (int i = 0; i < nums.length; i++) {
            maxs[i + 1] = Math.max(mins[i] * nums[i], maxs[i] * nums[i]);
            maxs[i + 1] = Math.max(maxs[i + 1], nums[i]);
            mins[i + 1] = Math.min(mins[i] * nums[i], maxs[i] * nums[i]);
            mins[i + 1] = Math.min(mins[i + 1], nums[i]);
            if (maxProductValue == null || maxs[i + 1] > maxProductValue) {
                maxProductValue = maxs[i + 1];
            }
        }
        return maxProductValue != null ? maxProductValue : 0;
    }
}
