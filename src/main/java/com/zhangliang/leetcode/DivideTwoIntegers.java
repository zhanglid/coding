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
        boolean sign = (dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0);

        if (dividend < 0) {
            if (dividend == Integer.MIN_VALUE) {
                if (sign && divisor == -1) {
                    return Integer.MAX_VALUE;
                }
                
                if (divisor < 0) {
                    return divide(dividend - divisor, divisor) + 1;
                }
                else {
                    return divide(dividend + divisor, divisor) - 1;
                }
            }
            dividend = -dividend;
        }

        if (divisor < 0) {
            if (dividend == Integer.MIN_VALUE) {
                return 0;
            }
            divisor = -divisor;
        }

        if (dividend < divisor) {
            return 0;
        }
        int base = 1;
        while (dividend - divisor >=  divisor) {
            divisor = divisor << 1;
            base = base << 1;
        }

        int ans = 0;
        while (base >= 1) {
            ans = ans + ans;
            if (dividend >= divisor) {
                ans += 1;
                dividend -= divisor;
            }
            divisor = divisor >> 1;
            base = base >> 1;
        }

        return sign ? ans : -ans;
    }

    public static void main(String[] args) {
        DivideTwoIntegers s = new DivideTwoIntegers();
        System.out.println(s.divide(2147483647, 3));
    }
}