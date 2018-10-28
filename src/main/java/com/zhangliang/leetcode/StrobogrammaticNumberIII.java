package com.zhangliang.leetcode;
/*
A strobogrammatic number is a number that looks the same when rotated 180 degrees 
(looked at upside down).

Write a function to count the total strobogrammatic numbers that exist in the range 
of low <= num <= high.

Example:

Input: low = "50", high = "100"
Output: 3 
Explanation: 69, 88, and 96 are three strobogrammatic numbers.
Note:
Because the range might be a large number, the low and high numbers are represented 
as string.
*/

public class StrobogrammaticNumberIII {
    public int strobogrammaticInRange(String low, String high) {
        int ans = 0;
        for (String x : new String[] { "1", "0", "8", "" }) {
            ans += dfs(x, low, high);
        }
        return ans;
    }

    private int dfs(String cur, String low, String high) {
        if (cur.length() > high.length()) {
            return 0;
        }
        int ans = 0;
        if (cur.length() >= low.length() && cur.length() > 0) {
            if ((cur.compareTo(low) >= 0 || cur.length() > low.length())
                    && (cur.compareTo(high) <= 0 || cur.length() < high.length()) && (cur.charAt(0) != '0' || cur.length() == 1)) {
                ans++;
            }
        }
        for (char[] pair : new char[][] { { '1', '1' }, { '6', '9' }, { '8', '8' }, { '9', '6' }, { '0', '0' } }) {
            String next = pair[0] + cur + pair[1];
            ans += dfs(next, low, high);
        }

        return ans;
    }
}
