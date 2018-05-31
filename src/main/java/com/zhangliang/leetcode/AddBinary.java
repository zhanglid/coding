package com.zhangliang.leetcode;
/*
Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
*/

public class AddBinary {
    public String addBinary(String a, String b) {
        if (a == null || b == null) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        int cur1 = a.length() - 1;
        int cur2 = b.length() - 1;
        int step = 0;

        while (cur1 >= 0 || cur2 >= 0) {
            int n1 = cur1 >= 0 ? a.charAt(cur1) - '0' : 0;
            int n2 = cur2 >= 0 ? b.charAt(cur2) - '0' : 0;
            int sum = n1 + n2 + step;
            sb.insert(0, sum % 2);
            step = sum / 2;
            cur1--;
            cur2--;
        }

        if (step > 0) {
            sb.insert(0, step);
        }

        return sb.toString();
    }
}
