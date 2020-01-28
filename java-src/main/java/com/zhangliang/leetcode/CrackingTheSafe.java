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

import java.util.HashSet;
import java.util.Set;

public class CrackingTheSafe {
    public String crackSafe(int n, int k) {
        if (n < 1 || k < 1) {
            return "";
        }

        int totalCount = (int)Math.pow(k, n);
        StringBuilder ansBuilder = new StringBuilder();
        Set<String> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            ansBuilder.append('0');
        }
        visited.add(ansBuilder.toString());

        dfs(ansBuilder, visited, n, k, totalCount);

        return ansBuilder.toString();
    }
    
    private boolean dfs(StringBuilder sb, Set<String> visited, int n, int k, int totalCount) {
        if (visited.size() == totalCount) {
            return true;
        }

        String last = sb.substring(sb.length() - n + 1, sb.length());

        for (int i = 0; i < k; i++) {
            String choice = last + i;
            if (!visited.contains(choice)) {
                visited.add(choice);
                sb.append(i);
                if (dfs(sb, visited, n, k, totalCount)) {
                    return true;
                }
                visited.remove(choice);
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        return false;
    }
}
