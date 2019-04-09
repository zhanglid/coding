package com.zhangliang.leetcode;
/*
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace 
the number by the sum of the squares of its digits, and repeat the process until the number equals 1 
(where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which 
this process ends in 1 are happy numbers.

Example: 

Input: 19
Output: true
Explanation: 
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
*/

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    private int getTransformed(int n) {
        int ans = 0;
        while (n > 0) {
            int digit = n % 10;
            ans += digit * digit;
            n /= 10;
        }

        return ans;
    }

    public boolean isHappy(int n) {
        if (n < 1) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        while (n != 1 || !set.contains(n)) {
            set.add(n);
            n = getTransformed(n);
        }

        return n == 1;
    }
}
