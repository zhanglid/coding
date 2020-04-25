package com.zhangliang.leetcode;
/*
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers
within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose
of this problem, assume that your function returns 0 when the reversed 
integer overflows.
*/

public class ReverseInteger {
    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int next = 10 * ans + (x % 10);
            if (next / 10 != ans) {
                return 0;
            }
            ans = next;
            x /= 10;
        }

        return ans;
    }
}