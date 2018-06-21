package com.zhangliang.leetcode;
/*
Given two strings s and t, determine if they are both one edit distance apart.

Note: 

There are 3 possiblities to satisify one edit distance apart:

Insert a character into s to get t
Delete a character from s to get t
Replace a character of s to get t
Example 1:

Input: s = "ab", t = "acb"
Output: true
Explanation: We can insert 'c' into s to get t.
Example 2:

Input: s = "cab", t = "ad"
Output: false
Explanation: We cannot get t from s by only one step.
Example 3:

Input: s = "1203", t = "1213"
Output: true
Explanation: We can replace '0' with '1' to get t.
*/

public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        boolean flag = false;
        int lengthDiff = Math.abs(s.length() - t.length());
        if (lengthDiff > 1) {
            return false;
        } else if (lengthDiff == 1) {
            String small = s.length() > t.length() ? t : s;
            String large = s.length() > t.length() ? s : t;

            int smallCur = 0;
            for (int i = 0; i < large.length(); i++) {
                if (smallCur >= small.length() || large.charAt(i) != small.charAt(smallCur)) {
                    if (!flag) {
                        flag = true;
                        continue;
                    } else {
                        return false;
                    }
                }

                smallCur++;
            }
        } else {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    if (flag) {
                        return false;
                    }
                    flag = true;
                }
            }
        }

        return flag;
    }
}
