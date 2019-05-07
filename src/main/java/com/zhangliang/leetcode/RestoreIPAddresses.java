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
        helper(new ArrayList<>(), 0, s, ans);
        return ans;
    }

    private void helper(List<String> parts, int index, String s, List<String> result) {
        if (parts.size() == 4) {
            if (index >= s.length()) {
                result.add(String.join(".", parts));
            }
            return;
        }
        int part = 0;
        for (int i = index; i < Math.min(s.length(), index + 3); i++) {
            part = 10 * part + (s.charAt(i) - '0');
            if (part > 255) {
                break;
            }
            parts.add(Integer.toString(part));
            helper(parts, i + 1, s, result);
            parts.remove(parts.size() - 1);
            if (part == 0) {
                break;
            }
        }
    }
}
