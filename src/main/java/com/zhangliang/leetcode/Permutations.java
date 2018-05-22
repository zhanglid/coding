package com.zhangliang.leetcode;
/*
Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 1) {
            return ans;
        }

        helper(nums, new boolean[nums.length], new ArrayList<>(), ans);
        return ans;
    }

    private void helper(int[] nums, boolean[] isSelected, List<Integer> cur, List<List<Integer>> ans) {
        if (cur.size() == nums.length) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < isSelected.length; i++) {
            if (!isSelected[i]) {
                cur.add(nums[i]);
                isSelected[i] = true;
                helper(nums, isSelected, cur, ans);
                isSelected[i] = false;
                cur.remove(cur.size() - 1);
            }
        }
    }
}
