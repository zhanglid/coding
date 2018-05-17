package com.zhangliang.leetcode;
/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.
*/

public class LongestCommonPrefix {

    private boolean checkCommonPrefix(String[] strs, String prefix) {
        for (String str : strs) {
            if (!str.startsWith(prefix)) {
                return false;
            }
        }

        return true;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length < 1) {
            return "";
        }

        int len = strs[0].length();
        for (String str : strs) {
            len = Math.min(str.length(), len);
        }

        int l = 0;
        int r = len;

        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (checkCommonPrefix(strs, strs[0].substring(0, mid))) {
                l = mid;
            } else {
                r = mid;
            }
        }

        String ans = strs[0].substring(0, r);
        if (checkCommonPrefix(strs, ans)) {
            return ans;
        }

        return strs[0].substring(0, l);
    }

    public static void main(String[] args) {
        LongestCommonPrefix s = new LongestCommonPrefix();
        System.out.println(s.longestCommonPrefix(new String[] { "flower", "flow", "flight" }));
    }
}