package com.zhangliang.leetcode;
/*
Given an input string, reverse the string word by word.

Example:  

Input: "the sky is blue",
Output: "blue is sky the".
Note:

A word is defined as a sequence of non-space characters.
Input string may contain leading or trailing spaces. However, your reversed string should not 
contain leading or trailing spaces.
You need to reduce multiple spaces between two words to a single space in the reversed string.
Follow up: For C programmers, try to solve it in-place in O(1) space.
*/

import java.util.*;

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (word.length() > 0) {
                result.add(word);
            }
        }
        Collections.reverse(result);
        return String.join(" ", result);
    }
}
