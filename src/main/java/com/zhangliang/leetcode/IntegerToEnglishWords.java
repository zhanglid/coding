package com.zhangliang.leetcode;
/*
Convert a non-negative integer to its english words representation. 
Given input is guaranteed to be less than 2^31 - 1.

Example 1:

Input: 123
Output: "One Hundred Twenty Three"

Example 2:

Input: 12345
Output: "Twelve Thousand Three Hundred Forty Five"

Example 3:

Input: 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"

Example 4:

Input: 1234567891
Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
*/

public class IntegerToEnglishWords {
    static final String[] DigitWords = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
            "Nineteen" };
    static final String[] TenWords = { "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
            "Ninety" };
    static final String[] HundredWords = { "Hundred", "Thousand", "Million", "Billion" };

    public String numberToWords(int num) {
        if (num < 100) {
            if (num < 20) {
                return DigitWords[num];
            }
            return TenWords[num / 10 - 1] + (num % 10 > 0 ? " " + DigitWords[num % 10] : "");
        } else if (num < 1000) {
            return numberToWords(num / 100) + " " + HundredWords[0]
                    + (num % 100 > 0 ? " " + numberToWords(num % 100) : "");
        } else {
            StringBuilder sb = new StringBuilder();
            if (num % 1000 > 0) {
                sb.append(numberToWords(num % 1000));
            }
            int hundredWordsIndex = 1;
            int base = 1000;
            while (num / base > 0) {
                int baseNum = (num / base) % 1000;
                String part = baseNum > 0 ? numberToWords(baseNum) + " " + HundredWords[hundredWordsIndex] : "";
                if (sb.length() > 0 && part.length() > 0) {
                    sb.insert(0, " ");
                }
                sb.insert(0, part);
                hundredWordsIndex++;
                base *= 1000;
            }
            return sb.toString();
        }

    }
}
