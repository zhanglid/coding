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

    /**
     * Find all combinations of [25, 10, 5, 1] to get 99. You can use as much times
     * as you want for an element.
     */
    static class CoinDivision {
        private void helper(int amount, int index, int[] cents, List<Integer> path, List<List<Integer>> result) {
            if (amount == 0) {
                result.add(new ArrayList<>(path));
                return;
            }
            if (index >= cents.length) {
                return;
            }
            for (int i = 0; amount - i * cents[index] >= 0; i++) {
                path.add(i);
                helper(amount - i * cents[index], index + 1, cents, path, result);
                path.remove(path.size() - 1);
            }
        }

        public List<List<Integer>> divide(int amount, int[] cents) {
            List<List<Integer>> result = new ArrayList<>();
            helper(amount, 0, cents, new ArrayList<>(), result);
            return result;
        }
    }
}
