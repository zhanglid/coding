package com.zhangliang.leetcode;
/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example:

Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]
*/

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        if (s == null) {
            return ans;
        }

        helper(s, 0, new ArrayList<>(), ans);

        return ans;
    }

    private void helper(String s, int start, List<String> curList, List<List<String>> ans) {
        if (start >= s.length()) {
            ans.add(new ArrayList<>(curList));
            return;
        }

        for (int i = start + 1; i <= s.length(); i++) {
            String subString = s.substring(start, i);
            if (isPalindrome(subString)) {
                curList.add(subString);
                helper(s, i, curList, ans);
                curList.remove(curList.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}
