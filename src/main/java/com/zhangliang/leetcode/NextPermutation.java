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

        Arrays.sort(nums, i + 1, nums.length);

        int j = i + 1;
        while (j < nums.length && nums[j] <= nums[i]) {
            j++;
        }

        swap(nums, i, j);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        NextPermutation s = new NextPermutation();
        int[] ans = new int[] { 2, 3, 1 };
        s.nextPermutation(ans);
        System.out.println(Arrays.toString(ans));
    }
}