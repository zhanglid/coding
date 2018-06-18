package com.zhangliang.leetcode;
/*
Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if (n < 1) {
            return 0;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            int num = 0;
            for (int j = 1; j <= i; j++) {
                num += dp[j - 1] * dp[i - j];
            }
            dp[i] = num;
        }

        return dp[n];
    }
}
