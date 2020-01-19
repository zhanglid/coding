package com.zhangliang.leetcode;
/*
Given a set of candidate numbers (candidates) (without duplicates) and 
a target number (target), 
find all unique combinations in candidates where the candidate numbers sums 
to target.

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
    private List<List<Integer>> find(int[] nums, int start, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (target == 0) {
            ans.add(new ArrayList<>());
            return ans;
        }
        if (start >= nums.length || target < 0) {
            return ans;
        }
        for (int i = start; i < nums.length; i++) {
            List<List<Integer>> rest = find(nums, i, target - nums[i]);
            for (List<Integer> choice : rest) {
                List<Integer> extended = new ArrayList<>();
                extended.add(nums[i]);
                extended.addAll(choice);
                ans.add(extended);
            }
        }
        return ans;
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        return find(nums, 0, target);
    }
}
