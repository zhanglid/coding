package com.zhangliang.leetcode;
/*
Given an integer array nums, find the contiguous subarray (containing at least 
one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the 
divide and conquer approach, which is more subtle.
*/

public class MaximumSubarray {
    private class ReturnType {
        int sumLeft;
        int sumRight;
        int maxSum;
        int totalSum;

        public ReturnType(int left, int right, int max, int sum) {
            sumLeft = left;
            sumRight = right;
            maxSum = max;
            totalSum = sum;
        }
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        ReturnType rt = helper(nums, 0, nums.length - 1);
        return rt.maxSum;
    }

    private ReturnType helper(int[] nums, int start, int end) {
        if (start == end) {
            int num = nums[start];
            return new ReturnType(num, num, num, nums[start]);
        }

        int mid = start + (end - start) / 2;

        ReturnType left = helper(nums, start, mid);
        ReturnType right = helper(nums, mid + 1, end);

        int max = Math.max(left.maxSum, right.maxSum);
        max = Math.max(max, left.sumRight + right.sumLeft);
        return new ReturnType(Math.max(left.sumLeft, left.totalSum + right.sumLeft),
                Math.max(right.sumRight, right.totalSum + left.sumRight), max, left.totalSum + right.totalSum);
    }
}
