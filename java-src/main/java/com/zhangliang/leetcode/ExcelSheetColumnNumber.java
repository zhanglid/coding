package com.zhangliang.leetcode;
/*
Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...
Example 1:

Input: "A"
Output: 1
Example 2:

Input: "AB"
Output: 28
Example 3:

Input: "ZY"
Output: 701
*/

public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int base = 1;
        int ans = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            ans += base * (s.charAt(i) - 'A' + 1);
            base *= 26;
        }

        return ans;
    }
}
