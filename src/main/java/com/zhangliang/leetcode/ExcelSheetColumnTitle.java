package com.zhangliang.leetcode;
/*
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
    ...
Example 1:

Input: 1
Output: "A"
Example 2:

Input: 28
Output: "AB"
Example 3:

Input: 701
Output: "ZY"
*/

public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        if (n < 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            int digit = n % 26;
            if (digit == 0) {
                digit = 26;
            }
            sb.insert(0, (char) (digit - 1 + 'A'));
            n -= digit;
            n /= 26;
        }

        return sb.toString();
    }
}
