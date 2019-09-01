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

import java.util.*;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
            case '[':
            case '(':
            case '{':
                stack.push(s.charAt(i));
                break;
            case ']':
            case ')':
            case '}':
                if (stack.isEmpty()) {
                    return false;
                }
                char leftPart = stack.pop();
                if (s.charAt(i) == ']' && leftPart != '[') {
                    return false;
                }
                if (s.charAt(i) == ')' && leftPart != '(') {
                    return false;
                }
                if (s.charAt(i) == '}' && leftPart != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}