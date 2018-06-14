package com.zhangliang.leetcode;
/*
Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 1) {
            return ans;
        }

        Arrays.sort(nums);

        helper(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void helper(int[] nums, int start, List<Integer> curList, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(curList));

        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i] == nums[i - 1]) {
                continue;
            }

            curList.add(nums[i]);
            helper(nums, i + 1, curList, ans);
            curList.remove(curList.size() - 1);
        }
    }
}
