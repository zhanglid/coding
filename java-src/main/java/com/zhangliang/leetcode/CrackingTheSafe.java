package com.zhangliang.leetcode;
/*
There is a box protected by a password. The password is n digits, where 
each letter can be one of the first k digits 0, 1, ..., k-1.

You can keep inputting the password, the password will automatically 
be matched against the last n digits entered.


For example, assuming the password is "345", I can open it when I type 
"012345", but I enter a total of 6 digits.

Please return any string of minimum length that is guaranteed to open 
the box after the entire string is inputted.

Example 1:
Input: n = 1, k = 2
Output: "01"
Note: "10" will be accepted too.

"0", "1"

Example 2:
Input: n = 2, k = 2
Output: "00110"
Note: "01100", "10011", "11001" will be accepted too.
Note:
n will be in the range [1, 4].
k will be in the range [1, 10].
k^n will be at most 4096.

"00", "01", "10", "11"

   "0"         "1"
"0"  "1"    "0"   "1"
*/

import java.util.*;

public class CrackingTheSafe {
    public String crackSafe(int n, int k) {
        StringBuilder sb = new StringBuilder();
        Set<String> visited = new HashSet<>();
        for (int i = 0; i < n - 1; i++) {
            sb.append('0');
        }
        dfs(sb, visited, n, k, (int) Math.pow(k, n));
        return sb.toString();
    }

    private boolean dfs(StringBuilder sb, Set<String> visited, int n, int k, int maxSize) {
        if (visited.size() == maxSize) {
            return true;
        }
        String prefix = sb.substring(sb.length() - n + 1, sb.length());
        for (int i = 0; i < k; i++) {
            String key = prefix + i;
            if (!visited.contains(key)) {
                visited.add(key);
                sb.append(i);
                if (dfs(sb, visited, n, k, maxSize)) {
                    return true;
                }
                sb.deleteCharAt(sb.length() - 1);
                visited.remove(key);
            }
        }
        return false;
    }
}
