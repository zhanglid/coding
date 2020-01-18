package com.zhangliang.leetcode;
/*
Implement pow(x, n), which calculates x raised to the power n (xn).

Example 1:
Input: 2.00000, 10
Output: 1024.00000

B: 10 => 1010

Example 2:
Input: 2.10000, 3
Output: 9.26100

Example 3:
Input: 2.00000, -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25

Note:
-100.0 < x < 100.0
n is a 32-bit signed integer, within the range [−231, 231 − 1]
*/

import java.util.*;

public class PowXN {
    public double myPow(double x, int n) {
        boolean isNegative = true;
        if (n > 0) {
            // Attention: Use negative n to cover overflow.
            isNegative = false;
            n = -n;
        }
        double result = 1;
        while (n != 0) {
            if (n % 2 == -1) {
                result *= x;
            }
            x *= x;
            n /= 2;
        }
        return isNegative ? 1.0 / result : result;
    }
}
