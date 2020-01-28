package com.zhangliang.leetcode;
/*
Given a positive integer num, write a function which returns True if 
num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:
Input: 16
Output: true

Example 2:
Input: 14
Output: false
*/

public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num < 4) {
            return num == 1;
        }

        int l = 2;
        int r = num / 2;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= num) {
                l = mid;
            } else {
                r = mid;
            }
        }

        return (long) l * l == num || (long) r * r == num;
    }
}
