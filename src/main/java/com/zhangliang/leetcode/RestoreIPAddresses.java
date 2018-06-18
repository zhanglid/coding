package com.zhangliang.leetcode;
/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

Example:

Input: "25525511135"
Output: ["255.255.11.135", "255.255.111.35"]
*/

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if (s == null) {
            return ans;
        }

        helper(s, 0, new String[4], 0, ans);

        return ans;
    }

    private void helper(String s, int start, String[] parts, int cur, List<String> ans) {
        int part = 0;
        if (start >= s.length()) {
            return;
        }
        if (s.length() - start > 3 * (4 - cur)) {
            return;
        }
        if (cur == 3) {
            String last = s.substring(start);
            part = Integer.parseInt(last);
            if (part <= 255 && (part == 0 && last.equals("0") || part > 0 && s.charAt(start) != '0')) {
                parts[cur++] = Integer.toString(part);
                ans.add(String.join(".", parts));
            }
            return;
        }

        if (s.charAt(start) == '0') {
            parts[cur] = "0";
            helper(s, start + 1, parts, cur + 1, ans);
            return;
        }

        part = 0;
        for (int i = start; i < Math.min(i + 3, s.length() - (4 - cur - 1)); i++) {
            part = 10 * part + (s.charAt(i) - '0');
            if (part > 255) {
                return;
            }
            parts[cur] = Integer.toString(part);
            helper(s, i + 1, parts, cur + 1, ans);
        }
    }
}