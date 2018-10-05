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

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CrackingTheSafe {
    public String crackSafe(int n, int k) {
        if (n < 1 || k < 1) {
            return "";
        }

        LinkedList<String> queue = new LinkedList<>();
        queue.add("");
        for (int i = 0; i < n; i++) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String pre = queue.poll();
                for (int t = 0; t < k; t++) {
                    String choice = pre + t;
                    queue.add(choice);
                }
            }
        }

        String ans = null;
        for (int i = 0; i < queue.size(); i++) {
            String choice = getMinStringStartWith(i, queue);
            if (ans == null || choice.length() < ans.length()) {
                ans = choice;
            }
        }

        return ans;
    }

    private Map<String, Integer> cache = new HashMap<>();
    private int calCommonLength(String a, String b) {
        String key = a + b;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        int ans = 0;
        for (int i = 0; i < a.length(); i++) {
            int count = 0;
            int cur = i;
            for (int j = 0; j < b.length() && cur < a.length(); j++) {
                if (a.charAt(cur) != b.charAt(j)) {
                    break;
                }
                cur++;
                count++;
            }
            if (cur == a.length()) {
                ans = Math.max(ans, count);
            }
        }
        cache.put(key, ans);
        return ans;
    }


    private Map<String, String> cacheSet = new HashMap<>();
    private String getMinStringStartWith(int prefixIndex, List<String> choices) {
        String key = prefixIndex + choices.toString();
        if (cacheSet.containsKey(key)) {
            return cacheSet.get(key);
        }
        String prefix = choices.get(prefixIndex);
        String ans = null;
        choices.remove(prefixIndex);
        if (choices.isEmpty()) {
            ans = prefix;
        }
        for (int i = 0; i < choices.size(); i++) {
            String choice = choices.get(i);
            int length = calCommonLength(prefix, choice);
            String next = getMinStringStartWith(i, choices);
            String nextCombine = prefix + next.substring(length);
            if (ans == null || ans.length() > nextCombine.length()) {
                ans = nextCombine;
            }
        }
        choices.add(prefixIndex, prefix);

        cacheSet.put(key, ans);
        return ans;
    }
}
