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

import java.util.Stack;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }

        char[] chars = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ')') {
                if (stack.isEmpty()) {
                    stack.push(i);
                }
                else if (chars[stack.peek()] == '(') {
                    stack.pop();
                }
                else {
                    stack.push(i);
                }
            }
            else {
                stack.push(i);
            }
        }

        int ans = 0;

        int up = chars.length;
        while(!stack.isEmpty()) {
            int nextUp = stack.pop();
            ans = Math.max(up - nextUp - 1, ans);
            up = nextUp;
        }

        ans = Math.max(up, ans);

        return ans;
    }
}
