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
Output: 
"One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"

Example 4:

Input: 1234567891
Output: 
"One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
*/

public class IntegerToEnglishWords {
    static String[] DIGITS = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };
    static String[] TEENS = { "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
            "Eighteen", "Nineteen" };
    static String[] TENS = { "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };

    // 0 - 9
    private String encodeDigit(int num) {
        return DIGITS[num];
    }

    // 10 - 19
    private String encodeTeen(int num) {
        return TEENS[num - 10];
    }

    // 20 - 99
    private String encodeTenth(int num) {
        return TENS[num / 10 - 2] + (num % 10 == 0 ? "" : " " + numberToWords(num % 10));
    }

    // 100 - 999
    private String encodeHundred(int num) {
        return encodeDigit(num / 100) + " " + "Hundred" + (num % 100 == 0 ? "" : " " + numberToWords(num % 100));
    }

    // 1000 - 999,999
    private String encodeThousand(int num) {
        return numberToWords(num / 1000) + " " + "Thousand"
                + ((num % 1000 == 0) ? "" : " " + numberToWords(num % 1000));
    }

    // 1,000,000 - 999,999,999
    private String encodeMillion(int num) {
        int rest = num % 1_000_000;
        return numberToWords(num / 1_000_000) + " " + "Million" + (rest == 0 ? "" : (" " + numberToWords(rest)));
    }

    // 1,000,000,000 - (2^31 - 1)
    private String encodeBillion(int num) {
        int rest = num % 1_000_000_000;
        return numberToWords(num / 1_000_000_000) + " " + "Billion" + (rest == 0 ? "" : " " + numberToWords(rest));
    }

    public String numberToWords(int num) {
        if (num < 10) {
            return encodeDigit(num);
        } else if (num < 20) {
            return encodeTeen(num);
        } else if (num < 100) {
            return encodeTenth(num);
        } else if (num < 1000) {
            return encodeHundred(num);
        } else if (num < 1_000_000) {
            return encodeThousand(num);
        } else if (num < 1_000_000_000) {
            return encodeMillion(num);
        } else {
            return encodeBillion(num);
        }
    }
}
