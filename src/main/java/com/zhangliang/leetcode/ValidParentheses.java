package com.zhangliang.leetcode;
/*
Given a string containing just the characters 
'(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
*/

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() < 1) {
            return true;
        }
        Stack<Character> stack = new Stack<>();

        for (char x : s.toCharArray()) {
            if (x == '(' || x == '{' || x == '[') {
                stack.push(x);
            }
            else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (x == ')') {
                    if (stack.peek() != '(') {
                        return false;
                    }
                }
                else if (x == ']') {
                    if (stack.peek() != '[') {
                        return false;
                    }
                }
                else if (x == '}') {
                    if (stack.peek() != '{') {
                        return false;
                    }
                }
                stack.pop();
            }
        }

        return stack.size() == 0;
    }

    public static void main(String[] args) {
        ValidParentheses s = new ValidParentheses();
        System.out.println(s.isValid("{[]}"));
    }
}