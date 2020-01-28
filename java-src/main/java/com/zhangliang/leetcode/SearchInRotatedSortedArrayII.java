package com.zhangliang.leetcode;
/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

You are given a target value to search. If found in the array return true, otherwise return false.

Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
Example 2:

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
Follow up:

This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
Would this affect the run-time complexity? How and why?

*/

public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return false;
        }

        int l = 0;
        int r = nums.length - 1;

        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (nums[l] < nums[r]) {
                if (nums[mid] < target) {
                    l = mid;
                } else {
                    r = mid;
                }
            } else if (nums[l] == nums[r]) {
                l++;
            } else {
                if (nums[mid] < target) {
                    if (nums[mid] >= nums[l]) {
                        l = mid;
                    } else {
                        if (target <= nums[r]) {
                            l = mid;
                        } else {
                            r = mid;
                        }
                    }
                } else if (nums[mid] == target) {
                    return true;
                } else {
                    if (nums[mid] <= nums[r]) {
                        r = mid;
                    } else if (target >= nums[l]) {
                        r = mid;
                    } else {
                        l = mid;
                    }
                }
            }
        }

        return nums[l] == target || nums[r] == target;
    }
}
