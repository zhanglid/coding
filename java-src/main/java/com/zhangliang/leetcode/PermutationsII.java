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

import java.util.*;

public class PermutationsII {
    private void helper(int[] nums, boolean[] chosenStatus, List<Integer> path, List<List<Integer>> result) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (chosenStatus[i] || i > 0 && nums[i] == nums[i - 1] && !chosenStatus[i - 1]) {
                continue;
            }
            chosenStatus[i] = true;
            path.add(nums[i]);
            helper(nums, chosenStatus, path, result);
            chosenStatus[i] = false;
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, new boolean[nums.length], new ArrayList<>(), result);
        return result;
    }
}
