package com.zhangliang.leetcode;
/*
In a string composed of 'L', 'R', and 'X' characters, like "RXXLRXRXL", 
a move consists of either replacing one occurrence of "XL" with "LX", 
or replacing one occurrence of "RX" with "XR". Given the starting string 
start and the ending string end, return True if and only if there exists 
a sequence of moves to transform one string to the other.

Example:

Input: start = "RXXLRXRXL", end = "XRLXXRRLX"
Output: True
Explanation:
We can transform start to end following these steps:
RXXLRXRXL ->
XRXLRXRXL ->
XRLXRXRXL ->
XRLXXRRXL ->
XRLXXRRLX
Note:

1 <= len(start) = len(end) <= 10000.
Both start and end will only consist of characters in {'L', 'R', 'X'}.
*/

public class SwapAdjacentInLRString {
    public boolean canTransform(String start, String end) {
        if (start == null || end == null) {
            return start == null;
        }
        if (start.length() != end.length()) {
            return false;
        }
        if (start.length() == 0) {
            return true;
        }
        int i = 0;
        int j = 0;
        while (i < start.length() && j < end.length()) {
            if (start.charAt(i) == 'X') {
                i++;
                continue;
            }
            if (end.charAt(j) == 'X') {
                j++;
                continue;
            }
            if (start.charAt(i) != end.charAt(j)) {
                return false;
            }
            if (start.charAt(i) == 'L' && j > i) {
                return false;
            }
            if (start.charAt(i) == 'R' && j < i) {
                return false;
            }
            i++;
            j++;
        }
        while (i < start.length() && start.charAt(i) == 'X') {
            i++;
        }
        while (j < end.length() && end.charAt(j) == 'X') {
            j++;
        }
        return i == j;
    }
}
