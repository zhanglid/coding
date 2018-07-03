package com.zhangliang.leetcode;
/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

The array may contain duplicates.

Example 1:

Input: [1,3,5]
Output: 1
Example 2:

Input: [2,2,2,0,1]
Output: 0
Note:

This is a follow up problem to Find Minimum in Rotated Sorted Array.
Would allow duplicates affect the run-time complexity? How and why?
*/

public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int l = 0;
        int r = nums.length - 1;

        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (nums[l] == nums[r] && nums[mid] == nums[l]) {
                l++;
            } else if (nums[l] < nums[r]) {
                return nums[l];
            } else {
                if (nums[mid] >= nums[l]) {
                    l = mid;
                } else {
                    r = mid;
                }
            }
        }

        return Math.min(nums[l], nums[r]);
    }
}
