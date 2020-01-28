package com.zhangliang.leetcode;
/*
Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
Note:

There may be more than one LIS combination, it is only necessary for you to return the length.
Your algorithm should run in O(n2) complexity.
Follow up: Could you improve it to O(n log n) time complexity?
*/

import java.util.TreeMap;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int ans = 0;
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for (int num : nums) {
            Integer floor = tm.floorKey(num);
            int len = 1;
            if (floor != null) {
                if (floor == num) {
                    len = tm.get(floor);
                } else {
                    len += tm.get(floor);
                }
            }
            Integer ceiling = tm.ceilingKey(num);
            tm.put(num, len);
            if (ceiling != null && ceiling > num && tm.get(ceiling) <= len) {
                tm.remove(ceiling);
            }
        }

        for (int val : tm.values()) {
            ans = Math.max(val, ans);
        }

        return ans;
    }
}
