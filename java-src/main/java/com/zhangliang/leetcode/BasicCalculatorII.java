package com.zhangliang.leetcode;
/*
Implement a basic calculator to evaluate a simple expression string.
The expression string contains only non-negative integers, +, -, *, / 
operators and empty spaces. The integer division should truncate toward 
zero.

Example 1:
Input: "3+2*2"
Output: 7

Example 2:
Input: " 3/2 "
Output: 1

Example 3:
Input: " 3+5 / 2 "
Output: 5
Note:

You may assume that the given expression is always valid.
Do not use the eval built-in library function.
*/

public class BasicCalculatorII {
    private boolean isSign(char x) {
        return x == '+' || x == '-';
    }

    // {index, result}
    private int[] processPart(String s, int start) {
        int val = 1;
        int i = start;
        while (i < s.length()) {
            int j = i + 1;
            while (j < s.length() && Character.isDigit(s.charAt(j))) {
                j++;
            }
            int part = Integer.parseInt(s.substring(i, j));
            if (i == start || s.charAt(i - 1) == '*') {
                val *= part;
            } else {
                val /= part;
            }
            i = j + 1;
            if (j >= s.length() || isSign(s.charAt(j))) {
                break;
            }
        }
        return new int[] { i - 2, val };
    }

    public int calculate(String s) {
        s = s.replaceAll(" ", "");
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] part = processPart(s, i);
            i = part[0];
            ans += part[1];
        }
        return ans;
    }
}
