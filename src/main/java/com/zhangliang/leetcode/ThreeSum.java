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

import java.util.*;

public class ThreeSum {
    class Pair implements Comparable<Pair> {
        int value;
        int key;

        public Pair(int value, int key) {
            this.value = value;
            this.key = key;
        }

        public int compareTo(Pair other) {
            return value - other.value;
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        // assume nums is non-null non-empty
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                if (l > i + 1 && nums[l] == nums[l - 1]) {
                    l++;
                    continue;
                }
                int sum = nums[l] + nums[r] + nums[i];
                if (sum < 0) {
                    l++;
                } else if (sum > 0) {
                    r--;
                } else {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                }
            }
        }

        return ans;
    }
}