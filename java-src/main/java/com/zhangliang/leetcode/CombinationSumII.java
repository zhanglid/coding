package com.zhangliang.leetcode;
/*
Given a collection of candidate numbers (candidates) and a target number (target), 
find all unique combinations in candidates where the candidate numbers sums to 
target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates == null || candidates.length < 1) {
            return ans;
        }

        Arrays.sort(candidates);
        helper(candidates, ans, 0, 0, target, new ArrayList<>());
        return ans;
    }

    private void helper(int[] nums, List<List<Integer>> ans, int start, int sum, int target, List<Integer> curList) {
        if (sum == target) {
            ans.add(new ArrayList<>(curList));
            return;
        }

        if (start >= nums.length || sum > target) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i] == nums[i - 1]) {
                continue;
            }
            curList.add(nums[i]);
            helper(nums, ans, i + 1, sum + nums[i], target, curList);
            curList.remove(curList.size() - 1);
        }
    }
}
