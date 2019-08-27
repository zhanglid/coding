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

public class SortTransformedArray {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] vals = new int[nums.length];
        int state = 0;
        int pivot = -1;
        for (int i = 0; i < nums.length; i++) {
            vals[i] = a * nums[i] * nums[i] + b * nums[i] + c;
            if (i > 0) {
                int curState = vals[i] == vals[i - 1] ? 0 : vals[i] > vals[i - 1] ? 1 : -1;
                if (state * curState < 0) {
                    pivot = i - 1;
                }
                if (curState != 0) {
                    state = curState;
                }
            }
        }
        int[] sortedVals = new int[nums.length];
        if (a > 0 && pivot > 0) {
            int l = pivot;
            int r = pivot + 1;
            for (int i = 0; i < sortedVals.length; i++) {
                if (r >= vals.length || l >= 0 && vals[l] < vals[r]) {
                    sortedVals[i] = vals[l--];
                } else {
                    sortedVals[i] = vals[r++];
                }
            }
        } else {
            int l = 0;
            int r = vals.length - 1;
            for (int i = 0; i < sortedVals.length; i++) {
                if (vals[l] < vals[r]) {
                    sortedVals[i] = vals[l++];
                } else {
                    sortedVals[i] = vals[r--];
                }
            }
        }
        return sortedVals;
    }
}
