package com.zhangliang.linkedin;
/*
求非相邻的数的最大和 例如 [3,4,5,6,7] -> 3 + 5+ 7
*/

public class NonNeighborMaxSum {
    public int maxSum(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i % 2] = Math.max(dp[(i - 2) % 2] + nums[i - 1], dp[(i - 1) % 2]);
        }
        return dp[nums.length % 2];
    }
}
