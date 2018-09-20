package com.zhangliang.leetcode;
/*
Given a sorted array of integers nums and integer values a, b and c. Apply a quadratic function of the form 
f(x) = ax2 + bx + c to each element x in the array.

The returned array must be in sorted order.

Expected time complexity: O(n)

Example 1:

Input: nums = [-4,-2,2,4], a = 1, b = 3, c = 5
Output: [3,9,15,33]
Example 2:

Input: nums = [-4,-2,2,4], a = -1, b = 3, c = 5
Output: [-23,-5,1,7]
*/

import java.util.Arrays;

public class SortTransformedArray {

    private int calculate(int num, int a, int b, int c) {
        return a * num * num + b * num + c;
    }

    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if (nums == null || nums.length < 1) {
            return nums;
        }
        int[] ans = new int[nums.length];
        int l = -1;
        int r = 0;
        if (a > 0) {
            int index = Arrays.binarySearch(nums, -b / (2 * a));
            if (index < 0) {
                index = -index - 1;
            }
            l = index - 1;
            r = index;
        } else if (a <= 0) {
            l = 0;
            r = nums.length - 1;
        }

        int index = 0;
        while ((l >= 0 || r < nums.length) && l <= r) {
            if (l >= 0 && (r >= nums.length || calculate(nums[l], a, b, c) < calculate(nums[r], a, b, c))) {
                ans[index++] = calculate(nums[l], a, b, c);
                if (a <= 0) {
                    l++;
                } else {
                    l--;
                }
            } else {
                ans[index++] = calculate(nums[r], a, b, c);
                if (a <= 0) {
                    r--;
                } else {
                    r++;
                }
            }
        }

        return ans;
    }
}
