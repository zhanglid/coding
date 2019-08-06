package com.zhangliang.leetcode;
/*
Implement pow(x, n), which calculates x raised to the power n (xn).

Example 1:
Input: 2.00000, 10
Output: 1024.00000

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
        if (n == 0) {
            return 1;
        }
        int sign = n < 0 ? -1 : 1;
        if (n > 0) {
            n = -n;
        }
        int base = -1;
        Stack<Double> xs = new Stack<>();
        xs.push(x);
        while ((base << 1) >= n && (base << 1) >> 1 == base) {
            x *= x;
            base = base << 1;
            xs.push(x);
        }
        double result = 1;
        while (!xs.isEmpty()) {
            x = xs.pop();
            if (n <= base) {
                n -= base;
                result *= x;
            }
            base = base >> 1;
        }
        return sign > 0 ? result : 1.0 / result;
    }
}
