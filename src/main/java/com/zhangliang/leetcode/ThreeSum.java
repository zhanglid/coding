package com.zhangliang.leetcode;
/*
Given an array nums of n integers, are there elements a, b, c in nums 
such that a + b + c = 0? Find all unique triplets in the array which 
gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return ans;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    List<Integer> record = new ArrayList<>();
                    record.add(nums[i]);
                    record.add(nums[left]);
                    record.add(nums[right]);
                    ans.add(record);
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ThreeSum s = new ThreeSum();
        System.out.println(s.threeSum(new int[] { 0, 0, 0, 0 }));
    }
}