package com.zhangliang.leetcode;
/*
A peak element is an element that is greater than its neighbors.
Given an input array nums, where nums[i] ≠ nums[i+1], find a peak 
element and return its index.
The array may contain multiple peaks, in that case return the index to 
any one of the peaks is fine.
You may imagine that nums[-1] = nums[n] = -∞.

Example 1:
Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the 
index number 2.

Example 2:
Input: nums = [1,2,1,3,5,6,4]
Output: 1 or 5 
Explanation: Your function can return either index number 1 where the 
peak element is 2, or index number 5 where the peak element is 6.

Note:
Your solution should be in logarithmic complexity.
*/

public class FindPeakElement {
    private boolean isPeak(int[] nums, int index) {
        if (index - 1 >= 0 && nums[index - 1] > nums[index]) {
            return false;
        }

        if (index + 1 < nums.length && nums[index + 1] > nums[index]) {
            return false;
        }

        return true;
    }

    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (mid + 1 < nums.length && nums[mid + 1] > nums[mid]) {
                l = mid;
            } else {
                r = mid;
            }
        }
        if (isPeak(nums, l)) {
            return l;
        }
        if (isPeak(nums, r)) {
            return r;
        }
        return -1;
    }
}
