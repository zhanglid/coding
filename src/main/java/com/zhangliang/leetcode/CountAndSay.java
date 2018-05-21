package com.zhangliang.leetcode;
/*
The count-and-say sequence is the sequence of integers with the first five terms 
as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

Example 1:

Input: 1
Output: "1"
Example 2:

Input: 4
Output: "1211"
*/

public class CountAndSay {
    public String countAndSay(int n) {
        if (n < 1) {
            return "";
        }

        if (n == 1) {
            return "1";
        }

        String prev = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < prev.length(); i++) {
            int j = i;
            while (j < prev.length() && prev.charAt(j) == prev.charAt(i)) {
                j++;
            }
            j--;
            sb.append(j - i + 1);
            sb.append(prev.charAt(i));
            i = j;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        CountAndSay s = new CountAndSay();
        System.out.println(s.countAndSay());
    }
}
