package com.zhangliang.leetcode;
/*
Given an array nums of n integers and an integer target, are 
there elements a, b, c, and d in nums such that a + b + c + d 
= target? Find all unique quadruplets in the array which gives 
the sum of target.

Note:

The solution set must not contain duplicate quadruplets.

Example:

Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return ans;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int left = j + 1;
                int right = nums.length - 1; 

                int twoTarget = target - nums[i] - nums[j];

                while (left < right) {
                    int sum = nums[left] + nums[right];

                    if (sum == twoTarget) {
                        List<Integer> record = new ArrayList<>();
                        record.add(nums[i]);
                        record.add(nums[j]);
                        record.add(nums[left]);
                        record.add(nums[right]);
                        ans.add(record);
                        left++;
                        while(left < right && nums[left + 1] == nums[left]) {
                            left++;
                        }
                    }
                    else if (sum < twoTarget) {
                        left++;
                    }
                    else {
                        right--;
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        FourSum s = new FourSum();
        List<List<Integer>> ans = s.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        System.out.println(ans.toString());
    }
}