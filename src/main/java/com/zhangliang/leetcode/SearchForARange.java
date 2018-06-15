package com.zhangliang.leetcode;
/*
Given an array of integers nums sorted in ascending order, 
find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of 
O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
*/

import java.util.concurrent.Callable;

public class SearchForARange {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[] { -1, -1 };
        if (nums == null || nums.length < 1) {
            return ans;
        }
        ans[0] = binarySearchStart(nums, target);
        ans[1] = binarySearchEnd(nums, target);

        return ans;
    }

    private int binarySearchStart(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        if (target < nums[0]) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        if (nums[right] == target)
            return right;

        return -1;
    }

    private int binarySearchEnd(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        if (target < nums[0]) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (nums[right] == target) {
            return right;
        }
        if (nums[left] == target)
            return left;

        return -1;
    }
}
