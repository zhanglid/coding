package com.zhangliang.leetcode;
/*
Given an unsorted integer array, find the smallest missing positive integer.

Example 1:

Input: [1,2,0]
Output: 3
Example 2:

Input: [3,4,-1,1]
Output: 2
Example 3:

Input: [7,8,9,11,12]
Output: 1
Note:

Your algorithm should run in O(n) time and uses constant extra space.
*/

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 1;
        }

        int dummy = nums.length + 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = dummy;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]);
            if (index >= 1 && index <= nums.length) {
                nums[index - 1] = -Math.abs(nums[index - 1]);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }

    public static void main(String[] args) {
        FirstMissingPositive s = new FirstMissingPositive();
        System.out.println(s.firstMissingPositive());
    }
}