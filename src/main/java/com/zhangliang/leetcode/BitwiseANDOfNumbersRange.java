package com.zhangliang.leetcode;
/*
Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, 
inclusive.

Example 1:

Input: [5,7]
Output: 4
Example 2:

Input: [0,1]
Output: 0
*/

public class BitwiseANDOfNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        if (m >= n) {
            return m;
        }

        int ans = 0;
        int base = 1;
        while (m != 0 || n != 0) {
            int md = m % 2;
            int nd = n % 2;
            m /= 2;
            n /= 2;
            if (md != nd || nd == 0) {
                ans = 0;
            } else {
                ans += base;
            }

            base *= 2;
        }

        return ans;
    }
}
