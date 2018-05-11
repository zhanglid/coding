package com.zhangliang.leetcode;
/*
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        
        Set<Character> set = new HashSet<>();

        int l = 0;
        int r = 0;
        int ans = 0;

        while (r < s.length()) {
            char c = s.charAt(r);
            if (set.contains(c)) {
                while(s.charAt(l) != c) {
                    set.remove(s.charAt(l));
                    l++;
                }
                l++;
            }
            set.add(c);
            ans = Math.max(ans, r - l + 1);
            r++;
        }

        return ans;
    }

    
    public int lengthOfLongestSubstringOneWhile(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }

        Set<Character> set = new HashSet<>();

        int r = 0, l = 0, ans = 0;


        while (r < s.length()) {
            if (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l++));
            }
            else {
                ans = Math.max(ans, r - l + 1);
                set.add(s.charAt(r));
                r++;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters s = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(s.lengthOfLongestSubstringOneWhile("abcabcbb"));
    }
}