package com.zhangliang.leetcode;
/*
Given a non-negative integer, you could swap two digits at most once to 
get the maximum valued number. Return the maximum valued number you 
could get.

Example 1:
Input: 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.

Example 2:
Input: 9973
Output: 9973
Explanation: No swap.

Note:
The given number is in the range [0, 108]
*/

public class MaximumSwap {
    public int maximumSwap(int num) {
        char[] chars = Integer.toString(num).toCharArray();
        int maxIndex = chars.length - 1;
        int swapMaxTargetIndex = maxIndex;
        int swapTargetIndex = -1;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] < chars[maxIndex]) {
                swapTargetIndex = i;
                swapMaxTargetIndex = maxIndex;
            } else if (chars[i] > chars[maxIndex]) {
                maxIndex = i;
            }
        }
        if (swapTargetIndex != -1) {
            char t = chars[swapMaxTargetIndex];
            chars[swapMaxTargetIndex] = chars[swapTargetIndex];
            chars[swapTargetIndex] = t;
        }
        int ans = 0;
        for (char x : chars) {
            ans = 10 * ans + x - '0';
        }
        return ans;
    }
}
