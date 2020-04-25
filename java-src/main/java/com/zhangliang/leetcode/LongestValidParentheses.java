package com.zhangliang.leetcode;
/*
Given a string containing just the characters '(' and ')', find the 
length of the longest valid (well-formed) parentheses substring.

Example 1:
Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"

Example 2:
Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"

*/

import java.util.*;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty() || s.charAt(i) == '(' || s.charAt(stack.peek()) == ')') {
                stack.push(i);
            } else {
                stack.pop();
            }
        }
        int size = 0;
        int r = s.length();
        while (!stack.isEmpty()) {
            size = Math.max(size, r - stack.peek() - 1);
            r = stack.pop();
        }
        size = Math.max(size, r);
        return size;
    }
}
