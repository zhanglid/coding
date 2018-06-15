package com.zhangliang.leetcode;
/*
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), 
find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
*/

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 1) {
            return ans;
        }
        helper(nums, target, new ArrayList<>(), 0, 0, ans);
        return ans;
    }

    private void helper(int[] nums, int target, List<Integer> row, int sum, int start, List<List<Integer>> ans) {
        if (sum == target) {
            ans.add(new ArrayList<>(row));
            return;
        }
        if (start >= nums.length || sum > target) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i] == nums[i - 1]) {
                continue;
            }

            row.add(nums[i]);
            helper(nums, target, row, sum + nums[i], i, ans);
            row.remove(row.size() - 1);
        }
    }
}
