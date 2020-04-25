package com.zhangliang.leetcode;
/*
Implement a basic calculator to evaluate a simple expression 
string.

The expression string may contain open ( and closing parentheses 
), the plus + or minus sign -, non-negative integers and empty 
spaces .

Example 1:

Input: "1 + 1"
Output: 2
Example 2:

Input: " 2-1 + 2 "
Output: 3
Example 3:

Input: "(1+(4+5+2)-3)+(6+8)"
Output: 23
Note:
You may assume that the given expression is always valid.
Do not use the eval built-in library function.
*/

public class BasicCalculator {
    class Result {
        // Parsed and calculated value.
        int value;

        // End index. Not included in the parsed value.
        int endIndex;

        public Result(int value, int endIndex) {
            this.value = value;
            this.endIndex = endIndex;
        }

    }

    /**
     * Calculate a expression with +. End when meet unmatched ).
     */
    private Result calcSum(String s, int startIndex) {
        int value = 0;
        int endIndex = s.length();
        boolean positive = true;
        for (int i = startIndex; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                endIndex = i;
                break;
            } else if (s.charAt(i) == '(') {
                Result part = calcSum(s, i + 1);
                value += positive ? part.value : -part.value;
                positive = true;
                i = part.endIndex;
            } else if (s.charAt(i) == '-') {
                positive = false;
            } else if (s.charAt(i) == '+') {
                positive = true;
            } else {
                Result part = calcPart(s, i);
                value += positive ? part.value : -part.value;
                positive = true;
                i = part.endIndex - 1;
            }
        }
        return new Result(value, endIndex);
    };

    /**
     * Calculate a expression without +. End when meet +, unmatched ).
     */
    private Result calcPart(String s, int startIndex) {
        int value = 0;
        int endIndex = s.length();
        for (int i = startIndex; i < s.length(); i++) {
            char x = s.charAt(i);
            if (!Character.isDigit(x)) {
                endIndex = i;
                break;
            }
            value = 10 * value + (x - '0');
        }
        return new Result(value, endIndex);
    };

    public int calculate(String s) {
        if (s == null) {
            return 0;
        }
        s = s.replaceAll(" ", "");
        return calcSum(s, 0).value;
    }
}
