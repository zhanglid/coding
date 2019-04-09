package com.zhangliang.leetcode;
/*
Given an integer n, return the number of trailing zeroes in n!.

Example 1:

Input: 3
Output: 0
Explanation: 3! = 6, no trailing zero.
Example 2:

Input: 5
Output: 1
Explanation: 5! = 120, one trailing zero.
Note: Your solution should be in logarithmic time complexity.
*/

public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        if (n <= 0) {
            return 0;
        }
        int ans = 0;

        int base = 1;
        n /= 5;
        while (n > 0) {
            ans += (n % 5) * base;
            base *= 5;
            n /= 5;
        }

        return ans;
    }
}
