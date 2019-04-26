package com.zhangliang.leetcode;
/*
Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus 
sign -, non-negative integers and empty spaces .

The expression string contains only non-negative integers, +, -, *, / operators , open 
( and closing parentheses ) and empty spaces . The integer division should truncate 
toward zero.

You may assume that the given expression is always valid. All intermediate results will 
be in the range of [-2147483648, 2147483647].

Some examples:

"1 + 1" = 2
" 6-4 / 2 " = 4
"2*(5+5*2)/3+(6/2+8)" = 21
"(2+6* 3+5- (3*14/7+2)*5)+3"=-12
 

Note: Do not use the eval built-in library function.
*/

public class BasicCalculatorIII {
    class Result {
        int value;
        int end;

        public Result(int value, int end) {
            this.value = value;
            this.end = end;
        }
    }

    public int calculate(String s) {
        if (s == null) {
            return 0;
        }
        s = s.replace(" ", "");
        if (s.length() < 1) {
            return 0;
        }
        return (int) processAdd(s, 0).value;
    }

    /**
     * process +- parts, end when string end or meet )
     * 
     * @param s
     * @param start
     * @return value and position
     */
    private Result processAdd(String s, int start) {
        int value = 0;
        int end = s.length();
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                end = i;
                break;
            }
            Result r = processMultiply(s, i);
            value += r.value;
            i = r.end - 1;
        }

        return new Result(value, end);
    }

    /**
     * Process a part connected with multiply or divide
     * 
     * @param s     string to process
     * @param start start position
     * @return value and position
     */
    private Result processMultiply(String s, int start) {
        int value = 1;
        int end = s.length();
        boolean isDivide = false;
        for (int i = start; i < s.length(); i++) {
            Result r = processGroup(s, i);
            if (isDivide) {
                value /= r.value;
                isDivide = false;
            } else {
                value *= r.value;
            }

            i = r.end - 1;
            if (i + 1 < s.length()) {
                if (s.charAt(i + 1) == '/') {
                    isDivide = true;
                } else if (s.charAt(i + 1) != '*') {
                    end = r.end;
                    break;
                }
                i++;
            }
        }

        return new Result(value, end);
    }

    /**
     * Process a part can be used as a number
     * 
     * @param s     string to process
     * @param start start position
     * @return value and position
     */
    private Result processGroup(String s, int start) {
        boolean positive = true;
        if (s.charAt(start) == '-') {
            positive = false;
            start++;
        } else if (s.charAt(start) == '+') {
            start++;
        }
        if (s.charAt(start) == '(') {
            Result r = processAdd(s, start + 1);
            return new Result(positive ? r.value : -r.value, r.end + 1);
        }
        Result r = processNum(s, start);
        return new Result(positive ? r.value : -r.value, r.end);
    }

    /**
     * Process a part as number
     * 
     * @param s     string
     * @param start start position
     * @return value and position
     */
    private Result processNum(String s, int start) {
        int value = 0;
        int end = s.length();
        boolean positive = true;
        if (s.charAt(start) == '-') {
            positive = false;
            start++;
        } else if (s.charAt(start) == '+') {
            start++;
        }

        for (int i = start; i < s.length(); i++) {
            char x = s.charAt(i);
            if (x >= '0' && x <= '9') {
                value = (x - '0') + 10 * value;
            } else {
                end = i;
                break;
            }
        }

        return new Result(positive ? value : -value, end);
    }
}
