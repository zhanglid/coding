package com.zhangliang.leetcode;
/*
Given an integer array, return the k-th smallest distance among all the pairs. The distance 
of a pair (A, B) is defined as the absolute difference between A and B.

Example 1:
Input:
nums = [1,3,1]
k = 1
Output: 0 
Explanation:
Here are all the pairs:
(1,3) -> 2
(1,1) -> 0
(3,1) -> 2

Then the 1st smallest distance pair is (1,1), and its distance is 0.
Note:
2 <= len(nums) <= 10000.
0 <= nums[i] < 1000000.
1 <= k <= len(nums) * (len(nums) - 1) / 2.
*/

import java.util.Arrays;

public class FindKthSmallestPairDistance {

    private int binarySearchStart(int target, int[] nums) {
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid;
            } else {
                r = mid;
            }
        }

        if (nums[l] >= target) {
            return l;
        }

        return r;
    }

    private int getRank(int targetDiff, int[] nums) {
        int rank = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int r = binarySearchStart(num + targetDiff, nums);
            rank += Math.max(0, r - i - 1);
        }
        return rank;
    }

    private boolean hasDiff(int diff, int[] nums) {
        for (int num : nums) {
            int r = binarySearchStart(num + diff, nums);
            if (r < nums.length && nums[r] - num == diff) {
                return true;
            }
        }

        return false;
    }

    public int smallestDistancePair(int[] nums, int k) {
        if (nums == null || k < 1) {
            return 0;
        }

        Arrays.sort(nums);
        int r = nums[nums.length - 1] - nums[0];
        int l = 0;

        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            int rank = Math.abs(getRank(mid, nums));

            if (rank < k) {
                l = mid;
            } else {
                r = mid;
            }
        }

        int lRank = getRank(l, nums);
        int rRank = getRank(r, nums);
        if (lRank <= k && hasDiff(l, nums) && rRank >= k) {
            return l;
        }

        if (rRank <= k && hasDiff(r, nums)) {
            return r;
        }
        return 0;
    }
}
