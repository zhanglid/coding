package com.zhangliang.leetcode;
/*
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Find all strobogrammatic numbers that are of length = n.

Example:

Input:  n = 2
Output: ["11","69","88","96"]
*/

import java.util.ArrayList;
import java.util.List;

public class StrobogrammaticNumberII {
    private static char[][] pairs = new char[][] { { '0', '0' }, { '1', '1' }, { '6', '9' }, { '8', '8' },
            { '9', '6' } };
    private static char[] singles = new char[] { '0', '1', '8' };

    public List<String> findStrobogrammatic(int n) {
        List<String> ans = new ArrayList<>();

        if (n % 2 == 0) {
            expand(n, new StringBuilder(), ans);
        } else {
            for (char single : singles) {
                StringBuilder sb = new StringBuilder();
                sb.append(single);
                expand(n, sb, ans);
            }
        }

        return ans;
    }

    private void expand(int size, StringBuilder sb, List<String> ans) {
        if (sb.length() == size) {
            if (sb.charAt(0) != '0' || sb.charAt(0) == '0' && sb.length() == 1) {
                ans.add(sb.toString());
            }
            return;
        }

        for (char[] pair : pairs) {
            sb.append(pair[1]);
            sb.insert(0, pair[0]);
            expand(size, sb, ans);
            sb.deleteCharAt(0);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
