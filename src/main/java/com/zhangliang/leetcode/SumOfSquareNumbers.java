package com.zhangliang.leetcode;
/*
Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a^2 + b^2 = c.

Example 1:
Input: 5
Output: True
Explanation: 1 * 1 + 2 * 2 = 5
 

Example 2:
Input: 3
Output: False
*/

import java.util.*;

public class SumOfSquareNumbers {
    public boolean judgeSquareSum(int c) {
        Set<Integer> squareNums = new HashSet<>();
        for (int i = 0; i * i <= c; i++) {
            int diff = c - i * i;
            if (diff < 0) {
                return false;
            }
            squareNums.add(i * i);
            if (squareNums.contains(diff)) {
                return true;
            }
        }
        return false;
    }
}
