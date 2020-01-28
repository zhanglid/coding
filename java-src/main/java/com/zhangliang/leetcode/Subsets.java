package com.zhangliang.leetcode;
/*
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 1) {
            return ans;
        }
        Arrays.sort(nums);
        helper(nums, new ArrayList<>(), ans, 0);
        return ans;
    }

    private void helper(int[] nums, List<Integer> curList, List<List<Integer>> ans, int start) {
        ans.add(new ArrayList<Integer>(curList));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            curList.add(nums[i]);
            helper(nums, curList, ans, i + 1);
            curList.remove(curList.size() - 1);
        }
    }
}
