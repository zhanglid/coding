package com.zhangliang.leetcode;
/*
Given an encoded string, return its decoded string.
The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly 
k times. Note that k is guaranteed to be a positive integer.
You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
Furthermore, you may assume that the original data does not contain any digits and that digits are only for those 
repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
*/

import java.util.LinkedList;

public class DecodeString {
    public String decodeString(String s) {
        LinkedList<Integer> numStack = new LinkedList<>();
        LinkedList<String> strStack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int j = i + 1;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    j++;
                }
                int num = Integer.parseInt(s.substring(i, j));
                numStack.push(num);
                strStack.push(sb.toString());
                sb = new StringBuilder();
                i = j;
            } else if (s.charAt(i) == ']') {
                int num = numStack.pop();
                String base = sb.toString();
                for (int j = 1; j < num; j++) {
                    sb.append(base);
                }
                sb.insert(0, strStack.pop());
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
