package com.zhangliang.leetcode;
/*
Given an array of integers and an integer k, you need to find the total number of continuous subarrays 
whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2

Note:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
*/

import java.util.*;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        Map<Long, Integer> sums = new HashMap<>();
        sums.put((long) 0, 1);
        int sum = 0;
        int result = 0;
        for (int num : nums) {
            sum += num;
            result += sums.getOrDefault((long) sum - k, 0);
            sums.put((long) sum, sums.getOrDefault((long) sum, 0) + 1);
        }
        return result;
    }
}
