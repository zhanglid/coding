package com.zhangliang.leetcode;
/*
Given a collection of numbers that might contain duplicates, return all possible 
unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        if (nums == null || nums.length < 1) {
            return ans;
        }

        Arrays.sort(nums);
        helper(nums, new boolean[nums.length], new ArrayList<>(), ans);
        return ans;
    }

    private void helper(int[] nums, boolean[] selected, List<Integer> cur, List<List<Integer>> ans) {
        if (cur.size() == nums.length) {
            ans.add(new ArrayList<Integer>(cur));
            return;
        }

        int lastIndex = -1;
        for (int i = 0; i < selected.length; i++) {
            if (lastIndex >= 0 && nums[i] == nums[lastIndex]) {
                continue;
            }
            if (!selected[i]) {
                lastIndex = i;
                cur.add(nums[i]);
                selected[i] = true;
                helper(nums, selected, cur, ans);
                selected[i] = false;
                cur.remove(cur.size() - 1);
            }
        }
    }
}
