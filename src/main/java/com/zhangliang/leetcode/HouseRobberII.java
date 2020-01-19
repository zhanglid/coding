package com.zhangliang.leetcode;
/*
You are a professional robber planning to rob houses along a street. 
Each house has a certain amount of money stashed. 
All houses at this place are arranged in a circle. 
That means the first house is the neighbor of the last one. 
Meanwhile, adjacent houses have security system connected and 
it will automatically contact the police 
if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing 
the amount of money of each house, determine 
the maximum amount of money you can rob tonight 
without alerting the police.

Example 1:

Input: [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
             because they are adjacent houses.
Example 2:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
*/

public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int[] dpRobFirst = new int[nums.length];
        int[] dpNonRobFirst = new int[nums.length];
        dpRobFirst[0] = nums[0];
        if (nums.length >= 2) {
            dpRobFirst[1] = nums[0];
            dpNonRobFirst[1] = nums[1];
        }
        for (int i = 2; i < nums.length - 1; i++) {
            dpRobFirst[i] = Math.max(dpRobFirst[i - 2] + nums[i], dpRobFirst[i - 1]);
            dpNonRobFirst[i] = Math.max(dpNonRobFirst[i - 2] + nums[i], dpNonRobFirst[i - 1]);
        }
        if (nums.length >= 2) {
            dpRobFirst[nums.length - 1] = dpRobFirst[nums.length - 2];
            if (nums.length >= 3) {
                dpNonRobFirst[nums.length - 1] = Math.max(dpNonRobFirst[nums.length - 2],
                        nums[nums.length - 1] + dpNonRobFirst[nums.length - 3]);
            }

        }
        return Math.max(dpNonRobFirst[nums.length - 1], dpRobFirst[nums.length - 1]);
    }
}
