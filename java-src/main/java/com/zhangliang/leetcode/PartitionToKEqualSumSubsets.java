package com.zhangliang.leetcode;
/*
Given an array of integers nums and a positive integer k, find whether 
it's possible to divide this array into k non-empty subsets whose sums 
are all equal.

Example 1:
Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
Output: True
Explanation: It's possible to divide it into 4 subsets 
(5), (1, 4), (2,3), (2,3) with equal sums.
 

Note:

1 <= k <= len(nums) <= 16.
0 < nums[i] < 10000.
*/

public class PartitionToKEqualSumSubsets {
    private boolean helper(int[] nums, int target, int index, int sum, int k) {
        if (sum > target) {
            return false;
        } else if (sum == target) {
            return canPartitionKSubsets(nums, k - 1);
        }
        for (int i = index; i < nums.length; i++) {
            if (helper(nums, target, i + 1, sum, k)) {
                return true;
            }
            int val = nums[i];
            if (val > 0) {
                nums[i] = -1;
                if (helper(nums, target, i + 1, sum + val, k)) {
                    nums[i] = val;
                    return true;
                }
            }
            nums[i] = val;
        }
        return false;
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k <= 1) {
            return true;
        }
        int sum = 0;
        for (int num : nums) {
            if (num < 0) {
                continue;
            }
            sum += num;
        }
        if (sum == 0) {
            return true;
        }
        if (sum % k != 0) {
            return false;
        }
        int partSum = sum / k;
        return helper(nums, partSum, 0, 0, k);
    }
}
