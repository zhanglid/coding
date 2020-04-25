package com.zhangliang.leetcode;
/*
Given an array consisting of n integers, find the contiguous subarray whose length is greater
 than or equal to k that has the maximum average value. And you need to output the maximum 
 average value.

Example 1:
Input: [1,12,-5,-6,50,3], k = 4
Output: 12.75
Explanation:
when length is 5, maximum average value is 10.8,
when length is 6, maximum average value is 9.16667.
Thus return 12.75.
Note:
1 <= k <= n <= 10,000.
Elements of the given array will be in range [-10,000, 10,000].
The answer with the calculation error less than 10-5 will be accepted.
*/

import java.util.*;

public class MaximumAverageSubarrayII {
    private static double DELTA = 1e-5;

    private int findMin(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans = Math.min(ans, nums[i]);
        }
        return ans;
    }

    private int findMax(int[] nums) {
        int ans = nums[0];
        for (int i = 0; i < nums.length; i++) {
            ans = Math.max(nums[i], ans);
        }
        return ans;
    }

    private boolean hasSubArrayLongerThanKWithNonNegativeSum(double[] nums, int k) {
        double minSum = 0;
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        if (sum >= 0) {
            return true;
        }
        double prevSum = 0;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i];
            prevSum += nums[i - k];
            minSum = Math.min(minSum, prevSum);
            if (sum >= minSum) {
                return true;
            }
        }

        return false;
    }

    private boolean exists(double target, int[] nums, int k) {
        double[] offsetNums = new double[nums.length];
        for (int i = 0; i < offsetNums.length; i++) {
            offsetNums[i] = nums[i] - target;
        }
        return hasSubArrayLongerThanKWithNonNegativeSum(offsetNums, k);
    }

    public double findMaxAverage(int[] nums, int k) {
        double min = findMin(nums);
        double max = findMax(nums);
        while (min + DELTA < max) {
            double mid = min + (max - min) / 2;
            if (exists(mid, nums, k)) {
                min = mid;
            } else {
                max = mid;
            }
        }
        return min;
    }
}
