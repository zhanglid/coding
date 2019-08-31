package com.zhangliang.leetcode;
/*
A strobogrammatic number is a number that looks the same when rotated 180 degrees 
(looked at upside down).

Write a function to determine if a number is strobogrammatic. The number is represented as a 
string.

Example 1:
Input:  "69"
Output: true

Example 2:
Input:  "88"
Output: true

Example 3:
Input:  "962"
Output: false
*/

public class StrobogrammaticNumber {
    static private final int[] pairs = new int[] { 0, 1, -1, -1, -1, -1, 9, -1, 8, 6 };

    public boolean isStrobogrammatic(String num) {
        int l = 0;
        int r = num.length() - 1;
        while (l <= r) {
            if (pairs[num.charAt(l) - '0'] != num.charAt(r) - '0') {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
