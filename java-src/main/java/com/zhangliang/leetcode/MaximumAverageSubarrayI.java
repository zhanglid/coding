package com.zhangliang.leetcode;
/*
Given an array consisting of n integers, find the contiguous subarray of given length k 
that has the maximum average value. And you need to output the maximum average value.

Example 1:

Input: [1,12,-5,-6,50,3], k = 4
Output: 12.75
Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
 

Note:

1 <= k <= n <= 30,000.
Elements of the given array will be in the range [-10,000, 10,000].
*/

public class MaximumAverageSubarrayI {
    /**
     * Slide window solution. Keep a window of size k, update the average. We need
     * to keep track of sum of the nums in the window.
     * 
     * @assumption non-null, 1 <= k <= n <= 30,000. num in [-10,000, 10,000]
     * 
     * @param nums an array of n integers
     * @param k    the contiguous subarray of given length k
     * @return maximum average
     */
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;

        // initialize the window
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        // placeholder value
        int maxSum = sum;

        for (int i = k; i < nums.length; i++) {
            // update window
            sum = sum + nums[i] - nums[i - k];
            if (sum > maxSum) {
                maxSum = sum;
            }
        }

        return (double) maxSum / k;
    }
}
