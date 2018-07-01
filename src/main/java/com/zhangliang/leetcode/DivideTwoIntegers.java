package com.zhangliang.leetcode;
/*
Given two integers dividend and divisor, divide two integers without using 
multiplication, division and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero.

Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Note:

Both dividend and divisor will be 32-bit signed integers.
The divisor will never be 0.
Assume we are dealing with an environment which could only store integers 
within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose 
of this problem, assume that your function returns 231 − 1 when the division 
result overflows.
*/

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (divisor == Integer.MIN_VALUE) {
            if (dividend == Integer.MIN_VALUE) {
                return 1;
            }

            return 0;
        }

        int offset = 0;
        if (dividend == Integer.MIN_VALUE) {
            dividend += Math.abs(divisor);
            offset += 1;
        }
        boolean isPostive = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int base = divisor;
        int baseIndex = 1;

        while (base * 2 < dividend && base * 2 > base) {
            base *= 2;
            baseIndex *= 2;
        }

        int ans = 0;
        while (dividend >= divisor) {
            if (dividend >= base) {
                dividend -= base;
                ans += baseIndex;
            }
            base = base >> 1;
            baseIndex = baseIndex >> 1;
        }

        if (ans + offset < 0) {
            if (isPostive) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        }
        ans += offset;
        return isPostive ? ans : -ans;
    }
}