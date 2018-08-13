package com.zhangliang.leetcode;
/*
Given a string S, check if the letters can be rearranged so that two characters that are 
adjacent to each other are not the same.

If possible, output any possible result.  If not possible, return the empty string.

Example 1:

Input: S = "aab"
Output: "aba"
Example 2:

Input: S = "aaab"
Output: ""
Note:

S will consist of lowercase letters and have length in range [1, 500].
*/

import java.util.Comparator;
import java.util.PriorityQueue;

public class ReorganizeString {
    public String reorganizeString(String S) {
        if (S == null || S.length() < 1) {
            return "";
        }

        int n = S.length();
        int[] count = new int[26];
        for (char x : S.toCharArray()) {
            count[x - 'a']++;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return -a[0] + b[0];
            }
        });

        for (int i = 0; i < count.length; i++) {
            int[] pair = new int[2];
            pair[0] = count[i];
            pair[1] = i;
            pq.add(pair);
        }

        if (n < 2 * pq.peek()[0] - 1) {
            return "";
        }

        StringBuilder[] sbs = new StringBuilder[pq.peek()[0]];

        for (int i = 0; i < sbs.length; i++) {
            sbs[i] = new StringBuilder();
        }

        int index = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            char c = (char) (cur[1] + 'a');
            for (int i = 0; i < cur[0]; i++) {
                int j = (index + i) % sbs.length;
                sbs[j].append(c);
            }
            index = (index + cur[0]) % sbs.length;
        }

        StringBuilder ansBuilder = new StringBuilder();

        for (StringBuilder sb : sbs) {
            ansBuilder.append(sb);
        }

        return ansBuilder.toString();
    }
}
