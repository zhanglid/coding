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

import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i == -1) {
            Arrays.sort(nums);
            return;
        }

        Arrays.sort(nums, 0, nums.length);

        int temp = nums[i];
        nums[i] = nums[i + 1];
        nums[i + 1] = temp;
    }

    public static void main(String[] args) {
        NextPermutation s = new NextPermutation();
        s.nextPermutation(new int[] { 1, 3, 2 });
    }
}