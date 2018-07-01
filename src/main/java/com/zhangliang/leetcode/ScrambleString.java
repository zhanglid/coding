package com.zhangliang.leetcode;
/*
Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of s1 = "great":

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that "rgeat" is a scrambled string of "great".

Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that "rgtae" is a scrambled string of "great".

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.

Example 1:

Input: s1 = "great", s2 = "rgeat"
Output: true
Example 2:

Input: s1 = "abcde", s2 = "caebd"
Output: false
*/

public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }

        if (s1.equals(s2)) {
            return true;
        }
        int[] counter1 = new int[26];
        int[] counter2 = new int[26];
        int[] counter3 = new int[26];

        for (int i = 0; i < s1.length() - 1; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            char c3 = s2.charAt(s2.length() - i - 1);

            counter1[c1 - 'a']++;
            counter2[c2 - 'a']++;
            counter3[c3 - 'a']++;

            boolean isDifference12 = false;
            boolean isDifference13 = false;
            for (int j = 0; j < 26; j++) {
                if (counter1[j] != counter2[j]) {
                    isDifference12 = true;
                    break;
                }
            }

            for (int j = 0; j < 26; j++) {
                if (counter1[j] != counter3[j]) {
                    isDifference13 = true;
                    break;
                }
            }

            if (!isDifference12) {
                if (isScramble(s1.substring(0, i + 1), s2.substring(0, i + 1))
                        && isScramble(s1.substring(i + 1), s2.substring(i + 1))) {
                    return true;
                }
            }

            if (!isDifference13) {
                if (isScramble(s1.substring(0, i + 1), s2.substring(s2.length() - i - 1))
                        && isScramble(s1.substring(i + 1), s2.substring(0, s2.length() - i - 1))) {
                    return true;
                }
            }
        }

        return false;
    }
}
