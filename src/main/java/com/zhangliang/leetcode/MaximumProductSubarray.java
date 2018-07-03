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
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int[] mins = new int[nums.length + 1];
        int[] maxs = new int[nums.length + 1];

        int ans = nums[0];
        for (int i = 1; i <= nums.length; i++) {
            mins[i] = Math.min(mins[i - 1] * nums[i - 1], nums[i - 1]);
            mins[i] = Math.min(mins[i], maxs[i - 1] * nums[i - 1]);

            maxs[i] = Math.max(maxs[i - 1] * nums[i - 1], nums[i - 1]);
            maxs[i] = Math.max(maxs[i], mins[i - 1] * nums[i - 1]);

            ans = Math.max(ans, maxs[i]);
        }

        return ans;
    }
}
