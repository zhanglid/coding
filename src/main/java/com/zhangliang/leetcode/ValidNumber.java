package com.zhangliang.leetcode;
/*
Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true

Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before 
implementing one.

Update (2015-02-10):
The signature of the C++ function had been updated. If you still see your function signature accepts a const char 
* argument, please click the reload button to reset your code definition.
*/

public class ValidNumber {
    private boolean isCharValid(char c) {
        if (c <= '9' && c >= '0') {
            return true;
        }

        if (c == 'e') {
            return true;
        }

        if (c == '.') {
            return true;
        }

        if (c == '-') {
            return true;
        }

        if (c == '+') {
            return true;
        }
        return false;
    }

    public boolean isNumber(String s) {
        if (s == null) {
            return false;
        }
        s = s.trim();
        if (s.isEmpty()) {
            return false;
        }
        if (s.equals(".")) {
            return false;
        }

        if (s.charAt(s.length() - 1) == 'e') {
            return false;
        }
        if (s.charAt(s.length() - 1) == '-') {
            return false;
        }
        boolean hasMetPoint = false;
        boolean hasMetE = false;
        boolean hasMetNumber = false;
        boolean hasMetSign = false;
        for (char c : s.toCharArray()) {
            if (!isCharValid(c)) {
                return false;
            }
            if (c == '-' || c == '+') {
                if (hasMetSign || hasMetNumber || hasMetPoint) {
                    return false;
                }

                hasMetSign = true;
            }

            else if (c == '.') {
                if (hasMetPoint) {
                    return false;
                }
                hasMetPoint = true;
            }

            else if (c == 'e') {
                if (hasMetE || !hasMetNumber) {
                    return false;
                }
                hasMetE = true;
                hasMetNumber = false;
                hasMetPoint = true;
                hasMetSign = false;
            }

            else {
                hasMetNumber = true;
            }
        }

        return hasMetNumber;
    }
}
