package com.zhangliang.leetcode;
/*
Shuffle a set of numbers without duplicates.

Example:

// Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] 
must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle();
*/

import java.util.*;

public class ShuffleAnArray {
    static class Solution {
        private int[] original;
        private int[] nums;
        private Random rand = new Random();

        private int[] clone(int[] nums) {
            int[] ans = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                ans[i] = nums[i];
            }
            return ans;
        }

        public Solution(int[] nums) {
            this.original = clone(nums);
            this.nums = clone(nums);
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            nums = clone(original);
            return nums;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            for (int i = nums.length - 1; i >= 0; i--) {
                int target = rand.nextInt(i + 1);
                int t = nums[i];
                nums[i] = nums[target];
                nums[target] = t;
            }
            return nums;
        }
    }

    /**
     * Your Solution object will be instantiated and called as such: Solution obj =
     * new Solution(nums); int[] param_1 = obj.reset(); int[] param_2 =
     * obj.shuffle();
     */
}
