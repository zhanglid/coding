package com.zhangliang.leetcode;
/*
Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true

Note: It is intended for the problem statement to be ambiguous. 
You should gather all requirements up front before 
implementing one.

Update (2015-02-10):
The signature of the C++ function had been updated. If you still see 
your function signature accepts a const char * argument, please click 
the reload button to reset your code definition.
*/

public class ValidNumber {
    private boolean validateChars(String s) {
        boolean hasDigit = false;
        int dotCount = 0;
        int eCount = 0;
        for (char x : s.toCharArray()) {
            hasDigit = Character.isDigit(x) || hasDigit;
            if (x == '.') {
                dotCount++;
            } else if (x == 'e') {
                eCount++;
            }
            if (!Character.isDigit(x) && x != '.' && x != 'e' && x != '+' && x != '-') {
                return false;
            }
        }
        return hasDigit && dotCount <= 1 && eCount <= 1;
    }

    private String removeSign(String s) {
        if (s.length() > 0 && (s.charAt(0) == '+' || s.charAt(0) == '-')) {
            return s.substring(1);
        }
        return s;
    }

    private boolean validateInteger(String s) {
        s = removeSign(s);
        if (s.length() < 1) {
            return false;
        }
        for (char x : s.toCharArray()) {
            if (!Character.isDigit(x)) {
                return false;
            }
        }
        return true;
    }

    private boolean validateFloat(String s) {
        s = removeSign(s);
        if (s.length() < 1 || s.equals(".")) {
            return false;
        }
        for (char x : s.toCharArray()) {
            if (!Character.isDigit(x) && x != '.') {
                return false;
            }
        }
        String[] parts = s.split("\\.");
        if (parts.length > 2 || parts.length == 0) {
            return false;
        }
        if (parts.length == 1) {
            return s.equals("+") || s.equals("-") || validateInteger(parts[0]);
        }
        if (parts[0].length() > 0 && !validateInteger(parts[0])) {
            return false;
        }
        return parts[1].length() == 0 || !parts[1].equals("+") && !parts[1].equals("-") && validateInteger(parts[1]);
    }

    private boolean validateExp(String s) {
        String[] parts = s.split("e");
        if (parts.length != 2) {
            return false;
        }
        return validateFloat(parts[0]) && validateInteger(parts[1]);
    }

    public boolean isNumber(String s) {
        if (s == null) {
            return false;
        }
        s = s.trim();
        if (s.length() < 1) {
            return false;
        }
        if (!validateChars(s)) {
            return false;
        }
        if (s.indexOf("e") >= 0) {
            return validateExp(s);
        }
        return validateFloat(s);
    }
}
