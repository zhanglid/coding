package com.zhangliang.leetcode;
/*
Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending 
order, then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

Example 1:
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Note:
Then length of the input array is in range [1, 10,000].
The input array may contain duplicates, so ascending order here means <=.
*/

import java.util.*;

public class ShortestUnsortedContinuousSubarray {

    // To which index, the array is sorted (Not include the return).
    private int findUnsortedStartIndex(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peekLast()] > nums[i]) {
                stack.pollLast();
            }
            stack.addLast(i);
        }
        int index = 0;
        while (!stack.isEmpty() && stack.pollFirst() == index) {
            index++;
        }
        return index;
    }

    private void reverse(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int t = nums[l];
            nums[l] = -nums[r];
            nums[r] = -t;
            l++;
            r--;
        }
    }

    public int findUnsortedSubarray(int[] nums) {
        int left = findUnsortedStartIndex(nums);
        reverse(nums);
        int right = findUnsortedStartIndex(nums);
        return Math.max(0, nums.length - right - left);
    }
}
