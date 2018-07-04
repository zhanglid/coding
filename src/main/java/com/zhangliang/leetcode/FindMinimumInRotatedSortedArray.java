package com.zhangliang.leetcode;
/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:

Input: [3,4,5,1,2] 
Output: 1
Example 2:

Input: [4,5,6,7,0,1,2]
Output: 0
*/

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int l = 0;
        int r = nums.length - 1;

        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (nums[l] < nums[r]) {
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
