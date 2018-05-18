package com.zhangliang.leetcode;
/*
Suppose an array sorted in ascending order is rotated at some pivot 
unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return
 its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
*/

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= nums[left]) {
                if (target > nums[mid]) {
                    left = mid;
                } else {
                    if (target >= nums[left]) {
                        right = mid;
                    } else {
                        left = mid;
                    }
                }
            } else {
                if (target >= nums[mid]) {
                    if (target >= nums[left]) {
                        right = mid;
                    } else {
                        left = mid;
                    }
                } else {
                    right = mid;
                }
            }
        }

        if (nums[left] == target) {
            return left;
        }

        if (nums[right] == target) {
            return right;
        }

        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
        System.out.println(s.search(new int[] { 5, 1, 3 }, 5));
    }
}