package com.zhangliang.leetcode;
/*
Given an array of integers nums sorted in ascending order, find the 
starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
*/

public class FindFirstAndLastPositionOfElementInSortedArray {
    private int helper(int[] nums, int target, boolean isSearchingStart) {
        int l = 0;
        int r = nums.length - 1;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > target || isSearchingStart && nums[mid] == target) {
                r = mid;
            } else {
                l = mid;
            }
        }
        if (nums[l] == target && nums[r] == target) {
            if (isSearchingStart) {
                return l;
            } else {
                return r;
            }
        }
        if (nums[l] == target) {
            return l;
        }
        if (nums[r] == target) {
            return r;
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return new int[] { -1, -1 };
        }
        return new int[] { helper(nums, target, true), helper(nums, target, false) };
    }
}
