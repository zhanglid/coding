package com.zhangliang.algorithm;
/*
*/

import java.util.*;

public class Recursion {
    /**
     * Given a collection of distinct integers, return all possible permutations.
     * 
     * Example:
     * 
     * Input: [1,2,3] Output: [ [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1]
     * ]
     */
    static class Permutation {

        private void swap(List<Integer> nums, int i, int j) {
            int temp = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, temp);
        }

        private void dfs(List<Integer> nums, int index, List<List<Integer>> result) {
            if (index >= nums.size()) {
                result.add(new ArrayList<>(nums));
                return;
            }

            for (int i = index; i < nums.size(); i++) {
                swap(nums, index, i);
                dfs(nums, index + 1, result);
                swap(nums, index, i);
            }
        }

        public List<List<Integer>> permute(int[] nums) {
            List<Integer> path = new ArrayList<>();
            for (int num : nums) {
                path.add(num);
            }
            List<List<Integer>> result = new ArrayList<>();
            dfs(path, 0, result);
            return result;
        }
    }
}
