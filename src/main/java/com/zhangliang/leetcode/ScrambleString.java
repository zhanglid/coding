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
    private class Counter {
        private int[] counts = new int[26];

        public void add(char x) {
            counts[x - 'a']++;
        }

        public int get(char x) {
            return counts[x - 'a'];
        }

        public boolean equals(Counter other) {
            for (char x = 'a'; x <= 'z'; x++) {
                if (counts[x - 'a'] != other.get(x)) {
                    return false;
                }
            }

            return true;
        }
    }

    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }

        if (s1.length() != s2.length()) {
            return false;
        }

        if (s1.equals(s2)) {
            return true;
        }

        Counter lcounter = new Counter();
        Counter l2counter = new Counter();
        Counter r2counter = new Counter();

        for (int i = 1; i < s1.length(); i++) {
            String l1 = s1.substring(0, i);
            String r1 = s1.substring(i);
            String l2 = s2.substring(0, s1.length() - i);
            String r2 = s2.substring(s1.length() - i);
            String rl2 = s2.substring(0, i);
            String rr2 = s2.substring(i);

            lcounter.add(s1.charAt(i - 1));
            l2counter.add(s2.charAt(i - 1));
            r2counter.add(s2.charAt(s2.length() - i));

            if (lcounter.equals(l2counter) && isScramble(l1, rl2) && isScramble(r1, rr2)) {
                return true;
            }

            if (lcounter.equals(r2counter) && isScramble(l1, r2) && isScramble(r1, l2)) {
                return true;
            }
        }

        return false;
    }
}
