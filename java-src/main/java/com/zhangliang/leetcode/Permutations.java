package com.zhangliang.leetcode;
/*
Given a collection of distinct integers, return all possible 
permutations.

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

import java.util.*;

public class Permutations {
    private void helper(Set<Integer> numSet, List<Integer> path, List<List<Integer>> result) {
        if (numSet.size() == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (Integer num : numSet.toArray(new Integer[0])) {
            numSet.remove(num);
            path.add(num);
            helper(numSet, path, result);
            path.remove(path.size() - 1);
            numSet.add(num);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        helper(numSet, new ArrayList<>(), result);
        return result;
    }

}
