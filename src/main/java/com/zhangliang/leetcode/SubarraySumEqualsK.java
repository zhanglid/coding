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
        Map<Integer, Integer> sums = new HashMap<>();
        int ans = 0;
        sums.put(0, 1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sums.containsKey(sum - k)) {
                ans += sums.get(sum - k);
            }
            sums.put(sum, sums.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
