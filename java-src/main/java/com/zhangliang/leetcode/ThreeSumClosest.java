package com.zhangliang.leetcode;
/*
Given an array nums of n integers and an integer target, find three 
integers in nums such that the sum is closest to target. Return the 
sum of the three integers. You may assume that each input would have 
exactly one solution.

Example:

Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }

        Arrays.sort(nums);

        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int next = nums[i];
            int subTarget = target - next;
            int right = nums.length - 1;
            int left = i + 1;
            int closest = nums[left] + nums[right];
            while (left < right) {
                int sum = nums[left] + nums[right];
                closest = Math.abs(sum - subTarget) > Math.abs(closest - subTarget) ? closest : sum;
                if (sum < subTarget) {
                    left++;
                }
                else {
                    right--;
                }
            }

            ans = Math.abs(target - closest - nums[i]) < Math.abs(target - ans) ? closest + nums[i]: ans;
        }

        return ans;
    }

    public static void main(String[] args) {
        ThreeSumClosest s = new ThreeSumClosest();
        System.out.println(s.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }
}