package com.zhangliang.leetcode;
/*
Given a set of candidate numbers (candidates) (without duplicates) and a target number 
(target), find all unique combinations in candidates where the candidate numbers sums to 
target.

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

import java.util.*;

public class CombinationSum {
    private void dfs(int[] nums, int index, List<Integer> path, int sum, int target, List<List<Integer>> result) {
        if (sum == target) {
            result.add(new ArrayList<>(path));
        }
        if (sum >= target) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            dfs(nums, i, path, sum + nums[i], target, result);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), 0, target, result);
        return result;
    }
}
