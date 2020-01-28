package com.zhangliang.leetcode;
/*
Implement next permutation, which rearranges numbers into the lexicographically 
next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible 
order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding 
outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/

import java.util.*;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 1) {
            return;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (stack.isEmpty() || nums[stack.peek()] <= nums[i]) {
                stack.push(i);
            } else {
                int lastIndex = -1;
                while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                    lastIndex = stack.pop();
                }
                int temp = nums[i];
                nums[i] = nums[lastIndex];
                nums[lastIndex] = temp;
                Arrays.sort(nums, i + 1, nums.length);
                return;
            }
        }

        Arrays.sort(nums);
    }
}