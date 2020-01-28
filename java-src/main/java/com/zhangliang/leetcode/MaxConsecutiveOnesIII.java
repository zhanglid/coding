package com.zhangliang.leetcode;
/*
Given an array A of 0s and 1s, we may change up to K values from 0 to 1.

Return the length of the longest (contiguous) subarray that contains only 1s. 

Example 1:
Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
Output: 6
Explanation: 
[1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.

Example 2:
Input: A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
Output: 10
Explanation: 
[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.

Note:

1 <= A.length <= 20000
0 <= K <= A.length
A[i] is 0 or 1 
*/

public class MaxConsecutiveOnesIII {
    private int moveAndFindMax(int[] dp, int k) {
        int oneCount = dp[0];
        dp[0] = 0;
        int max = dp[k] + oneCount;
        for (int i = k; i > 0; i--) {
            dp[i] = dp[i - 1] + 1 + oneCount;
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int longestOnes(int[] A, int K) {
        int[] dp = new int[K + 1];
        int k = 0;
        int ans = 0;
        for (int num : A) {
            if (num == 0) {
                k = Math.min(K, k + 1);
                ans = Math.max(ans, moveAndFindMax(dp, k));
            } else {
                dp[0]++;
            }
        }

        ans = Math.max(ans, moveAndFindMax(dp, k));
        return ans;
    }
}
