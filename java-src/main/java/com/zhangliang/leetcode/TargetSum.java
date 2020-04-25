package com.zhangliang.leetcode;
/*
You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. 
Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:
Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.
Note:
The length of the given array is positive and will not exceed 20.
The sum of elements in the given array will not exceed 1000.
Your output answer is guaranteed to be fitted in a 32-bit integer.

*/

import java.util.*;

public class TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        Map<Integer, Integer> values = new HashMap<>();
        values.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            Map<Integer, Integer> nextValues = new HashMap<>();
            for (Integer key : values.keySet()) {
                int value = key + nums[i];
                nextValues.put(value, nextValues.getOrDefault(value, 0) + values.get(key));
                value = key - nums[i];
                nextValues.put(value, nextValues.getOrDefault(value, 0) + values.get(key));
            }
            values = nextValues;
        }
        return values.getOrDefault(S, 0);
    }
}
