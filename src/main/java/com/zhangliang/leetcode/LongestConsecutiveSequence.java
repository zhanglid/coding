package com.zhangliang.leetcode;
/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.

Example:

Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
*/

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            set.add(x);
        }

        int ans = 0;
        for (int num : nums) {
            if (!set.contains(num)) {
                continue;
            }

            int count = 1;
            int cur = num - 1;
            while (set.contains(cur)) {
                set.remove(cur);
                count++;
                cur--;
            }

            cur = num + 1;
            while (set.contains(cur)) {
                set.remove(cur);
                count++;
                cur++;
            }

            ans = Math.max(ans, count);
        }

        return ans;
    }
}
