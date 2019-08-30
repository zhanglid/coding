package com.zhangliang.leetcode;
/*
Given a sorted array consisting of only integers where every element appears exactly twice except 
or one element which appears exactly once. Find this single element that appears only once.

Example 1:
Input: [1,1,2,3,3,4,4,8,8]
Output: 2

Example 2:
Input: [3,3,7,7,10,11,11]
Output: 10
 

Note: Your solution should run in O(log n) time and O(1) space.
*/

public class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            int prev = mid - 1;
            if (!(nums[mid] == nums[prev] ^ mid % 2 == 1)) {
                l = mid;
            } else {
                r = mid;
            }
        }

        if ((l - 1 < 0 || nums[l - 1] != nums[l]) && (l + 1 >= nums.length || nums[l] != nums[l + 1])) {
            return nums[l];
        }
        return nums[r];
    }
}
