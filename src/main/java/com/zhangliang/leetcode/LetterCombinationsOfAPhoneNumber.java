package com.zhangliang.leetcode;
/*
Given a string containing digits from 2-9 inclusive, return all possible letter 
combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. 
Note that 1 does not map to any letters.



Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any 
order you want.
*/

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    private char[][] digitArray = { 
        {}, 
        {}, 
        { 'a', 'b', 'c' }, 
        { 'd', 'e', 'f' }, 
        { 'g', 'h', 'i' }, 
        { 'j', 'k', 'l' },
        { 'm', 'n', 'o' },
        { 'p', 'q', 'r', 's' },
        { 't', 'u', 'v' },
        { 'w', 'x', 'y', 'z' }
    };

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() < 1) {
            return ans;
        }

        ans.add("");
        char[] chars = digits.toCharArray();
        for (char x : chars) {
            char[] nextChars = digitArray[x - '0'];
            if (nextChars.length >= 1) {
                List<String> next = new ArrayList<>();
                for (String str: ans) {
                    for (char nextChar: nextChars) {
                        next.add(str + nextChar);
                    }
                }
                ans = next;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber s = new LetterCombinationsOfAPhoneNumber();
        System.out.println(s.letterCombinations("23"));
    }
}
