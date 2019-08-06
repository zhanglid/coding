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
        int[] digits = new int[Math.max(a.length(), b.length()) + 1];
        int step = 0;
        for (int i = 0; i <= Math.max(a.length(), b.length()); i++) {
            int ai = a.length() - 1 - i;
            int bi = b.length() - 1 - i;
            int sum = (ai >= 0 ? (a.charAt(ai) - '0') : 0) + (bi >= 0 ? (b.charAt(bi) - '0') : 0) + step;
            digits[digits.length - i - 1] = sum % 2;
            step = sum / 2;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digits.length; i++) {
            if (sb.length() > 0 || digits[i] != 0) {
                sb.append(digits[i]);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
